package com.codegym.controller;

import com.codegym.model.AppCustomer;
import com.codegym.model.Bill;
import com.codegym.model.BillDetail;
import com.codegym.model.BillStatus;
import com.codegym.model.Cart;
import com.codegym.model.CartProduct;
import com.codegym.model.Product;
import com.codegym.service.bill.IBillService;
import com.codegym.service.billDetail.IBillDetailService;
import com.codegym.service.billStatus.IBillStatusService;
import com.codegym.service.product.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"cart", "sessionCustomer"})
public class CartController {

    //  public static BillStatus billStatus = new BillStatus();

    @Autowired
    private IBillService billService;

    @Autowired
    private IBillStatusService billStatusService;

    @Autowired
    private IBillDetailService billDetailService;

    @Autowired
    private IProduceService productService;


    @ModelAttribute("sessionCustomer")
    public AppCustomer setUpCustomer() {
        return new AppCustomer();
    }

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/cart-buy")
    public ModelAndView billPage(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        if (customer.getId() == null) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("customer", new AppCustomer());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("bill");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
    }

    @PostMapping("/cart-buy")
    public ModelAndView buyProduct(@ModelAttribute("sessionCustomer") AppCustomer customer, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("bill");
        if(cart.getTotalQuantity() == 0){
            modelAndView.addObject("message", "Đặt hàng thất bại do không có sản phẩm để đặt !!");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }
        Long ti = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(ti);
        List<Product> products = new ArrayList<>();
        for (CartProduct cartProduct : cart.getProduct()) {
            Optional<Product> product = productService.getById(cartProduct.getId());
            Product product1 = product.get();
             product1.setQuantity(cartProduct.getQuantity());
            products.add(product1);
        }
        BillDetail billDetail = new BillDetail(products);
        billDetailService.save(billDetail);
        Optional<BillStatus> billStatus = billStatusService.getById((long) 1);
        BillStatus billStatus1 = billStatus.get();
        Bill bill = new Bill(customer, billDetail, billStatus1, timestamp);
        billService.save(bill);
        modelAndView.addObject("message", "Bạn đã đặt hàng thành công !! ");
        modelAndView.addObject("customer", customer);
        cart.setProduct(new ArrayList<>());
        cart.setTotalQuantity(0);
        cart.setTotalPrice(0);
        return modelAndView;

    }

    @GetMapping("/wait-confirm")
    public ModelAndView getWaitConfirmProduct(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        ModelAndView modelAndView = new ModelAndView("bills-status");
        List<Bill> bills = billService.getAllBillByCustomerIdAndStatus(customer.getId(), (long) 1);
        modelAndView.addObject("bills", bills);
        return modelAndView;
    }

    @GetMapping("/wait-delivery")
    public ModelAndView getWaitDeliveryProduct(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        ModelAndView modelAndView = new ModelAndView("bills-status");
        List<Bill> bills = billService.getAllBillByCustomerIdAndStatus(customer.getId(), (long) 2);
        modelAndView.addObject("bills", bills);
        return modelAndView;
    }

    @GetMapping("/delivering")
    public ModelAndView getDeliveringProduct(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        ModelAndView modelAndView = new ModelAndView("bills-status");
        List<Bill> bills = billService.getAllBillByCustomerIdAndStatus(customer.getId(), (long) 3);
        modelAndView.addObject("bills", bills);
        return modelAndView;
    }

    @GetMapping("/delivered")
    public ModelAndView getDeliveredProduct(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        ModelAndView modelAndView = new ModelAndView("bills-status");
        List<Bill> bills = billService.getAllBillByCustomerIdAndStatus(customer.getId(), (long) 4);
        modelAndView.addObject("bills", bills);
        return modelAndView;
    }

    @GetMapping("cancelOrder")
    public ModelAndView getCancelOrder(@ModelAttribute("sessionCustomer") AppCustomer customer) {
        ModelAndView modelAndView = new ModelAndView("bills-status");
        List<Bill> bills = billService.getAllBillByCustomerIdAndStatus(customer.getId(), (long) 5);
        modelAndView.addObject("bills", bills);
        return modelAndView;
    }
}
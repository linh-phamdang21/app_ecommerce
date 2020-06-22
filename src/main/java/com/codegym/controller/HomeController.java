package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.CartProduct;
import com.codegym.model.Product;
import com.codegym.service.cart.ICartService;
import com.codegym.service.product.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class HomeController {

    @Autowired
    private IProduceService produceService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "loginForm";
    }

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = (List<Product>) produceService.findAll();
      //  System.out.println(products.size());
        List<Product> featuredProducts = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            featuredProducts.add(products.get(i));
        }
//        System.out.println(featuredProducts.size());
        modelAndView.addObject("featuredProducts",featuredProducts );
        return modelAndView;
    }

    @GetMapping("/carts")
    public ModelAndView cartPage(){
        ModelAndView modelAndView = new ModelAndView("cart");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView productPage(){
        ModelAndView modelAndView = new ModelAndView("product");
        return modelAndView;
    }

    @GetMapping("/product-detail")
    public ModelAndView productDetailsPage(){
        ModelAndView modelAndView = new ModelAndView("product-detail");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView details(){
        ModelAndView modelAndView = new ModelAndView("blog");
        return modelAndView;
    }

    @GetMapping("/abouts")
    public ModelAndView aboutPage(){
        ModelAndView modelAndView = new ModelAndView("about");
        return modelAndView;
    }

    @GetMapping("/contacts")
    public ModelAndView contactPage(){
        ModelAndView modelAndView = new ModelAndView("contact");
        return modelAndView;
    }

    @GetMapping("/blog-detail")
    public ModelAndView blogDetailsPage(){
        ModelAndView modelAndView = new ModelAndView("blog-detail");
        return modelAndView;
    }
//    @Autowired
//    private ICartService cartService;

//    @PostMapping("/api/carts")
//    public ResponseEntity<String> addToCart1(@RequestBody Product product, @ModelAttribute("cart") Cart cart){
//        List<CartProduct> product3 = cart.getProduct();
//        boolean isProductExist = cartService.isExists(product.getId(), product3);
//        if (isProductExist) {
//            CartProduct product1 = cartService.findOne(product.getId(), product3);
//            product1.setQuantity(product1.getQuantity() + 1);
//        } else {
//            CartProduct product1 = new CartProduct(product.getId(), product.getProductName(), product.getImage(), product.getPrice(), product.getDescribes(), product.getCategory(), product.getBrand(), 1);
//            product3.add(product1);
//            System.out.println("id : " + product3.get(0).getId());
//        }
//        int totalQuantity = cartService.getTotalQuantity(product3);
//        cart.setTotalQuantity(totalQuantity);
//        float totalPrice = cartService.getTotalPrice(product3);
//        cart.setTotalPrice(totalPrice);
//        System.out.println(totalQuantity);
//        return new ResponseEntity<>(String.valueOf(totalQuantity), HttpStatus.OK);
//    }

}

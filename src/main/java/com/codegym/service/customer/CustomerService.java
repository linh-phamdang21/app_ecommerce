package com.codegym.service.customer;


import com.codegym.model.AppCustomer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService, UserDetailsService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<AppCustomer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<AppCustomer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public AppCustomer save(AppCustomer model) {
        return customerRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public AppCustomer getCustomerByName(String name) {
        return customerRepository.findByUsername(name);
    }

    @Override
    public Page<AppCustomer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @Override
    public Page<AppCustomer> findAllByUserNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByUsernameContaining(name,pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppCustomer customer = getCustomerByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(customer.getAppRole());
        UserDetails userDetails = new User(customer.getUsername(), customer.getPassword(), authorities);
        return userDetails;
    }
}
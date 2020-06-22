package com.codegym.service.approle;

import com.codegym.model.AppRole;
import com.codegym.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements AppRoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole getRoleById(Long id) {
        return roleRepository.findByid(id);
    }
}

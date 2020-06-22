package com.codegym.service.approle;

import com.codegym.model.AppRole;
import org.springframework.stereotype.Service;

@Service
public interface AppRoleService {
    AppRole getRoleById(Long id);
}

package com.codegym.service.approle;

import com.codegym.model.AppRole;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AppRoleService {
    AppRole getRoleById(Long id);
}

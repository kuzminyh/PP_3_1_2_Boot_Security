package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository RoleRepository;

    public Role getRoleById(Long id) {
        return RoleRepository.getById(id);
    }
    public List<Role> getRolesList() {
        return RoleRepository.findAll();
    }
}
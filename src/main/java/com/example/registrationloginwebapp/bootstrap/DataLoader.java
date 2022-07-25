package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.RoleEnum;
import com.example.registrationloginwebapp.services.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private final RoleService roleService;

    public DataLoader(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start load DB.");
        log.info("Preloading " + roleService.save(new Role(RoleEnum.GUEST, "guest rights")));
        log.info("Preloading " + roleService.save(new Role(RoleEnum.ADMIN, "admin rights")));
    }
}

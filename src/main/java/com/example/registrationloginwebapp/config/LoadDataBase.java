package com.example.registrationloginwebapp.config;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.RoleEnum;
import com.example.registrationloginwebapp.repositories.RoleRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);
    private final RoleRepository roleRepository;

    public LoadDataBase(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    CommandLineRunner initDatabase(RoleRepository repository) {
        return args -> {
            log.info("Start load DB.");
            log.info("Preloading " + roleRepository.save(new Role(RoleEnum.GUEST, "guest rights")));
            log.info("Preloading " + roleRepository.save(new Role(RoleEnum.ADMIN, "admin rights")));
            log.info(roleRepository.count() + " roles was uploaded into repo.");
        };
    }
}

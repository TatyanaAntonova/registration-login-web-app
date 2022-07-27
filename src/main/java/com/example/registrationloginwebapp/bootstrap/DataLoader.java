package com.example.registrationloginwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    /*private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private final RoleService roleService;

    public DataLoader(RoleService roleService) {
        this.roleService = roleService;
    }
*/
    @Override
    public void run(String... args) throws Exception {
       /* log.info("Start load DB.");
        log.info("Preloading " + roleService.save(new Role(RoleEnum.GUEST, "Guest rights")));
        log.info("Preloading " + roleService.save(new Role(RoleEnum.USER, "User rights")));
        log.info("Preloading " + roleService.save(new Role(RoleEnum.ADMIN, "Admin rights")));
        */
    }
}

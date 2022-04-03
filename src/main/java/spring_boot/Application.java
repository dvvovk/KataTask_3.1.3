package spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring_boot.model.Role;
import spring_boot.model.User;
import spring_boot.service.RoleService;
import spring_boot.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Application(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);

        User newUser = new User("User", "User's", 23, "user@gmail.com", "user",
                "user", userSet);
        User admin = new User("Admin", "Admin's", 30, "admin@gmail.com", "admin",
                "admin", adminSet);

        userService.saveUser(newUser);
        userService.saveUser(admin);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
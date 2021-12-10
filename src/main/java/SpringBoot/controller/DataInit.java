package SpringBoot.controller;

import SpringBoot.model.Role;
import SpringBoot.model.User;
import SpringBoot.service.RoleService;
import SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class DataInit {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private Set<Role> roles1;
    private Set<Role> roles2;
    @PostConstruct
    public void dataInit() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        HashSet<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles1.add(roleService.getRoleByName("ROLE_USER"));
        User user1 = new User("admin","admin","admin@mail","admin", roles1);
        userService.addUser(user1);

        HashSet<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRoleByName("ROLE_USER"));
        User user2 = new User("user","user","user@mail","user", roles2);
        userService.addUser(user2);
    }
}

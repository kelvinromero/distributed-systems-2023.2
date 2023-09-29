package br.ifpb.edu.progdist.restexample.controller;

import br.ifpb.edu.progdist.restexample.model.User;
import br.ifpb.edu.progdist.restexample.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService = new UsersService();

    @GetMapping("")
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{code}")
    public User getUserByCode(@PathVariable int code) {
        return usersService.getUserByCode(code);
    }

    @PostMapping(path="", consumes = "application/json", produces = "application/json")
    public int InserUser(@RequestBody User user) {
        usersService.insertUser(user);
        return user.getCode();
    }
}

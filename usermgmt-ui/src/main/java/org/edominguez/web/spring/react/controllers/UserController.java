package org.edominguez.web.spring.react.controllers;

import org.edominguez.web.spring.react.model.User;
import org.edominguez.web.spring.react.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository UserRepository;

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public Iterable<User> User() {
        return UserRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public User save(@RequestBody User User) {
        UserRepository.save(User);

        return User;
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public Optional<User> show(@PathVariable String id) {
        return UserRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public User update(@PathVariable String id, @RequestBody User User) {
        Optional<User> optUser = UserRepository.findById(id);
        User user = optUser.get();
        if(User.getFirstName() != null)
            user.setFirstName(User.getFirstName());
        if(User.getLastName() != null)
            user.setFirstName(User.getFirstName());
        if(User.getAddress() != null)
            user.setAddress(User.getAddress());
        if(User.getCity() != null)
            user.setCity(User.getCity());
        if(User.getPhone() != null)
            user.setPhone(User.getPhone());
        if(User.getEmail() != null)
            user.setEmail(User.getEmail());
        UserRepository.save(user);
        return user;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
    public String delete(@PathVariable String id) {
        Optional<User> optUser = UserRepository.findById(id);
        User User = optUser.get();
        UserRepository.delete(User);

        return "";
    }
}

package ru.igorek.springMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.igorek.springMVC.dao.BookDao;
import ru.igorek.springMVC.dao.UserDao;
import ru.igorek.springMVC.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDao personDao;
    private final BookDao bookDao;


    @Autowired
    public UserController(UserDao personDao, BookDao bookDao) {
        this.personDao = personDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user/new";

        personDao.createUser(user);

        return "redirect:/user";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", personDao.getAllUsers());
        return "user/index";
    }

    @GetMapping("{id}")
    public String getUserById(@PathVariable int id, Model model) {
        User user = personDao.getUserById(id);
        model.addAttribute("user", user);
        return "user/userDetails";
    }


    @GetMapping("{id}/edit")
    public String editUser(@PathVariable int id, Model model) {
        User user = personDao.getUserById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    @PatchMapping("{id}")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors()) {
            return "user/update";
        }

        personDao.updateUser(user, id);
        return "redirect:/user";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id) {
        personDao.deleteUser(id);
        return "redirect:/user";
    }


}

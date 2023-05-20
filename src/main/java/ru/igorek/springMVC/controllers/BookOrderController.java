package ru.igorek.springMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.igorek.springMVC.dao.BookDao;
import ru.igorek.springMVC.model.Book;

@Controller
@RequestMapping("/order")
public class BookOrderController {

    private final BookDao bookDao;

    @Autowired
    public BookOrderController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/free/{userId}")
    public String getListOfFreeBooks(Model model
            , @ModelAttribute("book") Book book
            , @PathVariable int userId) {
        model.addAttribute("books", bookDao.getAllFreeBooks());
        model.addAttribute("userId", userId);
        return "book/addBusy";
    }

    @GetMapping("/busy/{userId}")
    public String getListOfBusyBooks(Model model
            , @ModelAttribute("book") Book book
            , @PathVariable int userId) {
        model.addAttribute("books", bookDao.getAllBusyBooks(userId));
        model.addAttribute("userId", userId);
        return "book/removeBusy";
    }

    @PostMapping("/{userId}")
    public String addBusyBook(@PathVariable int userId, @ModelAttribute Book book) {
        bookDao.addBusyBook(userId, book.getId());
        return "redirect:/user";
    }

    @DeleteMapping("/{userId}")
    public String deleteBusyBook(@PathVariable int userId, @ModelAttribute Book book) {
        bookDao.deleteBusyBook(userId, book.getId());
        return "redirect:/user";
    }
}

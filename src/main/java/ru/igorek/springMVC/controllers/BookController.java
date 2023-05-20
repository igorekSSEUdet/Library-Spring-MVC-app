package ru.igorek.springMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.igorek.springMVC.dao.BookDao;
import ru.igorek.springMVC.model.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "book/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "book/new";

        bookDao.createBook(user);

        return "redirect:/book";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("book", bookDao.getAllBooks());
        return "book/index";
    }

    @GetMapping("{id}")
    public String getBookById(@PathVariable int id, Model model) {
        Book book = bookDao.getBookById(id);
        model.addAttribute("book", book);
        return "book/bookDetails";
    }

    @GetMapping("{id}/edit")
    public String editBook(@PathVariable int id, Model model) {
        Book book = bookDao.getBookById(id);
        model.addAttribute("book", book);
        return "book/update";
    }

    @PatchMapping("{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult bindingResult,
                             @PathVariable int id) {
        if (bindingResult.hasErrors()) {
            return "book/update";
        }
        bookDao.updateBook(book, id);
        return "redirect:/book";
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id) {
        bookDao.deleteBook(id);
        return "redirect:/book";
    }

}

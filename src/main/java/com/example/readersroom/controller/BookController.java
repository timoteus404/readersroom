package com.example.readersroom.controller;

import com.example.readersroom.entity.Books;
import com.example.readersroom.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"/list", "/"})
    public String listBooks(Model model){
        model.addAttribute("books", bookService.listAll());
        return "books/list";
    }

    @RequestMapping("/show/{id}")
    public String getBook(@PathVariable Long id, Model model){
        model.addAttribute("books", bookService.getById(id));
        return "books/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("books", bookService.getById(id));
        return "books/bookform";
    }

    @RequestMapping("/new")
    public String createBook(Model model){
        model.addAttribute("books", new Books());
        return "redirect:/books/bookform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Books book){
        Books savedBook = bookService.saveOrUpdate(book);
        return "redirect:/books/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books/list";
    }
}

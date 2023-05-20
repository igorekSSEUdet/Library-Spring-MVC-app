package ru.igorek.springMVC.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.igorek.springMVC.model.Book;

import java.util.List;

@Component
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBusyBook(int userId, int bookId) {
        jdbcTemplate.update("INSERT INTO busy_books(userId,bookId)VALUES(?,?)"
                , userId
                , bookId);
        jdbcTemplate.update("UPDATE books SET isFree = false WHERE id = ?", bookId);
    }

    public void deleteBusyBook(int userId, int bookId) {
        jdbcTemplate.update("UPDATE books SET isFree=true WHERE id=?", bookId);
        jdbcTemplate.update("DELETE FROM busy_books WHERE bookId = ? AND userId = ?", bookId, userId);
    }

    public void createBook(Book book) {
        jdbcTemplate.update("INSERT INTO books(title,author,yearOfRealize,isFree) VALUES(?,?,?,?)"
                , book.getTitle()
                , book.getAuthor()
                , book.getYearOfRealize()
                , true);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id=?", new BeanPropertyRowMapper<>(Book.class), id)
                .stream().findAny().orElse(null);
    }

    public void updateBook(Book book, int id) {
        jdbcTemplate.update("UPDATE books  SET title=?,author=?,yearOfRealize=? WHERE id=?"
                , book.getTitle()
                , book.getAuthor()
                , book.getYearOfRealize()
                , id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM books  WHERE id=?", id);

    }

    public List<Book> getAllFreeBooks() {
        return jdbcTemplate.query("SELECT * FROM books WHERE isFree = true", new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> getAllBusyBooks(int userId) {
        return jdbcTemplate.query("SELECT * FROM books WHERE books.id IN(SELECT bookId FROM busy_books JOIN users U ON ? = userId)",
                new BeanPropertyRowMapper<>(Book.class), userId);
    }
}

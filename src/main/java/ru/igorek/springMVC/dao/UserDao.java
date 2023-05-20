package ru.igorek.springMVC.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.igorek.springMVC.model.User;

import java.util.List;

@Component
public class UserDao {

    private final JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void createUser(User user) {
        jdbc.update("INSERT INTO users(name,surname,yearOfBirth) VALUES(?,?,?)"
                , user.getName()
                , user.getSurname()
                , user.getYearOfBirth());
    }

    public User getUserById(int id) {
        return jdbc.query("SELECT * FROM users WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public List<User> getAllUsers() {
        return jdbc.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public void updateUser(User user, int id) {
        jdbc.update("UPDATE users SET name=?,surname=?,yearOfBirth=? WHERE id=?"
                , user.getName()
                , user.getSurname()
                , user.getYearOfBirth(), id);
    }

    public void deleteUser(int id) {
        jdbc.update("DELETE FROM users WHERE id = ?", id);
    }
}
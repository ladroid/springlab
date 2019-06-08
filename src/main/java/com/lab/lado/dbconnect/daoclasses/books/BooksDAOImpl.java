package com.lab.lado.dbconnect.daoclasses.books;

import com.lab.lado.dbconnect.Books;
import com.lab.lado.dbconnect.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(value = "book")
public class BooksDAOImpl implements BooksDAO {
    private JdbcTemplate jdbcTemplate;

    public BooksDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String taken_book(String email) {
        String sql = "SELECT books.name, persons.point, books.point FROM books "+
                "INNER JOIN persons ON books.point = persons.point " +
                "WHERE persons.email = ?";
        String result = jdbcTemplate.queryForObject(sql, new Object[]{email}, String.class);
        return result;
    }

    @Override
    public List getBook() {
        String sql = "SELECT * FROM books";

        List books = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Books books = new Books();
                books.setName(resultSet.getString("name"));
                return books;
            }
        });
        return books;
    }

    @Override
    public void insertBook(Books books) {
        String sql = "INSERT INTO books(bookid, name, pagecount, point, authorid, typeid, textbook) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, books.getId(), books.getName(), books.getPagecount(), books.getPoint(), books.getAuthorid(), books.getTypeid(), books.getFragment());
    }

    @Override
    public void delete_book(String name) {
        String sql = "DELETE FROM books WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}

package com.lab.lado.dbconnect.daoclasses.authorz;

import com.lab.lado.dbconnect.Authorz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component(value = "author")
public class AuthorzDAOImpl implements AuthorzDAO {
    private JdbcTemplate jdbcTemplate;

    public AuthorzDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertAuthorz(Authorz authorz) {
        String sql = "INSERT INTO authorz(authorid, name, surname) " +
                "VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, authorz.getAuthorid(), authorz.getName(), authorz.getSurname());
    }

    @Override
    public void delete_book(String name) {
        String sql = "DELETE FROM authorz WHERE surname = ?";
        jdbcTemplate.update(sql, name);
    }
}

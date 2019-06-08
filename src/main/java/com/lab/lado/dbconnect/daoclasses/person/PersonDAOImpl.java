package com.lab.lado.dbconnect.daoclasses.person;

import com.lab.lado.dbconnect.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component(value = "person")
public class PersonDAOImpl implements PersonDAO {
    private JdbcTemplate jdbcTemplate;

    public PersonDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void connectPerson(Person person) {
        String sql = "INSERT INTO persons(personId, name, surname, email, passwords, birthdate, gender, job, point, phone_number) " +
                                                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.getId(), person.getName(), person.getSurname(),
                person.getEmail(), person.getPass(), person.getBirthdate(), person.getGender(),
                person.getJob(), person.getPoint(), person.getPhonenumber());
    }

    @Override
    public Boolean checkPerson(String email, String pass) {
        String sql = "SELECT EXISTS(SELECT * FROM persons WHERE email = ? AND passwords = ?)";
        Boolean check = false;

        check = jdbcTemplate.queryForObject(sql, new Object[] {email, pass}, Boolean.class);
        return check;
    }

    @Override
    public List getInfromStudent(String email, String pass) {
        String sql = "SELECT * FROM persons WHERE email = ?" + " AND passwords = ?";
        List info = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person();
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setEmail(resultSet.getString("email"));
                person.setPhonenumber(resultSet.getString("phone_number"));
                return person;
            }
        }, email, pass);
        return info;
    }

    @Override
    public List searchStudent(String email) {
        String sql = "SELECT persons.name, persons.surname, persons.email, persons.phone_number, borrows.takenDate, books.name FROM borrows " +
                "INNER JOIN persons " + "ON borrows.personId = persons.personId " +
                "INNER JOIN books " + "ON borrows.bookId = books.bookId " +
                "WHERE persons.email = ?";
        List borrows_student = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person();
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setEmail(resultSet.getString("email"));
                return person;
            }
        }, email);
        return borrows_student;
    }

    @Override
    public void changeBook(Integer point, String email) {
        String sql = "UPDATE persons SET point = ? WHERE email = ?";
        jdbcTemplate.update(sql, point, email);
    }

    @Override
    public void leftBook(String email) {
        String sql = "update persons set point = null where email = ?";
        jdbcTemplate.update(sql, email);
    }
}

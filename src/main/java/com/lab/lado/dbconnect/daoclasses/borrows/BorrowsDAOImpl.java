package com.lab.lado.dbconnect.daoclasses.borrows;

import com.lab.lado.dbconnect.Books;
import com.lab.lado.dbconnect.Borrows;
import com.lab.lado.dbconnect.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component(value = "borrow")
public class BorrowsDAOImpl implements BorrowsDAO {
    private JdbcTemplate jdbcTemplate;

    public BorrowsDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertBorrow(Borrows borrow) {
        String sql = "INSERT INTO borrows(borrowid, personid, bookid, takendate, broughtdate) " +
                "VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, borrow.getId(), borrow.getStudentid(), borrow.getBookid(),
                borrow.getTakendate(), borrow.getBroughtdate());
    }

    @Override
    public List getBorrowsStudent() {
        String sql = "SELECT persons.name, persons.surname, persons.email, persons.phone_number, borrows.takenDate, books.name FROM borrows " +
                "INNER JOIN persons " + "ON borrows.personId = persons.personId " +
                "INNER JOIN books " + "ON borrows.bookId = books.bookId";
        List borrows_student = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Borrows borrows = new Borrows();
                Books books = new Books();
                Person person = new Person();

                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setEmail(resultSet.getString("email"));
                person.setPhonenumber(resultSet.getString("phone_number"));
                borrows.setTakendate(resultSet.getTimestamp("takenDate"));
                books.setName(resultSet.getString("name"));

                return person;
            }
        });
        return borrows_student;
    }
}

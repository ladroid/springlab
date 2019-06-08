package com.lab.lado.dbconnect.dbconnection;

import com.lab.lado.dbconnect.Authorz;
import com.lab.lado.dbconnect.Books;
import com.lab.lado.dbconnect.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorkClass {

    public void connectPerson(Connection conn, Person person) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            String SQL = "INSERT INTO persons(personId, name, surname, email, passwords, birthdate, gender, job, point, phone_number) \"\n" +
                    "                + \"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getName());
            pstmt.setString(3, person.getSurname());
            pstmt.setString(4, person.getEmail());
            pstmt.setString(5, person.getPass());
            pstmt.setDate(6, person.getBirthdate());
            pstmt.setString(7, person.getGender());
            pstmt.setString(8, person.getJob());
            pstmt.setInt(9, person.getPoint());
            pstmt.setString(10, person.getPhonenumber());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public Boolean checkPerson(Connection conn, String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Boolean check = false;
        try {
            String SQL = "SELECT * FROM persons WHERE email = ? AND passwords = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                check = true;
                String email_ = rs.getString("email");
                if(email_.equals(email)) {
                    return check;
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return check;
    }

    public List getInfromStudent(Connection conn, String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "SELECT * FROM persons WHERE email = ? AND passwords = ?";
        List info = new ArrayList();
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name_ = rs.getString("name");
                String surname  = rs.getString("surname");
                String email_ = rs.getString("email");
                String phonenumber = rs.getString("phone_number");
                info.add(name_);
                info.add(surname);
                info.add(email_);
                info.add(phonenumber);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return info;
    }

    public String taken_book(Connection conn, String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "SELECT books.name, persons.point, books.point FROM books "+
                "INNER JOIN persons ON books.point = persons.point " +
                "WHERE persons.email = ?";
        String result = "";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result = rs.getString("name");
                return result;
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return result;
    }

    public List getBook(Connection conn) {
        List books = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM books";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("bookid") + " "
                        + rs.getString("name"));
                books.add(rs.getString("name"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return books;
    }

    public void insertBook(Connection conn, Books books) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "INSERT INTO books(bookid, name, pagecount, point, authorid, typeid, textBook) "+
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, books.getId());
            pstmt.setString(2, books.getName());
            pstmt.setInt(3, books.getPagecount());
            pstmt.setInt(4, books.getPoint());
            pstmt.setInt(5, books.getAuthorid());
            pstmt.setInt(6, books.getTypeid());
            pstmt.setString(7, books.getFragment());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void insertAuthorz(Connection conn, Authorz authorz) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String SQL = "INSERT INTO authorz(authorid, name, surname) "+
                "VALUES(?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, authorz.getAuthorid());
            pstmt.setString(2, authorz.getName());
            pstmt.setString(3, authorz.getSurname());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void delete_author(Connection conn, String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "DELETE FROM authorz WHERE surname = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void delete_book(Connection conn, String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "DELETE FROM books WHERE name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List getBorrowsStudent(Connection conn) throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT persons.name, persons.surname, persons.email, persons.phone_number, borrows.takenDate, books.name FROM borrows " +
                    "INNER JOIN persons " + "ON borrows.personId = persons.personId " +
                    "INNER JOIN books " + "ON borrows.bookId = books.bookId";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                borrows_student.add(rs.getString("name") + " " + rs.getString("surname") + " " +
                        rs.getString("email") + " " + rs.getString("phone_number") +
                        " " + rs.getString("takenDate"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return borrows_student;
    }

    public List searchStudent(Connection conn, String email) throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT persons.name, persons.surname, persons.email, persons.phone_number, borrows.takenDate, books.name FROM borrows " +
                "INNER JOIN persons " + "ON borrows.personId = persons.personId " +
                "INNER JOIN books " + "ON borrows.bookId = books.bookId " +
                "WHERE persons.email = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                borrows_student.add(rs.getString("name"));
                borrows_student.add(rs.getString("surname"));
                borrows_student.add(rs.getString("email"));
            }
            rs.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return borrows_student;
    }

    public Timestamp getTimeTake(Connection connection, String email) throws ClassNotFoundException {
        Timestamp timetake = null;
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT borrows.takenDate FROM borrows " + "INNER JOIN persons " +
                "ON borrows.personId = persons.personId " + "WHERE persons.email = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                timetake = rs.getTimestamp("takendate");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return timetake;
    }

    public List get_free_books(Connection conn) throws ClassNotFoundException {
        List list_free_books = new ArrayList();
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT books.bookid FROM books " + "FULL OUTER JOIN persons " +
                "ON books.point = persons.point " + "WHERE books.point IS NULL OR persons.point IS NULL";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list_free_books.add(rs.getString("bookid"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list_free_books;
    }

    public void change_book(Connection conn, Integer point, String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String sql = "UPDATE persons SET point = ? WHERE email = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, point);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void leftBook(Connection conn, String email) {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                String sql = "update persons " + "set point = null " + "where email = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.getMessage();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


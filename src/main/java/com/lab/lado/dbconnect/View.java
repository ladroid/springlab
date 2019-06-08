package com.lab.lado.dbconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class View {
    private Authorz authorz;
    private Books books;
    private Person person;
    private Borrows borrows;
    private Integer choiceBookId;

    private static String url = "jdbc:postgresql://localhost:5432/jdbcproj";
    private static String user = "postgres";
    private static String password = "1";

    public View() {
        this.authorz = new Authorz();
        this.books = new Books();
        this.person = new Person();
        this.borrows = new Borrows();
    }

    public void personRegister(Integer id, String name, String email, String pass, String surname, Date birthdate, String gender, String job, Integer point, String phonenumber) {
        person.setId(id);
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);
        person.setPass(pass);
        person.setBirthdate(birthdate);
        person.setGender(gender);
        person.setJob(job);
        person.setPoint(point);
        person.setPhonenumber(phonenumber);

//        System.out.println("Please make a choice of book(id)");
//        try(Connection conn = DriverManager.getConnection(url, user, password)) {
//            Statement st = conn.createStatement();
//            String sql = "SELECT * FROM books";
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("bookid") + " "
//                        + rs.getString("name"));
//            }
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void updateToDB(Integer id, String name, String surname, String email, String pass, Date birthdate, String gender, String class_, Integer point, String phonenumber) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        person.setId(id);
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);
        person.setPass(pass);
        person.setBirthdate(birthdate);
        person.setGender(gender);
        person.setJob(class_);
        person.setPoint(point);
        person.setPhonenumber(phonenumber);

        System.out.println(person.getId() + " " + person.getName() + " " + person.getSurname()
                + " " + person.getBirthdate() + " " + person.getGender() + " " + person.getJob()
                + " " + person.getPoint());
        String SQL = "INSERT INTO students(studentid, name, surname, email, passwords, birthdate, gender, class, point, phone_number) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

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
            e.printStackTrace();
        }
    }

    public Boolean checkPerson(String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Boolean check = false;
        String SQL = "SELECT * FROM persons WHERE email = ? AND passwords = ?";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
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

    public List getInfromStudent(String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "SELECT * FROM persons WHERE email = ? AND passwords = ?";
        List info = new ArrayList();
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
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

    public String taken_book(String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "SELECT books.name, students.point, books.point FROM books "+
                     "INNER JOIN persons ON books.point = persons.point " +
                     "WHERE persons.email = ?";
        String result = "";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
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

    public List getBook() {
        List books = new ArrayList();
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
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

    public void insertBook(Integer id, String name, Integer pagecount, Integer point, Integer authorid, Integer typeid) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        books.setId(id);
        books.setName(name);
        books.setPagecount(pagecount);
        books.setPoint(point);
        books.setAuthorid(authorid);
        books.setTypeid(typeid);
        String SQL = "INSERT INTO books(bookid, name, pagecount, point, authorid, typeid) "+
                "VALUES(?, ?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, books.getId());
            pstmt.setString(2, books.getName());
            pstmt.setInt(3, books.getPagecount());
            pstmt.setInt(4, books.getPoint());
            pstmt.setInt(5, books.getAuthorid());
            pstmt.setInt(6, books.getTypeid());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void insertAuthorz(Integer authorId, String name, String surname) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        authorz.setAuthorid(authorId);
        authorz.setName(name);
        authorz.setSurname(surname);
        String SQL = "INSERT INTO authorz(authorid, name, surname) "+
                "VALUES(?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, authorz.getAuthorid());
            pstmt.setString(2, authorz.getName());
            pstmt.setString(3, authorz.getSurname());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void delete_author(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "DELETE FROM authorz WHERE surname = ?";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void delete_book(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String SQL = "DELETE FROM books WHERE name = ?";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List getBorrowsStudent() throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
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

    public List searchStudent(String email) throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        String sql = "SELECT persons.name, persons.surname, persons.email, persons.phone_number, borrows.takenDate, books.name FROM borrows " +
                "INNER JOIN persons " + "ON borrows.personId = persons.personId " +
                "INNER JOIN books " + "ON borrows.bookId = books.bookId " +
                "WHERE persons.email = ?";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
}

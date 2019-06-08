package com.lab.lado.dbconnect.dbconnection;

import com.lab.lado.dbconnect.Authorz;
import com.lab.lado.dbconnect.Books;
import com.lab.lado.dbconnect.Borrows;
import com.lab.lado.dbconnect.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    private Authorz authorz;
    private Books books;
    private Person person;
    private Borrows borrows;
    private Integer choiceBookId;
    private DBWorkClass dbWorkClass;

    private static String url = "jdbc:postgresql://localhost:5432/jdbcproj";
    private static String user = "postgres";
    private static String password = "1";

    public DBConnect() {
        this.authorz = new Authorz();
        this.books = new Books();
        this.person = new Person();
        this.borrows = new Borrows();
        this.dbWorkClass = new DBWorkClass();
    }

    public void updateToDB(Integer id, String name, String surname, String email, String pass, Date birthdate, String gender, String job, Integer point, String phonenumber) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Person person = new Person.BuilderPerson().setId(id).setName(name).setSurname(surname).setEmail(email)
                .setPass(pass).setBirthdate(birthdate).setGender(gender).setJob(job).setPoint(point).setPhonenumber(phonenumber).build();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.connectPerson(connection, person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean checkPerson(String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Boolean check = false;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            check = dbWorkClass.checkPerson(connection, email, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List getInfromStudent(String email, String pass) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        List informstudent = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            for(int i=0; i<dbWorkClass.getInfromStudent(connection, email, pass).size(); i++) {
                informstudent = dbWorkClass.getInfromStudent(connection, email, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informstudent;
    }

    public String taken_book(String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String takenbook = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            takenbook = dbWorkClass.taken_book(connection, email);
        } catch (SQLException e) {
            e.getMessage();
        }
        return takenbook;
    }

    public List getBook() {
        List books = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            for (int i=0; i<dbWorkClass.getBook(connection).size(); i++) {
                books = dbWorkClass.getBook(connection);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return books;
    }

    public void insertBook(Integer id, String name, Integer pagecount, Integer point, Integer authorid, Integer typeid, String fragment) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Books books = new Books.BuilderBooks().setId(id).setName(name).setPagecount(pagecount)
                .setPoint(point).setAuthorid(authorid).setTypeid(typeid).setFragment(fragment).build();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.insertBook(connection, books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAuthorz(Integer authorId, String name, String surname) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Authorz authorz = new Authorz.BuilderAuthorz().setAuthorid(authorId).setName(name).setSurname(surname).build();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.insertAuthorz(connection, authorz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_author(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.delete_author(connection, name);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void delete_book(String name) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.delete_book(connection, name);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List getBorrowsStudent() throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            for(int i=0; i<dbWorkClass.getBorrowsStudent(connection).size(); i++) {
                borrows_student.add(dbWorkClass.getBorrowsStudent(connection).get(i));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return borrows_student;
    }

    public List searchStudent(String email) throws ClassNotFoundException {
        List borrows_student = new ArrayList();
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            for(int i=0; i<dbWorkClass.searchStudent(connection, email).size(); i++) {
                borrows_student=dbWorkClass.searchStudent(connection, email);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return borrows_student;
    }

    public Timestamp getTimeTakeBook(String email) throws ClassNotFoundException {
        Timestamp time = null;
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            time = dbWorkClass.getTimeTake(connection, email);
        } catch (SQLException e) {
            e.getMessage();
        }
        return time;
    }

    public List getFreeBooks() throws ClassNotFoundException {
        List freeBooks = new ArrayList();
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            for(int i=0; i<dbWorkClass.get_free_books(connection).size(); i++) {
                freeBooks = dbWorkClass.get_free_books(connection);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return freeBooks;
    }

    public void changeBook(Integer point, String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.change_book(connection, point, email);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void leftBook(String email) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            dbWorkClass.leftBook(connection, email);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}

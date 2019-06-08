package com.lab.lado.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private View view;
    private static String url = "jdbc:postgresql://localhost:5432/jdbcproj";
    private static String user = "postgres";
    private static String password = "1";

    public Connector() {
        this.view = new View();
    }

//    public void startStud() {
//        view.personRegister();
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection(url, user, password);
//            System.out.println(connection.getCatalog());
//            System.out.println("Connected successfully!");
//            view.updateToDB();
//            view.insertToBorrows();
//        } catch (SQLException e) {
//            e.getMessage();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void startBook() {
        //view.insertBook();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection.getCatalog());
            System.out.println("Connected successfully!");
            //view.updateBook();
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startAuthorz() {
        //view.insertAuthorz();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection.getCatalog());
            System.out.println("Connected successfully!");
            //view.updateAuthorz();
        } catch (SQLException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.lab.lado.dbconnect;

import com.lab.lado.dbconnect.daoclasses.borrows.BorrowsDAOImpl;
import com.lab.lado.dbconnect.dbconnection.DBConnect;

public class Library {
//    private static String url = "jdbc:postgresql://localhost:5432/jdbcproj";
//    private static String user = "postgres";
//    private static String password = "1";

    public static void main(String[] args) throws ClassNotFoundException {
        //Connector connector = new Connector();



        View view = new View();
        view.getInfromStudent("carteradams@gmail.com", "cartenadams");
        if(view.checkPerson("carteradams@gmail.com", "cartenadams") == true) {
            System.out.println("True");
            System.out.println(view.getInfromStudent("carteradams@gmail.com", "cartenadams"));
            System.out.println(view.taken_book("carteradams@gmail.com"));
        } else {
            System.out.println("Error");
        }
        view.insertAuthorz(27, "Albert", "Camu");
        view.insertBook(27, "The Stranger", 245, 123, 27, 13);
        for(int i=0; i<view.getBorrowsStudent().size(); i++) {
            System.out.println(view.getBorrowsStudent().get(i));
        }
        System.out.println(view.searchStudent("carteradams@gmail.com"));

        //connector.startStud();
//        com.library.View view = new com.library.View();
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
    }

//    public void inserting() {
//        com.library.Person person = new com.library.Person();
//        String SQL = "INSERT INTO students(studentid, name, surname, birthdate, gender, class, point) "
//                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
//        try(Connection conn = DriverManager.getConnection(url, user, password);
//        PreparedStatement pstmt = conn.prepareStatement(SQL)) {
//            person.setId(21);
//            person.setName("Jhon");
//            person.setSurname("Edisson");
//            person.setBirthdate(Date.valueOf("1999-09-03"));
//            person.setGender("M");
//            person.setClass_("9D");
//            person.setPoint(12);
//
//            pstmt.setInt(1, person.getId());
//            pstmt.setString(2, person.getName());
//            pstmt.setString(3, person.getSurname());
//            pstmt.setDate(4, person.getBirthdate());
//            pstmt.setString(5, person.getGender());
//            pstmt.setString(6, person.getClass_());
//            pstmt.setInt(7, person.getPoint());
//
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

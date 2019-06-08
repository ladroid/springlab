package com.lab.lado.dbconnect.daoclasses.person;

import com.lab.lado.dbconnect.Person;

import java.util.List;

public interface PersonDAO {
    public void connectPerson(Person person);
    public Boolean checkPerson(String email, String pass);
    public List getInfromStudent(String email, String pass);
    public List searchStudent(String email);
    public void changeBook(Integer point, String email);
    public void leftBook(String email);
}

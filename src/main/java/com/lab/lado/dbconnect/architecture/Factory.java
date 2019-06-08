package com.lab.lado.dbconnect.architecture;

public class Factory {
    public Person getType(String typeemail) {
        if(typeemail == null) {
            return null;
        }
        if(typeemail.equals("admin@admin.com")) {
            return new Admin();
        } else {
            return new LoginPerson();
        }
    }
}

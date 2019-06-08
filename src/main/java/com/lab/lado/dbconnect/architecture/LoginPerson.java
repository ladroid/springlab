package com.lab.lado.dbconnect.architecture;

public class LoginPerson implements Person {
    public String email;
    public String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }
}

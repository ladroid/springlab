package com.lab.lado.dbconnect;

public class Studentinfo {
    public String name;
    public String surname;
    public String email;
    public String phonenumber;
    public String takenbook;

    public Studentinfo() {}

    public Studentinfo(String name, String surname, String email, String phonenumber, String takenbook) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.takenbook = takenbook;
    }

    public static class BuilderStudentinfo {
        public String name;
        public String surname;
        public String email;
        public String phonenumber;
        public String takenbook;

        public BuilderStudentinfo setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderStudentinfo setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public BuilderStudentinfo setEmail(String email) {
            this.email = email;
            return this;
        }

        public BuilderStudentinfo setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public BuilderStudentinfo setTakenbook(String takenbook) {
            this.takenbook = takenbook;
            return this;
        }

        public Studentinfo build() {
            return new Studentinfo(name, surname, email, phonenumber, takenbook);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setTakenbook(String takenbook) {
        this.takenbook = takenbook;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getTakenbook() {
        return takenbook;
    }
}

package com.lab.lado.dbconnect;

import java.sql.Date;

public class Person {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String pass;
    private Date birthdate;
    private String gender;
    private String job;
    private Integer point;
    private String phonenumber;

    public Person() {}

    public Person(Integer id, String name, String surname, String email, String pass, Date birthdate, String gender, String job, Integer point, String phonenumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.birthdate = birthdate;
        this.gender = gender;
        this.job = job;
        this.point = point;
        this.phonenumber = phonenumber;
    }

    public static class BuilderPerson {
        private Integer id;
        private String name;
        private String surname;
        private String email;
        private String pass;
        private Date birthdate;
        private String gender;
        private String job;
        private Integer point;
        private String phonenumber;

        public BuilderPerson() {}

        public BuilderPerson setId(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderPerson setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderPerson setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public BuilderPerson setEmail(String email) {
            this.email = email;
            return this;
        }

        public BuilderPerson setPass(String pass) {
            this.pass = pass;
            return this;
        }

        public BuilderPerson setBirthdate(Date birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public BuilderPerson setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public BuilderPerson setJob(String job) {
            this.job = job;
            return this;
        }

        public BuilderPerson setPoint(Integer point) {
            this.point = point;
            return this;
        }

        public BuilderPerson setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public Person build() {
            return new Person(id, name, surname, email, pass, birthdate, gender, job, point, phonenumber);
        }
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getId() {
        return id;
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

    public String getPass() {
        return pass;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public Integer getPoint() {
        return point;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getSurname() + " " + getEmail() + " " + getPass() + " " + getBirthdate()
                + " " + getGender() + " " + getJob() + " " + getPoint() + " " + getPhonenumber();
    }
}

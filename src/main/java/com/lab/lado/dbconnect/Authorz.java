package com.lab.lado.dbconnect;

public class Authorz {
    private Integer authorid;
    private String name;
    private String surname;

    public Authorz() {}

    public Authorz(Integer authorid, String name, String surname) {
        this.authorid = authorid;
        this.name = name;
        this.surname = surname;
    }

    public static class BuilderAuthorz {
        private Integer authorid;
        private String name;
        private String surname;

        public BuilderAuthorz setAuthorid(Integer authorid) {
            this.authorid = authorid;
            return this;
        }

        public BuilderAuthorz setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderAuthorz setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Authorz build() {
            return new Authorz(authorid, name, surname);
        }
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

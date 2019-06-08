package com.lab.lado.dbconnect;

import java.sql.Timestamp;

public class Borrows {
    private Integer id;
    private Integer studentid;
    private Integer bookid;
    private Timestamp takendate;
    private Timestamp broughtdate;

    public Borrows() {}

    public Borrows(Integer id, Integer studentid, Integer bookid, Timestamp takendate, Timestamp broughtdate) {
        this.id = id;
        this.studentid = studentid;
        this.bookid = bookid;
        this.takendate = takendate;
        this.broughtdate = broughtdate;
    }

    public static class BuilderBorrows {
        private Integer id;
        private Integer studentid;
        private Integer bookid;
        private Timestamp takendate;
        private Timestamp broughtdate;

        public BuilderBorrows setId(Integer id) {
            this.id = id;
            return this;
        }

        public BuilderBorrows setStudentid(Integer studentid) {
            this.studentid = studentid;
            return this;
        }

        public BuilderBorrows setBookid(Integer bookid) {
            this.bookid = bookid;
            return this;
        }

        public BuilderBorrows setTakendate(Timestamp takendate) {
            this.takendate = takendate;
            return this;
        }

        public BuilderBorrows setBroughtdate(Timestamp broughtdate) {
            this.broughtdate = broughtdate;
            return this;
        }

        public Borrows build() {
            return new Borrows(id, studentid, bookid, takendate, broughtdate);
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public void setTakendate(Timestamp takendate) {
        this.takendate = takendate;
    }

    public void setBroughtdate(Timestamp broughtdate) {
        this.broughtdate = broughtdate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public Timestamp getTakendate() {
        return takendate;
    }

    public Timestamp getBroughtdate() {
        return broughtdate;
    }
}

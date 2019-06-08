package com.lab.lado.dbconnect.daoclasses.borrows;

import com.lab.lado.dbconnect.Borrows;

import java.util.List;

public interface BorrowsDAO {
    public void insertBorrow(Borrows borrow);
    public List getBorrowsStudent();
}

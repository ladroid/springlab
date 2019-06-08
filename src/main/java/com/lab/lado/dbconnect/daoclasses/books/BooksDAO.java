package com.lab.lado.dbconnect.daoclasses.books;

import com.lab.lado.dbconnect.Books;

import java.sql.Connection;
import java.util.List;

public interface BooksDAO {
    public String taken_book(String email);
    public List getBook();
    public void insertBook(Books books);
    public void delete_book(String name);
}

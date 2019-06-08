package com.lab.lado.dbconnect.daoclasses.authorz;

import com.lab.lado.dbconnect.Authorz;
import org.springframework.stereotype.Service;

public interface AuthorzDAO {
    public void insertAuthorz(Authorz authorz);
    public void delete_book(String name);
}

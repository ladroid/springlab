package com.lab.lado;

import com.lab.lado.dbconnect.Authorz;
import com.lab.lado.dbconnect.Books;
import com.lab.lado.dbconnect.Borrows;
import com.lab.lado.dbconnect.Person;
import com.lab.lado.dbconnect.daoclasses.authorz.AuthorzDAO;
import com.lab.lado.dbconnect.daoclasses.books.BooksDAO;
import com.lab.lado.dbconnect.daoclasses.borrows.BorrowsDAO;
import com.lab.lado.dbconnect.daoclasses.person.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class.getName());
    @Autowired
    @Qualifier("author")
    private AuthorzDAO authorzDAO;
    @Autowired
    @Qualifier("book")
    private BooksDAO booksDAO;
    @Autowired
    @Qualifier("borrow")
    private BorrowsDAO borrowsDAO;
    @Autowired
    @Qualifier("person")
    private PersonDAO personDAO;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView printHello() {
        return new ModelAndView("hello", "command", new LoginPerson());
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String login(@ModelAttribute("SpringWeb")LoginPerson person, ModelMap model, HttpServletRequest request) {
        model.addAttribute("info", personDAO.getInfromStudent(person.getEmail(), person.getPassword()));
        model.addAttribute("takenbook", person.getEmail());
        if (person.getEmail().equals("admin@admin.com") && person.getPassword().equals("admin")) {
            logger.warning("AAAAA");
            logger.warning(person.getEmail());
            return "admin";
        } else if(personDAO.checkPerson(person.getEmail(), person.getPassword()) == true){
            logger.warning(personDAO.checkPerson(person.getEmail(), person.getPassword()).toString());
            logger.warning("BBBBB");
            logger.warning(person.getPassword());
            return "personinfo";
        } else {
            return new ResponseStatusException().error();
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "person", new Person());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute("person") Person person) {
        logger.warning("Hello");
        logger.warning(person.toString());
        personDAO.connectPerson(person);
        return "redirect:/registerbook";
    }

    @RequestMapping(value = "/registerbook", method = RequestMethod.GET)
    public ModelAndView registerbook() {
        //model.addAttribute("newborrow", new Borrows());
        return new ModelAndView("registerbook", "newborrow", new Borrows());
    }

    @RequestMapping(value = "/registerbook", method = RequestMethod.POST)
    public String regbook(@ModelAttribute("newborrow") Borrows borrows, ModelMap model) {
        logger.warning(String.valueOf(borrows.getId()));
        model.addAttribute("borrowid", borrows.getId());
        model.addAttribute("personid", borrows.getStudentid());
        model.addAttribute("bookid", borrows.getBookid());
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date today30 = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp todays30 = Timestamp.valueOf(dateFormat.format(today30));
        Timestamp todayy = Timestamp.valueOf(dateFormat.format(today));
        borrows.setTakendate(todayy);
        borrows.setBroughtdate(todays30);
        borrowsDAO.insertBorrow(borrows);
        return "hello";
    }

    @RequestMapping(value = "/addauth", method = RequestMethod.GET)
    public ModelAndView addauth() {
        return new ModelAndView("addauthbooks", "adding", new Authorz());
    }

    @RequestMapping(value = "/example", method = RequestMethod.POST)
    public String addingauthor(@ModelAttribute Authorz authorz, ModelMap model) {
        model.addAttribute("id_author", authorz.getAuthorid());
        model.addAttribute("fname_author", authorz.getName());
        model.addAttribute("lname_author", authorz.getSurname());
        logger.warning(String.valueOf(authorz.getAuthorid()));
        logger.warning(authorz.getName());
        logger.warning(authorz.getSurname());
        authorzDAO.insertAuthorz(authorz);
        return "example";
    }

    @RequestMapping(value = "/addbooks", method = RequestMethod.GET)
    public ModelAndView addbook() {
        return new ModelAndView("addbook", "addingbook", new Books());
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String addingbook(@ModelAttribute Books books, ModelMap model) {
        model.addAttribute("id", books.getId());
        model.addAttribute("name", books.getName());
        model.addAttribute("pagecount", books.getPagecount());
        model.addAttribute("point", books.getPoint());
        model.addAttribute("authorid", books.getAuthorid());
        model.addAttribute("typeid", books.getTypeid());
        model.addAttribute("fragment", books.getFragment());
        logger.warning(String.valueOf(books.getId()));
        logger.warning(books.getName());
        logger.warning(String.valueOf(books.getPagecount()));
        booksDAO.insertBook(books);
        return "admin";
    }

    @RequestMapping(value = "/deleteauth", method = RequestMethod.GET)
    public ModelAndView deleteauthbooks() {
        return new ModelAndView("deleteauthbooks", "deletingauthor", new Authorz());
    }

    @RequestMapping(value = "/admins", method = RequestMethod.POST)
    public String deleteresult(@ModelAttribute Authorz authorz, ModelMap model) {
        model.addAttribute("id", authorz.getAuthorid());
        model.addAttribute("name", authorz.getName());
        model.addAttribute("surname", authorz.getSurname());
        authorzDAO.delete_book(authorz.getSurname());
        return "admin";
    }

    @RequestMapping(value = "/deletebooks", method = RequestMethod.GET)
    public ModelAndView deletebook() {
        return new ModelAndView("deletebooks", "deletingbook", new Books());
    }

    @RequestMapping(value = "/nadmin", method = RequestMethod.POST)
    public String deletebookresult(@ModelAttribute Books books, ModelMap model) {
        model.addAttribute("id", books.getId());
        model.addAttribute("name", books.getName());
        model.addAttribute("pagecount", books.getPagecount());
        model.addAttribute("point", books.getPoint());
        model.addAttribute("authid", books.getAuthorid());
        model.addAttribute("typeid", books.getTypeid());
        booksDAO.delete_book(books.getName());
        return "admin";
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.GET)
    public ModelAndView borrows() {
        return new ModelAndView("borrow", "borrowing", new LoginPerson());
    }

    @RequestMapping(value = "/res", method = RequestMethod.POST)
    public String borrow(@ModelAttribute LoginPerson borrows, ModelMap model) {
        logger.warning(borrows.getEmail());
        List list_borrows = personDAO.searchStudent(borrows.getEmail());
        logger.warning(list_borrows.toString());
        model.addAttribute("borrow", list_borrows);
        return "result";
    }

    @RequestMapping(value = "/changebook", method = RequestMethod.GET)
    public ModelAndView change() {
        return new ModelAndView("changebook", "changing", new Person());
    }

    @RequestMapping(value = "/changebook", method = RequestMethod.POST)
    public String changebook(@ModelAttribute("changebook") Person point, ModelMap model, HttpServletRequest request) {
        model.addAttribute("point", point.getPoint());
        model.addAttribute("email", point.getEmail());
        logger.warning("Upper");
        logger.warning(String.valueOf(point.getPoint()));
        logger.warning(point.getEmail());
        logger.warning(request.getParameter("email"));
        if(point.getPoint() != null && request.getParameter("email") != null) {
            logger.warning("It works!!!");
            personDAO.changeBook(point.getPoint(), request.getParameter("email"));
        }
        logger.warning("Down");
        return "changebook";
    }

    @RequestMapping(value = "/leavebook", method = RequestMethod.GET)
    public ModelAndView leave() {
        return new ModelAndView("leavebook", "leaving", new Person());
    }

    @RequestMapping(value = "/nmain", method = RequestMethod.POST)
    public String leaving(@ModelAttribute("leavebook") Person point, ModelMap model, HttpServletRequest request) {
        model.addAttribute("email", point.getEmail());
        logger.warning("Upper");
        logger.warning(String.valueOf(point.getPoint()));
        logger.warning(point.getEmail());
        logger.warning(request.getParameter("email"));
        if(request.getParameter("email") != null) {
            logger.warning("It works!!!");
            personDAO.leftBook(request.getParameter("email"));
        }
        logger.warning("Down");
        return "personinfo";
    }
}

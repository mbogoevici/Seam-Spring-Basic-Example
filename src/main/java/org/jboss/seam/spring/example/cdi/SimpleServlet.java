package org.jboss.seam.spring.example.cdi;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.spring.example.domain.UserDao;

/**
 * @author Marius Bogoevici
 */
@WebServlet(name="simpleServlet", urlPatterns = "/servlet")
public class SimpleServlet extends HttpServlet{

    @Inject
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().println(userDao.getForUsername("jdoe").getFirstName());
    }
}

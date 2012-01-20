package org.jboss.seam.spring.example.web;

import org.jboss.seam.spring.example.cdi.Invoker;
import org.jboss.seam.spring.example.domain.User;
import org.jboss.seam.spring.example.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("greet")
public class GreetController {

    @Autowired
    private Invoker invoker;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ModelAttribute("message")
    String getInitialMessage() {
        return "Enter a valid name";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ModelAttribute("message")
    String getGreeting(@RequestParam("username") String username) {
        return invoker.getMessage(username);
    }
}
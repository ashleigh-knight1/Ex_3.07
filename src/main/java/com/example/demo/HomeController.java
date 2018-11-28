package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person= new Person();
        person.setName("Ashleigh Knight");
        person.setNationality("Antiguan");

        Passport passport= new Passport();
        passport.setCode("a9w0ue");
        passport.setCountryoforigin("Antigua & Barbuda");

        person.setPassport(passport);

        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
}

package edu.sharif.webclass.security.JWT.Prac.controllers;

import edu.sharif.webclass.security.JWT.Prac.models.EndUser;
import edu.sharif.webclass.security.JWT.Prac.repositories.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EndUserController {
    @Autowired
    private EndUserRepository endUserRepository;


}

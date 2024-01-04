package api.agendame.controllers;

import api.agendame.AgendameApplication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/csrf")
    @CrossOrigin
    public String csrf(CsrfToken csrfToken) {
        AgendameApplication.CUR_TOKEN = csrfToken.getToken();
        return AgendameApplication.CUR_TOKEN;
    }
}

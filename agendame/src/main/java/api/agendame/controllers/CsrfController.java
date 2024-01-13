package api.agendame.controllers;

import api.agendame.AgendameApplication;
import api.agendame.CustomInfo;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {
    @GetMapping("/csrf")
    public String csrf(CsrfToken csrfToken) {
        CustomInfo.CUR_TOKEN = csrfToken.getToken();
        return CustomInfo.CUR_TOKEN;
    }
}

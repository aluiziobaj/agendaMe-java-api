package api.agendame.controllers;

import api.agendame.AgendameApplication;
import api.agendame.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login/{email}/{senha}")
    @CrossOrigin
    public ResponseEntity<Object> login(CsrfToken csrfToken,
                                @PathVariable(value = "email") String email,
                                @PathVariable(value = "senha") String senha) {

        var userModel = new UserModel().getInstance(
                1,
                "Aluizio",
                "aluizio@teste",
                "123456",
                "" );

        if(userModel.getLogin().equals(email)
                && userModel.getSenha().equals(senha)){
            userModel.setSenha("");
            userModel.setToken(csrfToken.getToken());
            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping("/user")
    @CrossOrigin
    public boolean isUserLogged() {
        return !AgendameApplication.CUR_TOKEN.isEmpty();
    }

    @GetMapping("/logout")
    @CrossOrigin
    public boolean logout() {
        AgendameApplication.CUR_TOKEN = "";
        return true;
    }
}

package api.agendame.controllers;

import api.agendame.CustomInfo;
import api.agendame.exception.AuthenticationException;
import api.agendame.models.LoginModel;
import api.agendame.models.UserModel;
import api.agendame.resources.UserResource;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    /*
    Post esta pedindo para desativar o CSRF.
    Não vou fazer isso pois preciso entendê-lo melhor
    */

    private UserModel currentUser;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginModel loginModel)
    {
        currentUser = null;
        var loginModelTemp=
                new LoginModel("aluizio@estreladistribuidora.com.br", "123456");

        int secondsToSleep = 1;
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        if(!loginModel.getLogin().equals(loginModelTemp.getLogin())
                || !loginModel.getPassword().equals(loginModelTemp.getPassword())){

            throw new AuthenticationException();
        }

        currentUser = new UserModel()
                .getInstance(1, "Aluizio", loginModel.getLogin());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UserResource().toHashMap(currentUser));
    }

    @GetMapping("/userLogged")
    public ResponseEntity<Object> isUserLogged() {
        if(currentUser == null || CustomInfo.CUR_TOKEN.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new UserResource().toHashMap(currentUser));
    }

    @GetMapping("/logout")
    public boolean logout() {
        currentUser = null;
        CustomInfo.CUR_TOKEN = "";
        return true;
    }
}

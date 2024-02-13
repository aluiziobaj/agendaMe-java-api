package api.agendame.controllers;

import api.agendame.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

@RestController
public class RegisterController{

    @PostMapping("/create")
    public ResponseEntity<Object> login(@RequestBody UserModel userModel)
    {
        int secondsToSleep = 2;
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        var usuarios = LoginController.usuarios;

        for (UserModel user : usuarios) {
            if (user.getLogin().equals(userModel.getLogin())) {
                return ResponseEntity
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .body("Ja existe um usuario cadastrado com este login");
            }
        }
        userModel.setId(usuarios.size() + 1);
        usuarios.add(userModel);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(null);
    }
}

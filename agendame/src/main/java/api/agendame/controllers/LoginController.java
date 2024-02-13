package api.agendame.controllers;

import api.agendame.CustomInfo;
import api.agendame.models.UserModel;
import api.agendame.resources.UserResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController{

    private UserModel currentUser;
    public static ArrayList<UserModel> usuarios = new ArrayList<UserModel>();

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserModel userModel)
    {
        currentUser = null;

        if(usuarios.isEmpty()){
            usuarios.add(new UserModel(1, "Aluizio Araujo"
                    ,"aluizio@estreladistribuidora.com.br", "123456"));
        }

        int secondsToSleep = 2;
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < usuarios.size(); i++) {
            var user = usuarios.get(i);

            if(user.getLogin().equals(userModel.getLogin()) && user.getPassword().equals(userModel.getPassword())){
                user.setCurrentUser(true);
                currentUser = user;
            }else{
                user.setCurrentUser(false);
            }

            usuarios.set(i ,user);
        }

        if(currentUser != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new UserResource().toHashMap(currentUser));
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED).body(null);
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

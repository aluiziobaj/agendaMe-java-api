package api.agendame.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


@Setter
@Getter
public class UserModel implements Serializable {
    private int Id;
    private String Nome;
    private String Login;
    private String Senha;
    private String Token;

    public UserModel getInstance(int id, String nome, String login, String senha, String token){
        var userModel = new UserModel();
        userModel.Id = id;
        userModel.Nome = nome;
        userModel.Login = login;
        userModel.Senha = senha;
        userModel.Token = token;
        return userModel;
    }

}

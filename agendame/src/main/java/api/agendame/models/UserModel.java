package api.agendame.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


@Setter
@Getter
public class UserModel implements Serializable {
    private int Id;
    private String Nome;
    @Email(message = "Preencha o campo login ")
    private String Login;
    @Size(min=6, message = "O campo password deve ter no minimo 6 caracteres")
    private String Password;
    private boolean isCurrentUser;

    public UserModel (int id, String nome, String login, String password){
        this.Id = id;
        this.Nome = nome;
        this.Login = login;
        this.Password = password;
    }

}

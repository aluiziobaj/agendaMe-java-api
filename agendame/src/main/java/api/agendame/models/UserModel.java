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
    private String Email;

    public UserModel getInstance(int id, String nome, String email){
        var userModel = new UserModel();
        userModel.Id = id;
        userModel.Nome = nome;
        userModel.Email = email;
        return userModel;
    }

}

package api.agendame.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class LoginModel {
    /*Como não haverá implementação no banco de dados, vou apenas 'mockar' as informações*/
    @Email(message = "Preencha o campo login ")
    private String login;
    @Size(min=6, message = "Preencha o campo password ")
    private String password;

    public LoginModel(String _login, String _password){
        login = _login;
        password = _password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package api.agendame.exception;

import api.agendame.CustomInfo;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends RuntimeException{
    public String getGeneralMessage() {
        return CustomInfo.INVALID_LOGIN;
    }

    public String getExceptionMessage() {
        return CustomInfo.INVALID_LOGIN_TIP;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

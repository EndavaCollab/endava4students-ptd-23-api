package travel.journal.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccesException extends RuntimeException {

    public UnauthorizedAccesException(String message) {
        super(message);
    }
}
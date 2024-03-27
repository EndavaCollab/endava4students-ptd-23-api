package travel.journal.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NoPermissionException extends RuntimeException{

    public NoPermissionException(String message) {
        super(message);
    }
}

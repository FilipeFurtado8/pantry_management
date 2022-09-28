package academy.mindswap.pantry_management.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static academy.mindswap.pantry_management.utils.Messages.RESOURCE_NOT_FOUND;

@ControllerAdvice
public class AppExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.error(RESOURCE_NOT_FOUND, ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

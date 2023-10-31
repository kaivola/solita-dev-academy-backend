package cloud.kaivola.devacademyassignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorDetails errorDetails = createErrorDetails(e.getMessage(), status);
        return new ResponseEntity<>(errorDetails, status);
    }

    private ErrorDetails createErrorDetails(String message, HttpStatus httpStatusCode) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setErrorMessage(message);
        errorDetails.setStatus(httpStatusCode);
        return errorDetails;
    }
}

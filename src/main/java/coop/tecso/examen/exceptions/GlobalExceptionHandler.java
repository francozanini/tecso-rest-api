package coop.tecso.examen.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid (
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
            HttpStatus status, 
            WebRequest request) 
	{

        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", new Date());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<?> handleIllegalArgumentException (
			RuntimeException ex, 
			HttpHeaders headers,
            HttpStatus status, 
            WebRequest request) 
{
		return errorResponse(HttpStatus.BAD_REQUEST, headers, ex.getMessage()); 
}
	
	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<?> handleNotFoundException(
			RuntimeException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request)
	{
		return errorResponse(HttpStatus.NOT_FOUND, headers, ex.getMessage());
	}
	
	@ExceptionHandler(value = {SQLException.class})
	protected ResponseEntity<?> handleSQLException(
			RuntimeException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, headers, ex.getMessage());
	}
	
		
	private ResponseEntity<Object> errorResponse(HttpStatus status, HttpHeaders headers, String errorMessage)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("timestamp", new Date());
		body.put("status", status);
		body.put("error", errorMessage);
		
		return new ResponseEntity<Object>(body, headers, status);
	}
	

}

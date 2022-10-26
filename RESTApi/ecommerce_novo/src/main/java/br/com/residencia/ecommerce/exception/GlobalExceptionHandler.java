package br.com.residencia.ecommerce.exception;

import java.util.List;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handlerAllExceptions(Exception ex, WebRequest request) {
		List<String> detalhes = new ArrayList<>();
		detalhes.add(ex.getLocalizedMessage());
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), "Erro ao processar a requisição", detalhes);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementFoundException.class)
	public final ResponseEntity<Object> handlerNoSuchElementFoundException(NoSuchElementFoundException ex,
			WebRequest request) {
		List<String> detalhes = new ArrayList<>();
		detalhes.add(ex.getLocalizedMessage());
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), "O registro buscado não foi encontrado", detalhes);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ErrorResponse error = new ErrorResponse(httpStatus.value(), "Falha na Validação dos Dados da Requisição",
				details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

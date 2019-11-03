package com.salesianostriana.dam.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(status, ex);
		return ResponseEntity.status(status).body(apiError);
	}
	
	@ExceptionHandler({VentaNotFoundException.class, ProductoNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiError apiError = new ApiError(status, "No encontrado", ex);
		return ResponseEntity.status(status).body(apiError);
	}
	
	@ExceptionHandler(VentaErroneaException.class)
	public ResponseEntity<Object> handleBadRequestVenta(VentaErroneaException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ApiError apiError = new ApiError(status, "Error al crear una nueva venta", ex);
		return ResponseEntity.status(status).body(apiError);
		
	}
	
	
	

}

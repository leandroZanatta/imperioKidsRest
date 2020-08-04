package br.com.sysdesc.imperio.kids.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class SysdescExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleBusinesServiceException(Exception ex) {

		return new ResponseEntity<>(new ExceptionHandlerModel(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}

@AllArgsConstructor
@Data
class ExceptionHandlerModel {

	private String mensagem;

}

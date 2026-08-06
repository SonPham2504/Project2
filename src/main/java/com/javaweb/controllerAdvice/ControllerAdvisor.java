package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.CustomException.FieldRequiredException;
import com.javaweb.model.ErrorResponeDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(
			ArithmeticException ex, WebRequest request) {

	    ErrorResponeDTO errorResponeDTO = new ErrorResponeDTO();
	    errorResponeDTO.setError(ex.getMessage());
	    List<String> deList = new ArrayList<String>();
	    deList.add("So nguyen khong chia cho so 0");
	    errorResponeDTO.setDetailsList(deList);

	    return new ResponseEntity<>(errorResponeDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

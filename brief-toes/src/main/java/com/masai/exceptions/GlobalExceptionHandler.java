package com.masai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	  @ExceptionHandler(CustomerException.class)
	   public ResponseEntity<MyErrorDetails>  customerExceptionHandler(CustomerException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	  
	  @ExceptionHandler(OrderException.class)
	   public ResponseEntity<MyErrorDetails>  orderExceptionHandler(OrderException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	  
	  
	  @ExceptionHandler(CartException.class)
	   public ResponseEntity<MyErrorDetails>  cartExceptionHandler(CartException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	
	
	   @ExceptionHandler(Exception.class)
	   public ResponseEntity<MyErrorDetails>  anyExceptionHandler(Exception ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }
	   
	   @ExceptionHandler(NoHandlerFoundException.class)
	   public ResponseEntity<MyErrorDetails>  noHandlerFound(NoHandlerFoundException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }
	   
	   
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetails>  notValidArgs(MethodArgumentNotValidException ex,WebRequest wr) {
		        
		   MyErrorDetails md=new MyErrorDetails();
		   md.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }

		@ExceptionHandler(FertilizerNotFoundException.class)
		public ResponseEntity<MyErrorDetails>  fertilizerExceptionHandler(FertilizerNotFoundException ex,WebRequest wr) {

			MyErrorDetails md=new MyErrorDetails();
			md.setMessage(ex.getMessage());
			md.setDetails(wr.getDescription(false));
			return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
		}
}

package com.springmart.springmartbackend.exception;

import com.springmart.springmartbackend.dto.ErrorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * SpringUserNotFoundException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(SpringUserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSpringUserNotFoundException(SpringUserNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("SpringUserNotFoundException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * ProductNotFoundException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("ProductNotFoundException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * CartNotFoundException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCartNotFoundException(CartNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("CartNotFoundException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * WishListNotFoundException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(WishListNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWishListNotFound(WishListNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("WishListNotFoundException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * WishListItemNotFoundException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(WishListItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWishListItemNotFound(WishListItemNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("WishListItemNotFoundException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * AuthenticationFailureException
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(AuthenticationFailureException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationFailureException(
            AuthenticationFailureException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        logger.error("AuthenticationFailureException Occurred:", errorResponse);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * EmptyResultDataAccessException
     * Deletion Exception Handler
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(
            EmptyResultDataAccessException exception) {
        ErrorResponse errorResponse = new ErrorResponse("Item does not exist.", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Exception
     * General Exception Handler
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse("Something went wrong", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

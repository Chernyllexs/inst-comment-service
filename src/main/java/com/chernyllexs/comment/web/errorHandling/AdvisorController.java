package com.chernyllexs.comment.web.errorHandling;

import com.chernyllexs.comment.api.AdvisorService;
import com.chernyllexs.comment.api.exception.CommentNotFoundException;
import com.chernyllexs.comment.api.exception.InvalidCommentException;
import com.chernyllexs.comment.api.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdvisorController extends ResponseEntityExceptionHandler {
    /**
     * add response entity builder
     **/
    @Autowired
    private AdvisorService advisorService;

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Object> handleCommentNotFoundException(CommentNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(advisorService.responseBuilder(ex, request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(advisorService.responseBuilder(ex, request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCommentException.class)
    public ResponseEntity<Object> handleInvalidCommentException(InvalidCommentException ex, WebRequest request) {
        return new ResponseEntity<>(advisorService.responseBuilder(ex, request), HttpStatus.BAD_REQUEST);
    }
}

package com.chernyllexs.comment.api.exception;

public class InvalidCommentException extends RuntimeException{
    public InvalidCommentException() {
        super();
    }

    public InvalidCommentException(String message) {
        super(message);
    }
}

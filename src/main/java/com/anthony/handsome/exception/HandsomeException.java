package com.anthony.handsome.exception;

public class HandsomeException extends RuntimeException {

    private int errorNo = HandsomeError.DEFAULT_ERROR.errorCode();
    private String errorMsg;

    public HandsomeException( HandsomeError error )
    {
        this.errorNo = error.errorCode();
        this.errorMsg = error.errorMsg();
    }

    public HandsomeException( HandsomeError error, String message )
    {
        this.errorNo = error.errorCode();
        this.errorMsg = error.errorMsg()+" : "+message;
    }
}

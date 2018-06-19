package com.anthony.handsome.exception;

public enum HandsomeError {

    DEFAULT_ERROR(0000000, "Default error"),

    INVALID_PATH(0000001, "Input path is invalid"),

    IS_NOT_FOLDER(0000002, "Inut path is not a folder");

    private int errorCode;

    private String errMsg;

    HandsomeError(int errorCode, String errMsg) {
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    public int errorCode() {
        return errorCode;
    }

    public String errorMsg() {
        return errMsg;
    }

    public String toString() {
        return String.valueOf(this.errorCode + ":" + this.errMsg);
    }
}

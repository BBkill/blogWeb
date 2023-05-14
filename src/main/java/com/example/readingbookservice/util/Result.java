package com.example.readingbookservice.util;

import java.io.Serializable;

public class Result<T> implements Serializable{

    public final static int SUCCESS = 200;
    public final static String SUCCESS_MES = "Success";

    public final static int NOT_FOUND = 400;
    public final static String NOT_FOUND_MES = "Not Found";

    public final static int BAD_REQUEST = 401;
    public final static String BAD_REQUEST_MES = "Bad request";

    private int code;

    private String rd;

    private int rc;

    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.rd = msg;
        this.data = data;
        this.rc = 0;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.rd = msg;
        this.data = null;
        this.rc = 0;
    }

    public Result() {
    }

    public static <T> Result<T> fail() {
        return new Result<T>(BAD_REQUEST, BAD_REQUEST_MES);
    }

    public static <T> Result<T> success() {
        return new Result<T>(SUCCESS, SUCCESS_MES);
    }

    public static <T> Result<T> fail(String meg) {
        return new Result<T>(BAD_REQUEST, meg);
    }

    public static <T> Result<T> success(String meg) {
        return new Result<T>(SUCCESS, meg);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<T>(BAD_REQUEST, BAD_REQUEST_MES, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(SUCCESS, SUCCESS_MES, data);
    }

    public static <T> Result<T> fail(String meg, T data) {
        return new Result<T>(BAD_REQUEST, meg, data);
    }

    public static <T> Result<T> success(String meg,T data) {
        return new Result<T>(SUCCESS, meg, data);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }

    public static <T> Result<T> error(String meg) {
        return new Result<T>(BAD_REQUEST, meg);
    }

    public static <T> Result<T> notFound(String meg) {
        return new Result<>(NOT_FOUND, meg);
    }

    public static <T> Result<T> notFound() {
        return new Result<>(NOT_FOUND, NOT_FOUND_MES);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

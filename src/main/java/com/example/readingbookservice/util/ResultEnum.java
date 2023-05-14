package com.example.readingbookservice.util;

public enum ResultEnum {
    BAD_REQUEST(400, "Bad Request"),
    SUCCESS(200, "OK"),
    TOKEN_EXPIRED(301, "Token expired"),
    TOKEN_ERROR(302, "Token Error"),
    LOGIN_ERROR(303, "Login Error"),
    REMOTE_ERROR(304, "Remote Error"),
    ITEM_EXIST_ERROR(305, "ITEM_EXIST_ERROR"),
    ITEM_NOT_FOUND_ERROR(306, "ITEM_NOT_FOUND_ERROR"),
    PARAM_INVALID_ERROR(307, "PARAM_INVALID_ERROR"),
    OTP_UNAUTHEN(308, "OTP_UNAUTHEN"),
    PACKAGE_EXPIRED_ERROR(309, "PACKAGE_EXPIRED_ERROR"),
    NO_REG(310, "NO_REG"),
    FAIL(311, "FAIL"),
    USER_NAME_NOT_FOUND(314, "FAIL"),
    ERR_IMPORT_EXCEL(313, "ERR_IMPORT_EXCEL"),
    ERR_CHOT_HOC_BA(315, "ERR_CHOT_HOC_BA"),
    SERVICE_ABNORMAL(99, "Dịch vụ đang bận"),
    OUT_OFF_MEMORY(312, "Hết tài nguyên hệ thống"),
    OTP_EXPIRE(501, "Mã OTP hết hiệu lực"),
    ERROR(999, "Hệ thống bận vui lòng thử lại sau!"),
    NOT_FOUND(404, "Not Found");
    private Integer code;
    private String desc;

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    private ResultEnum(final Integer code, final String desc) {
        this.code = code;
        this.desc = desc;
    }
}

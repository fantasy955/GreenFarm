package edu.cn.green_farm.service.exception;

/**
 * 用户名不存在
 */
public class PageParamErrorException extends ServiceException {

    private static final long serialVersionUID = -2470715991347231448L;

    public PageParamErrorException() {
        super();
    }

    public PageParamErrorException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PageParamErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageParamErrorException(String message) {
        super(message);
    }

    public PageParamErrorException(Throwable cause) {
        super(cause);
    }


}

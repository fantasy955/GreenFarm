package edu.cn.green_farm.service.exception;

/**
 * 订单数据不存在异常
 *
 * @author Choococo
 */
public class OrderDataNotFoundException extends ServiceException {

    private static final long serialVersionUID = 3247248436291557749L;

    public OrderDataNotFoundException() {
    }

    public OrderDataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OrderDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDataNotFoundException(String message) {
        super(message);
    }

    public OrderDataNotFoundException(Throwable cause) {
        super(cause);
    }
}

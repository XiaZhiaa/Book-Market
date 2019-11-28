package cn.javabs.book.exception;

import java.sql.SQLException;

public class BookDaoImplException extends RuntimeException{
    public BookDaoImplException() {
        super();
    }

    public BookDaoImplException(String message) {
        super(message);
    }

    public BookDaoImplException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDaoImplException(Throwable cause) {
        super(cause);
    }

    protected BookDaoImplException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

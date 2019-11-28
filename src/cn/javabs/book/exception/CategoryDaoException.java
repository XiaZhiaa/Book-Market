package cn.javabs.book.exception;

import java.sql.SQLException;

public class CategoryDaoException extends RuntimeException {
    public CategoryDaoException() {
        super();
    }

    public CategoryDaoException(String message) {
        super(message);
    }

    public CategoryDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryDaoException(Throwable cause) {
        super(cause);
    }

    protected CategoryDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

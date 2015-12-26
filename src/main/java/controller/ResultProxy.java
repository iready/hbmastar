package controller;

import other.entity.api.ErrorMessage;
import other.entity.api.Result;

public class ResultProxy {
    public static <T> T proxy(Result result, Class<T> class1) {
        if (class1.isInstance(result)) {
            return class1.cast(result);
        } else if (result instanceof ErrorMessage) {
            ErrorMessage errorMessage = (ErrorMessage) result;
            throw new IllegalAccessError(errorMessage.getMessage());
        }
        throw new RuntimeException("无法解析");
    }
}
package org.zyq.huobi.controller;

import org.zyq.huobi.other.entity.api.ErrorMessage;
import org.zyq.huobi.other.entity.api.Result;
import org.zyq.huobi.other.utils.SwingUtils;

import javax.swing.text.JTextComponent;

public class ResultProxy {
    public static <T> T proxy(Result result, Class<T> class1) {
        return proxy(result, class1, null);
    }

    public static <T> T proxy(Result result, Class<T> class1, JTextComponent jTextComponent) {
        if (class1.isInstance(result)) {
            return class1.cast(result);
        } else if (result instanceof ErrorMessage) {
            ErrorMessage errorMessage = (ErrorMessage) result;
            if (jTextComponent != null)
                SwingUtils.appendText(jTextComponent, errorMessage.getMessage());
            throw new IllegalAccessError(errorMessage.getMessage());
        }
        throw new RuntimeException("无法解析");
    }
}
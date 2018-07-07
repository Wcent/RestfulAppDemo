package org.cent.RestfulAppDemo.service;

import org.cent.RestfulAppDemo.exception.ServiceException;

public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public static String process(double number) {
        if (number < 0) {
            throw new ServiceException(ResultStatus.WARN);
        }

        if (number > 3) {
            return "lager than 3";
        } else if (number > 0) {
            return "range of 0 to 3 exclude 0";
        } else {
            return "zero";
        }
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

package com.carlos.workshopMongo.controller.exception;

import java.io.Serializable;

public class StandartError implements Serializable {

    private static long serialVersionUID = 1L;
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandartError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public StandartError() {

    }
}

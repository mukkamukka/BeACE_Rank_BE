package com.example.realmanclub.beacerank_be;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Message {

    private StatusEnum statusEnum;
    private String message;
    private Object data;

    public Message() {
        this.statusEnum = StatusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }
}

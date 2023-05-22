package com.prior.grpc.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseModel <T>{

    private LocalDate timeStamp;
    private String description;
    private Integer status;
    private T data;

}

package org.sandcastle.apps.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -4422507735400345361L;

    private T data;
    private long time;
    private String ip;
}

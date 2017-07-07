package org.sandcastle.apps.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String name;
    private String surname;
}
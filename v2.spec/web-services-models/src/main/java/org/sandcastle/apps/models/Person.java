package org.sandcastle.apps.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -2471997968975087024L;

    private String name;
    private String surname;
    private String displayName;
    private Gender gender;
}
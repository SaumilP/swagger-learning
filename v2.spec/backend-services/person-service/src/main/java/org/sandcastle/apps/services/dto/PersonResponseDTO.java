package org.sandcastle.apps.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sandcastle.apps.dto.ResponseDTO;
import org.sandcastle.apps.models.Person;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonResponseDTO extends ResponseDTO<Person> {
    private static final long serialVersionUID = 6548255564808717337L;
}

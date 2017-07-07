package org.sandcastle.apps.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sandcastle.apps.dto.ResponseDTO;
import org.sandcastle.apps.models.Memory;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemoryResponseDTO extends ResponseDTO<Memory> {
    private static final long serialVersionUID = -4851666122472660982L;
}

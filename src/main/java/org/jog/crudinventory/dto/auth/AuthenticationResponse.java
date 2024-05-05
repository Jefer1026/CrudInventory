package org.jog.crudinventory.dto.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class AuthenticationResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 2455480633085009467L;

    private String jwt;
}

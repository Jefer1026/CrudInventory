package org.jog.crudinventory.dto.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class AuthenticationRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -5754897833294078615L;

    private String username;
    private String password;
}

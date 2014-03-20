package com.common.dto.role;


import com.common.dto.IInputDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="role")
public class RoleInputDTO implements IInputDTO{

    private Long id;

    @NotEmpty(message="{valid.err.role.name.required}")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

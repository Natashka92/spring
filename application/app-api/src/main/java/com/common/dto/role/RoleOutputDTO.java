package com.common.dto.role;

import com.common.dto.IIdentiferDTO;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="role")
public class RoleOutputDTO implements IIdentiferDTO{
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

    private Long id;
    private String name;
}

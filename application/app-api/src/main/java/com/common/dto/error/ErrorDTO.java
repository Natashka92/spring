package com.common.dto.error;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="error")
public class ErrorDTO implements Serializable{
    private String type;
    private String message;

    public ErrorDTO(final Throwable exception, final String message) {
        this.type = exception.getClass().getSimpleName();
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

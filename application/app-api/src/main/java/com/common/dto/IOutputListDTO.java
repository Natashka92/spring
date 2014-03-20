package com.common.dto;

import java.io.Serializable;
import java.util.List;

public interface IOutputListDTO<DTO extends Serializable> extends IListDTO<DTO> {
    public List<DTO> getData();
    public void setData(List<DTO> data);
    public void addToData(DTO data);
}

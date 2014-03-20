package com.common.dto;

import java.io.Serializable;
import java.util.List;

public interface IListDTO<DTO extends Serializable> extends Serializable {
    public List<DTO> getData();
    public void setData(List<DTO> data);
    public void addToData(DTO data);
}

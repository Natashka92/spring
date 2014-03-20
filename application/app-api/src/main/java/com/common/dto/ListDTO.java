package com.common.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@XmlRootElement(name="elements")
public class ListDTO<DTO extends Serializable> implements IListDTO<DTO> {

    private List<DTO> data = new ArrayList<DTO>();

    @Override
    public String toString(){
        return "ListDTO [data=" + data + "]";
    }

    @Override
    public List<DTO> getData(){
        return data;
    }

    @Override
    public void setData(List<DTO> data){
        this.data = data;
    }

    @Override
    public void addToData(DTO dto){
        this.data.add(dto);
    }
}

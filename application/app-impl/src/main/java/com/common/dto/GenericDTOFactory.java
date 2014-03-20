package com.common.dto;

import org.springframework.stereotype.Component;
import java.util.List;
import com.common.model.*;


@Component
public abstract class GenericDTOFactory<
        T extends IdentifierEntity,
        InputDTO extends IInputDTO,
        OutputDTO extends IIdentiferDTO,
        ListDTO extends IListDTO<OutputDTO>> {

    public OutputDTO createOutputDTO(T model){
        OutputDTO dto = null;
        if (model != null) {
            dto = getOutputDTO();
            dto.setId(model.getId());
        }
        return dto;
    }

    public ListDTO createListDTO(List<T> modelList) {
        ListDTO listDto = getNewListDTO();
        if ((modelList != null) && (!modelList.isEmpty())) {
            for (T t : modelList) {
                OutputDTO dto = createOutputDTO(t);
                listDto.addToData(dto);
            }
        }
        return listDto;
    }

    protected abstract InputDTO getInputDTO();

    protected abstract OutputDTO getOutputDTO();

    protected abstract ListDTO getNewListDTO();
}

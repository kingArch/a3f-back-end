package com.a3f.building.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.a3f.building.dtos.RequestDto;
import com.a3f.building.entities.RequestEntity;

@Component
@Qualifier("requestMapper")
public class RequestMapper extends AbstractMapper<RequestEntity, RequestDto> {

    ModelMapper modelMapper = new ModelMapper();

    TypeMap<RequestEntity, RequestDto> entityToDto;
    TypeMap<RequestDto, RequestEntity> dtoToEntity;

    public RequestMapper() {
        this.entityToDto = this.modelMapper.createTypeMap(RequestEntity.class, RequestDto.class);
        this.dtoToEntity = this.modelMapper.createTypeMap(RequestDto.class, RequestEntity.class);

        this.entityToDto.addMappings(
            mapper -> mapper.map(src -> src.getRequester().getFName(), RequestDto::setRequesterGiven)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getLName(), RequestDto::setRequesterFamily)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getEmail(), RequestDto::setRequesterEmail)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getPhoneNumber(), RequestDto::setRequesterPhone)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getLine(), RequestDto::setRequesterLine)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getCity(), RequestDto::setRequesterCity)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getState(), RequestDto::setRequesterState)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequester().getPostalCode(), RequestDto::setRequesterPostal)
        ).addMappings(
            mapper -> mapper.map(src -> src.getId(), RequestDto::setId)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequestType(), RequestDto::setRequestType)
        ).addMappings(
            mapper -> mapper.map(src -> src.getRequestTitle(), RequestDto::setRequestTitle)
        ).addMappings(
            mapper -> mapper.map(src -> src.getDescription(), RequestDto::setDescription)
        ).addMappings(
            mapper -> mapper.map(src -> src.getUrgency(), RequestDto::setUrgency)
        ).addMappings(
            mapper -> mapper.map(src -> src.getLanguagePref(), RequestDto::setLanguagePref)
        ).addMappings(
            mapper -> mapper.map(src -> src.isCanReceiveSMS(), RequestDto::setCanReceiveSMS)
        );

        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterGiven(), (dest,value) -> dest.getRequester().setFName((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterFamily(), (dest,value) -> dest.getRequester().setLName((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterEmail(), (dest,value) -> dest.getRequester().setEmail((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterPhone(), (dest,value) -> dest.getRequester().setPhoneNumber((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterLine(), (dest,value) -> dest.getRequester().setLine((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterCity(), (dest,value) -> dest.getRequester().setCity((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterState(), (dest,value) -> dest.getRequester().setState((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequesterPostal(), (dest,value) -> dest.getRequester().setPostalCode((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getId(), (dest, value) -> dest.setId((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getInitialDate(), (dest, value) -> dest.setInitialDate((String) value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequestType(), (dest,value) -> dest.setRequestType((String)value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getRequestTitle(), (dest,value) -> dest.setRequestTitle((String)value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getDescription(), (dest,value) -> dest.setDescription((String)value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getUrgency(), (dest,value) -> dest.setUrgency((String)value))
        );
        this.dtoToEntity.addMappings(
            mapper -> mapper.map(src -> src.getLanguagePref(), (dest,value) -> dest.setLanguagePref((String)value))
        );
    }

    public RequestEntity dtoToEntity(RequestDto dto) {
        return this.dtoToEntity.map(dto);
    }

    public RequestDto entityToDto(RequestEntity entity) {
        return this.entityToDto.map(entity);
    }

}

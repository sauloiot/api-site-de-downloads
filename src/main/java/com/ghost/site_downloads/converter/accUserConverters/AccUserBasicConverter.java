package com.ghost.site_downloads.converter.accUserConverters;

import com.ghost.site_downloads.dto.AccUserDTO.AccUserBasicDTO;
import com.ghost.site_downloads.models.AccUser;

import java.util.List;
import java.util.stream.Collectors;

public class AccUserBasicConverter {
    public static AccUserBasicDTO entityToDTO(AccUser accUser){
        AccUserBasicDTO dto = new AccUserBasicDTO();
        dto.setUser_id(accUser.getUser_id());
        dto.setUser_name(accUser.getUser_name());

        return dto;
    }

    public static List<AccUserBasicDTO> entityToDTOList(List<AccUser> accUsers){
        return accUsers.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static AccUser dtoToEntity(AccUserBasicDTO dto){
        AccUser accUser = new AccUser();
        accUser.setUser_id(dto.getUser_id());
        accUser.setUser_name(dto.getUser_name());

        return accUser;
    }

    public static List<AccUser> dtoToEntityList(List<AccUserBasicDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}

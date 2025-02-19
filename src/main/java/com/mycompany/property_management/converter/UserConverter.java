package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO) {
        UserEntity ue = new UserEntity();
        ue.setOwnerEmail(userDTO.getOwnerEmail());
        ue.setOwnerName(userDTO.getOwnerName());
        ue.setPassword(userDTO.getPassword());
        ue.setPhone(userDTO.getPhone());
        return ue;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setId(userEntity.getId());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}

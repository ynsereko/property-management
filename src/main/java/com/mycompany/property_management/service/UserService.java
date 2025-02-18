package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDTO;

public interface UserService {

public UserDTO  register(UserDTO userDTO);
public UserDTO login(String email, String password);
}

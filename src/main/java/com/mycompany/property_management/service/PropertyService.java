package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
    public  void deleteProperty(Long propertyId);
}

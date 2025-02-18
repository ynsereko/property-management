package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
    public  void deleteProperty(Long propertyId);
}

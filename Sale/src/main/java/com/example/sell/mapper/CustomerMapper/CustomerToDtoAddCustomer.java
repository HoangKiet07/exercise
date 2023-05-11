package com.example.sell.mapper.CustomerMapper;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerToDtoAddCustomer {

    CustomerToDtoAddCustomer instance = Mappers.getMapper(CustomerToDtoAddCustomer.class);

    Customer toCustomer(DtoAddCustomer dtoAddCustomer);

    DtoAddCustomer toAddCustomer(Customer customer);
}

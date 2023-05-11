package com.example.sell.mapper.CustomerMapper;

import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerToUpdateCustomer {

    CustomerToUpdateCustomer instance = Mappers.getMapper(CustomerToUpdateCustomer.class);

    Customer toCustomer(DtoUpdateCustomer dtoUpdateCustomer);

    DtoUpdateCustomer toUpdateCustomer(Customer customer);
}

package com.springbootjunit5mockito;

import com.springbootjunit5mockito.controllers.CustomerController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;


public class ModelMaperTest {

    ModelMapper modelMapper = new ModelMapper();
    @Test
    public void mapTest()
    {
        Order order =  Order.builder().build();
        order.setCustomer(new Customer());
        order.getCustomer().setName(new Name());
        order.getCustomer().getName().setFirstName("mesut");
        order.getCustomer().getName().setFirstName("zincir");
        order.setBillingAddress(new Address());
        order.getBillingAddress().setCity("London");
        order.getBillingAddress().setStreet("HEX");

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        Assertions.assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        Assertions.assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        Assertions.assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        Assertions.assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
    }
}
@Data
@Builder
  class Order {
    Customer customer;
    Address billingAddress;
}
@Data
  class Customer {
    Name name;
}
@Data
 class Name {
    String firstName;
    String lastName;
}
@Data
 class Address {
    String street;
    String city;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class OrderDTO {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;

}

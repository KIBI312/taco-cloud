package com.example.tacocloud.domainobj;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class TacoOrder {
    
    @NotBlank(message = "Required field")
    private String deliveryName;

    @NotBlank(message = "Required field")
    private String deliveryStreet;

    @NotBlank(message = "Required field")
    private String deliveryCity;

    @NotBlank(message = "Required field")
    private String deliveryState;

    @NotBlank(message = "Required field")
    private String deliveryZip;
    
    @CreditCardNumber(message = "Enter valid credit card number")
    private String ccNumber;
    
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message="Must be formatted MM/YY")
    private String ccExpiration;
    
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
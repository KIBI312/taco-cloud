package com.example.tacocloud.domainobj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

    private Date placedAt = new Date();
    
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

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco) {
        this.tacos.add(taco);
    }
}
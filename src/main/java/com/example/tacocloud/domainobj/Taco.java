package com.example.tacocloud.domainobj;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
    @NotNull
    @Size(min=5, message = "Min length 5 chars")
    private String name;

    @NotNull
    @Size(min=1, message = "Choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
 
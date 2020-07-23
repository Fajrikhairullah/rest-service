package com.enigma.restservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;



@ApiModel(value = "Item", description = "Item description..")
public class ItemModel {
    
    @ApiModelProperty(value = "Item ID")
    private Integer id;
    
    @NotBlank(message = "{name.notblank}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}

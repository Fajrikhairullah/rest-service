package com.enigma.restservice.models;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.entities.Unit;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class StockModel {

    private Integer id;

    private Item item;

    @ApiModelProperty(value = "Quantity Name")
    @NotNull(message = "Quantity can't null")
    private Integer qty;

    private Unit unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "StockModel{"
                + "id=" + id
                + ", item=" + item
                + ", item=" + item.getName()
                + ", qty=" + qty
                + ", unit=" + unit
                + ", unit=" + unit.getName()
                + ", unit=" + unit.getDescription() + '}';
    }

}

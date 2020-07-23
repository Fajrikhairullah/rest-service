package com.enigma.restservice.entities;

import javax.persistence.*;

@Table(name = "stock")
@Entity
public class Stock extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    @Column(name = "qty")
    private Integer qty;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Unit unit;

    public Stock() {

    }

    public Stock(Item item, Integer qty, Unit unit) {

        this.item = item;
        this.qty = qty;
        this.unit = unit;
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
        return "Stock{" 
                + "id=" + getId() 
                + ", item=" + item
                + ", item=" + item.getName()
                + ", qty=" + qty 
                + ", unit=" + unit
                + ", unit=" + unit.getName()
                + ", unit=" + unit.getDescription()
                + '}';
    }

}

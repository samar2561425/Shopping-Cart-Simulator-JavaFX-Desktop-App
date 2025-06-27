/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingcart;

/**
 * Name, ID:-
 * Samar Asiri, 444000717
 * Rema Al-Ghamdi, 444001279
 * Aya Babkoor, 444002180
 * Raghad Al-Subhi, 444003965
 * 
 * Groub: 1
 */

import java.util.ArrayList;
import java.util.List;

public class ProductBundle extends ProductComponent {
    private String name;
    private List<ProductComponent> components = new ArrayList<>();

    public ProductBundle(String name) {
        this.name = name;
    }

    @Override
    public void add(ProductComponent component) {
        components.add(component);
    }

    @Override
    public void remove(ProductComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (ProductComponent c : components) {
            total += c.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return name + " (Bundle) - $" + getPrice();
    }
}

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

import java.util.List;

public class AddToCartCommand implements Command {
    private ProductComponent product;
    private List<ProductComponent> cart;

    public AddToCartCommand(ProductComponent product, List<ProductComponent> cart) {
        this.product = product;
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.add(product);
    }

    @Override
    public void undo() {
        cart.remove(product);
    }
}

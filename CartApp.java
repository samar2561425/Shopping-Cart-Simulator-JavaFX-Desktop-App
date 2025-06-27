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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class CartApp extends Application {

    private List<ProductComponent> cart = new ArrayList<>();
    private CommandManager commandManager = new CommandManager();
    private ListView<ProductComponent> productListView = new ListView<>();
    private ListView<ProductComponent> cartListView = new ListView<>();
    private Label totalLabel = new Label("Total: $0.00");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🛒 Shopping Cart Simulator");

        ProductComponent laptop = new SingleProduct("Laptop", 1200);
        ProductComponent mouse = new SingleProduct("Mouse", 50);
        ProductComponent keyboard = new SingleProduct("Keyboard", 100);

        ProductBundle bundle = new ProductBundle("Student Bundle");
        bundle.add(laptop);
        bundle.add(mouse);
        bundle.add(keyboard);

        productListView.getItems().addAll(laptop, mouse, keyboard, bundle);

        Button addButton = new Button("Add ➕");
        Button removeButton = new Button("Remove ➖");
        Button undoButton = new Button("Undo 🔁");

        addButton.setOnAction(e -> {
            ProductComponent selected = productListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Command cmd = new AddToCartCommand(selected, cart);
                commandManager.executeCommand(cmd);
                refreshCart();
            }
        });

        removeButton.setOnAction(e -> {
            ProductComponent selected = cartListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Command cmd = new RemoveFromCartCommand(selected, cart);
                commandManager.executeCommand(cmd);
                refreshCart();
            }
        });

        undoButton.setOnAction(e -> {
            commandManager.undoLastCommand();
            refreshCart();
        });

        VBox left = new VBox(10, new Label("Available Products:"), productListView);
        VBox right = new VBox(10, new Label("Your Cart:"), cartListView, totalLabel);
        VBox buttons = new VBox(10, addButton, removeButton, undoButton);
        buttons.setMinWidth(100);

        HBox root = new HBox(20, left, buttons, right);
        root.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(root, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshCart() {
        cartListView.getItems().setAll(cart);
        double total = 0;
        for (ProductComponent p : cart) {
            total += p.getPrice();
        }
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

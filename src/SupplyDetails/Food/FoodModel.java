package SupplyDetails.Food;


import Utilities.OracleConnection;

import java.util.Date;

public class FoodModel {
    String name,supplier;
    int id,quantity,price;
    Date purchaseDate, expiryDate;

    public FoodModel(String name, String supplier, int id, int quantity, int price, Date purchaseDate, Date expiryDate) {
        this.name = name;
        this.supplier = supplier;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }

    OracleConnection oc = new OracleConnection();

    public boolean isFoodSupplyAddSuccessful() {
        return false;
    }
}

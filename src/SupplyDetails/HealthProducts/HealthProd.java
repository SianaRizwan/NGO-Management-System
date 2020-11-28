package SupplyDetails.HealthProducts;

import java.util.Date;

public class HealthProd {
    int price, quantity;
    Date pDate, eDate;
    String name,supplier,manufacturer,id;

    public HealthProd(int price, int quantity, Date pDate, Date eDate, String name, String supplier, String manufacturer, String id) {
        this.price = price;
        this.quantity = quantity;
        this.pDate = pDate;
        this.eDate = eDate;
        this.name = name;
        this.supplier = supplier;
        this.manufacturer = manufacturer;
        this.id = id;
    }

    public HealthProd(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package model;

import java.util.Objects;
import java.util.EnumSet;

public class Product {
    private String id;
    private String description;
    private int price;
    private int amount;
    private Category category;
    private double totalSell;

    public Product(String id, String description, int price, int amount, Category category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.totalSell = 0;
    }

    public Product(Product product, int quantity) {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(double totalSell) {
        this.totalSell = totalSell;
    }
    public void setQuantity(int quantity) {
        this.amount = quantity;
    }
   
    @Override
    public String toString() {
        return "Product [id=" + id + ", description=" + description + ", price=" + price + ", amount=" + amount + ", category=" + category + ", totalSell=" + totalSell + "]";
    }

}
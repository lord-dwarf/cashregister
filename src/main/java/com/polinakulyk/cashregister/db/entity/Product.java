package com.polinakulyk.cashregister.db.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String code;
    private String category;
    private String name;
    private String details;
    private int price;
    private String amountUnit;
    private int amountAvailable;
    @OneToMany(mappedBy = "product")
    private Set<ReceiptItem> items = new HashSet<>();

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Product setDetails(String details) {
        this.details = details;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public Product setAmountUnit(String unit) {
        this.amountUnit = unit;
        return this;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public Product setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
        return this;
    }

    public Set<ReceiptItem> getItems() {
        return items;
    }

    public Product setItems(Set<ReceiptItem> items) {
        this.items = items;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("code='" + code + "'")
                .add("category='" + category + "'")
                .add("name='" + name + "'")
                .add("details='" + details + "'")
                .add("price=" + price)
                .add("amountUnit=" + amountUnit)
                .add("amountAvailable=" + amountAvailable)
                .add("items=" + items)
                .toString();
    }
}
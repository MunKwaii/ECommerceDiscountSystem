package com.ecommerce.discount.model;

import com.ecommerce.discount.strategy.DiscountStrategy;

// (SRP) Một lớp POJO (Plain Old Java Object) chứa dữ liệu của món hàng.
public class ShoppingItem {
    private String name;
    private double originalPrice;

    // DIP: ShoppingItem phụ thuộc vào trừu tượng DiscountStrategy, không phụ thuộc cụ thể.
    private DiscountStrategy discountStrategy;

    public ShoppingItem(String name, double originalPrice, DiscountStrategy discountStrategy) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountStrategy = discountStrategy;
    }

    // Tự biết cách tính giá cuối cùng của chính mình
    public double getFinalPrice() {
        // LSP: Nó gọi hàm trừu tượng mà không quan tâm lớp con nào đang thực thi.
        double discountAmount = discountStrategy.applyDiscount(originalPrice);
        return originalPrice - discountAmount;
    }

    // Getters cho việc in báo cáo
    public String getName() { return name; }
    public double getOriginalPrice() { return originalPrice; }
    public DiscountStrategy getDiscountStrategy() { return discountStrategy; }
}

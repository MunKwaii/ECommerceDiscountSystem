package com.ecommerce.discount.strategy;

// (SRP) Chỉ chịu trách nhiệm tính toán giảm giá theo phần trăm.
public class PercentageDiscount implements DiscountStrategy {
    private double percentage; // Ví dụ: 0.2 cho 20%

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Tỷ lệ phần trăm phải từ 0 đến 1");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * percentage;
    }

    @Override
    public String getDiscountDescription() {
        return String.format("Giảm giá %.0f%%", percentage * 100);
    }
}

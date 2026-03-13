package com.ecommerce.discount.strategy;

// (SRP) Chỉ chịu trách nhiệm trừ đi một số tiền cố định.
public class FlatRateDiscount implements DiscountStrategy {
    private double flatAmount; // Ví dụ: 50000 VNĐ

    public FlatRateDiscount(double flatAmount) {
        if (flatAmount < 0) {
            throw new IllegalArgumentException("Số tiền giảm giá không được âm");
        }
        this.flatAmount = flatAmount;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        // Đảm bảo không giảm giá nhiều hơn giá gốc
        return Math.min(originalPrice, flatAmount);
    }

    @Override
    public String getDiscountDescription() {
        return String.format("Giảm giá cố định %,.0f VNĐ", flatAmount);
    }
}

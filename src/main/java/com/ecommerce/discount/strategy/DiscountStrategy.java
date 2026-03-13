package com.ecommerce.discount.strategy;

// (ISP) Interface này chỉ định nghĩa đúng 1 trách nhiệm: áp dụng giảm giá.
public interface DiscountStrategy {
    // Nhận giá gốc, trả về số tiền được giảm giá
    double applyDiscount(double originalPrice);

    // Phương thức bổ trợ để in báo cáo đẹp hơn (DIP hữu ích ở đây)
    String getDiscountDescription();
}

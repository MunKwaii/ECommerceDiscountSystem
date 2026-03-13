package com.ecommerce.discount.service;

import com.ecommerce.discount.model.ShoppingItem;
import java.util.List;

// (SRP) Chỉ chịu trách nhiệm tổng hợp tổng số tiền cần thanh toán.
public class CheckoutCalculator {

    // (OCP & LSP) Hàm này hoạt động với List các ShoppingItem trừu tượng.
    // Nếu bạn thêm loại giảm giá mới, hàm này KHÔNG CẦN SỬA ĐỔI.
    public double calculateTotalPayable(List<ShoppingItem> items) {
        double total = 0;
        for (ShoppingItem item : items) {
            // Đa hình diễn ra ở đây khi gọi getFinalPrice()
            total += item.getFinalPrice();
        }
        return total;
    }
}

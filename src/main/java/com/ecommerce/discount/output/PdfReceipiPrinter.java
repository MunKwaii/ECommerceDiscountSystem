package com.ecommerce.discount.output;

import com.ecommerce.discount.model.ShoppingItem;

import java.util.List;

public class PdfReceipiPrinter implements ReceiptPrinter{
    @Override
    public void printReceipt(List<ShoppingItem> items, double totalAmountToPay) {
        System.out.println("\n===== HÓA ĐƠN THANH TOÁN BẰNG pdf =====");
        System.out.println("\npdf..........");

        System.out.printf("%-20s | %-15s | %-25s | %-15s\n",
                "Tên món hàng", "Giá gốc", "Chính sách", "Giá cuối");
        System.out.println("---------------------------------------------------------------------------------");

        for (ShoppingItem item : items) {
            System.out.printf("%-20s | %,.0f VNĐ   | %-25s | %,.0f VNĐ\n",
                    item.getName(),
                    item.getOriginalPrice(),
                    item.getDiscountStrategy().getDiscountDescription(),
                    item.getFinalPrice());
        }

        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("TỔNG TIỀN PHẢI THANH TOÁN: %,.0f VNĐ\n", totalAmountToPay);
        System.out.println("==============================");
    }
}

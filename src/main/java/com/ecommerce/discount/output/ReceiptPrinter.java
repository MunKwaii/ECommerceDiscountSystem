package com.ecommerce.discount.output;

import com.ecommerce.discount.model.ShoppingItem;
import java.util.List;

// (ISP) Chỉ định nghĩa duy nhất cam kết về việc in hóa đơn.
public interface ReceiptPrinter {
    void printReceipt(List<ShoppingItem> items, double totalAmountToPay);

}

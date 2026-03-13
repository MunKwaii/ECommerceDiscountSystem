package com.ecommerce.discount;

import com.ecommerce.discount.model.ShoppingItem;
import com.ecommerce.discount.output.PdfReceipiPrinter;
import com.ecommerce.discount.output.ReceiptPrinter;
import com.ecommerce.discount.output.StandardReceiptPrinter;
import com.ecommerce.discount.service.CheckoutCalculator;
import com.ecommerce.discount.strategy.DiscountStrategy;
import com.ecommerce.discount.strategy.FlatRateDiscount;
import com.ecommerce.discount.strategy.PercentageDiscount;

import java.util.List;

public class ECommerceApp {
    public static void main(String[] args) {
        System.out.println("--- KHỞI ĐỘNG HỆ THỐNG GIẢM GIÁ E-COMMERCE (SOLID DEMO) ---\n");

        // GIAI ĐOẠN 1: CẤU HÌNH & LẮP RÁP (Composition Root)
        // Chúng ta khởi tạo các implementation cụ thể ở đây.
        CheckoutCalculator calculator = new CheckoutCalculator();

        // DIP: Khai báo kiểu trừu tượng, gán đối tượng cụ thể.
//        ReceiptPrinter printer = new StandardReceiptPrinter();
        ReceiptPrinter printer = new PdfReceipiPrinter();

        // GIAI ĐOẠN 2: CHẠY NGHIỆP VỤ (Runtime)

        // 1. Tạo các chiến lược giảm giá (Strategies/Policies)
        DiscountStrategy disc20Pct = new PercentageDiscount(0.2); // Giảm 20%
        DiscountStrategy disc50k = new FlatRateDiscount(50000);   // Giảm 50k
        DiscountStrategy noDisc = new PercentageDiscount(0.0);   // Không giảm (0%)

        // 2. Tạo giỏ hàng (Shopping Cart Items)
        // LSP: ShoppingItem nhận bất kỳ impl nào của DiscountStrategy.
        ShoppingItem item1 = new ShoppingItem("Sách OOP căn bản", 150000, disc20Pct);
        ShoppingItem item2 = new ShoppingItem("Bút ký cao cấp", 200000, disc50k);
        ShoppingItem item3 = new ShoppingItem("Chuột máy tính", 120000, noDisc);

        List<ShoppingItem> cart = List.of(item1, item2, item3);

        // 3. Thực hiện tính toán tổng tiền
        double finalTotal = calculator.calculateTotalPayable(cart);

        // 4. In hóa đơn (DIP: Gọi qua interface trừu tượng)
        printer.printReceipt(cart, finalTotal);
    }
}

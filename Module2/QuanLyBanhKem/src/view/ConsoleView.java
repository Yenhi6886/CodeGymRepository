package view;

import model.Cake;
import model.Order;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static Scanner sc = new Scanner(System.in);

    public static int menu() {
        System.out.println("=== Cake App ===");
        System.out.println("1. Thêm món ăn");
        System.out.println("2. Sửa món ăn");
        System.out.println("3. Xóa món ăn");
        System.out.println("4. Tìm món ăn");
        System.out.println("5. Đọc món ăn từ file");
        System.out.println("6. Lưu món ăn ra file");
        System.out.println("7. Quản lý đơn hàng");
        System.out.println("8. Exit");
        System.out.print("Chọn: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    public static Order.Status readStatus(String prompt) {
        System.out.print(prompt);
        return Order.Status.valueOf(sc.nextLine().toUpperCase());
    }

    public static void showCakes(List<Cake> cakes) {
        System.out.println("--- Danh sách món ăn ---");
        for (Cake c : cakes) {
            System.out.printf("ID: %s | %s | %s | %.2f | %d | %s\n",
                    c.getId(), c.getName(), c.getType(), c.getPrice(), c.getQuantity(), c.getDescription());
        }
    }

    public static void showOrders(List<Order> orders) {
        System.out.println("--- Danh sách đơn hàng ---");
        for (Order o : orders) {
            System.out.printf("Mã: %s | Khách: %s | SĐT: %s | Địa chỉ: %s | Tổng: %.2f | Ngày: %s | TT: %s\n",
                    o.getOrderId(), o.getCustomerName(), o.getPhone(), o.getAddress(), o.getTotal(), o.getOrderDate(), o.getStatus());
            System.out.println("  Items: " + o.getItems());
        }
    }

    public static void pause() {
        System.out.println("Nhấn Enter để tiếp tục...");
        sc.nextLine();
    }
}
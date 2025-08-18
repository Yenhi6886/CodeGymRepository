package controller;

import dao.CakeDAOImpl;
import dao.OrderDAOImpl;
import model.Cake;
import model.Order;
import services.CakeService;
import services.OrderService;
import view.ConsoleView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppController {
    private CakeService cakeService = new CakeService(new CakeDAOImpl());
    private OrderService orderService = new OrderService(new OrderDAOImpl(), cakeService);

    public void run() {
        while (true) {
            int choice = ConsoleView.menu();
            switch (choice) {
                case 1:
                    Cake c = new Cake();
                    c.setId(ConsoleView.readString("ID: "));
                    c.setName(ConsoleView.readString("Tên: "));
                    c.setType(ConsoleView.readString("Loại: "));
                    c.setPrice(ConsoleView.readDouble("Giá: "));
                    c.setQuantity(ConsoleView.readInt("Số lượng: "));
                    c.setDescription(ConsoleView.readString("Mô tả: "));
                    cakeService.addCake(c);
                    System.out.println("Đã thêm món ăn!");
                    ConsoleView.pause();
                    break;
                case 2:
                    String uid = ConsoleView.readString("ID món cần sửa: ");
                    Cake uc = cakeService.getCakeById(uid);
                    if (uc != null) {
                        uc.setName(ConsoleView.readString("Tên mới: "));
                        uc.setType(ConsoleView.readString("Loại mới: "));
                        uc.setPrice(ConsoleView.readDouble("Giá mới: "));
                        uc.setQuantity(ConsoleView.readInt("Số lượng mới: "));
                        uc.setDescription(ConsoleView.readString("Mô tả mới: "));
                        cakeService.updateCake(uc);
                        System.out.println("Đã cập nhật món ăn!");
                    } else {
                        System.out.println("Không tìm thấy ID này.");
                    }
                    ConsoleView.pause();
                    break;
                case 3:
                    String did = ConsoleView.readString("ID món cần xóa: ");
                    cakeService.deleteCake(did);
                    System.out.println("Đã xóa (nếu tồn tại).");
                    ConsoleView.pause();
                    break;
                case 4:
                    String kw = ConsoleView.readString("Từ khóa: ");
                    List<Cake> found = cakeService.search(kw);
                    ConsoleView.showCakes(found);
                    ConsoleView.pause();
                    break;
                case 5:
                    cakeService = new CakeService(new CakeDAOImpl());
                    System.out.println("Đã đọc lại danh sách món ăn.");
                    ConsoleView.pause();
                    break;
                case 6:
                    // Lưu mặc định đã thực hiện sau mỗi thao tác
                    System.out.println("Dữ liệu đã được lưu tự động.");
                    ConsoleView.pause();
                    break;
                case 7:
                    manageOrders();
                    break;
                case 8:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void manageOrders() {
        while (true) {
            System.out.println("=== Quản lý đơn hàng ===");
            System.out.println("1. Tạo đơn hàng");
            System.out.println("2. Cập nhật trạng thái đơn");
            System.out.println("3. Xem tất cả đơn");
            System.out.println("4. Quay lại");
            int sub = ConsoleView.readInt("Chọn: ");
            switch (sub) {
                case 1:
                    Order o = new Order();
                    o.setOrderId(ConsoleView.readString("Mã đơn: "));
                    o.setCustomerName(ConsoleView.readString("Tên khách: "));
                    o.setPhone(ConsoleView.readString("SĐT: "));
                    o.setAddress(ConsoleView.readString("Địa chỉ: "));
                    Map<String, Integer> items = new HashMap<>();
                    while (true) {
                        String cakeId = ConsoleView.readString("ID món muốn mua: ");
                        int qty = ConsoleView.readInt("Số lượng: ");
                        items.put(cakeId, items.getOrDefault(cakeId, 0) + qty);
                        String more = ConsoleView.readString("Mua thêm? (y/n): ");
                        if (!more.equalsIgnoreCase("y")) break;
                    }
                    o.setItems(items);
                    orderService.placeOrder(o);
                    System.out.println("Đã tạo đơn hàng!");
                    ConsoleView.pause();
                    break;
                case 2:
                    String oid = ConsoleView.readString("Mã đơn cần cập nhật trạng thái: ");
                    Order order = orderService.findById(oid);
                    if (order != null) {
                        Order.Status st = ConsoleView.readStatus("Trạng thái (UNCONFIRMED/SHIPPING/COMPLETED): ");
                        orderService.updateStatus(oid, st);
                        System.out.println("Đã cập nhật trạng thái.");
                    } else {
                        System.out.println("Không tìm thấy đơn.");
                    }
                    ConsoleView.pause();
                    break;
                case 3:
                    ConsoleView.showOrders(orderService.listAll());
                    ConsoleView.pause();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
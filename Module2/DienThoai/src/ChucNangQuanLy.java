import java.util.Scanner; // Import lớp Scanner để nhập dữ liệu từ bàn phím

// Lớp ChucNangQuanLy chịu trách nhiệm giao tiếp với người dùng (hiển thị menu, nhập dữ liệu, thông báo)
public class ChucNangQuanLy {
    // Đối tượng Scanner dùng để nhập dữ liệu từ bàn phím
    private Scanner scanner = new Scanner(System.in);

    // Phương thức hiển thị menu chức năng cho người dùng
    public void hienThiMenu() {
        System.out.println("\n===============================================");
        System.out.println("    CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI");
        System.out.println("===============================================");
        System.out.println("Chọn chức năng theo số:");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách điện thoại");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Thoát");
        System.out.println("===============================================");
    }

    // Phương thức nhập một chuỗi từ bàn phím với thông báo hướng dẫn
    public String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextLine();
    }

    // Phương thức nhập một số nguyên từ bàn phím với thông báo hướng dẫn
    public int nhapSoNguyen(String thongBao) {
        System.out.print(thongBao);
        int so = scanner.nextInt(); // Nhập số nguyên
        scanner.nextLine(); // Đọc bỏ ký tự xuống dòng còn lại
        return so;
    }

    // Phương thức hiển thị một thông báo ra màn hình
    public void thongBao(String message) {
        System.out.println(message);
    }

    // Phương thức tạm dừng chương trình, chờ người dùng nhấn Enter để tiếp tục
    public void tamDung() {
        System.out.println("\nNhấn Enter để tiếp tục...");
        scanner.nextLine();
    }
}

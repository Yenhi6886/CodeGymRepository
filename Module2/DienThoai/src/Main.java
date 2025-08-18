// Lớp Main là điểm bắt đầu của chương trình
public class Main {
    // Phương thức main là phương thức chạy đầu tiên khi chương trình bắt đầu
    public static void main(String[] args) {
        // Tạo đối tượng QuanLyDienThoai để quản lý các chức năng liên quan đến điện thoại
        QuanLyDienThoai controller = new QuanLyDienThoai();
        // Gọi phương thức chayChuongTrinh để bắt đầu chương trình quản lý điện thoại
        controller.chayChuongTrinh();
    }
}

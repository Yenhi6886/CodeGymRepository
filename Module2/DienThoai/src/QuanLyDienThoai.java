import java.util.ArrayList; // Import lớp ArrayList để sử dụng danh sách động

// Lớp QuanLyDienThoai chịu trách nhiệm quản lý các thao tác với danh sách điện thoại
public class QuanLyDienThoai {
    // Khai báo danh sách các đối tượng Điện Thoại
    private ArrayList<DienThoai> danhSach = new ArrayList<>();
    // Đối tượng view để thực hiện các chức năng nhập/xuất dữ liệu với người dùng
    private ChucNangQuanLy view = new ChucNangQuanLy();

    // Phương thức chạy chương trình chính, hiển thị menu và xử lý lựa chọn
    public void chayChuongTrinh() {
        int luaChon; // Biến lưu lựa chọn của người dùng

        do {
            view.hienThiMenu(); // Hiển thị menu chức năng
            luaChon = view.nhapSoNguyen("Chọn chức năng: "); // Nhập lựa chọn từ người dùng

            switch (luaChon) { // Xử lý theo lựa chọn
                case 1:
                    themMoi(); // Thêm mới điện thoại
                    break;
                case 2:
                    xoa(); // Xóa điện thoại
                    break;
                case 3:
                    xemDanhSach(); // Xem danh sách điện thoại
                    break;
                case 4:
                    timKiem(); // Tìm kiếm điện thoại
                    break;
                case 5:
                    view.thongBao("Cảm ơn bạn đã sử dụng chương trình!"); // Thoát chương trình
                    break;
                default:
                    view.thongBao("Lựa chọn không hợp lệ. Vui lòng chọn lại!"); // Lựa chọn sai
            }

            // Nếu chưa thoát thì tạm dừng để người dùng đọc kết quả
            if (luaChon != 5) view.tamDung();
        } while (luaChon != 5); // Lặp lại cho đến khi chọn thoát
    }

    // Phương thức thêm mới một điện thoại vào danh sách
    private void themMoi() {
        view.thongBao("\n--- THÊM MỚI ĐIỆN THOẠI ---");

        // Nhập thông tin điện thoại từ người dùng
        String ten = view.nhapChuoi("Nhập tên điện thoại: ");
        String soDienThoai = view.nhapChuoi("Nhập số điện thoại: ");
        String thuongHieu = view.nhapChuoi("Nhập thương hiệu: ");

        // Thêm đối tượng điện thoại mới vào danh sách
        danhSach.add(new DienThoai(ten, soDienThoai, thuongHieu));
        view.thongBao("Đã thêm điện thoại thành công!");
    }

    // Phương thức xóa một điện thoại khỏi danh sách
    private void xoa() {
        view.thongBao("\n--- XÓA ĐIỆN THOẠI ---");

        // Nếu danh sách rỗng thì thông báo và thoát
        if (danhSach.isEmpty()) {
            view.thongBao("Danh sách trống. Không có gì để xóa!");
            return;
        }

        xemDanhSach(); // Hiển thị danh sách để chọn vị trí xóa
        int viTri = view.nhapSoNguyen("Nhập số thứ tự cần xóa (1-" + danhSach.size() + "): ");

        // Kiểm tra vị trí hợp lệ
        if (viTri >= 1 && viTri <= danhSach.size()) {
            DienThoai dt = danhSach.remove(viTri - 1); // Xóa điện thoại tại vị trí đã chọn
            view.thongBao("Đã xóa: " + dt.getTen());
        } else {
            view.thongBao("Vị trí không hợp lệ!");
        }
    }

    // Phương thức hiển thị danh sách điện thoại
    private void xemDanhSach() {
        view.thongBao("\n--- DANH SÁCH ĐIỆN THOẠI ---");

        // Nếu danh sách rỗng thì thông báo
        if (danhSach.isEmpty()) {
            view.thongBao("Danh sách trống!");
            return;
        }

        // Duyệt qua danh sách và in ra từng điện thoại
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
    }

    // Phương thức tìm kiếm điện thoại theo tên hoặc thương hiệu
    private void timKiem() {
        view.thongBao("\n--- TÌM KIẾM ĐIỆN THOẠI ---");

        // Nếu danh sách rỗng thì thông báo
        if (danhSach.isEmpty()) {
            view.thongBao("Danh sách trống!");
            return;
        }

        // Nhập từ khóa tìm kiếm từ người dùng
        String tuKhoa = view.nhapChuoi("Nhập từ khóa tìm kiếm (tên hoặc thương hiệu): ").toLowerCase();

        boolean timThay = false; // Biến kiểm tra có tìm thấy hay không
        System.out.println("\nKết quả tìm kiếm:");
        // Duyệt qua danh sách để tìm kiếm
        for (int i = 0; i < danhSach.size(); i++) {
            DienThoai dt = danhSach.get(i);
            // Nếu tên hoặc thương hiệu chứa từ khóa thì in ra
            if (dt.getTen().toLowerCase().contains(tuKhoa) || dt.getThuongHieu().toLowerCase().contains(tuKhoa)) {
                System.out.println((i + 1) + ". " + dt);
                timThay = true;
            }
        }

        // Nếu không tìm thấy thì thông báo
        if (!timThay) {
            view.thongBao("Không tìm thấy kết quả nào!");
        }
    }
}

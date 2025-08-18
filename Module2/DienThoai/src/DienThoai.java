// Lớp DienThoai biểu diễn thông tin của một chiếc điện thoại
public class DienThoai {
    // Thuộc tính tên điện thoại
    private String ten;
    // Thuộc tính số điện thoại
    private String soDienThoai;
    // Thuộc tính thương hiệu điện thoại
    private String thuongHieu;

    // Hàm khởi tạo để tạo đối tượng điện thoại với đầy đủ thông tin
    public DienThoai(String ten, String soDienThoai, String thuongHieu) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.thuongHieu = thuongHieu;
    }

    // Phương thức lấy tên điện thoại
    public String getTen() {
        return ten;
    }

    // Phương thức thiết lập tên điện thoại
    public void setTen(String ten) {
        this.ten = ten;
    }

    // Phương thức lấy số điện thoại
    public String getSoDienThoai() {
        return soDienThoai;
    }

    // Phương thức thiết lập số điện thoại
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    // Phương thức lấy thương hiệu điện thoại
    public String getThuongHieu() {
        return thuongHieu;
    }

    // Phương thức thiết lập thương hiệu điện thoại
    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    // Phương thức trả về chuỗi mô tả thông tin điện thoại (dùng khi in ra màn hình)
    @Override
    public String toString() {
        return "Tên: " + ten + ", SĐT: " + soDienThoai + ", Thương hiệu: " + thuongHieu;
    }
}

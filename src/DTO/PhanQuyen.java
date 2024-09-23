package DTO;

public class PhanQuyen {

    private String quyen;
    private int nhapHang;
    private int banHang;
    private int qlSanPham;
    private int qlNhanVien;
    private int qlKhachHang;
    private int thongKe;
    private int qlKhuyenMai;

    public PhanQuyen() {
    }

    public PhanQuyen(String quyen, int nhapHang, int banHang, int qlSanPham, int qlNhanVien, int qlKhachHang, int thongKe, int qlKhuyenMai) {
        this.quyen = quyen;
        this.nhapHang = nhapHang;
        this.banHang = banHang;
        this.qlSanPham = qlSanPham;
        this.qlNhanVien = qlNhanVien;
        this.qlKhachHang = qlKhachHang;
        this.thongKe = thongKe;
        this.qlKhuyenMai = qlKhuyenMai;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public int getNhapHang() {
        return nhapHang;
    }

    public void setNhapHang(int nhapHang) {
        this.nhapHang = nhapHang;
    }
    
    public int getBanHang() {
        return banHang;
    }

    public void setBanHang(int banHang) {
        this.banHang = banHang;
    }

    public int getQlSanPham() {
        return qlSanPham;
    }

    public void setQlSanPham(int qlSanPham) {
        this.qlSanPham = qlSanPham;
    }

    public int getQlNhanVien() {
        return qlNhanVien;
    }

    public void setQlNhanVien(int qlNhanVien) {
        this.qlNhanVien = qlNhanVien;
    }

    public int getQlKhachHang() {
        return qlKhachHang;
    }

    public void setQlKhachHang(int qlKhachHang) {
        this.qlKhachHang = qlKhachHang;
    }

    public int getThongKe() {
        return thongKe;
    }

    public void setThongKe(int thongKe) {
        this.thongKe = thongKe;
    }

    public int getQlKhuyenMai() {
        return qlKhuyenMai;
    }

    public void setQlKhuyenMai(int qlKhuyenMai) {
        this.qlKhuyenMai = qlKhuyenMai;
    }
    
    @Override
    public String toString() {
        return quyen; 
    }
}

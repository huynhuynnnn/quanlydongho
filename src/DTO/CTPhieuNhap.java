package DTO;

public class CTPhieuNhap {
    private int maPN;
    private int maSP;
    private int soLuong;
    private int donGia;
//    private float loiNhuan;
    private int thanhTien;

    public CTPhieuNhap() {
    }

    public CTPhieuNhap(int maPN, int maSP, int soLuong, int donGia, 
//            float loiNhuan,
            int thanhTien) {
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
//        this.loiNhuan = loiNhuan;
        this.thanhTien = thanhTien;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

//    public float getLoiNhuan() {
//        return loiNhuan;
//    }
//
//    public void setLoiNhuan(float loiNhuan) {
//        this.loiNhuan = loiNhuan;
//    }
}

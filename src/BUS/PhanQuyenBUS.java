package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;

import java.util.ArrayList;

public class PhanQuyenBUS {

    private PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
    private ArrayList<PhanQuyen> listPhanQuyen = null;

    public void docDanhSachNhomQuyen() {
        this.listPhanQuyen = phanQuyenDAO.getListQuyen();
    }
    public void layDanhSachNhomQuyen() {
        this.listPhanQuyen = phanQuyenDAO.getListTenQuyen();
    }

    public PhanQuyen getNhomQuyen(String quyen) {
        return phanQuyenDAO.getQuyen(quyen);
    }
    
    public ArrayList<PhanQuyen> getListNhomQuyen() {
        if (listPhanQuyen == null)
            docDanhSachNhomQuyen();
        return this.listPhanQuyen;
    }
    public ArrayList<PhanQuyen> getListTenNhomQuyen() {
        if (listPhanQuyen == null)
            layDanhSachNhomQuyen();
        return this.listPhanQuyen;
    }

    public String getTenLoai(String ma) {
        for (PhanQuyen loai : listPhanQuyen) {
            if (loai.getQuyen() == ma) {
                return loai.getQuyen();
            }
        }
        return "";
    }

    public boolean suaNhomQuyen(String tenNhomQuyen, int nhapHang, int banHang, int sanPham, int nhanVien, int khachHang, int thongKe, int khuyenMai) {
        PhanQuyen phanQuyen = new PhanQuyen(tenNhomQuyen, nhapHang, banHang, sanPham, nhanVien, khachHang, thongKe, khuyenMai);
        return phanQuyenDAO.suaNhomQuyen(phanQuyen);
    }

    public boolean themNhomQuyen(String tenNhomQuyen) {
        PhanQuyen phanQuyen = new PhanQuyen(tenNhomQuyen, 0, 0, 0, 0, 0, 0, 0);
        boolean flag = phanQuyenDAO.themNhomQuyen(phanQuyen);
        return flag;
    }

    private boolean kiemTraTrungTenNhomQuyen(String tenNhomQuyen) {
        docDanhSachNhomQuyen();
        for (PhanQuyen q : listPhanQuyen) {
            if (q.getQuyen().equalsIgnoreCase(tenNhomQuyen))
                return true;
        }
        return false;
    }

    public boolean xoaNhomQuyen(String tenNhomQuyen) {
        boolean flag = phanQuyenDAO.xoaNhomQuyen(tenNhomQuyen);
        return flag;
    }
}

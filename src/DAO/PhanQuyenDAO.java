package DAO;

import DTO.PhanQuyen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PhanQuyenDAO {

    public ArrayList<PhanQuyen> getListQuyen() {
        try {
            String sql = "SELECT * FROM phanquyen";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<PhanQuyen> dspq = new ArrayList<>();
            while (rs.next()) {
                PhanQuyen phanQuyen = new PhanQuyen();
                phanQuyen.setQuyen(rs.getString(1));
                phanQuyen.setNhapHang(rs.getInt(2));
                phanQuyen.setBanHang(rs.getInt(3));
                phanQuyen.setQlSanPham(rs.getInt(4));
                phanQuyen.setQlNhanVien(rs.getInt(5));
                phanQuyen.setQlKhachHang(rs.getInt(6));
                phanQuyen.setThongKe(rs.getInt(7));
                phanQuyen.setQlKhuyenMai(rs.getInt(8));
                dspq.add(phanQuyen);
            }
            return dspq;
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<PhanQuyen> getListTenQuyen() {
        try {
            String sql = "SELECT Quyen FROM phanquyen";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<PhanQuyen> dspq = new ArrayList<>();
            while (rs.next()) {
                PhanQuyen phanQuyen = new PhanQuyen();
                phanQuyen.setQuyen(rs.getString(1));
                
                dspq.add(phanQuyen);
            }
            return dspq;
        } catch (Exception e) {
        }
        return null;
    }


    public PhanQuyen getQuyen(String quyen) {
        try {
            String sql = "SELECT * FROM phanquyen WHERE quyen='" + quyen + "'";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                PhanQuyen phanQuyen = new PhanQuyen();
                phanQuyen.setQuyen(quyen);
                phanQuyen.setNhapHang(rs.getInt(2));
                phanQuyen.setBanHang(rs.getInt(3));
                phanQuyen.setQlSanPham(rs.getInt(4));
                phanQuyen.setQlNhanVien(rs.getInt(5));
                phanQuyen.setQlKhachHang(rs.getInt(6));
                phanQuyen.setThongKe(rs.getInt(7));
                phanQuyen.setQlKhuyenMai(rs.getInt(8));
                return phanQuyen;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean suaNhomQuyen(PhanQuyen phanQuyen) {
        boolean flag = false;
        try {
            String sql = "UPDATE phanquyen SET NhapHang=?,BanHang=?,QLSanPham=?,QLNhanVien=?,QLKhachHang=?,ThongKe=?, QLKhuyenMai=? WHERE Quyen=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, phanQuyen.getNhapHang());
            pre.setInt(2, phanQuyen.getBanHang());
            pre.setInt(3, phanQuyen.getQlSanPham());
            pre.setInt(4, phanQuyen.getQlNhanVien());
            pre.setInt(5, phanQuyen.getQlKhachHang());
            pre.setInt(6, phanQuyen.getThongKe());
            pre.setInt(7, phanQuyen.getQlKhuyenMai());
            pre.setString(8, phanQuyen.getQuyen());
            flag = pre.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
        return flag;
    }

    public boolean themNhomQuyen(PhanQuyen phanQuyen) {
        try {
            String sql = "INSERT INTO phanquyen VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, phanQuyen.getQuyen());
            pre.setInt(2, phanQuyen.getNhapHang());
            pre.setInt(3, phanQuyen.getBanHang());
            pre.setInt(4, phanQuyen.getQlSanPham());
            pre.setInt(5, phanQuyen.getQlNhanVien());
            pre.setInt(6, phanQuyen.getQlKhachHang());
            pre.setInt(7, phanQuyen.getThongKe());
            pre.setInt(8, phanQuyen.getQlKhuyenMai());
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaNhomQuyen(String phanQuyen) {
        try {
            String sql1 = "UPDATE TaiKhoan SET Quyen='Default' WHERE Quyen='" + phanQuyen + "'";
            Statement st1 = MyConnect.conn.createStatement();
            st1.executeUpdate(sql1);
            String sql = "DELETE FROM phanquyen WHERE Quyen='" + phanQuyen + "'";
            Statement st = MyConnect.conn.createStatement();
            return st.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

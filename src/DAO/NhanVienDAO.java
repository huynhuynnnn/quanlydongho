package DAO;

import DTO.KhachHang;
import DTO.NhanVien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienDAO {

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        try {
            String sql = "SELECT * FROM nhanvien";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> dssv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setChucVu(rs.getString(6));

                dssv.add(nv);
            }
            return dssv;
        } catch (SQLException e) {
        }

        return null;
    }

    public NhanVien getNhanVien(int maNV) {
        NhanVien nv = null;
        try {
            String sql = "SELECT * FROM nhanvien WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setChucVu(rs.getString(6));
            }
        } catch (SQLException e) {
            return null;
        }

        return nv;
    }

    public boolean suaNhanVien(NhanVien nv) {
        boolean result = false;
        try {
            String sql = "UPDATE nhanvien SET Ho=?, Ten=?, GioiTinh=?, SoDienThoai=?, ChucVu=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, nv.getHo());
            pre.setString(2, nv.getTen());
            pre.setString(3, nv.getGioiTinh());
            pre.setString(4, nv.getSoDienThoai());
            pre.setString(5, nv.getChucVu());
            pre.setInt(6, nv.getMaNV());
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean xoaNhanVien(int maNV) {
        boolean result = false;
        try {
            String sql = "DELETE FROM nhanvien WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean themNhanVien(NhanVien nv) {
        boolean result = false;
        try {
            String sql = "INSERT INTO nhanvien VALUES(?,?,?,?,?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHo());
            pre.setString(3, nv.getTen());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getSoDienThoai());
            pre.setString(6, nv.getChucVu());
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("DAO lỗi");
            return false;
        }
        return result;
    }
    
    public boolean nhapNhanVienTuExcel(NhanVien nv) {
        try {
            String sql = "DELETE * FROM nhanvien; " +
                    "INSERT INTO NhanVien(Ho, Ten, GioiTinh,SoDienThoai, ChucVu) " +
                    "VALUES(?, ?, ?, ?,?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, nv.getHo());
            pre.setString(2, nv.getTen());
            pre.setString(3, nv.getGioiTinh());
            pre.setString(4, nv.getSoDienThoai());
            pre.setString(5, nv.getChucVu());
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    public ArrayList<NhanVien> timKHTheoTen(String tenNV) {
        ArrayList<NhanVien> kq = new ArrayList<>();
        try {
            String sql = "SELECT * FROM nhanvien WHERE Ten LIKE ?";
            PreparedStatement pstm = MyConnect.conn.prepareStatement(sql);
            pstm.setString(1, "%" + tenNV + "%");
            ResultSet rs = pstm.executeQuery();
          while(rs.next()) {
    			int id = rs.getInt(1);
    			String ho = rs.getString(2);
    			String ten = rs.getString(3);
    			String gioitinh = rs.getString(4);
    			String sdt = rs.getString(5);
    			String cv = rs.getString(6);
    			
    			NhanVien kh = new NhanVien(id,ho,ten,gioitinh,sdt,cv);
    			kq.add(kh);
    		}
        } catch (SQLException e) {
        }
        return kq;
    }
    public  NhanVien timKHTheoSDT(String sdtKH) {
     NhanVien kq = null;
        try {
            String sql = "SELECT * FROM nhanvien WHERE SoDienThoai=?";
            PreparedStatement pstm = MyConnect.conn.prepareStatement(sql);
            pstm.setString(1, sdtKH);
            ResultSet rs = pstm.executeQuery();
           while(rs.next()) {
        	   int id = rs.getInt(1);
   			String ho = rs.getString(2);
   			String ten = rs.getString(3);
   			String gioitinh = rs.getString(4);
   			String sdt = rs.getString(5);
   			String cv = rs.getString(6);
   			
    			
    			kq = new NhanVien(id,ho,ten,gioitinh,sdt,cv);
    			
    		}
        } catch (SQLException e) {
        }
        return kq;
    }
}

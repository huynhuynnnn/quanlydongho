
package DAO;

import DTO.KhachHang;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhachHangDAO {

    public ArrayList<KhachHang> getListKhachHang() {
        try {
            String sql = "SELECT * FROM khachhang WHERE TinhTrang=1";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhachHang> dskh = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setSoDienThoai(rs.getString(5));
                kh.setTongChiTieu(rs.getInt(6));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
        }
        return null;
    }
    

    public KhachHang getKhachHang(int maKH) {
        KhachHang kh = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE MaKH=? AND TinhTrang=1";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setSoDienThoai(rs.getString(5));
                kh.setTongChiTieu(rs.getInt(6));
            }
        } catch (SQLException ex) {
            return null;
        }
        return kh;
    }

    public boolean themKhachHang(KhachHang kh) {
        boolean result = false;
        try {
            String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,1)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, kh.getMaKH());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioiTinh());
            prep.setString(5, kh.getSoDienThoai());
            prep.setInt(6, kh.getTongChiTieu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean xoaKhachHang(int maKH) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TinhTrang=2 WHERE MaKH=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }


  

    public boolean suaKhachHang(int maKH, KhachHang kh) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET Ho=?, Ten=?, GioiTinh=?, SoDienThoai=? WHERE MaKH=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, kh.getHo());
            prep.setString(2, kh.getTen());
            prep.setString(3, kh.getGioiTinh());
            prep.setString(4, kh.getSoDienThoai());
            prep.setInt(5, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean capNhatTongChiTieu(int maKH, int tongChiTieu) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TongChiTieu=" + tongChiTieu + " WHERE MaKH=" + maKH;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    public ArrayList<KhachHang> timKHTheoTen(String tenKH) {
        ArrayList<KhachHang> kq = new ArrayList<>();
        try {
            String sql = "SELECT * FROM khachhang WHERE Ten LIKE ?";
            PreparedStatement pstm = MyConnect.conn.prepareStatement(sql);
            pstm.setString(1, "%" + tenKH + "%");
            ResultSet rs = pstm.executeQuery();
          while(rs.next()) {
    			int id = rs.getInt(1);
    			String ho = rs.getString(2);
    			String ten = rs.getString(3);
    			String gioitinh = rs.getString(4);
    			String sdt = rs.getString(5);
    			int chitieu = rs.getInt(6);
    			
    			KhachHang kh = new KhachHang(id,ho,ten,gioitinh,sdt,chitieu);
    			kq.add(kh);
    		}
        } catch (SQLException e) {
        }
        return kq;
    }
    public  KhachHang timKHTheoSDT(String sdtKH) {
      KhachHang kq = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE SoDienThoai=?";
            PreparedStatement pstm = MyConnect.conn.prepareStatement(sql);
            pstm.setString(1, sdtKH);
            ResultSet rs = pstm.executeQuery();
           while(rs.next()) {
    			int id = rs.getInt(1);
    			String ho = rs.getString(2);
    			String ten = rs.getString(3);
    			String gioitinh = rs.getString(4);
    			String sdt = rs.getString(5);
    			int chitieu = rs.getInt(6);
    			
    			kq = new KhachHang(id,ho,ten,gioitinh,sdt,chitieu);
    			
    		}
        } catch (SQLException e) {
        }
        return kq;
    }       
}

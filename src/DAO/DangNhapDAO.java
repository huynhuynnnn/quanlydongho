package DAO;

import DTO.TaiKhoan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhapDAO {

    public TaiKhoan dangNhap(TaiKhoan tk) {
        try {
            String sql = "SELECT * FROM taikhoan WHERE TaiKhoan=? AND MatKhau=? AND TrangThai=1";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tk.getTaiKhoan());
            pre.setString(2, tk.getMatKhau());
            ResultSet rs = pre.executeQuery();
            TaiKhoan tkLogin = null;
            if (rs.next()) {
                tkLogin = tk;
                tkLogin.setMaNV(rs.getInt("MaNV"));
                tkLogin.setQuyen(rs.getString("Quyen"));
            }
            return tkLogin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
}
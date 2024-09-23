package DAO;

import DTO.NhaCungCap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhaCungCapDAO {

    public ArrayList<NhaCungCap> getListNhaCungCap() {
        try {
            ArrayList<NhaCungCap> dsncc = new ArrayList<>();
            String sql = "SELECT * FROM nhacungcap WHERE Trangthai =2";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setSoDienThoai(rs.getString(4));
                dsncc.add(ncc);
            }
            return dsncc;
        } catch (SQLException ex) {
            return null;
        }
    }

    public NhaCungCap getNhaCungCap(int maNCC) {
        NhaCungCap ncc = null;
        try {
            String sql = "SELECT * FROM nhacungcap WHERE Trangthai =2 AND MaNCC= " + maNCC;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setSoDienThoai(rs.getString(4));
            }
        } catch (SQLException ex) {
            return null;
        }
        return ncc;
    }

//    public boolean addNCC(NhaCungCap ncc) {
//        boolean result = false;
//        try {
//            String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?)";
//            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
//            prep.setInt(1, ncc.getMaNCC());
//            prep.setString(2, ncc.getTenNCC());
//            prep.setString(3, ncc.getDiaChi());
//            prep.setString(4, ncc.getSoDienThoai());
//            result = prep.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            return false;
//        }
//        return result;
//    }
    
    public boolean addNCC(NhaCungCap ncc) {
    boolean result = false;
    PreparedStatement prep = null;

    try {
        // Chỉ chèn các trường cần thiết
        String sql = "INSERT INTO nhacungcap (TenNCC, DiaChi, SoDienThoai) VALUES (?, ?, ?)";
        prep = MyConnect.conn.prepareStatement(sql);
        prep.setString(1, ncc.getTenNCC());
        prep.setString(2, ncc.getDiaChi());
        prep.setString(3, ncc.getSoDienThoai());
        result = prep.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace(); // Ghi lại lỗi
    } finally {
        try {
            if (prep != null) prep.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return result;
}

    public boolean updateNCC(NhaCungCap ncc) {
        boolean result = false;
        try {
            String sql = "UPDATE nhacungcap SET TenNCC=?, DiaChi=?, SoDienThoai=? WHERE MaNCC=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, ncc.getTenNCC());
            prep.setString(2, ncc.getDiaChi());
            prep.setString(3, ncc.getSoDienThoai());
            prep.setInt(4, ncc.getMaNCC());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean deleteNCC(int maNCC) {
        boolean result = false;
        try {
            String sql = "update nhacungcap set Trangthai = 1 WHERE MaNCC=" + maNCC;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    
    public boolean xuatExcel() {
        try {
            ArrayList<NhaCungCap> dsncc = getListNhaCungCap();
            if (dsncc == null || dsncc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu để xuất!");
                return false;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Lưu file Excel");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");
            fileChooser.setFileFilter(filter);

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();

                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx"; 
                }

                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Danh sách nhà cung cấp");
                Row headerRow = sheet.createRow(0);
                String[] columns = {"MaNCC", "TenNCC", "DienThoai", "DiaChi"};

                for (int i = 0; i < columns.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columns[i]);
                }

                int rowNum = 1;
                for (NhaCungCap ncc : dsncc) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(ncc.getMaNCC());
                    row.createCell(1).setCellValue(ncc.getTenNCC());
                    row.createCell(2).setCellValue(ncc.getSoDienThoai());
                    row.createCell(4).setCellValue(ncc.getDiaChi());
                }

                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                outputStream.close();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean nhapExcel(File file) {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Không có tệp được chọn!");
            return false;
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // Skip header

            String line;
            ArrayList<NhaCungCap> dsncc = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(Integer.parseInt(data[0]));
                ncc.setTenNCC(data[1]);
                ncc.setSoDienThoai(data[2]);
                ncc.setDiaChi(data[3]);
                dsncc.add(ncc);
            }
            br.close();
            fr.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public ArrayList<NhaCungCap> timKiemNhaCungCap(String searchType, String searchValue) {
//        try {
//            if (MyConnect.conn == null || MyConnect.conn.isClosed()) {
//                MyConnect myConnect = new MyConnect();
//                MyConnect.conn = myConnect.conn;
//            }
//
//            String sql = "SELECT * FROM nhacungcap WHERE Trangthai =2 AND ";
//
//            switch (searchType) {
//                case "Mã NCC":
//                    sql += "MaNCC = ?";
//                    break;
//                case "Tên NCC":
//                    sql += "TenNCC LIKE ?";
//                    break;
//                default:
//                    sql += "1"; // Trường hợp mặc định, không tìm kiếm
//                    break;
//            }
//
//            PreparedStatement pstmt = MyConnect.conn.prepareStatement(sql);
//            pstmt.setString(1, searchValue);
//            ResultSet rs = pstmt.executeQuery();
//
//            ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<>();
//            while (rs.next()) {
//                NhaCungCap ncc = new NhaCungCap();
//                ncc.setMaNCC(rs.getInt("MaNCC"));
//                ncc.setTenNCC(rs.getString("TenNCC"));
//                ncc.setDiaChi(rs.getString("DiaChi"));
//                ncc.setSoDienThoai(rs.getString("SoDienThoai"));
//                listNhaCungCap.add(ncc);
//            }
//            return listNhaCungCap;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public ArrayList<NhaCungCap> timKiemNhaCungCap(String searchType, String searchValue) {
        ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            if (MyConnect.conn == null || MyConnect.conn.isClosed()) {
                MyConnect myConnect = new MyConnect();
                MyConnect.conn = myConnect.conn;
            }

            String sql = "SELECT * FROM nhacungcap WHERE Trangthai = 2 AND ";

            switch (searchType) {
                case "Mã NCC":
                    sql += "MaNCC = ?";
                    break;
                case "Tên NCC":
                    sql += "TenNCC LIKE ?";
                    searchValue = "%" + searchValue + "%"; // Thêm ký tự đại diện
                    break;
                default:
                    return listNhaCungCap; // Trả về danh sách rỗng trường hợp không tìm kiếm
            }

            pstmt = MyConnect.conn.prepareStatement(sql);
            pstmt.setString(1, searchValue);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setSoDienThoai(rs.getString("SoDienThoai"));
                listNhaCungCap.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                // Không cần đóng connection nếu nó được quản lý bên ngoài
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listNhaCungCap;
    }
}

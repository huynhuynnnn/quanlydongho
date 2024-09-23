package GUI;

import BUS.KhachHangBUS;
import DAO.MyConnect;
import DTO.KhachHang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class PnlQuanLyKhachHang extends JPanel {
    private final KhachHangBUS khachHangBUS = new KhachHangBUS();
    
    private JLabel lblTitleKhachHang, lblMaKH, lblHoKH, lblTenKH, lblGioiTinh, lblSoDienThoai, lblTongChiTieu, lblTim;
    private JTextField txtMaKH, txtHoKH, txtTenKH, txtSoDienThoai, txtTongChiTieu, txtSearch;
    private JButton btnReset, btnThem, btnSua, btnXoa;
    private JTable tblKhachHang;
    private DefaultTableModel modelKhachHang;
    private JComboBox<String> cbGioiTinh;
    private JComboBox<String> cmbChoice;
    private Font font, fontIcon;

    public PnlQuanLyKhachHang() {
        addControls();
        addEventsKhachHang();
        loadDataLenBangKhachHang();
    }
    
    private void addControls() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setLayout(null);

        font = new Font("Segoe UI", Font.BOLD, 26);

        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, 1000, 250));
        itemView.setBackground(null);

        lblTitleKhachHang = new JLabel("QUẢN LÝ KHÁCH HÀNG");
        lblTitleKhachHang.setFont(font);
        lblTitleKhachHang.setBounds(new Rectangle(300, 0, 400, 30));

        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontIcon = new Font("Segoe UI", Font.ROMAN_BASELINE, 20);
        
        lblMaKH = new JLabel("Mã khách hàng");
        lblMaKH.setBounds(new Rectangle(50, 50, 200, 30));
        lblMaKH.setFont(font0);

        lblSoDienThoai = new JLabel("Số điện thoại");
        lblSoDienThoai.setBounds(new Rectangle(400, 50, 200, 30));
        lblSoDienThoai.setFont(font0);

        lblHoKH = new JLabel("Họ");
        lblHoKH.setBounds(new Rectangle(50, 90, 200, 30));
        lblHoKH.setFont(font0);

        lblTenKH = new JLabel("Tên khách hàng");
        lblTenKH.setBounds(new Rectangle(400, 90, 200, 30));
        lblTenKH.setFont(font0);

        lblGioiTinh = new JLabel("Giới tính");
        lblGioiTinh.setBounds(new Rectangle(50, 130, 200, 30));
        lblGioiTinh.setFont(font0);

        cbGioiTinh = new JComboBox<>(new String[]{"Chọn giới tính", "Nam", "Nữ"});
        cbGioiTinh.setBounds(new Rectangle(150, 130, 220, 30));
        cbGioiTinh.setBackground(Color.WHITE);
        cbGioiTinh.setFont(font0);
        cbGioiTinh.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblTongChiTieu = new JLabel("Tổng chi tiêu");
        lblTongChiTieu.setBounds(new Rectangle(400, 130, 200, 30));
        lblTongChiTieu.setFont(font0);

        txtMaKH = new JTextField("");
        txtMaKH.setEditable(false);
        txtMaKH.setBounds(new Rectangle(150, 50, 220, 30));
        txtMaKH.setBackground(Color.WHITE);

        txtSoDienThoai = new JTextField("");
        txtSoDienThoai.setBounds(new Rectangle(500, 50, 220, 30));

        txtHoKH = new JTextField("");
        txtHoKH.setBounds(new Rectangle(150, 90, 220, 30));

        txtTenKH = new JTextField("");
        txtTenKH.setBounds(new Rectangle(500, 90, 220, 30));

        txtTongChiTieu = new JTextField("0");
        txtTongChiTieu.setEditable(false);
        txtTongChiTieu.setBounds(new Rectangle(500, 130, 220, 30));
        txtTongChiTieu.setBackground(Color.WHITE);

        lblTim = new JLabel("Tìm kiếm");
        lblTim.setBounds(new Rectangle(50, 220, 200, 30));
        lblTim.setFont(new Font("Segoe UI", Font.ROMAN_BASELINE, 20));

        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(Color.WHITE);
        searchBox.setBounds(new Rectangle(150, 220, 565, 30));
        searchBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        cmbChoice = new JComboBox<>();
        cmbChoice.setEditable(true);
        cmbChoice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbChoice.addItem("Mã KH");
        cmbChoice.addItem("Tên");
        cmbChoice.addItem("Sđt");
        cmbChoice.setBounds(new Rectangle(0, 0, 120, 30));
        cmbChoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmbChoice.setBackground(Color.WHITE);

        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(125, 0, 250, 35));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JLabel searchIcon = new JLabel(new ImageIcon(new ImageIcon("images/search_icon.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
        searchIcon.setBounds(new Rectangle(530, 0, 50, 30));
        searchBox.add(cmbChoice);
        searchBox.add(txtSearch);
        searchBox.add(searchIcon);

        itemView.add(searchBox);
        itemView.add(lblTitleKhachHang);
        itemView.add(lblMaKH);
        itemView.add(txtMaKH);
        itemView.add(lblSoDienThoai);
        itemView.add(txtSoDienThoai);
        itemView.add(lblHoKH);
        itemView.add(txtHoKH);
        itemView.add(lblTenKH);
        itemView.add(txtTenKH);
        itemView.add(lblGioiTinh);
        itemView.add(cbGioiTinh);
        itemView.add(lblTongChiTieu);
        itemView.add(txtTongChiTieu);
        itemView.add(lblTim);

        add(itemView);

        ImageIcon iconRefresh = new ImageIcon("images/Refresh-icon.png");
        ImageIcon iconDelete = new ImageIcon("images/delete-icon.png");
        ImageIcon iconEdit = new ImageIcon("images/Pencil-icon.png");
        ImageIcon iconAdd = new ImageIcon(getClass().getResource("/images/add-icon.png"));

        btnThem = createButton("Thêm", iconAdd, 750, 50, 140, 50);
        btnThem.setVerticalTextPosition(JLabel.CENTER);
        btnThem.setFont(fontIcon);
        btnThem.setOpaque(true);
        btnThem.setBackground(new Color(151, 255, 255));
        btnThem.setBorder(BorderFactory.createLineBorder(Color.black));
        btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSua = createButton("Sửa", iconEdit, 750, 110, 140, 50);
        btnSua.setVerticalTextPosition(JLabel.CENTER);
        btnSua.setFont(fontIcon);
        btnSua.setOpaque(true);
        btnSua.setBackground(new Color(151, 255, 255));
        btnSua.setBorder(BorderFactory.createLineBorder(Color.black));
        btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnXoa = createButton("Xóa", iconDelete, 750, 170, 140, 50);
        btnXoa.setVerticalTextPosition(JLabel.CENTER);
        btnXoa.setFont(fontIcon);
        btnXoa.setOpaque(true);
        btnXoa.setBackground(new Color(151, 255, 255));
        btnXoa.setBorder(BorderFactory.createLineBorder(Color.black));
        btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnReset = createButton("", iconRefresh, 400, 170, 50, 35);
        btnReset.setVerticalTextPosition(JLabel.CENTER);
        btnReset.setFont(fontIcon);
        btnReset.setOpaque(true);
        btnReset.setBackground(new Color(151, 255, 255));
        btnReset.setBorder(BorderFactory.createLineBorder(Color.black));
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        itemView.add(btnThem);
        itemView.add(btnSua);
        itemView.add(btnXoa);
        itemView.add(btnReset);

        Vector<String> header = new Vector<>();
        header.add("Mã KH");
        header.add("Họ");
        header.add("Tên");
        header.add("Giới tính");
        header.add("Số điện thoại");
        header.add("Chi tiêu");

        modelKhachHang = new DefaultTableModel(header, 0);
        tblKhachHang = new JTable(modelKhachHang);
        tblKhachHang.setRowSorter(new TableRowSorter<>(modelKhachHang));
        tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblKhachHang.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblKhachHang.getColumnModel().getColumn(5).setPreferredWidth(150);

        tblKhachHang.setFocusable(false);
        tblKhachHang.setIntercellSpacing(new Dimension(0, 0));
        tblKhachHang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblKhachHang.setRowHeight(30);
        tblKhachHang.setShowVerticalLines(true);
        tblKhachHang.getTableHeader().setOpaque(true);
        tblKhachHang.setFillsViewportHeight(true);
        tblKhachHang.getTableHeader().setBackground(new Color(144, 195, 212));
        tblKhachHang.setSelectionBackground(new Color(232, 232, 232));

        JScrollPane scrollPane = new JScrollPane(tblKhachHang);
        scrollPane.setBounds(new Rectangle(30, 330, 890, 360));
        scrollPane.setBackground(null);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(scrollPane);
        
        loadDataLenBangKhachHang();
    }

    private JButton createButton(String text, ImageIcon icon, int x, int y, int width, int height) {
        JButton button = new JButton(text, icon);
        button.setBounds(new Rectangle(x, y, width, height));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(null);
        button.setBorder(null);
        return button;
    }

    private void addEventsKhachHang() {
        tblKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblKhachHang.getSelectedRow();
                if (row != -1) {
                    txtMaKH.setText(tblKhachHang.getValueAt(row, 0).toString());
                    txtHoKH.setText(tblKhachHang.getValueAt(row, 1).toString());
                    txtTenKH.setText(tblKhachHang.getValueAt(row, 2).toString());
                    cbGioiTinh.setSelectedItem(tblKhachHang.getValueAt(row, 3).toString());
                    txtSoDienThoai.setText(tblKhachHang.getValueAt(row, 4).toString());
                    txtTongChiTieu.setText(tblKhachHang.getValueAt(row, 5).toString());
                }
            }
        });

        btnThem.addActionListener(e -> themKhachHang());
        btnSua.addActionListener(e -> suaKhachHang());
        btnXoa.addActionListener(e -> xoaKhachHang());
        btnReset.addActionListener(e -> resetKhachHang());
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                timKhachHang();
            }
        });
    }

    private void loadDataLenBangKhachHang() {
        khachHangBUS.docDanhSach();
        ArrayList<KhachHang> dskh = khachHangBUS.getListKhachHang();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : dskh) {
        	  Vector<String> row = new Vector<>();
              row.add(String.valueOf(kh.getMaKH())); // Convert int to String
           
            row.add(kh.getHo());
            row.add(kh.getTen());
            row.add(kh.getGioiTinh());
            row.add(kh.getSoDienThoai());
            row.add(String.valueOf(kh.getTongChiTieu()));
            modelKhachHang.addRow(row);
        }
    }

    private void themKhachHang() {
        String maKH = txtMaKH.getText().trim();
        String hoKH = txtHoKH.getText().trim();
        String tenKH = txtTenKH.getText().trim();
        String gioiTinh = cbGioiTinh.getSelectedItem().toString();
        String soDienThoai = txtSoDienThoai.getText().trim();
        String tongChiTieuStr = txtTongChiTieu.getText().trim();

        if (hoKH.isEmpty() || tenKH.isEmpty() || gioiTinh.equals("Chọn giới tính") || soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double tongChiTieu = Double.parseDouble(tongChiTieuStr);
          
            if (khachHangBUS.themKhachHang(hoKH, tenKH, gioiTinh, soDienThoai)) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                khachHangBUS.docDanhSach();
                loadDataLenBangKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Tổng chi tiêu phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void suaKhachHang() {
    	String ma = txtMaKH.getText().trim();
        String ho = txtHoKH.getText().trim();
        String ten = txtTenKH.getText().trim();
        String gioiTinh = cbGioiTinh.getSelectedItem() + "";
        String sdt = txtSoDienThoai.getText().trim();
        
        if(ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
        } else if(!kiemTra(ho, ten, gioiTinh, sdt)) {
            if(khachHangBUS.kiemTraTrungKhachHang(ho, ten, gioiTinh, sdt)) {
                int sua = JOptionPane.showConfirmDialog(this, "Thông tin khách hàng này đã tồn tại, bạn có chắc chắn muốn sửa?", "Thông báo trùng thông tin khách hàng khác", JOptionPane.YES_NO_OPTION);
                if(sua == JOptionPane.YES_OPTION) {
                    boolean flag = khachHangBUS.suaKhachHang(ma, ho, ten, gioiTinh, sdt);
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công");
                        khachHangBUS.docDanhSach();
                        loadDataLenBangKhachHang();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại");
                    }
                }
            } else {
                boolean flag = khachHangBUS.suaKhachHang(ma, ho, ten, gioiTinh, sdt);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công");
                    khachHangBUS.docDanhSach();
                    loadDataLenBangKhachHang();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại");
                }
            }
        }
    }

    private void xoaKhachHang() {
        String maKH = txtMaKH.getText().trim();
        if (maKH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmed = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            if (khachHangBUS.xoaKhachHang(maKH)) {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                khachHangBUS.docDanhSach();
                loadDataLenBangKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetKhachHang() {
        txtMaKH.setText("");
        txtHoKH.setText("");
        txtTenKH.setText("");
        txtSoDienThoai.setText("");
        txtTongChiTieu.setText("0");
        cbGioiTinh.setSelectedIndex(0);
        tblKhachHang.clearSelection();
        loadDataLenBangKhachHang();
    }

    private void timKhachHang() {
        String keyword = txtSearch.getText().trim();
        String choice = cmbChoice.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelKhachHang);
        tblKhachHang.setRowSorter(trs);

        if (keyword.isEmpty()) {
            trs.setRowFilter(null);
        } else {
            switch (choice) {
                case "Mã KH":
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, 0));
                    break;
                case "Tên":
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, 2));
                    break;
                case "Sđt":
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, 4));
                    break;
                default:
                    trs.setRowFilter(null);
                    break;
            }
        }
    }


    
    private void addRowsToTable(ArrayList<KhachHang> listKH) {
        for (KhachHang kh : listKH) {
            Vector row = new Vector();
             row.add(kh.getMaKH());
                row.add(kh.getHo());
                row.add(kh.getTen());
                row.add(kh.getSoDienThoai());
                row.add(kh.getGioiTinh());
                row.add(kh.getTongChiTieu());
            modelKhachHang.addRow(row);
        }
    }



    
    
    private boolean kiemTra(String ho, String ten, String gioiTinh, String sdt) {
        if(ho.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ đệm khách hàng");
            txtHoKH.requestFocus();
            return true;
        } else if(ten.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng");
            txtTenKH.requestFocus();
            return true;
        } else if(sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
            txtSoDienThoai.requestFocus();
            return true;
        } else if(!kiemTraSoDienThoai(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có độ dài 10 ký tự và bắt đầu bằng 03,09,...");
            txtSoDienThoai.requestFocus();
            return true;
        } else if (gioiTinh.equals("Chọn giới tính")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return true;
        } 
        return false;
    }
    
  
    
    private boolean kiemTraSoDienThoai(String sdt) {
        Pattern pattern = Pattern.compile("^0\\d{9}$");
        Matcher matcher = pattern.matcher(sdt);
        return matcher.matches();
    }
}
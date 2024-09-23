
package GUI;

import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import BUS.TaiKhoanBUS;
import Customs.MyDialog;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.PhanQuyen;

import DAO.MyConnect;


import javax.swing.*;

import static javax.swing.BorderFactory.createLineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

import Customs.XuLyFileExcel;
public final class PnlQuanLyNhanVien extends JPanel{
    private final NhanVienBUS NhanVienBUS = new NhanVienBUS();
    private final PhanQuyenBUS phanQuyenBUS = new PhanQuyenBUS();
    private final TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    private JLabel lblTabbedNhanVien, lblTabbedQuyen;
    final ImageIcon tabbedSelected = new ImageIcon("images/ManagerUI/tabbed-btn--selected.png");
    final ImageIcon tabbedDefault = new ImageIcon("images/ManagerUI/tabbed-btn.png");
    private JPanel pnlCardTabNhanVien;
    private final CardLayout cardNhanVienGroup = new CardLayout();
    private JLabel lblTitleNhanVien, lblMaNV, lblHoNV, lblTenNV, lblGioiTinh, lblSdt, lblTim;
    private JTextField txtMaNV, txtHoNV, txtTenNV,txtSdt, txtTim;
    private JButton btnReset, btnThem, btnSua, btnXoa,  btnXuat, btnNhap, btnCapTK, btnMKQuyen,btnKhoaTK, btnMoKhoaTK;
    private JTable tblNhanVien;
    private DefaultTableModel modelNhanVien;
    private JComboBox<String> cmbGioiTinh;
    private JLabel lblTitleQuyen, lblNhomQuyen;
    private JButton btnResetQuyen, btnThemQuyen, btnSuaQuyen, btnXoaQuyen;
    private JComboBox<String> cmbQuyen;
    private JCheckBox ckbNhapHang, ckbBanHang, ckbQLSanPham, ckbQLNhanVien, ckbQLKhachHang, ckbThongKe, ckbKhuyenMai;
    private JComboBox<PhanQuyen> txtChucvu;
    private Font font,fontTabbed;
    private final String placeholderTimKiem = "Nhập từ Khóa mà bạn muốn tìm kiếm...";
    JComboBox cmbChoice = new JComboBox();
	private JTextField txtSearch;
    
    public PnlQuanLyNhanVien() {
       addControls();
       addEventsNhanVien();
       addEventsQuyen();
    }
    
    public void addControls() {
        setLayout(new BorderLayout());
        font = new Font("Segoe UI", Font.BOLD, 26);

        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        Font fontIcon = new Font("Segoe UI", Font.ROMAN_BASELINE, 20);
        
//        Pnl TOP
        JPanel pnlTop = new JPanel();
        pnlTop.setOpaque(false);
        pnlTop.setPreferredSize(new Dimension(1000, 41));
        pnlTop.setLayout(null);
        pnlTop.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.GRAY));
        
        fontTabbed = new Font("Arial", Font.BOLD, 14);
        
        lblTabbedNhanVien = new JLabel("Nhân Viên");
        lblTabbedNhanVien.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedNhanVien.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedNhanVien.setIcon(tabbedSelected);
        lblTabbedNhanVien.setBounds(2, 2, 140, 37);
        lblTabbedNhanVien.setFont(fontTabbed);
        lblTabbedNhanVien.setForeground(Color.white);
        lblTabbedNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblTabbedQuyen = new JLabel("Quyền");
        lblTabbedQuyen.setHorizontalTextPosition(JLabel.CENTER);
        lblTabbedQuyen.setVerticalTextPosition(JLabel.CENTER);
        lblTabbedQuyen.setIcon(tabbedDefault);
        lblTabbedQuyen.setBounds(143, 2, 140, 37);
        lblTabbedQuyen.setFont(fontTabbed);
        lblTabbedQuyen.setForeground(Color.white);
        lblTabbedQuyen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        pnlTop.add(lblTabbedNhanVien);
        pnlTop.add(lblTabbedQuyen);
        
        //        Thêm pnlTop vào Frame
        this.add(pnlTop, BorderLayout.NORTH);
        
        DefaultTableCellRenderer centerRederer = new DefaultTableCellRenderer();
        centerRederer.setHorizontalAlignment(JLabel.CENTER);
        
        /*
        =========================================================================
                                    PANEL NHÂN VIÊN
        =========================================================================
         */
        
        JPanel pnlNhanVien = new JPanel(null);
        GridBagConstraints consNV = new GridBagConstraints();
        pnlNhanVien.setBounds(new Rectangle(30, 40, 1000, 250));
        pnlNhanVien.setBackground(null);

        lblTitleNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblTitleNhanVien.setFont(font);
        lblTitleNhanVien.setBounds(new Rectangle(300,0,400,30));
        
        
        lblMaNV = new JLabel("Mã nhân viên");
        lblMaNV.setBounds(new Rectangle(50,50,200,30));
        lblMaNV.setFont(font0);
        
        lblHoNV = new JLabel("Họ đệm");
        lblHoNV.setBounds(new Rectangle(50,90,200,30));
        lblHoNV.setFont(font0);
        
        lblTenNV = new JLabel("Tên");
        lblTenNV.setFont(font0);
        lblTenNV.setBounds(new Rectangle(400, 90, 200, 30));
        
        lblGioiTinh = new JLabel("Giới tính");
        lblGioiTinh.setFont(font0);
        lblGioiTinh.setBounds(new Rectangle(50, 130, 200, 30));
        
        lblSdt = new JLabel("Số điện thoại");
        lblSdt.setFont(font0);
        lblSdt.setBounds(new Rectangle(400, 50, 200, 30));
        lblTim = new JLabel("Từ khóa  tìm kiếm");
        
        txtMaNV = new JTextField("");
        
        txtMaNV.setEditable(false);
        txtMaNV.setBounds(new Rectangle(150,50,220,30));
        txtMaNV.setBackground(Color.WHITE);
        
        txtHoNV = new JTextField("");
        txtHoNV.setBounds(new Rectangle(150,90,220,30));
        
        txtTenNV = new JTextField("");
        txtTenNV.setBounds(new Rectangle(500,90,220,30));
        
        txtSdt = new JTextField("");
        txtSdt.setBounds(new Rectangle(500,50,220,30));
        txtTim = new JTextField(20);
        
        txtTim.setForeground(Color.GRAY);
        txtTim.setText(placeholderTimKiem);
        
        
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnXuat = new JButton("Xuất");
        btnNhap = new JButton("Nhập");
        btnCapTK = new JButton("Cấp tài khoản");
        btnMKQuyen = new JButton("MK/Quyền");
        btnKhoaTK = new JButton("Khóa tài khoản");
        btnMoKhoaTK = new JButton("Mở khóa tài khoản");
        
        cmbGioiTinh = new JComboBox<>();
        cmbGioiTinh.addItem("Chọn giới tính");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Nữ");
        cmbGioiTinh.setBackground(Color.WHITE);
       	cmbGioiTinh.setFont(font0);
        cmbGioiTinh.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	cmbGioiTinh.setBounds(new Rectangle(150, 130, 220, 30));
        
    	 JLabel lblChucvu = new JLabel("Chức vụ ");
         lblChucvu.setBounds(new Rectangle(400,130,200,30));
         lblChucvu.setFont(font0);
         txtChucvu = new JComboBox<>();
         txtChucvu.setBounds(new Rectangle(500, 130, 220, 30));
         txtChucvu.setFont(font0);
         txtChucvu.setBackground(Color.WHITE);
        
         ArrayList<PhanQuyen> listChucVu = phanQuyenBUS.getListTenNhomQuyen();
         for (PhanQuyen chucVu : listChucVu) {
        	 chucVu.toString();
             txtChucvu.addItem(chucVu);
         }


        pnlNhanVien.add(lblTitleNhanVien);
       
        pnlNhanVien.add(lblMaNV);
        pnlNhanVien.add(txtMaNV);
        pnlNhanVien.add(lblHoNV);
        pnlNhanVien.add(txtHoNV);
        pnlNhanVien.add(lblTenNV);
        pnlNhanVien.add(txtTenNV);

        pnlNhanVien.add(lblGioiTinh);
        pnlNhanVien.add(cmbGioiTinh);
        pnlNhanVien.add(lblSdt);
        pnlNhanVien.add(txtSdt);
        pnlNhanVien.add(lblChucvu);
        pnlNhanVien.add(txtChucvu);
        pnlNhanVien.add(lblTim);
       
        lblTim = new JLabel("Tìm kiếm");
        lblTim.setBounds(new Rectangle(50,220,200,30));
        lblTim.setFont(fontIcon);

        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(Color.WHITE);
        searchBox.setBounds(new Rectangle(150,250,565,30)); 
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền 
        
         //PHẦN CHỌN SEARCH
        
         cmbChoice.setEditable(true);
         cmbChoice.setFont(new Font("Segoe UI",Font.PLAIN,14));
         cmbChoice.addItem("Mã NV");
         cmbChoice.addItem("Tên");
         cmbChoice.addItem("Sdt");
         
         
         cmbChoice.setBounds(new Rectangle(0,0,120,30));
         cmbChoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
         cmbChoice.setBackground(Color.WHITE);
         //Phần TextField
         txtSearch = new JTextField();
         txtSearch.setBounds(new Rectangle(125,0,250,35));
         txtSearch.setBorder(null);
         txtSearch.setOpaque(false);
         txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));
         
         ImageIcon iconSearch = new ImageIcon("images\\search_icon.png");
         // Custem Icon search
           JLabel searchIcon = new JLabel("");
          searchIcon.setBounds(new Rectangle(530,0,50,30));

          searchIcon.setBackground(new Color(151,255,255));
          Image imgSearch = iconSearch.getImage();
          Image imgscale4 = imgSearch.getScaledInstance(32,32, Image.SCALE_SMOOTH);
          ImageIcon scaledicon4 = new ImageIcon(imgscale4);
          searchIcon.setIcon(scaledicon4);
          
          
    
         // Add tất cả vào search box
         searchBox.add(cmbChoice);
         searchBox.add(txtSearch);
         searchBox.add(searchIcon);
  
         pnlNhanVien.add(searchBox);
//        Panel Thông tin Nhân viên
         
         ImageIcon icon = new ImageIcon("images\\Refresh-icon.png");
         ImageIcon icon1 = new ImageIcon("images\\delete-icon.png");
         ImageIcon icon2 = new ImageIcon("images\\Pencil-icon.png");
         ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/add-icon.png"));
         ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/excel-icon.png"));
         
         btnThem = new JButton("Thêm");
         btnThem.setVerticalTextPosition(JLabel.CENTER);
         btnThem.setFont(fontIcon);
         btnThem.setBounds(new Rectangle(750,50, 100, 40));
         btnThem.setOpaque(true);
         btnThem.setBackground(new Color(151, 255, 255));
         btnThem.setBorder(BorderFactory.createLineBorder(Color.black));
         btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
         Image img = icon3.getImage();
         Image imgscale = img.getScaledInstance(35,35, Image.SCALE_SMOOTH);
         ImageIcon scaledicon = new ImageIcon(imgscale);
         btnThem.setIcon(scaledicon);

         btnSua = new JButton("Sửa");
         btnSua.setVerticalTextPosition(JLabel.CENTER);
         btnSua.setFont(fontIcon);
         btnSua.setBounds(new Rectangle(750, 100, 100,40));
         btnSua.setOpaque(true);
         btnSua.setBackground(new Color(151, 255, 255));
         btnSua.setBorder(BorderFactory.createLineBorder(Color.black));
         btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
         Image img1 = icon2.getImage();
         Image imgscale1 = img1.getScaledInstance(32,32, Image.SCALE_SMOOTH);
         ImageIcon scaledicon1 = new ImageIcon(imgscale1);
         btnSua.setIcon(scaledicon1);

         btnXoa = new JButton("Xóa");
         btnXoa.setVerticalTextPosition(JLabel.CENTER);
         btnXoa.setFont(fontIcon);
         btnXoa.setBounds(new Rectangle(750, 150, 100,40));
         btnXoa.setOpaque(true);
         btnXoa.setBackground(new Color(151, 255, 255));
         btnXoa.setBorder(BorderFactory.createLineBorder(Color.black));
         btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
         Image img2 = icon1.getImage();
         Image imgscale2 = img2.getScaledInstance(30,30, Image.SCALE_SMOOTH);
         ImageIcon scaledicon2 = new ImageIcon(imgscale2);
         btnXoa.setIcon(scaledicon2);

         btnReset = new JButton("");
         btnReset.setVerticalTextPosition(JLabel.CENTER);
         btnReset.setFont(fontIcon);
         btnReset.setOpaque(true);
         btnReset.setBounds(new Rectangle(650,10,70,30));
         btnReset.setBackground(new Color(151, 255, 255));
         btnReset.setBorder(BorderFactory.createLineBorder(Color.black));
         btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
         Image imgReset = icon.getImage();
         Image imgscale3 = imgReset.getScaledInstance(30,30, Image.SCALE_SMOOTH);
         ImageIcon scaledicon3 = new ImageIcon(imgscale3);
         btnReset.setIcon(scaledicon3);
         
         btnNhap = new JButton("Nhập excel", icon4);
         btnNhap.setHorizontalAlignment(JLabel.CENTER);
         btnNhap.setFont(fontIcon);
         btnNhap.setBounds(new Rectangle(745, 200, 140, 40));
         btnNhap.setOpaque(true);
         btnNhap.setBackground(new Color(0,205,102));
         
         btnNhap.setBorder(BorderFactory.createLineBorder(Color.black));
         btnNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
         
         btnXuat = new JButton("Xuất excel", icon4);
         btnXuat.setHorizontalAlignment(JLabel.CENTER);
         btnXuat.setFont(fontIcon);
         btnXuat.setBounds(new Rectangle(745, 250, 140, 40));
         btnXuat.setOpaque(true);
         btnXuat.setBackground(new Color(0,205,102));
         
         btnXuat.setBorder(BorderFactory.createLineBorder(Color.black));
         btnXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
     
         
         pnlNhanVien.add(btnThem);
         pnlNhanVien.add(btnSua);
         pnlNhanVien.add(btnXoa);
         pnlNhanVien.add(btnReset);
         pnlNhanVien.add(btnXuat);
         pnlNhanVien.add(btnNhap);
         
        
         btnCapTK.setVerticalTextPosition(JLabel.CENTER);
         btnCapTK.setFont(fontIcon);
         btnCapTK.setBounds(new Rectangle(50, 185, 140,40));
         btnCapTK.setOpaque(true);
         btnCapTK.setBackground(new Color(151, 255, 255));
         btnCapTK.setBorder(BorderFactory.createLineBorder(Color.black));
         btnCapTK.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
      
         btnMKQuyen.setVerticalTextPosition(JLabel.CENTER);
         btnMKQuyen.setFont(fontIcon);
         btnMKQuyen.setBounds(new Rectangle(210, 185, 140,40));
         btnMKQuyen.setOpaque(true);
         btnMKQuyen.setBackground(new Color(151, 255, 255));
         btnMKQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
         btnMKQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
         
         
       
         
         btnKhoaTK.setVerticalTextPosition(JLabel.CENTER);
         btnKhoaTK.setFont(fontIcon);
         btnKhoaTK.setBounds(new Rectangle(380, 185, 140,40));
         btnKhoaTK.setOpaque(true);
         btnKhoaTK.setBackground(new Color(151, 255, 255));
         btnKhoaTK.setBorder(BorderFactory.createLineBorder(Color.black));
         btnKhoaTK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
         
         btnMoKhoaTK.setVerticalTextPosition(JLabel.CENTER);
         btnMoKhoaTK.setFont(fontIcon);
         btnMoKhoaTK.setBounds(new Rectangle(545, 185, 170,40));
         btnMoKhoaTK.setOpaque(true);
         btnMoKhoaTK.setBackground(new Color(151, 255, 255));
         btnMoKhoaTK.setBorder(BorderFactory.createLineBorder(Color.black));
         btnMoKhoaTK.setCursor(new Cursor(Cursor.HAND_CURSOR));
         
         
         
       pnlNhanVien.add(btnCapTK);
       pnlNhanVien.add(btnMKQuyen);
       pnlNhanVien.add(btnKhoaTK);
       pnlNhanVien.add(btnMoKhoaTK);

//     
        
//    
       Vector header = new Vector();
       header.add("Mã NV");
       header.add("Họ");
       header.add("Tên");
       header.add("Giới tính");
       header.add("Số điện thoại");
       header.add("Chức vụ");
       header.add("Tài khoản");
       
       modelNhanVien = new DefaultTableModel(header, 7);
       tblNhanVien = new JTable( modelNhanVien);
       TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>( modelNhanVien);
       tblNhanVien.setRowSorter(rowSorter);
      

       tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(100);
       tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(150);
       tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(150);
       tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(150);
       tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(150);
       tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(150);
    

       tblNhanVien.setFocusable(false);
       tblNhanVien.setIntercellSpacing(new Dimension(0,0));     
       tblNhanVien.getTableHeader().setFont(font1);
       tblNhanVien.setRowHeight(30);
       tblNhanVien.setShowVerticalLines(true);              
       tblNhanVien.getTableHeader().setOpaque(true);
       tblNhanVien.setFillsViewportHeight(true);
       tblNhanVien.getTableHeader().setBackground(new Color(144, 195, 212));

       tblNhanVien.setSelectionBackground(new Color(232, 232, 232));          
       
       
       JScrollPane scrollPane = new JScrollPane(tblNhanVien);
       scrollPane.setBounds(new Rectangle(30,330, 1000 - 110, 360));
       scrollPane.setBackground(null);
       pnlNhanVien.add(scrollPane);
     
                /*
        =========================================================================
                                    PANEL QUYỀN
        =========================================================================
         */
        JPanel pnlQuyen = new JPanel(null);
       
        
        lblTitleQuyen = new JLabel("QUẢN LÝ QUYỀN TÀI KHOẢN");
        lblTitleQuyen.setBounds(new Rectangle(350,20,500,30));
        lblTitleQuyen.setFont(font);
        
        
        lblNhomQuyen = new JLabel("Nhóm Quyền :");
        lblNhomQuyen.setFont(fontIcon);
        lblNhomQuyen.setBounds(new Rectangle(350,80,200,30));
        
        btnResetQuyen = new JButton("",new ImageIcon(getClass().getResource("/images/Refresh-icon.png")));
        btnResetQuyen.setFont(fontIcon);
        btnResetQuyen.setBounds(new Rectangle(750,20,100,40));
        btnResetQuyen.setOpaque(true);
        btnResetQuyen.setBackground(new Color(151, 255, 255));
        btnResetQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
        btnResetQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnThemQuyen = new JButton("Thêm quyền",new ImageIcon(getClass().getResource("/images/add-icon.png")));
        btnThemQuyen.setFont(fontIcon);
        btnThemQuyen.setBounds(new Rectangle(300,480,150,40));
     
        btnThemQuyen.setOpaque(true);
        btnThemQuyen.setBackground(new Color(151, 255, 255));
        btnThemQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
        btnThemQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSuaQuyen = new JButton("Sửa quyền",new ImageIcon(getClass().getResource("/images/Pencil-icon.png")));
        btnSuaQuyen.setFont(fontIcon);
        btnSuaQuyen.setBounds(new Rectangle(480,480,150,40));
        btnSuaQuyen.setOpaque(true);
        btnSuaQuyen.setBackground(new Color(151, 255, 255));
        btnSuaQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
        btnSuaQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnXoaQuyen = new JButton("Xóa quyền",new ImageIcon(getClass().getResource("/images/delete-icon.png")));
        btnXoaQuyen.setFont(fontIcon);
        btnXoaQuyen.setBounds(new Rectangle(650,480,150,40));
        btnXoaQuyen.setOpaque(true);
        btnXoaQuyen.setBackground(new Color(151, 255, 255));
        btnXoaQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
        btnXoaQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        cmbQuyen = new JComboBox<>();
        cmbQuyen.setFont(fontIcon);
        cmbQuyen.setBounds(new Rectangle(485,80,200,30));
        cmbQuyen.setOpaque(true);
        cmbQuyen.setBackground(Color.WHITE);
        cmbQuyen.setBorder(BorderFactory.createLineBorder(Color.black));
        cmbQuyen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbNhapHang = new JCheckBox("Quản lý nhập hàng");
        ckbNhapHang.setFont(fontIcon);
        ckbNhapHang.setBounds(new Rectangle(485,130,200,40));
        ckbNhapHang.setOpaque(true);
        ckbNhapHang.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbNhapHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbBanHang = new JCheckBox("Quản lý bán hàng");
        ckbBanHang.setFont(fontIcon);
        ckbBanHang.setBounds(new Rectangle(485,180,200,40));
        ckbBanHang.setOpaque(true);
        ckbBanHang.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbBanHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbQLSanPham = new JCheckBox("Quản lý sản phẩm");
        ckbQLSanPham.setFont(fontIcon);
        ckbQLSanPham.setBounds(new Rectangle(485,230,200,40));
        ckbQLSanPham.setOpaque(true);
        ckbQLSanPham.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbQLSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbQLNhanVien = new JCheckBox("Quản lý nhân viên");
        ckbQLNhanVien.setFont(fontIcon);
        ckbQLNhanVien.setBounds(new Rectangle(485,280,200,40));
        ckbQLNhanVien.setOpaque(true);
        ckbQLNhanVien.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbQLNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbQLKhachHang = new JCheckBox("Quản lý khách hàng");
        ckbQLKhachHang.setFont(fontIcon);
        ckbQLKhachHang.setBounds(new Rectangle(485,330,200,40));
        ckbQLKhachHang.setOpaque(true);
        ckbQLKhachHang.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbQLKhachHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbThongKe = new JCheckBox("Quản lý thống kê");
        ckbThongKe.setFont(fontIcon);
        ckbThongKe.setBounds(new Rectangle(485,380,200,40));
        ckbThongKe.setOpaque(true);
        ckbThongKe.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ckbKhuyenMai = new JCheckBox("Quản lý khuyến mãi");
        ckbKhuyenMai.setFont(fontIcon);
        ckbKhuyenMai.setBounds(new Rectangle(485,430,200,40));
        ckbKhuyenMai.setOpaque(true);
        ckbKhuyenMai.setBorder(BorderFactory.createLineBorder(Color.black));
        ckbKhuyenMai.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        

        pnlQuyen.add(lblTitleQuyen);
        pnlQuyen.add(lblNhomQuyen);
        pnlQuyen.add(btnResetQuyen);
        pnlQuyen.add(btnThemQuyen);
        pnlQuyen.add(btnSuaQuyen);
        pnlQuyen.add(btnXoaQuyen);
        pnlQuyen.add(cmbQuyen);
        pnlQuyen.add(ckbNhapHang);
        pnlQuyen.add(ckbBanHang);
        pnlQuyen.add(ckbQLSanPham);
        pnlQuyen.add(ckbQLNhanVien);
        pnlQuyen.add(ckbQLKhachHang);
        pnlQuyen.add(ckbThongKe);
        pnlQuyen.add(ckbKhuyenMai);
        

        
//        Panel Button
        JPanel pnlBtnQuyen = new JPanel(new GridBagLayout());
        GridBagConstraints consBtnQuyen = new GridBagConstraints();
        
       

//        add pnl Button vào pnl Quyền
        
      
      
 
        
       
        
        
        pnlCardTabNhanVien = new JPanel(cardNhanVienGroup);
        pnlCardTabNhanVien.add(pnlNhanVien, "1");
        pnlCardTabNhanVien.add(pnlQuyen, "2");
   
        this.add(pnlCardTabNhanVien);
        
        loadDataLenBangNhanVien();
        loadDataLenCmbQuyen();
        
        setSize(1000, 700);
        setVisible(true);
    }
    
    private void addEventsNhanVien() {
        lblTabbedNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedNhanVien.setIcon(tabbedSelected);
                lblTabbedQuyen.setIcon(tabbedDefault);
                cardNhanVienGroup.show(pnlCardTabNhanVien, "1");
                loadDataLenBangNhanVien();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }
           
        });

        lblTabbedQuyen.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblTabbedQuyen.setIcon(tabbedSelected);
                lblTabbedNhanVien.setIcon(tabbedDefault);
                cardNhanVienGroup.show(pnlCardTabNhanVien, "2");
                loadDataLenCmbQuyen();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        tblNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	xuLyChonNhanVien();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Đặt loại con trỏ chuột khi di chuyển vào bảng
            	tblNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
           
            @Override
            public void mouseExited(MouseEvent e) {
                // Đặt lại loại con trỏ chuột khi di chuyển ra khỏi bảng
                tblNhanVien.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenBangNhanVien();
                xuLyReset();
            }
        });
        
     
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                timNhanVien();
            }
        });
      
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemNhanVien();
            }
        });
        
     
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaNhanVien();
            }
        });
      
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaNhanVien();
            }
        });
        
     
        
        btnXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXuatExcel();
            }
        });
        
      
        
        btnNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyNhapExcel();
            }
        });
        
       
        
        btnCapTK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    xuLyCapTaiKhoan();
            }
        });
        
      
        btnMKQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyResetMatKhau();
            }
        });
        
       
        btnKhoaTK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyKhoaTaiKhoan();
            }
        });
    
        
        btnMoKhoaTK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyMoKhoaTaiKhoan();
            }
        });
        
  
    }
     
    private void addEventsQuyen() {
        btnResetQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenCmbQuyen();
                xuLyResetQuyen();
            }
        });
        
        btnResetQuyen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    loadDataLenCmbQuyen();
                    xuLyResetQuyen();
                }
            }
        });

        btnThemQuyen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    xuLyThemQuyen();
                }
            }
        });
        
        btnThemQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemQuyen();
            }
        });
        
      
        
        btnSuaQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaQuyen();
            }
        });
        
        btnXoaQuyen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    xuLyXoaQuyen();
                }
            }
        });
        
        btnXoaQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaQuyen();
            }
        });
        
        cmbQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyHienThiChiTietQuyen();
            }
        });
        
        cmbQuyen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    xuLyHienThiChiTietQuyen();
                }
            }
        });
    }
    
    //    Phương thức của pnlNhanVien
     private void loadDataLenBangNhanVien() {
         NhanVienBUS.docDanhSach();
        ArrayList<NhanVien> dsnv = NhanVienBUS.getDanhSachNhanVien();
         loadDataLenBangNhanVien(dsnv);
    }
 
     private void loadDataLenBangNhanVien(ArrayList<NhanVien> dsnv) {
        modelNhanVien.setRowCount(0);
         for (NhanVien nv : dsnv) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHo());
            vec.add(nv.getTen());
            vec.add(nv.getGioiTinh());
            vec.add(nv.getSoDienThoai());
            vec.add(nv.getChucVu());
           
            int trangThai = taiKhoanBUS.getTrangThai(nv.getMaNV() + "");
            if (trangThai == 0) {
                vec.add("Khoá");
            }
            else if(trangThai == 1) {
                vec.add("Hiệu lực");
            }
            else {
                vec.add("Chưa có");
            }
            modelNhanVien.addRow(vec);
        }
     }
     
    public void xuLyReset() {
        txtMaNV.setText("");
        txtHoNV.setText("");
        txtTenNV.setText("");
        txtSdt.setText("");
        cmbGioiTinh.setSelectedIndex(0);
        txtTim.setText(placeholderTimKiem);
        txtTim.setForeground(Color.GRAY);
    }
    
    private void xuLyChonNhanVien() {
        int row = tblNhanVien.getSelectedRow();
        if(row > -1) {
            String ma = tblNhanVien.getValueAt(row, 0) + "";
            String ho = tblNhanVien.getValueAt(row, 1) + "";
            String ten = tblNhanVien.getValueAt(row, 2) + "";
            
            String sdt = tblNhanVien.getValueAt(row, 4) + "";
            
            String chucvu = tblNhanVien.getValueAt(row,5) + "";
            txtMaNV.setText(ma);
            txtHoNV.setText(ho);
            txtTenNV.setText(ten);
            int index = tblNhanVien.getValueAt(row, 3).equals("Nam") ? 1 : 2;
            cmbGioiTinh.setSelectedIndex(index);
            txtSdt.setText(sdt);
         
            for (int i = 0; i < txtChucvu.getItemCount(); i++) {
                PhanQuyen item = (PhanQuyen) txtChucvu.getItemAt(i);
                if (item.getQuyen().equals(chucvu)) {
                    txtChucvu.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void xuLyThemNhanVien() {
        String ho = txtHoNV.getText().trim();
        String ten = txtTenNV.getText().trim();
        String gioiTinh = cmbGioiTinh.getSelectedItem() + "";
        String cv = txtChucvu.getSelectedItem() + "";
        String sdt = txtSdt.getText().trim();
        if(cv.contains("Default")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ cho nhân viên");
            return ;
        }
        if(!kiemTra(ho, ten, gioiTinh,sdt, cv)) { //!true khi có lỗi và !false khi mà không có lỗi
            if(NhanVienBUS.kiemTraTrungNhanVien(ho, ten, gioiTinh,sdt, cv)) {
                int them = JOptionPane.showConfirmDialog(this, "Nhân viên này đã tồn tại, bạn có chắc chắn muốn thêm?", "Thông báo trùng Nhân viên", JOptionPane.YES_NO_OPTION);
                
                if(them == JOptionPane.YES_OPTION) {
                    boolean flag = NhanVienBUS.themNhanVien(ho, ten, gioiTinh,sdt, cv);
                    
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Thêm nhân viên hàng thành công");
                        NhanVienBUS.docDanhSach();
                        loadDataLenBangNhanVien();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
                    }
                }
            } else {
                boolean flag = NhanVienBUS.themNhanVien(ho, ten, gioiTinh,sdt, cv);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                    NhanVienBUS.docDanhSach();
                    loadDataLenBangNhanVien();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
                }
            }
        }
        
    }
    
    private void xuLySuaNhanVien() {
        String ma = txtMaNV.getText().trim();
        String ho = txtHoNV.getText().trim();
        String ten = txtTenNV.getText().trim();
        String gioiTinh = cmbGioiTinh.getSelectedItem() + "";
      
        String sdt = txtSdt.getText().trim();
        String cv = txtChucvu.getSelectedItem() + "";
        
        if(ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
        } else if(!kiemTra(ho, ten, gioiTinh,sdt, cv)) {
            if(NhanVienBUS.kiemTraTrungNhanVien(ho, ten, gioiTinh,sdt, cv)) {
                int sua = JOptionPane.showConfirmDialog(this, "Thông tin nhân viên này đã tồn tại, bạn có chắc chắn muốn sửa?", "Thông báo trùng thông tin nhân viên khác", JOptionPane.YES_NO_OPTION);
                if(sua == JOptionPane.YES_OPTION) {
                    boolean flag = NhanVienBUS.suaNhanVien(ma, ho, ten, gioiTinh,sdt, cv);
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
                        NhanVienBUS.docDanhSach();
                        loadDataLenBangNhanVien();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
                    }
                }
            } else {
                boolean flag = NhanVienBUS.suaNhanVien(ma, ho, ten, gioiTinh,sdt, cv);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
                    NhanVienBUS.docDanhSach();
                    loadDataLenBangNhanVien();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
                }
            }
        }
    }
       
    private void xuLyXoaNhanVien() {
        String ma = txtMaNV.getText().trim();
        String ho = txtHoNV.getText().trim();
        String ten = txtTenNV.getText().trim();
        String gioiTinh = cmbGioiTinh.getSelectedItem() + "";
        String sdt = txtSdt.getText().trim();
        String cv = txtChucvu.getSelectedItem() + "";
        
        if(ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
        } else if(!kiemTra(ho, ten, gioiTinh,sdt, cv)) {
            int flagXoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if(flagXoa == JOptionPane.YES_OPTION) {
                boolean flag = NhanVienBUS.xoaNhanVien(ma);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    xuLyReset();
                    NhanVienBUS.docDanhSach();
                    loadDataLenBangNhanVien();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        }
    }
    
    private void xuLyNhapExcel() {
        int nhap = JOptionPane.showConfirmDialog(this, "Dữ liệu cũ sẽ bị xoá, tiếp tục?", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (nhap == JOptionPane.YES_OPTION) {
            XuLyFileExcel nhapExcel = new XuLyFileExcel();
            nhapExcel.nhapExcel(tblNhanVien);

            int row = tblNhanVien.getRowCount();
            for (int i = 0; i < row; i++) {
                String ho = tblNhanVien.getValueAt(i, 1) + "";
                String ten = tblNhanVien.getValueAt(i, 2) + "";
                String gioiTinh = tblNhanVien.getValueAt(i, 3) + "";
                String chucVu = tblNhanVien.getValueAt(i, 4) + "";

                NhanVienBUS.nhapExcel(ho, ten, gioiTinh, chucVu);
            }
        }
    }

    private void xuLyXuatExcel() {
        XuLyFileExcel xuatExcel = new XuLyFileExcel();
        xuatExcel.xuatExcel(tblNhanVien);
    }
    
//    private void xuLyResetMatKhau() {
//        String maNV = txtMaNV.getText();
//        String trangThaiTK = layTrangThaiTK(maNV);
//        
//        
//        if (maNV.equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
//            return;
//        } else {
//            if(trangThaiTK.equals("Chưa có")) {
//                JOptionPane.showMessageDialog(this, "Nhân viên này chưa được cấp tài khoản");
//            } else {
//                DlgQuyen_MatKhau dialog = new DlgQuyen_MatKhau(maNV);
//                dialog.setVisible(true);
//            }
//        }
//    }
    
    private void xuLyResetMatKhau() {
    String maNV = txtMaNV.getText();
    String trangThaiTK = layTrangThaiTK(maNV);
    
    if (maNV.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
        return;
    }

    if (trangThaiTK.equals("Chưa có")) {
        JOptionPane.showMessageDialog(this, "Nhân viên này chưa được cấp tài khoản");
        return;
    }

    // Hiện dialog và lấy quyền đã chọn
    DlgQuyen_MatKhau dialog = new DlgQuyen_MatKhau(maNV);
    dialog.setVisible(true); // Hiện dialog

    // Sau khi dialog đóng, lấy quyền đã chọn
    String quyenDaChon = dialog.quyenSelected();
    if (quyenDaChon != null) {
        cmbQuyen.setSelectedItem(quyenDaChon);
        // Bạn có thể thực hiện thêm các hành động với quyền đã chọn
    }
    loadDataLenBangNhanVien();
    xuLyReset();
}

//    private void xuLyCapTaiKhoan() {
//        String maNV = txtMaNV.getText();
//        String trangThaiTK = layTrangThaiTK(maNV);
//        String quyen = txtChucvu.getSelectedItem().toString();
//        if (maNV.equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
//            return;
//        } else {
//            if(trangThaiTK.equals("Chưa có")) {
//                DlgCapTaiKhoan dialog = new DlgCapTaiKhoan(maNV,quyen);
//                dialog.setVisible(true);
//                loadDataLenBangNhanVien();
//            } else {
//                JOptionPane.showMessageDialog(this, "Nhân viên này đã có tài khoản, không thể cấp tài khoản khác");
//            }
//        }
//    }
    private void xuLyCapTaiKhoan() {
        String maNV = txtMaNV.getText();
        if (maNV == null || maNV.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
            return;
        }

        String trangThaiTK = layTrangThaiTK(maNV);
        if (trangThaiTK == null || trangThaiTK.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lỗi trong việc lấy trạng thái tài khoản");
            return;
        }

        String quyen = txtChucvu.getSelectedItem().toString();
        if (trangThaiTK.equals("Chưa có")) {
            DlgCapTaiKhoan dialog = new DlgCapTaiKhoan(maNV, quyen);
            dialog.setVisible(true);
            loadDataLenBangNhanVien();
        } else {
            JOptionPane.showMessageDialog(this, "Nhân viên này đã có tài khoản, không thể cấp tài khoản khác");
        }
    }

    private void xuLyKhoaTaiKhoan() {
        String maNV = txtMaNV.getText().trim();
        String trangThaiTK = layTrangThaiTK(maNV);
        
        if (maNV.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
            return;
        } else {
            if(trangThaiTK.equals("Hiệu lực")) {
                int khoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn khóa tài khoảng này?", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
                if(khoa == JOptionPane.YES_OPTION) {
                    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
                    boolean flag = taiKhoanBUS.khoaTaiKhoan(txtMaNV.getText());
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Khoá tài khoản thành công");
                        loadDataLenBangNhanVien();  
                    } else {
                        JOptionPane.showMessageDialog(this, "Khóa tài khoản thất bại");
                    }
                }
            } else if(trangThaiTK.equals("Chưa có")){
                JOptionPane.showMessageDialog(this, "Nhân viên này chưa được cấp tài khoản!");
            } else if(trangThaiTK.equals("Khóa")) {
                JOptionPane.showMessageDialog(this, "Tài khoản này đã bị khóa rồi, vui lòng mở khóa để tiếp tục");
            }
        }
    }
    
    private void xuLyMoKhoaTaiKhoan() {
        String maNV = txtMaNV.getText();
        String trangThaiTK = layTrangThaiTK(maNV);
        
        if (maNV.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên");
            return;
        } else {
            if(trangThaiTK.equals("Khóa")) {
                int moKhoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn mở khóa tài khoảng này?", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
                if(moKhoa == JOptionPane.YES_OPTION) {
                    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
                    boolean flag = taiKhoanBUS.moKhoaTaiKhoan(maNV);
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Mở khóa tài khoản thành công");
                        loadDataLenBangNhanVien();  
                    } else {
                        JOptionPane.showMessageDialog(this, "Mở khóa tài khoản thất bại");
                    }
                }
            } else if(trangThaiTK.equals("Chưa có")){
                JOptionPane.showMessageDialog(this, "Nhân viên này chưa được cấp tài khoản!");
            } else if(trangThaiTK.equals("Hiệu lực")) {
                JOptionPane.showMessageDialog(this, "Tài khoản này đang không bị khóa");
            }
        }
    }

//    Phương thức của pnl Quyền
     private void loadDataLenCmbQuyen() {
         phanQuyenBUS.docDanhSachNhomQuyen();
        ArrayList<PhanQuyen> dsq = phanQuyenBUS.getListNhomQuyen();
        cmbQuyen.removeAllItems();
        cmbQuyen.addItem("Chọn quyền");
        for (PhanQuyen pq : dsq) {
            cmbQuyen.addItem(pq.getQuyen());
        }
    }
    
     public void xuLyResetQuyen() {
        cmbQuyen.setSelectedIndex(0);
        ckbNhapHang.setSelected(false);
        ckbBanHang.setSelected(false);
        ckbQLSanPham.setSelected(false);
        ckbQLNhanVien.setSelected(false);
        ckbQLKhachHang.setSelected(false);
        ckbThongKe.setSelected(false);
        ckbKhuyenMai.setSelected(false);
    }
     
    private void xuLyHienThiChiTietQuyen(){
        ArrayList<PhanQuyen> dsq = phanQuyenBUS.getListNhomQuyen();
        PhanQuyen phanQuyen = new PhanQuyen();
        for (PhanQuyen pq : dsq) {
            if (pq.getQuyen().equals(cmbQuyen.getSelectedItem())) {
                phanQuyen.setQuyen(pq.getQuyen());
                phanQuyen.setNhapHang(pq.getNhapHang());
                phanQuyen.setBanHang(pq.getBanHang());
                phanQuyen.setQlSanPham(pq.getQlSanPham());
                phanQuyen.setQlNhanVien(pq.getQlNhanVien());
                phanQuyen.setQlKhachHang(pq.getQlKhachHang());
                phanQuyen.setThongKe(pq.getThongKe());
                phanQuyen.setQlKhuyenMai(pq.getQlKhuyenMai());
                break;
            }
        }
        ckbNhapHang.setSelected(false);
        ckbBanHang.setSelected(false);
        ckbQLSanPham.setSelected(false);
        ckbQLNhanVien.setSelected(false);
        ckbQLKhachHang.setSelected(false);
        ckbThongKe.setSelected(false);
        ckbKhuyenMai.setSelected(false);
        if (phanQuyen.getNhapHang() == 1) {
            ckbNhapHang.setSelected(true);
        }
        if (phanQuyen.getBanHang() == 1) {
            ckbBanHang.setSelected(true);
        }
        if (phanQuyen.getQlSanPham() == 1) {
            ckbQLSanPham.setSelected(true);
        }
        if (phanQuyen.getQlNhanVien() == 1) {
            ckbQLNhanVien.setSelected(true);
        }
        if (phanQuyen.getQlKhachHang() == 1) {
            ckbQLKhachHang.setSelected(true);
        }
        if (phanQuyen.getThongKe() == 1) {
            ckbThongKe.setSelected(true);
        }
        if (phanQuyen.getQlKhuyenMai() == 1) {
            ckbKhuyenMai.setSelected(true);
        }
    }

    private void xuLySuaQuyen() {
        if (cmbQuyen.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhóm quyền để sửa");
            return;
        }
        String tenQuyen = cmbQuyen.getSelectedItem() + "";
        int nhapHang = ckbNhapHang.isSelected() ? 1 : 0;
        int banHang = ckbBanHang.isSelected() ? 1 : 0;
        int sanPham = ckbQLSanPham.isSelected() ? 1 : 0;
        int nhanVien = ckbQLNhanVien.isSelected() ? 1 : 0;
        int khachHang = ckbQLKhachHang.isSelected() ? 1 : 0;
        int thongKe = ckbThongKe.isSelected() ? 1 : 0;
        int khuyenMai = ckbKhuyenMai.isSelected() ? 1 : 0;

        boolean flag = phanQuyenBUS.suaNhomQuyen(tenQuyen, nhapHang, banHang, sanPham, nhanVien, khachHang, thongKe, khuyenMai);
        if (flag) {
            JOptionPane.showMessageDialog(this, "Sửa nhóm quyền thành công");
            loadDataLenCmbQuyen();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa nhóm quyền thất bại");
        }
    }
 
    private void xuLyXoaQuyen() {
        if (cmbQuyen.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhóm quyền để xóa");
            return;
        }
        int xoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (xoa == JOptionPane.YES_OPTION) {
            String tenQuyen = cmbQuyen.getSelectedItem() + "";
            boolean flag = phanQuyenBUS.xoaNhomQuyen(tenQuyen);
            if (flag) {
                loadDataLenCmbQuyen();
            }
        }
    }

    private void xuLyThemQuyen() {
        String tenQuyen = JOptionPane.showInputDialog("Nhập tên quyền");

        boolean flag = phanQuyenBUS.themNhomQuyen(tenQuyen);
        if (flag) {
            loadDataLenCmbQuyen();
        }
    }
    

    
    private boolean kiemTra(String ho, String ten, String gioiTinh,String sdt, String cv) {
        if(ho.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ đệm Nhân Viên");
            txtHoNV.requestFocus();
            return true;
        } else if(ten.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Nhân Viên");
            txtTenNV.requestFocus();
            return true;
        } else if(cv.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Chức vụ nhân viên");
            txtSdt.requestFocus();
            return true;
        } else if (gioiTinh.equals("Chọn giới tính")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return true;
        } else if(sdt.equals("")) {
        	JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
            return true;
        }else if(!kiemTraSoDienThoai(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có độ dài 10 ký tự và bắt đầu bằng số 0 ");
            txtSdt.requestFocus();
        return true;
        }
        return false;
    }

    private void timNhanVien() {
        String keyword = txtSearch.getText().trim();
        String choice = cmbChoice.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelNhanVien);
        tblNhanVien.setRowSorter(trs);

        if (!keyword.isEmpty()) {
           
            String filterPattern = "(?i)" + keyword; 

            // Apply the filter based on the selected choice
            switch (choice) {
                case "Mã NV":
                    trs.setRowFilter(RowFilter.regexFilter(filterPattern, 0)); 
                    break;
                case "Tên":
                    trs.setRowFilter(RowFilter.regexFilter(filterPattern, 2)); 
                    break;
                case "Sdt":
                    trs.setRowFilter(RowFilter.regexFilter(filterPattern, 4)); 
                    break;
                default:
                    trs.setRowFilter(null); // No filtering for other choices
                    break;
            }
        } else {
            trs.setRowFilter(null); 
        }
    }


    private void addRowsToTable(ArrayList<NhanVien> listKH) {
        for (NhanVien kh : listKH) {
            Vector row = new Vector();
             row.add(kh.getMaNV());
                row.add(kh.getHo());
                row.add(kh.getTen());
                row.add(kh.getSoDienThoai());
                row.add(kh.getGioiTinh());
                row.add(kh.getChucVu());
            modelNhanVien.addRow(row);
        }
    }

    
    private boolean kiemTraSoDienThoai(String sdt) {
        Pattern pattern = Pattern.compile("^0\\d{9}$");
        Matcher matcher = pattern.matcher(sdt);
        return matcher.matches();
    }
    private String layTrangThaiTK(String maNV) {
        int trangThai = taiKhoanBUS.getTrangThai(maNV);
            if (trangThai == 0) {
                return "Khóa";
            }
            else if(trangThai == 1) {
                return "Hiệu lực";
            }
            else {
                return "Chưa có";
            }
    }
}
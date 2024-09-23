/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.CTPhieuNhapBUS;
import BUS.DangNhapBUS;
import BUS.LoaiBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import Customs.MyDialog;
import Customs.MyFileChooser;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import DAO.MyConnect;
import DTO.CTPhieuNhap;
import DTO.LoaiSP;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import GUI.DlgQuanLyLoai;
import static Main.Main.changLNF;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author PC
 */
public class PnQuanLyNhapHangGUI extends JPanel {
    
    LoaiBUS loaiBUS = new LoaiBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    NhaCungCapBUS nhacungcapBUS = new NhaCungCapBUS();
    NhanVienBUS nhanvienBUS = new NhanVienBUS();
    DangNhapBUS dangnhapBUS = new DangNhapBUS();
    PhieuNhapBUS phieunhapBUS = new PhieuNhapBUS();
    CTPhieuNhapBUS ctphieunhapBUS = new CTPhieuNhapBUS();
    private TableCellRenderer centerRenderer;
    JPanel pnlnhaphang, pnlphieunhap;
    JTabbedPane tabpnlqlnhaphang;
    DefaultTableModel dtmsanpham, dtmnhaphang, dtmchitietphieunhap, dtmphieunhap;
    JTable tblsanpham, tblnhaphang, tblchitietphieunhap, tblphieunhap;
    JLabel lbltittlepnlnhaphang, lbltittlepnlphieunhap, lbltimkiemnhaphang, lbltittlenhaphang, lblthongtinsanpham, lblthongtinphieunhap,  lblmasp, lbltensp, lbldongia,lblloinhuan, lblsoluong
            , lblnhacungcap, lblnhanvien, lblAnhSP, lblloaisanpham, lblmotasanpham, lblmapn, lblmanv, lblmancc, lblngaylap, lbltongtien, lbltittlechitietpn, lblchitietsanpham, lblchitietsoluong
            , lblchitietdongia, lblchitietthanhtien, lblchitietmapn;
    JComboBox<String> cmbNcc, cmbLoai;
    JButton btnResetnhaphang, btnnhapsanpham, btnChonAnh, btnxacnhan, btnxoa, btnResetphieunhap, btntimkiem, btnxoapn, btnThemSP;
    JTextField txttimkiem, txtmasp, txttensp, txtdongia, txtloinhuan, txtsoluong, txtnhanvien, txtmapn, txtmanv, txtmancc, txtngaylap, txttongtien,
             txtpnsanpham, txtpndongia, txtpnsoluong, txtpnthanhtien, txttientoithieu, txttientoida, txtngaytoithieu, txtngaytoida, txtpnmapn;
    JScrollPane scrsanpham, scrnhaphang, scrchitietpn, scrpn;
    Font font = new Font("Segoe UI",Font.BOLD,13);   
    ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/images/delete-icon.png"));
    ImageIcon confirmIcon = new ImageIcon(getClass().getResource("/images/confirm-icon.png"));
    ImageIcon addIcon = new ImageIcon(getClass().getResource("/images/add-icon.png"));
    
    
    public PnQuanLyNhapHangGUI()
    {
        changLNF("Windows");
        addcontrols();
        addevents();
    }
    
    public void addcontrols()
    {
        tabpnlqlnhaphang = new JTabbedPane();
        pnlnhaphang = new JPanel();
        pnlphieunhap = new JPanel();
        lbltittlepnlnhaphang = new JLabel("KHO HÀNG");
        lbltittlepnlphieunhap = new JLabel("PHIẾU NHẬP");
        lbltimkiemnhaphang = new JLabel("Tìm kiếm");
        lbltittlenhaphang = new JLabel("NHẬP HÀNG");
        lblthongtinphieunhap = new JLabel("THÔNG TIN PHIỀU NHẬP");
        lblthongtinsanpham = new JLabel("Thông Tin Sản Phẩm");
        lbldongia = new JLabel("Đơn Giá");
        lblloinhuan = new JLabel("Lợi nhuận(%)");
        lblmasp = new JLabel("Mã sản phẩm");
        lbltensp = new JLabel("Tên sản phẩm");
        lblsoluong = new JLabel("Số lượng");
        lblnhacungcap = new JLabel("Nhà Cung Cấp");
        lblnhanvien = new JLabel("Nhân Viên");
        lblloaisanpham = new JLabel("Loại");
        lblAnhSP = new JLabel();
        lblmotasanpham = new JLabel("Mô Tả");
        lblmapn = new JLabel("MÃ PN");
        lblmanv = new JLabel("Mã NV");
        lblmancc = new JLabel("Mã NCC");
        lblngaylap = new JLabel("Ngày Lập");
        lbltongtien = new JLabel("Tổng Tiền");
        lbltittlechitietpn = new JLabel("Chi Tiết Phiếu Nhập");
        lblchitietsanpham = new JLabel("Sản Phẩm");
        lblchitietsoluong = new JLabel("Số lượng");
        lblchitietdongia = new JLabel("Đơn Giá");
        lblchitietthanhtien = new JLabel("Thành Tiền");
        lblchitietmapn = new JLabel("Mã PN");
        btnThemSP = new JButton("Thêm sản phẩm");
        btnResetnhaphang = new JButton();
        btnChonAnh = new JButton("Chọn Ảnh");
        btnxacnhan = new JButton("Xác Nhận", confirmIcon);
        btnxoa = new JButton("Xoá", deleteIcon);
        btnnhapsanpham = new JButton("Chọn nhập sản phẩm", addIcon);
        btnResetphieunhap = new JButton();
        btnxoapn = new JButton("Xóa PN", deleteIcon);
        btntimkiem = new JButton();
        txttimkiem = new JTextField();
        txtpnmapn = new JTextField();
        txtmasp = new JTextField();
        txttensp = new JTextField();
        txtdongia = new JTextField();
        txtloinhuan = new JTextField();
        txtsoluong = new JTextField();
        txtnhanvien = new JTextField();
        txtmapn = new JTextField();
        txtmanv = new JTextField();
        txtmancc = new JTextField();
        txtngaylap = new JTextField();
        txttongtien = new JTextField();
        txtpnsanpham = new JTextField();
        txtpndongia = new JTextField();
        txtpnsoluong = new JTextField();
        txtpnthanhtien = new JTextField();
        txttientoithieu = new JTextField();
        txttientoida = new JTextField();
        txtngaytoithieu = new JTextField();
        txtngaytoida = new JTextField();
        cmbNcc = new JComboBox<>();
        cmbLoai = new JComboBox<>();
        
        
        setSize(1000, 700);
        setLayout(null);
        
        pnlnhaphang.setLayout(null);
        pnlphieunhap.setLayout(null);
        
        tabpnlqlnhaphang.add("Nhập hàng",pnlnhaphang);
        tabpnlqlnhaphang.add("Phiếu nhập",pnlphieunhap);
        tabpnlqlnhaphang.setBackground(new Color(144, 195, 212));
        tabpnlqlnhaphang.setBounds(0, 00, 983, 690);
        tabpnlqlnhaphang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(tabpnlqlnhaphang);
        
        //Tab nhập hàng
        
        lbltittlepnlnhaphang.setBounds(230, 20, 100, 20);
        pnlnhaphang.add(lbltittlepnlnhaphang);
        
        lbltimkiemnhaphang.setBounds(190, 60, 100, 20);
        pnlnhaphang.add(lbltimkiemnhaphang);
        
        txttimkiem.setBounds( 280, 60, 180, 22);
        pnlnhaphang.add(txttimkiem);
        
        btntimkiem.setBounds(300, 60, 10, 22);
        btntimkiem.setVisible(false);
        pnlnhaphang.add(btntimkiem);
        
        JPanel pnltablesanpham = new JPanel();
        pnltablesanpham.setBounds(10, 120, 600, 205);
        pnltablesanpham.setLayout(null);
        
        dtmsanpham = new DefaultTableModel();
        dtmsanpham.addColumn("Mã SP");
        dtmsanpham.addColumn("Tên Sản Phẩm");
        dtmsanpham.addColumn("Loại");
        dtmsanpham.addColumn("Đơn Giá");
        dtmsanpham.addColumn("Số Lượng");
        
        tblsanpham = new JTable(dtmsanpham);
        tblsanpham.setSize(600, 200);
        tblsanpham.setRowHeight(30);
        tblsanpham.setFocusable(false);
        tblsanpham.setIntercellSpacing(new Dimension(0,0));
        tblsanpham.getTableHeader().setFont(font);
        tblsanpham.setRowHeight(30);
        tblsanpham.setShowVerticalLines(false);
        tblsanpham.getTableHeader().setOpaque(false);
        tblsanpham.setFillsViewportHeight(true);
        tblsanpham.getTableHeader().setBackground(new Color(144, 195, 212));
        tblsanpham.getTableHeader().setForeground(Color.WHITE);
        tblsanpham.setSelectionBackground(new Color(232, 232, 232));
        tblsanpham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JScrollPane scrollPane = new JScrollPane(tblsanpham);
        pnltablesanpham.add(scrollPane, BorderLayout.CENTER);
        add(pnltablesanpham);
        
        TableColumnModel columnModelBanHang = tblsanpham.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(125);
        columnModelBanHang.getColumn(1).setPreferredWidth(200);
        columnModelBanHang.getColumn(2).setPreferredWidth(125);
        columnModelBanHang.getColumn(3).setPreferredWidth(125);
        columnModelBanHang.getColumn(4).setPreferredWidth(125);

        scrsanpham = new JScrollPane(tblsanpham);
        scrsanpham.setBounds(0, 0, 600, 200);
        pnltablesanpham.add(scrsanpham);
        pnlnhaphang.add(pnltablesanpham);
        
        lbltittlenhaphang.setBounds(230, 330, 100, 20);
        pnlnhaphang.add(lbltittlenhaphang);
        
        JPanel pnltablenhaphang = new JPanel();
        pnltablenhaphang.setLayout(null);
        pnltablenhaphang.setBounds(10, 380, 600, 205);
        
        dtmnhaphang = new DefaultTableModel();
        dtmnhaphang.addColumn("Mã SP");
        dtmnhaphang.addColumn("Tên Sản Phẩm");
        dtmnhaphang.addColumn("Loại");
        dtmnhaphang.addColumn("Số lượng");
        dtmnhaphang.addColumn("Đơn Giá");
        dtmnhaphang.addColumn("Lợi nhuận(%)");
        dtmnhaphang.addColumn("Thành Tiền");
        
        tblnhaphang = new JTable(dtmnhaphang);
        tblnhaphang.setSize(600, 200);
        tblnhaphang.setRowHeight(30);
        tblnhaphang.setFocusable(false);
        tblnhaphang.setIntercellSpacing(new Dimension(0,0));
        tblnhaphang.getTableHeader().setFont(font);
        tblnhaphang.setRowHeight(30);
        tblnhaphang.setShowVerticalLines(false);
        tblnhaphang.getTableHeader().setOpaque(false);
        tblnhaphang.setFillsViewportHeight(true);
        tblnhaphang.getTableHeader().setBackground(new Color(144, 195, 212));
        tblnhaphang.getTableHeader().setForeground(Color.WHITE);
        tblnhaphang.setSelectionBackground(new Color(232, 232, 232));
        tblnhaphang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JScrollPane scrollPane1 = new JScrollPane(tblnhaphang);
        pnltablenhaphang.add(scrollPane1, BorderLayout.CENTER);

        add(pnltablenhaphang);
        
        TableColumnModel columnmodelnhaphang = tblnhaphang.getColumnModel();
        columnmodelnhaphang.getColumn(0).setPreferredWidth(55);
        columnmodelnhaphang.getColumn(1).setPreferredWidth(120);
        columnmodelnhaphang.getColumn(2).setPreferredWidth(100);
        columnmodelnhaphang.getColumn(3).setPreferredWidth(75);
        columnmodelnhaphang.getColumn(4).setPreferredWidth(100);
        columnmodelnhaphang.getColumn(5).setPreferredWidth(100);
        columnmodelnhaphang.getColumn(6).setPreferredWidth(100);
        
        scrnhaphang = new JScrollPane(tblnhaphang);
        scrnhaphang.setBounds(0, 0, 600, 200);
        pnltablenhaphang.add(scrnhaphang);
        pnlnhaphang.add(pnltablenhaphang);
        
        ImageIcon icon = new ImageIcon("images\\Refresh-icon.png");
        btnResetnhaphang.setBounds(310, 18, 28, 28);
        btnResetnhaphang.setBackground(new Color(151, 255, 255));
        btnResetnhaphang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(btnResetnhaphang.getWidth(), btnResetnhaphang.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(imgscale);
        btnResetnhaphang.setIcon(scaledicon);
        pnlnhaphang.add(btnResetnhaphang);
        
        //Thông tin sản phẩm
        
        JPanel pnlthongtinsanpham = new JPanel();
        pnlthongtinsanpham.setBounds(650, 0, 400, 700);
        pnlthongtinsanpham.setLayout(null);
        lblthongtinsanpham.setBounds(95, 15, 160, 20);
        pnlthongtinsanpham.add(lblthongtinsanpham);
        
        JPanel pnlthongtinmasanpham, pnlthongtintensanpham, pnlthongdongiasp, pnlthongloinhuansp, pnlthongtinsoluongsp, pnlthongtinnhacungcap
                , pnlthongloaisanpham, pnlmota_hinhan, pnlthongtinnhanvien;
        pnlthongtinmasanpham = new JPanel();
        pnlthongtinmasanpham.setBounds(0, 55, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongtinmasanpham);
        pnlthongtinmasanpham.setLayout(null);
        lblmasp.setBounds(10, 3, 100, 22);
        pnlthongtinmasanpham.add(lblmasp);
        txtmasp.setBounds(120, 3, 180, 22);
        txtmasp.setEditable(false);
        pnlthongtinmasanpham.add(txtmasp);
        
        pnlthongtintensanpham = new JPanel();
        pnlthongtintensanpham.setBounds(0, 105, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongtintensanpham);
        pnlthongtintensanpham.setLayout(null);
        lbltensp.setBounds(10, 3, 100, 22);
        pnlthongtintensanpham.add(lbltensp);
        txttensp.setBounds(120, 3, 180, 22);
        txttensp.setEditable(true);
        pnlthongtintensanpham.add(txttensp);
        
        pnlthongdongiasp = new JPanel();
        pnlthongdongiasp.setBounds(0, 155, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongdongiasp);
        pnlthongdongiasp.setLayout(null);
        lbldongia.setBounds(10, 3, 100, 22);
        pnlthongdongiasp.add(lbldongia);
        txtdongia.setBounds(120, 3, 180, 22);
        pnlthongdongiasp.add(txtdongia);
        
        pnlthongloinhuansp = new JPanel();
        pnlthongloinhuansp.setBounds(0, 205, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongloinhuansp);
        pnlthongloinhuansp.setLayout(null);
        lblloinhuan.setBounds(10, 3, 100, 22);
        pnlthongloinhuansp.add(lblloinhuan);
        txtloinhuan.setBounds(120, 3, 180, 22);
        pnlthongloinhuansp.add(txtloinhuan);
        
        pnlthongtinsoluongsp = new JPanel();
        pnlthongtinsoluongsp.setBounds(0, 255, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongtinsoluongsp);
        pnlthongtinsoluongsp.setLayout(null);
        lblsoluong.setBounds(10, 3, 100, 22);
        pnlthongtinsoluongsp.add(lblsoluong);
        txtsoluong.setBounds(120, 3, 180, 22);
        pnlthongtinsoluongsp.add(txtsoluong);
        
        pnlthongloaisanpham = new JPanel();
        pnlthongloaisanpham.setBounds(0, 305, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongloaisanpham);
        pnlthongloaisanpham.setLayout(null);
        lblloaisanpham.setBounds(10, 3, 100, 22);
        pnlthongloaisanpham.add(lblloaisanpham);
        cmbLoai.setBounds(120, 3, 180, 22);
        cmbLoai.setEnabled(true);
        pnlthongloaisanpham.add(cmbLoai);
        
        pnlthongtinnhanvien = new JPanel();
        pnlthongtinnhanvien.setBounds(0,355, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongtinnhanvien);
        pnlthongtinnhanvien.setLayout(null);
        lblnhanvien.setBounds(10, 3, 100, 22);
        pnlthongtinnhanvien.add(lblnhanvien);
        txtnhanvien.setBounds(120, 3, 180, 22);
        txtnhanvien.setEnabled(false);
        pnlthongtinnhanvien.add(txtnhanvien);
        
        pnlthongtinnhacungcap = new JPanel();
        pnlthongtinnhacungcap.setBounds(0,405, pnlthongtinsanpham.getWidth(), 23);
        pnlthongtinsanpham.add(pnlthongtinnhacungcap);
        pnlthongtinnhacungcap.setLayout(null);
        lblnhacungcap.setBounds(10, 3, 100, 22);
        pnlthongtinnhacungcap.add(lblnhacungcap);
        cmbNcc.setBounds(120, 3, 180, 22);
        cmbNcc.setBackground(Color.white);
        pnlthongtinnhacungcap.add(cmbNcc);
        
        btnnhapsanpham.setBounds(70, 450, 195, 40);
        btnnhapsanpham.setBackground(new Color(155, 255, 255));
        btnnhapsanpham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlthongtinsanpham.add(btnnhapsanpham);
        
        btnxoa.setBounds(3, 510, 150, 40);
        btnxoa.setBackground(new Color(155, 255, 255));
        btnxoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlthongtinsanpham.add(btnxoa);
        
        btnxacnhan.setBounds(170, 510, 150, 40);       
        btnxacnhan.setBackground(new Color(155, 255, 255));
        btnxacnhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlthongtinsanpham.add(btnxacnhan);
        
        btnThemSP.setBounds(70, 580, 195, 40);
        btnThemSP.setBackground(new Color(155, 255, 255));
        ImageIcon themsp = new ImageIcon(getClass().getResource("/images/add-icon.png"));
        btnThemSP.setIcon(themsp);
        pnlthongtinsanpham.add(btnThemSP);
        
        pnlnhaphang.add(pnlthongtinsanpham);
        
        
        
        //Tab phiếu nhập
        
        pnlphieunhap.setSize(983, 690);
        
        JPanel pnlthongtinphieunhap = new JPanel();
        pnlthongtinphieunhap.setBounds(0, 0, 400, 690);
        pnlthongtinphieunhap.setLayout(null);
        pnlphieunhap.add(pnlthongtinphieunhap);
        
        lbltittlepnlphieunhap.setBounds(165, 20, 100, 22);
        pnlthongtinphieunhap.add(lbltittlepnlphieunhap);
        
        btnResetphieunhap.setBounds(250, 15, 28, 28);
        btnResetphieunhap.setIcon(scaledicon);
        btnResetphieunhap.setBackground(new Color(151, 255, 255));
        btnResetphieunhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlthongtinphieunhap.add(btnResetphieunhap);
        
        JPanel pnlphieunhapmapn, pnlphieunhapmanv, pnlphieunhapmancc, pnlgaynhap, pnltongtien;
        pnlphieunhapmapn = new JPanel();
        pnlphieunhapmapn.setBounds(0, 55, pnlthongtinphieunhap.getWidth(), 23);
        pnlthongtinphieunhap.add(pnlphieunhapmapn);
        pnlphieunhapmapn.setLayout(null);
        lblmapn.setBounds(50, 3, 100, 22);
        pnlphieunhapmapn.add(lblmapn);
        txtmapn.setBounds(150, 3, 180, 22);
        txtmapn.setEditable(false);
        pnlphieunhapmapn.add(txtmapn);
        
        pnlphieunhapmancc = new JPanel();
        pnlphieunhapmancc.setBounds(0, 105, pnlthongtinphieunhap.getWidth(), 23);
        pnlthongtinphieunhap.add(pnlphieunhapmancc);
        pnlphieunhapmancc.setLayout(null);
        lblmanv.setBounds(50, 3, 100, 22);
        pnlphieunhapmancc.add(lblmanv);
        txtmanv.setBounds(150, 3, 180, 22);
        txtmanv.setEditable(false);
        pnlphieunhapmancc.add(txtmanv);
        
        pnlphieunhapmanv = new JPanel();
        pnlphieunhapmanv.setBounds(0, 155, pnlthongtinphieunhap.getWidth(), 23);
        pnlthongtinphieunhap.add(pnlphieunhapmanv);
        pnlphieunhapmanv.setLayout(null);
        lblmancc.setBounds(50, 3, 100, 22);
        pnlphieunhapmanv.add(lblmancc);
        txtmancc.setBounds(150, 3, 180, 22);
        txtmancc.setEditable(false);
        pnlphieunhapmanv.add(txtmancc);
        
        pnlgaynhap = new JPanel();
        pnlgaynhap.setBounds(0, 205, pnlthongtinphieunhap.getWidth(), 23);
        pnlthongtinphieunhap.add(pnlgaynhap);
        pnlgaynhap.setLayout(null);
        lblngaylap.setBounds(50, 3, 100, 22);
        pnlgaynhap.add(lblngaylap);
        txtngaylap.setBounds(150, 3, 180, 22);
        txtngaylap.setEditable(false);
        pnlgaynhap.add(txtngaylap);
        
        pnltongtien = new JPanel();
        pnltongtien.setBounds(0, 255, pnlthongtinphieunhap.getWidth(), 23);
        pnlthongtinphieunhap.add(pnltongtien);
        pnltongtien.setLayout(null);
        lbltongtien.setBounds(50, 3, 100, 22);
        pnltongtien.add(lbltongtien);
        txttongtien.setBounds(150, 3, 180, 22);
        txttongtien.setEditable(false);
        pnltongtien.add(txttongtien);
        
        btnxoapn.setBounds(415, 240, 120, 40);
        btnxoapn.setBackground(new Color(151, 255, 255));
        btnxoapn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlphieunhap.add(btnxoapn);
        
        JLabel lblpntimkiem = new JLabel("Tìm Kiếm:");
        lblpntimkiem.setBounds(18, 300, 100, 22);
        pnlthongtinphieunhap.add(lblpntimkiem);
        
        JLabel lblden1, lblden2, lblgia, lblngay;
        
        JPanel pnltimkiemtien, pnltimkiemngay;
        
        pnltimkiemtien = new JPanel();
        pnltimkiemtien.setBounds(0, 330, pnlthongtinphieunhap.getWidth(), 30);
        pnltimkiemtien.setLayout(null);
        lblgia = new JLabel("Giá");
        lblgia.setBounds(5, 3, 80, 22);
        pnltimkiemtien.add(lblgia);
        txttientoithieu.setBounds(50, 3, 130, 24);
        pnltimkiemtien.add(txttientoithieu);
        lblden1 = new JLabel(" Đến ");
        lblden1.setBounds(195, 3, 100, 22);
        pnltimkiemtien.add(lblden1);
        txttientoida.setBounds(235, 3, 130, 24);
        pnltimkiemtien.add(txttientoida);
        pnlthongtinphieunhap.add(pnltimkiemtien);
        
        pnltimkiemngay = new JPanel();
        pnltimkiemngay.setBounds(0, 380, pnlthongtinphieunhap.getWidth(), 30);
        pnltimkiemngay.setLayout(null);
        lblngay = new JLabel("Ngày");
        lblngay.setBounds(5, 3, 80, 22);
        pnltimkiemngay.add(lblngay);
        txtngaytoithieu.setBounds(50, 3, 130, 24);
        pnltimkiemngay.add(txtngaytoithieu);
        lblden1 = new JLabel(" Đến ");
        lblden1.setBounds(195, 3, 100, 22);
        pnltimkiemngay.add(lblden1);
        txtngaytoida.setBounds(235, 3, 130, 24);
        pnltimkiemngay.add(txtngaytoida);
        pnlthongtinphieunhap.add(pnltimkiemngay);
        
        JPanel pnltablepn = new JPanel();
        pnltablepn.setLayout(null);
        pnltablepn.setBounds(0, 425, pnlthongtinphieunhap.getWidth(), 230);
        
        dtmphieunhap = new DefaultTableModel();
        dtmphieunhap.addColumn("Mã PN");
        dtmphieunhap.addColumn("Ngày lập");
        dtmphieunhap.addColumn("Tổng tiền");
        
        tblphieunhap = new JTable(dtmphieunhap);
        tblphieunhap.setSize(pnlthongtinphieunhap.getWidth(), 190);
        tblphieunhap.setRowHeight(30);
        tblphieunhap.setFocusable(false);
        tblphieunhap.setIntercellSpacing(new Dimension(0,0));
        tblphieunhap.getTableHeader().setFont(font);
        tblphieunhap.setRowHeight(30);
        tblphieunhap.setShowVerticalLines(false);
        tblphieunhap.getTableHeader().setOpaque(false);
        tblphieunhap.setFillsViewportHeight(true);
        tblphieunhap.getTableHeader().setBackground(new Color(144, 195, 212));
        tblphieunhap.getTableHeader().setForeground(Color.WHITE);
        tblphieunhap.setSelectionBackground(new Color(232, 232, 232));
        tblphieunhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JScrollPane scrollPane12 = new JScrollPane(tblphieunhap);
        pnltablepn.add(scrollPane12, BorderLayout.CENTER);

        add(pnltablepn);
        
        TableColumnModel columnmodelpn = tblphieunhap.getColumnModel();
        columnmodelpn.getColumn(0).setPreferredWidth(tblphieunhap.getWidth()/3);
        columnmodelpn.getColumn(1).setPreferredWidth(tblphieunhap.getWidth()/3);
        columnmodelpn.getColumn(2).setPreferredWidth(tblphieunhap.getWidth()/3);
        
        scrpn = new JScrollPane(tblphieunhap);
        scrpn.setBounds(0, 0, pnlthongtinphieunhap.getWidth(), 215);
        pnltablepn.add(scrpn);
        pnlthongtinphieunhap.add(pnltablepn);
        
        JPanel pnlthongtinchitietpn = new JPanel();
        pnlthongtinchitietpn.setBounds(405, 0, 595, pnlphieunhap.getHeight());
        pnlthongtinchitietpn.setLayout(null);
        pnlphieunhap.add(pnlthongtinchitietpn);
        
        lbltittlechitietpn.setBounds(240, 20, 180, 22);
        pnlthongtinchitietpn.add(lbltittlechitietpn);
        
        JPanel pnlchimapn, pnlchitietsp ,pnlchitietdongia, pnlchitietsoluong, pnlchitietthanhtien;
        
        pnlchimapn = new JPanel();
        pnlchimapn.setBounds(0, 55, pnlthongtinchitietpn.getWidth(), 23);
        pnlthongtinchitietpn.add(pnlchimapn);
        pnlchimapn.setLayout(null);
        lblchitietmapn.setBounds(175, 3, 100, 22);
        pnlchimapn.add(lblchitietmapn);
        txtpnmapn.setBounds(260, 3, 180, 22);
        txtpnmapn.setEditable(false);
        pnlchimapn.add(txtpnmapn);
        
        pnlchitietsp = new JPanel();
        pnlchitietsp.setBounds(0, 105, pnlthongtinchitietpn.getWidth(), 23);
        pnlthongtinchitietpn.add(pnlchitietsp);
        pnlchitietsp.setLayout(null);
        lblchitietsanpham.setBounds(175, 3, 100, 22);
        pnlchitietsp.add(lblchitietsanpham);
        txtpnsanpham.setBounds(260, 3, 180, 22);
        txtpnsanpham.setEditable(false);
        pnlchitietsp.add(txtpnsanpham);
        
        pnlchitietsoluong = new JPanel();
        pnlchitietsoluong.setBounds(0, 155, pnlthongtinchitietpn.getWidth(), 23);
        pnlthongtinchitietpn.add(pnlchitietsoluong);
        pnlchitietsoluong.setLayout(null);
        lblchitietsoluong.setBounds(175, 3, 100, 22);
        pnlchitietsoluong.add(lblchitietsoluong);
        txtpnsoluong.setBounds(260, 3, 180, 22);
        txtpnsoluong.setEditable(false);
        pnlchitietsoluong.add(txtpnsoluong);
        
        pnlchitietdongia = new JPanel();
        pnlchitietdongia.setBounds(0, 205, pnlthongtinchitietpn.getWidth(), 23);
        pnlthongtinchitietpn.add(pnlchitietdongia);
        pnlchitietdongia.setLayout(null);
        lblchitietdongia.setBounds(175, 3, 100, 22);
        pnlchitietdongia.add(lblchitietdongia);
        txtpndongia.setBounds(260, 3, 180, 22);
        txtpndongia.setEditable(false);
        pnlchitietdongia.add(txtpndongia);
        
        pnlchitietthanhtien = new JPanel();
        pnlchitietthanhtien.setBounds(0, 255, pnlthongtinchitietpn.getWidth(), 23);
        pnlthongtinchitietpn.add(pnlchitietthanhtien);
        pnlchitietthanhtien.setLayout(null);
        lblchitietthanhtien.setBounds(175, 3, 100, 22);
        pnlchitietthanhtien.add(lblchitietthanhtien);
        txtpnthanhtien.setBounds(260, 3, 180, 22);
        txtpnthanhtien.setEditable(false);
        pnlchitietthanhtien.add(txtpnthanhtien);

        JPanel pnltablechitietpn = new JPanel();
        pnltablechitietpn.setLayout(null);
        pnltablechitietpn.setBounds(10, 290, pnlthongtinchitietpn.getWidth(), 420);
        
        dtmchitietphieunhap = new DefaultTableModel();
        dtmchitietphieunhap.addColumn("Mã PN");
        dtmchitietphieunhap.addColumn("Mã SP");
        dtmchitietphieunhap.addColumn("Số lượng");
        dtmchitietphieunhap.addColumn("Đơn Giá");
        dtmchitietphieunhap.addColumn("Thành Tiền");
        
        tblchitietphieunhap = new JTable(dtmchitietphieunhap);
        tblchitietphieunhap.setSize(pnlthongtinchitietpn.getWidth()-30, 410);
        tblchitietphieunhap.setRowHeight(30);
        tblchitietphieunhap.setFocusable(false);
        tblchitietphieunhap.setIntercellSpacing(new Dimension(0,0));
        tblchitietphieunhap.getTableHeader().setFont(font);
        tblchitietphieunhap.setRowHeight(30);
        tblchitietphieunhap.setShowVerticalLines(false);
        tblchitietphieunhap.getTableHeader().setOpaque(false);
        tblchitietphieunhap.setFillsViewportHeight(true);
        tblchitietphieunhap.getTableHeader().setBackground(new Color(144, 195, 212));
        tblchitietphieunhap.getTableHeader().setForeground(Color.WHITE);
        tblchitietphieunhap.setSelectionBackground(new Color(232, 232, 232));
        tblchitietphieunhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JScrollPane scrollPane13 = new JScrollPane(tblchitietphieunhap);
        pnltablechitietpn.add(scrollPane13, BorderLayout.CENTER);

        add(pnltablechitietpn);

        TableColumnModel columnmodelchitietpn = tblchitietphieunhap.getColumnModel();
        columnmodelchitietpn.getColumn(0).setPreferredWidth(tblchitietphieunhap.getWidth()/5);
        columnmodelchitietpn.getColumn(1).setPreferredWidth(tblchitietphieunhap.getWidth()/5);
        columnmodelchitietpn.getColumn(2).setPreferredWidth(tblchitietphieunhap.getWidth()/5);
        columnmodelchitietpn.getColumn(3).setPreferredWidth(tblchitietphieunhap.getWidth()/5);
        columnmodelchitietpn.getColumn(4).setPreferredWidth(tblchitietphieunhap.getWidth()/5);

        
        scrchitietpn = new JScrollPane(tblchitietphieunhap);
        scrchitietpn.setBounds(0, 0, pnlthongtinchitietpn.getWidth()-30, 350);
        pnltablechitietpn.add(scrchitietpn);
        pnlthongtinchitietpn.add(pnltablechitietpn);
       
        loadDataLenBangSanPham();
        loadDataCmbLoai();
        loadDataCmbNcc();
        loadDataTableCTPhieuNhap();
        loadDataTablePhieuNhap();
        loadnhanvien();
    }
    
    public void addevents()
    {
        btnResetnhaphang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtmasp.setText("");
                txttensp.setText("");
                txttensp.setEditable(true);
                txtdongia.setText("");
                txtloinhuan.setText("");
                txtsoluong.setText("");
                cmbLoai.setSelectedIndex(0);
                cmbLoai.setEnabled(true);
                cmbNcc.setSelectedIndex(0);
                cmbNcc.setEnabled(true);
                loadDataLenBangSanPham();
                removeallitem();
            }
        });
        
        btnResetphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtpnmapn.setText("");
                txtpndongia.setText("");
                txtpnsanpham.setText("");
                txtpnsoluong.setText("");
                txtpnthanhtien.setText("");
                txtmanv.setText("");
                txtmancc.setText("");
                txtmapn.setText("");
                txtngaylap.setText("");
                txttongtien.setText("");
                txttientoithieu.setText("");
                txttientoida.setText("");
                txtngaytoithieu.setText("");
                txtngaytoida.setText("");
                loadDataTableCTPhieuNhap();
                loadDataTablePhieuNhap();
            }
        });
        
        btnnhapsanpham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhapsanpham();
            }
        });
        
        btnChonAnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyChonAnh();
            }
        });
        
        btnxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoasanphamnhap();
            }
        });
        
        btnThemSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemSanPhamPN();
            }
        });
 
        cmbLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemLoai();
            }
        });
        
        cmbNcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                loadNCC();
                loadsanphamtheonhacungcap();
            }
        });
        
        txttimkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btntimkiem.doClick();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                btntimkiem.doClick();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                btntimkiem.doClick();
            }
        });
        
        btntimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenBangSanPham(txttimkiem.getText());
            }
        });
        
        tblsanpham.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xuliclicktablesanpham();
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
        
        tblphieunhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xuliclicktablephieunhap();
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
        
        tblnhaphang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xuliclichtablenhaphang();
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
        
        tblchitietphieunhap.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xuliclicktabechitietphieunhap();
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
        
        btnxacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xacnhan();
            }
        });
        
        txttientoithieu.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if( e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    txttientoida.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txttientoida.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if( e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    loadDataTablePhieuNhapTheoGia(txttientoithieu.getText(), txttientoida.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtngaytoithieu.addKeyListener(new KeyListener() {
             @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if( e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    txtngaytoida.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        txtngaytoida.addKeyListener(new KeyListener() {
             @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if( e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    loadDataTablePhieuNhapTheoNgay(txtngaytoithieu.getText(), txtngaytoida.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        btnxoapn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                xoapn();
            }
        });
    }
    
    File fileAnhSP;
    DecimalFormat dcf = new DecimalFormat("###,###");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    
    private void removeallitem()
    {
        int row = tblnhaphang.getRowCount();
        if(row > 0)
        {
            for(int i = 0; i < row; i++)
            {
                dtmnhaphang.removeRow(0);
            }
        }
    }
    
    private void loadDataLenBangSanPham() {
        spBUS.docListSanPham();
        dtmsanpham.setRowCount(0);

        ArrayList<SanPham> dssp = spBUS.getListSanPham();

        DecimalFormat dcf = new DecimalFormat("###,###");

        for (SanPham sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMaSP());
            vec.add(sp.getTenSP());
            String tenLoai = loaiBUS.getTenLoai(sp.getMaLoai());
            vec.add(tenLoai);
            vec.add(dcf.format(sp.getDonGia()));
            vec.add(dcf.format(sp.getSoLuong()));
            dtmsanpham.addRow(vec);
        }
    }
    
    private void loadDataLenBangSanPham(String tukhoa) {
        spBUS.docListSanPham();
        dtmsanpham.setRowCount(0);

        ArrayList<SanPham> dssp = spBUS.getSanPhamTheoTen(tukhoa);

        DecimalFormat dcf = new DecimalFormat("###,###");

        for (SanPham sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMaSP());
            vec.add(sp.getTenSP());
            String tenLoai = loaiBUS.getTenLoai(sp.getMaLoai());
            vec.add(tenLoai);
            vec.add(dcf.format(sp.getDonGia()));
            vec.add(dcf.format(sp.getSoLuong()));
            dtmsanpham.addRow(vec);
        }
    }
    
    private void loadDataTablePhieuNhap() {
        phieunhapBUS.docDanhSach();
        ArrayList<PhieuNhap> dspn = phieunhapBUS.getListPhieuNhap();
        duaDataVaoTablePhieuNhap(dspn);
    }

    private void duaDataVaoTablePhieuNhap(ArrayList<PhieuNhap> dspn) {
        if (dspn != null) {
            dtmphieunhap.setRowCount(0);
            for (PhieuNhap pn : dspn) {
                Vector vec = new Vector();
                vec.add(pn.getMaPN());
                vec.add(sdf.format(pn.getNgayLap()));
                vec.add(dcf.format(pn.getTongTien()));
                dtmphieunhap.addRow(vec);
            }
        }
    }
    
    private void loadDataTablePhieuNhapTheoGia(String giatoithieu, String giatoida)
    {
        if(giatoithieu.isEmpty())
        {
            new MyDialog("Giá tối thiểu không được để trống", MyDialog.WARNING_DIALOG);
        }
        else if(giatoida.isEmpty())
        {
            new MyDialog("Giá tối đa không được để trống", MyDialog.WARNING_DIALOG);
        }
        else
        {
            ArrayList<PhieuNhap> dspn = new ArrayList<>();
            dspn = phieunhapBUS.getListPhieuNhapTheoGia(giatoithieu, giatoida);
            duaDataVaoTablePhieuNhap(dspn);
        }
                
    }
    
    private void loadDataTablePhieuNhapTheoNgay(String ngaytoithieu, String ngiatoida)
    {
        
        if(ngaytoithieu.isEmpty())
        {
            new MyDialog("Ngày tối thiểu không được để trống", MyDialog.WARNING_DIALOG);
        }
        else if(ngiatoida.isEmpty())
        {
            new MyDialog("Ngày tối đa không được để trống", MyDialog.WARNING_DIALOG);
        }
        else
        {
            ArrayList<PhieuNhap> dspn = new ArrayList<>();
            dspn = phieunhapBUS.getListPhieuNhapTheoNgay(ngaytoithieu, ngiatoida);
            duaDataVaoTablePhieuNhap(dspn);
        }
    }
    
    private void loadDataTableCTPhieuNhap() {
        dtmchitietphieunhap.setRowCount(0);
        ctphieunhapBUS.docDanhSach();
        ArrayList<CTPhieuNhap> dsct = ctphieunhapBUS.getListPhieuNhap();
        if (dsct != null) {
            for (CTPhieuNhap ct : dsct) {
                Vector vec = new Vector();
                vec.add(ct.getMaPN());
                vec.add(ct.getMaSP());
                vec.add(dcf.format(ct.getSoLuong()));
                vec.add(dcf.format(ct.getDonGia()));
                vec.add(dcf.format(ct.getThanhTien()));
                dtmchitietphieunhap.addRow(vec);
            }
        }
    }
    
    private void loadDataTableCTPhieuNhap(String ma) {
        dtmchitietphieunhap.setRowCount(0);
        ctphieunhapBUS.docDanhSach();
        ArrayList<CTPhieuNhap> dsct = ctphieunhapBUS.getListPhieuNhap(ma);
        if (dsct != null) {
            for (CTPhieuNhap ct : dsct) {
                Vector vec = new Vector();
                vec.add(ct.getMaPN());
                vec.add(ct.getMaSP());
                vec.add(dcf.format(ct.getSoLuong()));
                vec.add(dcf.format(ct.getDonGia()));
                vec.add(dcf.format(ct.getThanhTien()));
                dtmchitietphieunhap.addRow(vec);
            }
        }
    }
    
    private void loadAnh(String anh) {
        lblAnhSP.setIcon(getAnhSP(anh));
    }
    
    private void luuFileAnh() {
            BufferedImage bImage = null;
            try {
                File initialImage = new File(fileAnhSP.getPath());
                bImage = ImageIO.read(initialImage);

                ImageIO.write(bImage, "png", new File("images/" + fileAnhSP.getName()));

            } catch (IOException e) {
                System.out.println("Exception occured :" + e.getMessage());
            }
        }
    
    private void xuLyChonAnh() {
        JFileChooser fileChooser = new MyFileChooser("images/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Tệp hình ảnh", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileAnhSP = fileChooser.getSelectedFile();
            lblAnhSP.setIcon(getAnhSP(fileAnhSP.getPath()));
        }
    }
    
    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File(src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("images/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File(src);
        } catch (IOException e) {
            fileAnhSP = new File("imgs/anhthe/avatar.jpg");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }

        return null;
    }
    
    private void loadDataCmbLoai() {
        loaiBUS.docDanhSachLoai();
        cmbLoai.removeAllItems();
        ArrayList<LoaiSP> dsl = new ArrayList<>();
        dsl = loaiBUS.getDanhSachLoai();
        cmbLoai.addItem("0 - Chọn loại");
        for (LoaiSP loai : dsl) {
            cmbLoai.addItem(loai.getMaLoai() + " - " + loai.getTenLoai());
        }
        cmbLoai.addItem("Khác...");
    }

    private void loadDataCmbNcc()
    {
        nhacungcapBUS.docDanhSach();
        cmbNcc.removeAllItems();
        ArrayList<NhaCungCap> dsncc = nhacungcapBUS.getListNhaCungCap();
        cmbNcc.addItem("0 - Chọn nhà cung cấp");
        for (NhaCungCap ncc : dsncc) {
            cmbNcc.addItem(ncc.getMaNCC() + " - " + ncc.getTenNCC());
        }
        cmbNcc.addItem("Khác...");
    }
    
    private void xuLyThemLoai() {
        String loai = cmbLoai.getSelectedItem() + "";
        if (loai.equals("Khác..."))
        {
            DlgQuanLyLoai loaiGUI = new DlgQuanLyLoai();
            loaiGUI.setVisible(true);
            loaiGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadDataCmbLoai();
                }                
            });
        }
    }

    private void xuLyThemNcc() {
        String ncc = cmbNcc.getSelectedItem() + "";
        if (ncc.equals("Khác..."))
        {
            DlgQuanLyNcc nccGUI = new DlgQuanLyNcc();
            nccGUI.setVisible(true);
            nccGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadDataCmbNcc();
                }                
            });
        }
    }
    
    private void loadsanphamtheonhacungcap()
    {
        
        String ncc = cmbNcc.getSelectedItem() + "";
        int index = cmbNcc.getSelectedIndex();
        if(index == cmbNcc.getItemCount()-1)
        {
            xuLyThemNcc();
        }
        else if(index != 0)
        {
            String[] ncctmp = ncc.split(" - ");
            String tenncc = ncctmp[1];
            
            dtmsanpham.setRowCount(0);

            ArrayList<SanPham> dssptheoncc = spBUS.getListSanPham();

            DecimalFormat dcf = new DecimalFormat("###,###");
            
            for (SanPham sp : dssptheoncc) {
                if(nhacungcapBUS.gettennhacungcap(sp.getMaNCC()).equals(tenncc))
                {
                    Vector vec = new Vector();
                    vec.add(sp.getMaSP());
                    vec.add(sp.getTenSP());
                    String tenLoai = loaiBUS.getTenLoai(sp.getMaLoai());
                    vec.add(tenLoai);
                    vec.add(dcf.format(sp.getDonGia()));
                    vec.add(dcf.format(sp.getSoLuong()));
                    dtmsanpham.addRow(vec);
                }
            }
            cmbNcc.setEnabled(false);
        }
        else
        {
            xuLyThemNcc();
        }
    }
    
    private void nhapsanpham()
    {
        try {
            String ma= txtmasp.getText();
            String ten = txttensp.getText();
            txttensp.setEditable(true);
            String[] loaitmp = (cmbLoai.getSelectedItem() + "").split(" - ");
            cmbLoai.setEnabled(true);
            String loai = loaitmp[1];
            String[] ncctmp = (cmbNcc.getSelectedItem() + "").split(" - ");
            cmbNcc.setEnabled(true);
            String Ncc = ncctmp[1];
            if(ten.isEmpty())
            {
                new MyDialog("Chưa chọn sản phẩm để thêm vào", MyDialog.ERROR_DIALOG);
            }
            else if(txtdongia.getText().isEmpty())
            {
                new MyDialog("Đơn giá không được để trống!", MyDialog.ERROR_DIALOG);
            }
            else if(txtsoluong.getText().isEmpty())
            {
                new MyDialog("Số lượng không được để trống!", MyDialog.ERROR_DIALOG);
            }
            else if(cmbLoai.getSelectedItem().equals("0 - Chọn loại"))
            {
                new MyDialog("Vui lòng chọn Loại sản phẩm!", MyDialog.ERROR_DIALOG);
            }
            else if(txtloinhuan.getText().isEmpty())
            {
                new MyDialog("Lợi nhuận không được để trống!", MyDialog.ERROR_DIALOG);
            }
            else if(cmbNcc.getSelectedItem().equals("0 - Chọn nhà cung cấp"))
            {
                new MyDialog("Vui lòng chọn Nhà cung cấp!", MyDialog.ERROR_DIALOG);
            }
            else{
                float loiNhuan = Float.parseFloat(txtloinhuan.getText());
                int soluong = Integer.parseInt(txtsoluong.getText());
                int dongia = Integer.parseInt(txtdongia.getText().replace(",", ""));
                int thanhtien = dongia * soluong;

                if(soluong <= 0)
                {
                    new MyDialog("Số lượng sản phẩm không đủ", MyDialog.ERROR_DIALOG);
                }
                else if(dongia <= 0)
                {
                    new MyDialog("Đơn giá không phù hợp", MyDialog.ERROR_DIALOG);
                }
                else if(loiNhuan <= 0.00)
                {
                    new MyDialog("Lợi nhuận không phù hợp", MyDialog.ERROR_DIALOG);
                }
                else
                {
                    DecimalFormat dcf = new DecimalFormat("###,###");
                
                    int row = tblnhaphang.getRowCount();
                    for(int i = 0; i<row ;i++)
                    {
                        String tensp = tblnhaphang.getValueAt(i, 1) + "";
                        loiNhuan = Float.parseFloat(tblnhaphang.getValueAt(i,5)  + "");
                        int giasp = Integer.parseInt((tblnhaphang.getValueAt(i, 4) + "").replace(",", ""));
                        String loaisp = (tblnhaphang.getValueAt(i, 2)+"").split(" - ")[1];
                        if(tensp.equals(ten) && giasp == dongia && loaisp.equals(loai))
                        {
                            int sl = Integer.parseInt(tblnhaphang.getValueAt(i, 3) + "") + soluong;
                            int thanhtiennew = sl * giasp;
                            tblnhaphang.setValueAt(sl, i, 3);
                            tblnhaphang.setValueAt(thanhtiennew, i, 6);
                            txtmasp.setText("");
                            txttensp.setText("");
                            txtdongia.setText("");
                            txtloinhuan.setText("");
                            txtsoluong.setText("");
                            cmbLoai.setSelectedIndex(0);
                            cmbNcc.setSelectedIndex(0);
                            return;
                        }
                    }

                    int result = JOptionPane.showConfirmDialog(this, "Đây là giá cả mà bạn muốn nhập?\n" + "Giá: " + dcf.format(dongia), "thông báo", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        Vector vec = new Vector();
                        vec.add(ma);
                        vec.add(ten);
                        vec.add(cmbLoai.getSelectedItem() + "");
                        vec.add(soluong);
                        vec.add(dcf.format(dongia));
                        vec.add(dcf.format(loiNhuan));
                        vec.add(dcf.format(thanhtien));
                        dtmnhaphang.addRow(vec);

                        SanPham sptmp = spBUS.getSanPham(ma);
                        String ncc = nhacungcapBUS.gettennhacungcap(sptmp.getMaNCC());
                        cmbNcc.setSelectedItem(sptmp.getMaNCC() + " - " + ncc);

                        txtmasp.setText("");
                        txttensp.setText("");
                        txtdongia.setText("");
                        txtloinhuan.setText("");
                        txtsoluong.setText("");
                        cmbLoai.setSelectedIndex(0);
                    }
                }
            }
        } catch (Exception e) {
            new MyDialog("Nhập số hợp lệ cho Đơn giá và Số lượng!", MyDialog.ERROR_DIALOG);
        }
    }
    
    private void xoasanphamnhap()
    {
        int row = tblnhaphang.getSelectedRow();
        if(row > -1)
        {
            dtmnhaphang.removeRow(row);
        } else {
            new MyDialog("Chưa chọn sản phẩm để xoá", MyDialog.ERROR_DIALOG);
        }
    }
    
    private void xuliclicktablesanpham()
    {
        int row = tblsanpham.getSelectedRow();
        if(row > - 1)
        {
            String ma = tblsanpham.getValueAt(row, 0) + "";
            String ten = tblsanpham.getValueAt(row, 1) + "";
            String loai = tblsanpham.getValueAt(row, 2) + "";
            String donGia = tblsanpham.getValueAt(row, 3) + "";
            String soLuong = tblsanpham.getValueAt(row, 4) + "";
            
            txtmasp.setText(ma);
            txttensp.setText(ten);
            txttensp.setEditable(false);
            txtdongia.setText("");
            txtdongia.requestFocus();
            txtsoluong.setText("");
            
            int flagloai = 0;
            for (int i = 0; i < cmbLoai.getItemCount(); i++) {
                if (cmbLoai.getItemAt(i).contains(loai)) {
                    flagloai = i;
                    break;
                }
            }
            cmbLoai.setSelectedIndex(flagloai);
            cmbLoai.setEnabled(false);
            
//            loadNCC();
        }
    }
    
    private void xuliclichtablenhaphang()
    {
        int row = tblnhaphang.getSelectedRow();
        if(row > -1)
        {
            String ma = tblnhaphang.getValueAt(row, 0) + "";
            String ten = tblnhaphang.getValueAt(row, 1) + "";
            String loai = tblnhaphang.getValueAt(row, 2) + "";
            String soLuong = tblnhaphang.getValueAt(row, 3) + "";
            String donGia = tblnhaphang.getValueAt(row, 4) + "";
            String loiNhuan = tblnhaphang.getValueAt(row, 5) + "";
            
            txtmasp.setText(ma);
            txttensp.setText(ten);
            txttensp.setEditable(false);
            txtdongia.setText(donGia);
            txtdongia.requestFocus();
            txtloinhuan.setText(loiNhuan);
            txtsoluong.setText(soLuong);
            
            int flagloai = 0;
            for (int i = 0; i < cmbLoai.getItemCount(); i++) {
                if (cmbLoai.getItemAt(i).contains(loai)) {
                    flagloai = i;
                    break;
                }
            }
            
            cmbLoai.setSelectedIndex(flagloai); 
            cmbLoai.setEnabled(false);
            
//            loadNCC();
        }
    }
    
    private void xuliclicktabechitietphieunhap()
    {
        int row = tblchitietphieunhap.getSelectedRow();
        if(row > -1)
        {
            txtpnmapn.setText(tblchitietphieunhap.getValueAt(row, 0) + "");
            txtpnsanpham.setText( spBUS.getSanPham(tblchitietphieunhap.getValueAt(row, 1) + "").getTenSP());
            txtpnsoluong.setText(tblchitietphieunhap.getValueAt(row, 2) + "");
            txtpndongia.setText(tblchitietphieunhap.getValueAt(row, 3) + "");
            txtpnthanhtien.setText(tblchitietphieunhap.getValueAt(row, 4) + "");
        }
    }
    
    private void xuliclicktablephieunhap()
    {
        int row = tblphieunhap.getSelectedRow();
        if(row > -1)
        {
            ArrayList<PhieuNhap> dspn = phieunhapBUS.getListPhieuNhap();
            String manv,mancc;
            manv = "";
            mancc = "";
            for(PhieuNhap i : dspn)
            {
                if(i.getMaPN() == Integer.parseInt(tblphieunhap.getValueAt(row, 0) + ""))
                {
                    manv = String.valueOf(i.getMaNV());
                    mancc =  String.valueOf(i.getMaNCC());
                    break;
                }
            }
            txtmapn.setText(tblphieunhap.getValueAt(row, 0) + "");
            txtmanv.setText(manv + "");
            txtmancc.setText(mancc + "");
            txtngaylap.setText(tblphieunhap.getValueAt(row, 1) + "");
            txttongtien.setText(tblphieunhap.getValueAt(row, 2)+ "");
            loadDataTableCTPhieuNhap(tblphieunhap.getValueAt(row, 0) + "");
        }
    }
    
    private void xacnhan()
    {
        int row = tblnhaphang.getRowCount();
        if(row == 0)
        {
            new MyDialog("Chưa chọn sản phẩm để nhập!", MyDialog.ERROR_DIALOG);
            return;
        }
        
        String nhanvien = txtnhanvien.getText();
        String[] ncctmp = (cmbNcc.getSelectedItem() + "").split(" - ");
        String ncc = ncctmp[1];
        
        if (ncc.equals("")) {
            new MyDialog("Hãy chọn nhà cung cấp!", MyDialog.ERROR_DIALOG);
            return;
        }
        int donGiaData = 0;
        float loiNhuan = 0;
        ArrayList<CTPhieuNhap> dsct = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int maSP = Integer.parseInt(tblnhaphang.getValueAt(i, 0) + "");
            int soLuong = Integer.parseInt(tblnhaphang.getValueAt(i, 3) + "");
            int donGia = Integer.parseInt((tblnhaphang.getValueAt(i, 4) + "").replace(",", ""));
            loiNhuan = Float.parseFloat(tblnhaphang.getValueAt(i, 5) + "");
            int thanhTien = Integer.parseInt((tblnhaphang.getValueAt(i, 6) + "").replace(",", ""));
            donGiaData = spBUS.getDonGiaTheoMaSP(maSP);
            CTPhieuNhap ctpn = new CTPhieuNhap(0, maSP, soLuong, donGia, thanhTien);
            dsct.add(ctpn);
        }
        
        XuatPhieuNhapGUI xuatPhieuNhap = new XuatPhieuNhapGUI(cmbNcc.getSelectedItem() + "", nhanvien, dsct, loiNhuan, donGiaData);
        xuatPhieuNhap.setVisible(true);
        if (xuatPhieuNhap.getCheckNhap()) {
            dtmnhaphang.setRowCount(0);
            spBUS.docListSanPham();
            loadDataLenBangSanPham();
            loadDataTableCTPhieuNhap();
            loadDataTablePhieuNhap();
            cmbNcc.setEnabled(true);
        }
    }
        
    private void xoapn() {
        int row = tblphieunhap.getSelectedRow();
        if (row > -1) {
            int maPN = Integer.parseInt(txtmapn.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phiếu nhập này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                PhieuNhap phieuNhap = phieunhapBUS.timPhieuNhap(String.valueOf(maPN));
                if (phieuNhap != null) {
                    // Giảm số lượng sản phẩm trong phiếu nhập
                    ArrayList<CTPhieuNhap> chiTietPhieuNhapList = ctphieunhapBUS.getListPhieuNhap(tblphieunhap.getValueAt(row, 0).toString());
                    for (CTPhieuNhap chiTiet : chiTietPhieuNhapList) {
                        int maSP = chiTiet.getMaSP();
                        int soLuongDaThem = chiTiet.getSoLuong();
                        spBUS.giamSoLuongSP(maSP, soLuongDaThem); // Giảm số lượng sản phẩm
                        loadDataLenBangSanPham();
                    }            

                    // Xóa phiếu nhập
                    boolean xoaThanhCong = phieunhapBUS.xoaPhieuNhap(maPN);
                    if (xoaThanhCong) {
                        new MyDialog("Xóa phiếu nhập thành công!", MyDialog.SUCCESS_DIALOG);
                        dtmphieunhap.removeRow(row);
                        loadDataTableCTPhieuNhap();
                    } else {
                        new MyDialog("Xóa phiếu nhập thất bại!", MyDialog.ERROR_DIALOG);
                    }
                }
            }
        } else {
            new MyDialog("Chưa chọn phiếu nhập để xóa!", MyDialog.ERROR_DIALOG);
        }
    }
  
    private void loadnhanvien()
    {
        ArrayList<NhanVien> dsnv = nhanvienBUS.getDanhSachNhanVien();
        for(NhanVien i : dsnv)
        {
            if(i.getMaNV() == DangNhapBUS.taiKhoanLogin.getMaNV())
            {
                txtnhanvien.setText(i.getMaNV() + " - " + i.getHo() + " " + i.getTen());
                break;
            }
        }
    }
    
    private void xuLyThemSanPhamPN() {
        String tenSP = txttensp.getText();
        String loaiSP = cmbLoai.getSelectedItem().toString();
        String ncc = cmbNcc.getSelectedItem().toString();
        String soLuong = txtsoluong.getText();
        String donGia = txtdongia.getText();
        String loiNhuan = txtloinhuan.getText();

        // Kiểm tra dữ liệu đầu vào
        if (tenSP.isEmpty() || loaiSP.isEmpty() || ncc.isEmpty() ||
                soLuong.isEmpty() || 
                donGia.isEmpty()) {
            new MyDialog("Vui lòng nhập đầy đủ thông tin sản phẩm!", MyDialog.WARNING_DIALOG);
            return;
        }
        
        if(Integer.parseInt(soLuong)!=0){
            new MyDialog("Khi thêm sản phẩm mới vào danh sách sản phẩm thì số lượng phải bằng 0!", MyDialog.WARNING_DIALOG);
            return;
        }
        
        if(Float.parseFloat(loiNhuan)!=0.00){
            new MyDialog("Khi thêm sản phẩm mới vào danh sách sản phẩm thì lợi nhuận phải bằng 0!", MyDialog.WARNING_DIALOG);
            return;
        }

        // Thực hiện thêm sản phẩm
        boolean flag = spBUS.themSanPhamPN(tenSP, loaiSP, ncc, 
                soLuong, 
                donGia);
        if (flag) {
            // Load lại bảng sản phẩm
            loadDataLenBangSanPham();

            // Xóa dữ liệu trên các trường nhập liệu
            txtmasp.setText("");
            txttensp.setText("");
            txttensp.setEditable(true);
            txtdongia.setText("");
            txtsoluong.setText("");
            cmbLoai.setSelectedIndex(0);
            cmbLoai.setEditable(true);
            cmbNcc.setSelectedIndex(0);
        } else {
            
        }
    }
    
//    private void loadNCC() {
//        String maSP = txtmasp.getText();
//        String maNCC = spBUS.getMaNCCTheoMaSP(maSP);
//
//        if (maNCC != null) {
//            for (int i = 0; i < cmbNcc.getItemCount(); i++) {
//                String item = cmbNcc.getItemAt(i).toString();
//                if (item.startsWith(maNCC + " - ")) {
//                    cmbNcc.setSelectedIndex(i);
//                    return;
//                }
//            }
//        }
//    }
}


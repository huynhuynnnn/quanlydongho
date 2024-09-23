
package GUI;

import BUS.GiamGiaBUS;
import Customs.MyDialog;
import DAO.MyConnect;
import DTO.GiamGia;


import com.toedter.calendar.JDateChooser;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public final class PnlQLGiamGia extends JPanel{
  private final GiamGiaBUS GiamGiaBUS = new GiamGiaBUS();
    
    private JLabel lblTitleGiamGia, lblMaGG, lblTenGG, lblPhanTramGG, lblDieuKienGG, lblNgayBD, lblNgayKT, lblTim;
    private JTextField txtMaGG, txtTenGG, txtPhanTramGG,txtDieuKienGG, txtTim;
    private JDateChooser ngayBD, ngayKT;
    private JButton btnReset, btnThem, btnSua, btnXoa;
    private JTable tblGiamGia;
    private DefaultTableModel modelGiamGia;
    private Font font;
    JComboBox cmbChoice = new JComboBox();
    private final String placeholderTimKiem = "Nhập từ khóa mà bạn muốn tìm kiếm...";
    
    public PnlQLGiamGia() {
       addControls();
       addEventsGiamGia();
    }    
    public void addControls() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setLayout(null);
        
        font = new Font("Segoe UI", Font.BOLD, 24);

        DefaultTableCellRenderer centerRederer = new DefaultTableCellRenderer();
        centerRederer.setHorizontalAlignment(JLabel.CENTER);
        
        /*
        =========================================================================
                                    PANEL GIAM GIA
        =========================================================================
         */
        
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, 1000, 250));
        itemView.setBackground(null);

        
        lblTitleGiamGia = new JLabel("QUẢN LÝ GIẢM GIÁ KHUYẾN MÃI");
        lblTitleGiamGia.setFont(font);
        lblTitleGiamGia.setBounds(new Rectangle(300,0,400,30));

        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        Font fontIcon = new Font("Segoe UI", Font.ROMAN_BASELINE, 20);
        
        lblMaGG = new JLabel("Mã giảm giá");
        lblMaGG.setBounds(new Rectangle(50,50,200,30));
        lblMaGG.setFont(font0);
        
        lblTenGG = new JLabel("Tên giảm giá");
        lblTenGG.setBounds(new Rectangle(400, 50, 200, 30));
        lblTenGG.setFont(font0);
        
        lblPhanTramGG = new JLabel("Phần trăm giảm");
        lblPhanTramGG.setBounds(new Rectangle(50,90,200,30));
        lblPhanTramGG.setFont(font0);
        
        lblDieuKienGG = new JLabel("Điều kiện giảm");
        lblDieuKienGG.setBounds(new Rectangle(400, 90, 200, 30));
        lblDieuKienGG.setFont(font0);
        
        lblNgayBD = new JLabel("Ngày bắt đầu");
        lblNgayBD.setBounds(new Rectangle(50, 130, 200, 30));
        
        lblNgayKT = new JLabel("Ngày kết thúc");
        lblNgayKT.setBounds(new Rectangle(400, 130, 200, 30));
        lblTim = new JLabel("Từ khóa tìm kiếm");
        
        txtMaGG = new JTextField("");
        txtMaGG.setEditable(false);
        txtMaGG.setBounds(new Rectangle(150,50,220,30));
        
        
        txtTenGG = new JTextField("");
        txtTenGG.setBounds(new Rectangle(500, 50, 220, 30));
        
       
        txtPhanTramGG = new JTextField("");
        txtPhanTramGG.setBounds(new Rectangle(150,90,220,30));
        
        txtDieuKienGG = new JTextField("");
        txtDieuKienGG.setBounds(new Rectangle(500, 90, 220, 30));
        
        ngayBD = new JDateChooser();
        ngayBD.setDateFormatString("dd/MM/yyyy");
        ngayBD.setDate(new Date());
        ngayBD.setBounds(new Rectangle(150,130,220,30));

        ngayKT = new JDateChooser();
        ngayKT.setDateFormatString("dd/MM/yyyy");
        ngayKT.setBounds(new Rectangle(500,130,220,30));
        
        lblTim = new JLabel("Tìm kiếm");
        lblTim.setBounds(new Rectangle(50,220,200,30));
        lblTim.setFont(fontIcon);
        
        txtTim = new JTextField("");
        

        
        /*********************** SORT TABLE *****************************/
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(Color.WHITE);
        searchBox.setBounds(new Rectangle(150,220,565,30)); 
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền 
        
         //PHẦN CHỌN SEARCH
        
         cmbChoice.setEditable(true);
         cmbChoice.setFont(new Font("Segoe UI",Font.PLAIN,14));
         cmbChoice.addItem("Mã giảm giá");
         cmbChoice.addItem("Tên giảm giá");
         
         cmbChoice.setBounds(new Rectangle(0,0,120,30));
         cmbChoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
         cmbChoice.setBackground(Color.WHITE);
         //Phần TextField
         JTextField txtSearch = new JTextField();
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

       
         itemView.add(searchBox);
        
        itemView.add(lblTitleGiamGia);
        itemView.add(lblMaGG);
        itemView.add(lblMaGG);
        itemView.add( txtMaGG);
        itemView.add(lblTenGG);
        itemView.add( txtTenGG);
        itemView.add(lblPhanTramGG);
        itemView.add(txtPhanTramGG);
        itemView.add(lblDieuKienGG);
        itemView.add(txtDieuKienGG);
        itemView.add(lblNgayBD);
        itemView.add(ngayBD);
        itemView.add(lblNgayKT);
        itemView.add(ngayKT);
        itemView.add(lblTim);

        
        add(itemView);
       
        ImageIcon icon = new ImageIcon("images\\Refresh-icon.png");
        ImageIcon icon1 = new ImageIcon("images\\delete-icon.png");
        ImageIcon icon2 = new ImageIcon("images\\Pencil-icon.png");
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/add-icon.png"));
        
        btnThem = new JButton("Thêm");
        btnThem.setVerticalTextPosition(JLabel.CENTER);
        btnThem.setFont(fontIcon);
        btnThem.setBounds(new Rectangle(750,50, 140, 50));
        btnThem.setOpaque(true);
        btnThem.setBackground(new Color(151, 255, 255));
        btnThem.setBorder(BorderFactory.createLineBorder(Color.black));
        btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img = icon3.getImage();
        Image imgscale = img.getScaledInstance(32,32, Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(imgscale);
        btnThem.setIcon(scaledicon);

        btnSua = new JButton("Sửa");
        btnSua.setVerticalTextPosition(JLabel.CENTER);
        btnSua.setFont(fontIcon);
        btnSua.setBounds(new Rectangle(750, 110, 140,50));
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
        btnXoa.setBounds(new Rectangle(750, 170, 140,50));
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
        btnReset.setBounds(new Rectangle(400, 170, 50,35));
        btnReset.setOpaque(true);
        btnReset.setBackground(new Color(151, 255, 255));
        btnReset.setBorder(BorderFactory.createLineBorder(Color.black));
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image imgReset = icon.getImage();
        Image imgscale3 = imgReset.getScaledInstance(30,30, Image.SCALE_SMOOTH);
        ImageIcon scaledicon3 = new ImageIcon(imgscale3);
        btnReset.setIcon(scaledicon3);
        
        itemView.add(btnThem);
        itemView.add(btnSua);
        itemView.add(btnXoa);
        itemView.add(btnReset);
        
        
        

        Vector header = new Vector();
        header.add("Mã giảm");
        header.add("Tên mã giảm");
        header.add("Phần trăm");
        header.add("Điều kiện");
        header.add("Ngày bắt đầu");
        header.add("Ngày kết thúc");
        header.add("Tình trạng");
        modelGiamGia = new DefaultTableModel(header, 7);
        tblGiamGia = new JTable(modelGiamGia);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(modelGiamGia);
        tblGiamGia.setRowSorter(rowSorter);
       

        tblGiamGia.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblGiamGia.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblGiamGia.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblGiamGia.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblGiamGia.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblGiamGia.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblGiamGia.getColumnModel().getColumn(6).setPreferredWidth(150);

        tblGiamGia.setFocusable(false);
        tblGiamGia.setIntercellSpacing(new Dimension(0,0));     
        tblGiamGia.getTableHeader().setFont(font1);
        tblGiamGia.setRowHeight(30);
        tblGiamGia.setShowVerticalLines(true);              
        tblGiamGia.getTableHeader().setOpaque(true);
        tblGiamGia.setFillsViewportHeight(true);
        tblGiamGia.getTableHeader().setBackground(new Color(144, 195, 212));
//        tbl.getTableHeader().setForeground(Color.WHITE);
        tblGiamGia.setSelectionBackground(new Color(232, 232, 232));          
        
        
        JScrollPane scrollPane = new JScrollPane(tblGiamGia);
        scrollPane.setBounds(new Rectangle(30,330, 1000 - 110, 360));
        scrollPane.setBackground(null);
        add(scrollPane);
        
        loadDataLenBangGiamGia();
     // Xử lý sự kiện khi nhấn phím "Enter" trên JTextField txtSearch
        txtSearch.addActionListener((ActionEvent e) -> {
        // Lấy thông tin tìm kiếm từ trường nhập liệu
        String condition = txtSearch.getText();
        String searchOption = cmbChoice.getSelectedItem().toString(); // Lấy loại tìm kiếm từ JComboBox
        
        // Tìm kiếm nhân viên theo điều kiện
        listByCondition(condition, searchOption);
            });
        
        setSize(1000,730);
        setVisible(true);
    }
    
    private void addEventsGiamGia() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataLenBangGiamGia();
                xuLyReset();
            }
        });
        
        btnReset.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    loadDataLenBangGiamGia();
                    xuLyReset();
                }
            }
        });
        

        tblGiamGia.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xuLyChonGiamGia();
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            
            public void mouseEntered(MouseEvent e) {
                // Đặt loại con trỏ chuột khi di chuyển vào bảng
                tblGiamGia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
           
            @Override
            public void mouseExited(MouseEvent e) {
                // Đặt lại loại con trỏ chuột khi di chuyển ra khỏi bảng
                tblGiamGia.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } 
      
        });
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemGiamGia();
            }
        });
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaGiamGia();
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaGiamGia();
            }
            
        });
       
        
    }
    private void loadDataLenBangGiamGia() {
        GiamGiaBUS.docDanhSach();
        ArrayList<GiamGia> dsgg = GiamGiaBUS.getDanhSachGiamGia();
        loadDataLenBangGiamGia(dsgg);
    }

    private void loadDataLenBangGiamGia(ArrayList<GiamGia> dsgg) {
        modelGiamGia.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat dcf = new DecimalFormat(">###,###");
        for (GiamGia gg : dsgg) {
            Vector vec = new Vector();
            vec.add(gg.getMaGG());
            vec.add(gg.getTenGG());
            vec.add(gg.getPhanTramGiam());
            vec.add(dcf.format(gg.getDieuKien()));
            vec.add(sdf.format(gg.getNgayBD()));
            vec.add(sdf.format(gg.getNgayKT()));
            boolean flag = GiamGiaBUS.kiemTraHieuLucKhuyenMai(gg.getMaGG());
            if(flag) {
                vec.add("Hiệu lực");
            } else {
                vec.add("Không hiệu lực");
            }
            modelGiamGia.addRow(vec);
        }
    }
    
    private void xuLyChonGiamGia() {
        int row = tblGiamGia.getSelectedRow();
        if(row > -1) {
            String ma = tblGiamGia.getValueAt(row, 0) + "";
            String ten = tblGiamGia.getValueAt(row, 1) + "";
            String phanTramGG = tblGiamGia.getValueAt(row, 2) + "";
            String dieuKien = tblGiamGia.getValueAt(row, 3) + "";
            String start = tblGiamGia.getValueAt(row, 4) + "";
            String end = tblGiamGia.getValueAt(row, 5) + "";
            
            
            dieuKien = dieuKien.replace(">", "");
            dieuKien = dieuKien.replace(",", "");
            
            Date dateStart = new Date();
            Date dateEnd = new Date();
            
            try {
                dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(start);
                dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(end);
            } catch (ParseException e) {
            }
            
            txtMaGG.setText(ma);
            txtTenGG.setText(ten);
            txtPhanTramGG.setText(phanTramGG);
            txtDieuKienGG.setText(dieuKien);
            ngayBD.setDate(dateStart);
            ngayKT.setDate(dateEnd);
        }
    }
    
    public void xuLyReset() {
        txtMaGG.setText("");
        txtTenGG.setText("");
        txtPhanTramGG.setText("");
        txtDieuKienGG.setText("");
        ngayBD.setDate(null);
        ngayKT.setDate(null);
        txtTim.setText(placeholderTimKiem);
        txtTim.setForeground(Color.GRAY);
    }
    
    private void xuLyThemGiamGia() {
        String ten = txtTenGG.getText().trim();
        String phanTram = txtPhanTramGG.getText().trim();
        String dieuKien = txtDieuKienGG.getText().trim();
        Date start = ngayBD.getDate();
        Date end = ngayKT.getDate();
        
        if (Integer.parseInt(txtDieuKienGG.getText())<=0){
            new MyDialog("Điều kiện giảm phải là một số nguyên dương!", MyDialog.WARNING_DIALOG);
            return;
        }

        if(!kiemTra(ten, phanTram, dieuKien)) { //!true khi có lỗi và !false khi mà không có lỗi
            if(GiamGiaBUS.kiemTraTrungGiamGia(ten,phanTram,dieuKien,start,end)) {
                int xoa = JOptionPane.showConfirmDialog(this, "Mã giảm này đã tồn tại, bạn có chắc chắn muốn thêm?", "Thông báo trùng mã giảm", JOptionPane.YES_NO_OPTION);
                if(xoa == JOptionPane.YES_OPTION) {
                    boolean flag = GiamGiaBUS.themMaGiam(ten, phanTram,dieuKien,start,end);
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Thêm mã giảm thành công");
                        GiamGiaBUS.docDanhSach();
                        loadDataLenBangGiamGia();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm mã giảm thất bại");
                    }
                }
            } else {
                boolean flag = GiamGiaBUS.themMaGiam(ten, phanTram, dieuKien, start, end);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Thêm mã giảm thành công");
                    GiamGiaBUS.docDanhSach();
                    loadDataLenBangGiamGia();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm mã giảm thất bại");
                }
            }
        }
        
    }
    
    private void xuLySuaGiamGia() {
        String ma = txtMaGG.getText().trim();
        String ten = txtTenGG.getText().trim();
        String phanTram = txtPhanTramGG.getText().trim();
        String dieuKien = txtDieuKienGG.getText().trim();
        Date start = ngayBD.getDate();
        Date end = ngayKT.getDate();
        
        if(ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn mã giảm");
        } else if(!kiemTra(ten, phanTram, dieuKien)) {
            if(GiamGiaBUS.kiemTraTrungGiamGia(ten, phanTram, dieuKien, start, end)) {
                int sua = JOptionPane.showConfirmDialog(this, "Mã giảm này đã tồn tại, bạn có chắc chắn muốn sửa?", "Thông báo trùng mã giảm", JOptionPane.YES_NO_OPTION);
                if(sua == JOptionPane.YES_OPTION) {
                    boolean flag = GiamGiaBUS.suaMaGiam(ma, ten, phanTram, dieuKien, start, end);
                    if(flag) {
                        JOptionPane.showMessageDialog(this, "Sửa mã giảm thành công");
                        GiamGiaBUS.docDanhSach();
                        loadDataLenBangGiamGia();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa mã giảm thất bại");
                    }
                }
            } else {
                boolean flag = GiamGiaBUS.suaMaGiam(ma, ten, phanTram, dieuKien, start, end);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Sửa mã giảm thành công");
                    GiamGiaBUS.docDanhSach();
                    loadDataLenBangGiamGia();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa mã giảm thất bại");
                }
            }
        }
    }

    private void xuLyXoaGiamGia() {
        String ma = txtMaGG.getText().trim();
        String ten = txtTenGG.getText().trim();
        String phantram = txtPhanTramGG.getText().trim();
        String dieuKien = txtDieuKienGG.getText().trim();
        
        if(ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn mã giảm giá");
        } else if(!kiemTra(ten, phantram, dieuKien)) {
            int flagXoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if(flagXoa == JOptionPane.YES_OPTION) {
                boolean flag = GiamGiaBUS.xoaMaGiam(ma);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadDataLenBangGiamGia();
                    xuLyReset();
                    GiamGiaBUS.docDanhSach();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        }
    }
    
    private void xuLyLiveSearch() {
        String tuKhoa = txtTim.getText().toLowerCase().trim();
        ArrayList<GiamGia> dskh = GiamGiaBUS.timKiemGiamGia(tuKhoa);
        loadDataLenBangGiamGia(dskh);
        if(tuKhoa.equals(placeholderTimKiem.toLowerCase())) 
            loadDataLenBangGiamGia();
    }
    // Phương thức tìm kiếm và hiển thị danh sách nhân viên theo điều kiện
    private void listByCondition(String condition, String searchOption) {
        // Kiểm tra null cho nvBUS
        if (GiamGiaBUS == null) {
            // Xử lý khi nvBUS là null
            JOptionPane.showMessageDialog(null, "Không thể truy cập dữ liệu . Vui lòng thử lại sau.");
            return;
        }

        // Xóa toàn bộ dữ liệu hiện tại trên bảng
        modelGiamGia.setRowCount(0);

        // Tìm kiếm nhân viên theo điều kiện từ lớp BUS
        ArrayList<GiamGia> listKH = null;
        switch (searchOption) {
            case "Mã giảm giá":
                try {
                    int maGG = Integer.parseInt(condition);
                    GiamGia khByID = GiamGiaBUS.timTheoID(maGG);
                    if (khByID != null) {
                        listKH = new ArrayList<>();
                        listKH.add(khByID);
                    }
                } catch (Exception e) {
                    
                }
                break;
        
            case "Tên giảm giá":
                // Tìm kiếm theo Tên NV từ lớp BUS
                listKH = GiamGiaBUS.timKHTheoTen(condition);
                break;
            default:
                // Xử lý khi lựa chọn không hợp lệ
                JOptionPane.showMessageDialog(null, "Lựa chọn không hợp lệ. Vui lòng chọn 'Mã giảm giá' hoặc 'Tên giảm giá'.");
                break;
        }

       // Nếu không có kết quả tìm kiếm, hiển thị thông báo
        if (listKH == null || listKH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp!");
            // Reset lại bảng về trạng thái ban đầu
            loadDataLenBangGiamGia();
        } else {
            // Đổ dữ liệu vào bảng
            addRowsToTable(listKH);
        }
        }
    private void addRowsToTable(ArrayList<GiamGia> listKH) {
        for (GiamGia km : listKH) {
            Vector row = new Vector();
            row.add(km.getMaGG());
            row.add(km.getTenGG());
            row.add(km.getPhanTramGiam());
            row.add(km.getDieuKien());
            row.add(km.getNgayBD());
            row.add(km.getNgayKT());
     
            modelGiamGia.addRow(row);
        }
    }
   
    private boolean kiemTra(String ten, String phanTram, String dieuKien) {
        dieuKien = dieuKien.replace(">", "");
        dieuKien = dieuKien.replace(",", "");
        phanTram = phanTram.replace("%", "");
        
                
        String errorPT = "";
        String errorDK = "";
        String errorNgayBD = "";
        String errorNgayKT = "";
        String errorDate = "";
        
        try {
            Date start = ngayBD.getDate();
            Date end = ngayKT.getDate();
            if(start.getTime() > end.getTime()) 
                errorDate = "THOI_HAN_KHONG_HOP_LE";
        } catch (Exception e) {
        }
        
        try {
            int pt = Integer.parseInt(phanTram);
            if(pt < 0 || pt > 100)
                errorPT = "VUOT_KHOANG_CHO_PHEP";
        } catch (Exception e) {
            errorPT = "KHONG_PHAI_SO";
        }
        
        
        try {
            int dk = Integer.parseInt(dieuKien);
        } catch (Exception e) {
            errorDK = "KHONG_PHAI_SO";
        }
        
        try {
           Date start = ngayBD.getDate(); 
        } catch (Exception e) {
            errorPT = "KHONG_HOP_LE";
        }
        
        try {
           Date end = ngayKT.getDate(); 
        } catch (Exception e) {
            errorPT = "KHONG_HOP_LE";
        }

        
        if(ten.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tên giảm giá");
            txtTenGG.requestFocus();
            return true;
        } else if(phanTram.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trăm giảm giá");
            txtPhanTramGG.requestFocus();
            return true;
        } else if(errorPT.equals("VUOT_KHOANG_CHO_PHEP")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trăm giảm trong khoảng 0 đến 100");
            txtPhanTramGG.requestFocus();
            return true;
        } else if(errorPT.equals("KHONG_PHAI_SO")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số");
            txtPhanTramGG.requestFocus();
            return true;
        } else if(dieuKien.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện");
            txtDieuKienGG.requestFocus();
            return true;
        } else if(errorDK.equals("KHONG_PHAI_SO")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số");
            txtDieuKienGG.requestFocus();
            return true;
        } else if(ngayBD.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu");
            ngayBD.requestFocus();
            return true;
        } else if(errorNgayBD.equals("KHONG_HOP_LE")) {
            JOptionPane.showMessageDialog(this, "Ngày nhập vào không hợp lệ");
            ngayBD.requestFocus();
            return true;
        } else if(ngayKT.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc");
            ngayKT.requestFocus();
            return true;
        } else if(errorNgayKT.equals("KHONG_HOP_LE")) {
            JOptionPane.showMessageDialog(this, "Ngày nhập vào không hợp lệ");
            ngayKT.requestFocus();
            return true;
        } else if(errorDate.equals("THOI_HAN_KHONG_HOP_LE")) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu");
            ngayKT.requestFocus();
            return true;
        } 
        return false;
    }
}
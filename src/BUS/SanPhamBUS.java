package BUS;

import DAO.SanPhamDAO;
import DTO.SanPham;
import Customs.MyDialog;

import java.util.ArrayList;

public class SanPhamBUS {

    private ArrayList<SanPham> listSanPham = null;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public SanPhamBUS() {
        docListSanPham();
    }

    public void docListSanPham() {
        listSanPham = spDAO.getListSanPham();
    }

    public ArrayList<SanPham> getListSanPham() {
        if (listSanPham == null) {
            docListSanPham();
        }
        return listSanPham;
    }

    public SanPham getSanPham(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSP = Integer.parseInt(ma);
                for (SanPham sp : listSanPham) {
                    if (sp.getMaSP() == maSP) {
                        return sp;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSanPham) {
            if ((sp.getMaSP() + "").contains(ten)
                     ) {
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public ArrayList<SanPham> getSanPhamTheoLoai(String ma) {
        if (!ma.trim().equals("")) {
            ArrayList<SanPham> dssp = new ArrayList<>();
            try {
                int maLoai = Integer.parseInt(ma);
                for (SanPham sp : listSanPham) {
                    if (sp.getMaLoai() == maLoai) {
                        dssp.add(sp);
                    }
                }
                return dssp;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public String getAnh(String ma) {
        int maSP = Integer.parseInt(ma);
        return spDAO.getAnh(maSP);
    }

    public void capNhatSoLuongSP(int ma, int soLuongMat) {
        spDAO.capNhatSoLuongSP(ma, soLuongMat);
    }

    public boolean nhapSanPhamTuExcel(String ten,
            String loai,
            String ncc,
            String soLuong,
            String anh,
            String donGia,
            String moTa) {

        try {
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            String[] nccTmp = ncc.split(" - ");
            int maNCC = Integer.parseInt(nccTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);

            SanPham sp = new SanPham();
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setMaNCC(maNCC);
            sp.setSoLuong(soLuongSP);
            sp.setHinhAnh(anh);
            sp.setDonGia(donGiaSP);
            sp.setMoTa(moTa);

            spDAO.nhapSanPhamTuExcel(sp);
        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaSanPham(String ma) {
        if (ma.trim().equals("")) {
            new MyDialog("Chưa chọn sản phẩm để xoá!", MyDialog.ERROR_DIALOG);
            return false;
        }

        int maSP = Integer.parseInt(ma);
        if (spDAO.xoaSanPham(maSP)) {
            
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        }
        else
        {
            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

    public boolean suaSanPham(String ma,
            String ten,
            String anh,
            String moTa) {

        try {
            if (ma.trim().equals("")) {
                new MyDialog("Chưa chọn sản phẩm để sửa!", MyDialog.ERROR_DIALOG);
                return false;
            }
            int maSP = Integer.parseInt(ma);

            if (ten.trim().equals("")) {
                new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }

            SanPham sp = new SanPham();
            sp.setMaSP(maSP);
            sp.setTenSP(ten);
            sp.setHinhAnh(anh);
            sp.setMoTa(moTa);

            if (spDAO.suaSanPham(sp)) {
                new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
          
        }
        return false;
    }

    public String getTenSP(int maSP) {
        for (SanPham sp : listSanPham) {
            if (sp.getMaSP() == maSP) {
                return sp.getTenSP();
            }
        }
        return "";
    }
    
    public void giamSoLuongSP(int maSP, int soLuong) {
        spDAO.giamSoLuongSP(maSP, soLuong);
    }
    
    public void capNhatGiaSP(int ma, int donGia) {
        spDAO.capNhatSoLuongSP(ma, donGia);
    }
    
    public boolean themSanPhamPN(String ten,
            String loai,
            String ncc,
            String soLuong,
            String donGia) {

//        if (ten.trim().equals("")) {
//            new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
//            return false;
//        }
//
//        if (ncc.trim().equals("")) {
//            new MyDialog("Tên NCC không được để trống!", MyDialog.ERROR_DIALOG);
//            return false;
//        }

        try {
            String[] loaiTmp = loai.split(" - ");
            String[] nccTmp = ncc.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int maNCC = Integer.parseInt(nccTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);
            if (maLoai == 0) {
                new MyDialog("Vui lòng chọn Loại sản phẩm!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (maNCC == 0) {
                new MyDialog("Vui lòng chọn Nhà cung cấp!", MyDialog.ERROR_DIALOG);
                return false;
            }
            SanPham sp = new SanPham();
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setMaNCC(maNCC);
            sp.setSoLuong(soLuongSP);
            sp.setDonGia(donGiaSP);

            if (spDAO.themSanPhamPN(sp)) {
                new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int getDonGiaTheoMaSP(int maSP) {
        for (SanPham sp : listSanPham) {
            if (sp.getMaSP() == maSP) {
                return sp.getDonGia();
            }
        }
        return 0;
    }
    
//    public String getMaNCCTheoMaSP(String maSP) {
//        return spDAO.getMaNCCTheoMaSP(maSP);
//    }
}

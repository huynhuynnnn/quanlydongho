--
-- Database: `quanlydongho_nhom15`
--
CREATE DATABASE IF NOT EXISTS `quanlydongho_nhom15` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quanlydongho_nhom15`;

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `MaHD` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(1, 4, 2, 1050000, 2100000),
(2, 45, 3, 3150000, 9450000),
(2, 4, 1, 1050000, 1050000);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPN` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(1, 4, 10, 1000000, 10000000),
(2, 45, 10, 3000000, 30000000),
(3, 5, 2, 1990000, 3980000),
(4, 1, 2, 4000000, 8000000),
(4, 2, 2, 3000000, 6000000),
(5, 1, 2, 4000000, 8000000),
(6, 1, 2, 4800000, 9600000),
(7, 1, 2, 1900000, 3800000),
(7, 37, 2, 2000000, 4000000),
(8, 24, 2, 1000000, 2000000),
(8, 25, 2, 2900000, 5800000),
(9, 1, 12, 1900000, 22800000),
(9, 2, 47, 2900000, 136300000),
(9, 3, 20, 1900000, 38000000),
(9, 6, 25, 1980000, 49500000),
(9, 6, 15, 1890000, 28350000),
(9, 7, 2, 1000000, 2000000),
(9, 8, 17, 1980000, 33660000),
(9, 9, 20, 2000000, 40000000),
(9, 10, 25, 1200000, 30000000),
(9, 11, 16, 2000000, 32000000),
(9, 12, 18, 1000000, 18000000),
(9, 13, 5, 2000000, 10000000),
(9, 49, 30, 1990000, 59700000),
(10, 37, 25, 1000000, 25000000),
(10, 38, 20, 1900000, 38000000),
(10, 39, 28, 2900000, 81200000),
(10, 40, 10, 2999000, 29990000),
(10, 41, 29, 1000000, 29000000),
(10, 42, 20, 1000000, 20000000),
(10, 43, 18, 1000000, 18000000),
(10, 44, 20, 1000000, 20000000),
(10, 45, 12, 4000000, 48000000),
(11, 24, 18, 3000000, 54000000),
(11, 25, 19, 1900000, 36100000),
(11, 26, 12, 2000000, 24000000),
(11, 27, 49, 1000000, 49000000),
(11, 28, 20, 1890000, 37800000),
(11, 29, 19, 1900000, 36100000),
(11, 30, 26, 2000000, 52000000),
(11, 31, 28, 1900000, 53200000),
(11, 32, 20, 1900000, 38000000),
(11, 33, 28, 2000000, 56000000),
(11, 34, 30, 1200000, 36000000),
(11, 35, 25, 1290000, 32250000),
(11, 36, 25, 2000000, 50000000),
(11, 14, 20, 1999000, 39980000),
(11, 15, 27, 2000000, 54000000),
(11, 16, 18, 1000000, 18000000),
(11, 17, 27, 3000000, 81000000),
(11, 18, 30, 1999000, 59970000),
(11, 19, 29, 1200000, 34800000),
(11, 20, 12, 1299000, 15588000),
(11, 21, 19, 1999000, 37981000),
(11, 22, 28, 3000000, 84000000),
(11, 23, 24, 2999000, 71976000),
(13, 50, 29, 1900000, 55100000),
(14, 52, 25, 1999000, 49975000),
(14, 53, 15, 1899000, 28485000),
(14, 55, 30, 1999000, 59970000),
(14, 56, 29, 1799000, 52171000),
(15, 54, 20, 1999000, 39980000),
(15, 51, 30, 1989000, 59670000),
(15, 54, 12, 1200000, 14400000),
(16, 4, 12, 999000, 11988000),
(16, 5, 20, 2999000, 59980000),
(17, 4, 1, 1999000, 1999000);

-- --------------------------------------------------------

--
-- Table structure for table `giamgia`
--

CREATE TABLE `giamgia` (
  `MaGG` int(11) NOT NULL,
  `TenGG` text NOT NULL,
  `PhanTramGiam` int(11) NOT NULL,
  `DieuKien` int(11) NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giamgia`
--

INSERT INTO `giamgia` (`MaGG`, `TenGG`, `PhanTramGiam`, `DieuKien`, `NgayBD`, `NgayKT`) VALUES
(1, 'Không giảm giá', 0, 0, '2023-02-26', '2025-12-15'),
(2, 'Khuyến mãi tháng 9', 10, 150000, '2024-09-01', '2024-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(11) NOT NULL,
  `MaGG` int(11) NOT NULL,
  `GhiChu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaNV`, `MaKH`, `NgayLap`, `TongTien`, `MaGG`, `GhiChu`) VALUES
(1, 1, 1, '2024-09-20', 1890000, 2, 'Đã thanh toán'),
(2, 1, 2, '2024-09-20', 9450000, 2, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `TongChiTieu` int(11) NOT NULL DEFAULT 0,
  `TinhTrang` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `GioiTinh`, `SoDienThoai`, `TongChiTieu`, `TinhTrang`) VALUES
(1, 'Nguyễn Ngọc', 'An', 'Nữ', '0968751433', 1890000, 1),
(2, 'Hà Tường', 'Vy', 'Nữ', '0372767359', 9450000, 1),
(3, 'Võ Thị Thu', 'Huyền', 'Nữ', '0326543881', 0, 1),
(4, 'Lưu Trường', 'Thuận', 'Nam', '0372767359', 0, 1),
(5, 'Cao Thái', 'Hà', 'Nữ', '0987623145', 0, 1),
(6, 'Ưng Hoàng', 'Phúc', 'Nam', '0986543321', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`) VALUES
(1, 'Đồng hồ Nam'),
(2, 'Đồng hồ Nữ'),
(3, 'Đồng hồ khác');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL,
  `TrangThai` int(1) NOT NULL DEFAULT 2
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDienThoai`, `TrangThai`) VALUES
(1, 'CASIO', 'Nhật Bản', '0997878651', 2),
(2, 'G-SHOCK', 'Pháp', '0734226577', 2),
(3, 'TOMMY', 'Anh', '0875432441', 2),
(4, 'CITIZEN', 'Đức', '0986233157', 2);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `Ho` varchar(255) DEFAULT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `GioiTinh` varchar(3) DEFAULT NULL,
  `SoDienThoai` int(11) NOT NULL,
  `ChucVu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `Ten`, `GioiTinh`, `SoDienThoai`, `ChucVu`) VALUES
(1, 'Admin', ' ', ' ', 0, 'Quản trị viên'),
(2, 'Trần Thị Thu', 'Huyền', 'Nữ', 982538057, 'Nhân viên nhập hàng'),
(3, 'Nguyễn Ngọc', 'Nhi', 'Nữ', 989787675, 'Quản lý'),
(4, 'Nguyễn Bảo', 'Anh', 'Nữ', 988786765, 'Nhân viên bán hàng');

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `Quyen` varchar(255) NOT NULL DEFAULT 'Default' COMMENT 'Tên quyền',
  `NhapHang` int(1) NOT NULL DEFAULT 0,
  `BanHang` int(1) NOT NULL DEFAULT 0,
  `QLSanPham` int(1) NOT NULL DEFAULT 0,
  `QLNhanVien` int(1) NOT NULL DEFAULT 0,
  `QLKhachHang` int(1) NOT NULL DEFAULT 0,
  `ThongKe` int(1) NOT NULL DEFAULT 0,
  `QLKhuyenMai` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`Quyen`, `NhapHang`, `BanHang`, `QLSanPham`, `QLNhanVien`, `QLKhachHang`, `ThongKe`, `QLKhuyenMai`) VALUES
('Default', 0, 0, 0, 0, 0, 0, 0),
('Nhân viên bán hàng', 0, 1, 0, 0, 1, 0, 0),
('Nhân viên nhập hàng', 1, 0, 1, 0, 0, 0, 0),
('Quản lý', 1, 1, 1, 0, 1, 1, 1),
('Quản trị viên', 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNV`, `MaNCC`, `NgayLap`, `TongTien`) VALUES
(1, 1, 1, '2024-09-20', 10000000),
(2, 2, 1, '2024-09-20', 30000000),
(3, 1, 1, '2024-09-20', 3980000),
(4, 1, 1, '2024-09-20', 14000000),
(5, 1, 1, '2024-09-20', 8000000),
(6, 1, 1, '2024-09-20', 9600000),
(7, 2, 1, '2024-09-20', 7800000),
(8, 3, 1, '2024-09-20', 7800000),
(9, 1, 3, '2024-09-20', 500310000),
(10, 2, 3, '2024-09-20', 309190000),
(11, 3, 3, '2024-09-20', 554450000),
(13, 2, 1, '2024-09-20', 55100000),
(14, 2, 1, '2024-09-21', 190601000),
(15, 1, 1, '2024-09-21', 114050000),
(16, 1, 1, '2024-09-21', 71968000),
(17, 1, 1, '2024-09-21', 1999000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` int(11) NOT NULL,
  `TenSP` varchar(255) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL DEFAULT 0,
  `HinhAnh` varchar(255) DEFAULT NULL,
  `DonGia` int(11) NOT NULL DEFAULT 0,
  `MoTa` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `MaLoai`, `MaNCC`, `SoLuong`, `HinhAnh`, `DonGia`, `MoTa`) VALUES
(1, 'CASIO NAM – QUARTZ (PIN) – DÂY KIM LOẠI (MTP-1370D-7A2VDF)', 1, 1, 20, 'casio-mtp-vd03d-2audf-nam.jpg', 2280000, 'Đồng hồ nam Casio MTP-1370D-7A2VDF thanh lịch với kiểu dáng nam tính mặt đồng hồ nền trắng cùng chữ số vạch mạ vàng, chất liệu được làm từ thép không gỉ, 3 kim vàng, còn có 1 lịch ngày và 1 lịch thứ'),
(2, 'casio-ltp-v006d-7b2udf-nu', 2, 1, 49, 'casio-ltp-v006d-7b2udf-nu.jpg', 3480000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(3, 'casio-ltp-v007l-1budf-nu', 2, 1, 20, 'casio-ltp-v007l-1budf-nu.jpg', 2280000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(4, 'casio-ltp-vt01gl-4budf-nu', 2, 1, 20, 'casio-ltp-vt01gl-4budf-nu.jpg', 2189000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(5, 'casio-ltp-vt01l-5budf-nu', 2, 1, 22, 'casio-ltp-vt01l-5budf-nu.jpg', 3148950, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(6, 'casio-mtp-e715l-1avdf-nam', 1, 1, 40, 'casio-mtp-e715l-1avdf-nam.jpg', 2268000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(7, 'casio-mtp-m300d-7avdf-nam', 1, 1, 2, 'casio-mtp-m300d-7avdf-nam.jpg', 1200000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(8, 'casio-mtp-m300l-7avdf-nam', 1, 1, 17, 'casio-mtp-m300l-7avdf-nam.jpg', 2376000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(9, 'casio-ltp-v006d-7b2udf-nu', 2, 1, 20, 'casio-ltp-v006d-7b2udf-nu.jpg', 2400000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(10, 'casio-mtp-m305l-7avdf-nam', 1, 1, 25, 'casio-mtp-m305l-7avdf-nam.jpg', 1440000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(11, 'casio-mtp-m305l-7avdf-nam', 1, 1, 16, 'casio-mtp-m305l-7avdf-nam.jpg', 2400000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(12, 'casio-mtp-vd03d-2audf-nam', 1, 1, 18, 'casio-mtp-vd03d-2audf-nam.jpg', 1200000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(13, 'casio-mtp-vd03d-2audf-nam', 1, 1, 5, 'casio-mtp-vd03d-2audf-nam.jpg', 2400000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(14, 'citizen-em0993-82x-nu', 2, 4, 20, 'citizen-em0993-82x-nu.jpg', 2038980, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(15, 'citizen-eq0614-52e-nu', 2, 4, 27, 'citizen-eq0614-52e-nu.jpg', 2040000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(16, 'citizen-ew2449-83a-nu', 2, 4, 18, 'citizen-ew2449-83a-nu.jpg', 1900000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(17, 'citizen-ew2590-85d-nu.jpg', 2, 4, 27, 'citizen-ew2590-85d-nu.jpg', 3060000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(18, 'citizen-ew2590-85n-nu', 2, 4, 30, 'citizen-ew2590-85n-nu.jpg', 2038980, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(19, 'citizen-ew2591-82d-nu', 2, 4, 29, 'citizen-ew2591-82d-nu.jpg', 1900000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(20, 'citizen-nh8390-11x-nam', 1, 4, 12, 'citizen-nh8390-11x-nam.jpg', 1900000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(21, 'citizen-nj0155-87e-nam', 1, 4, 19, 'citizen-nj0155-87e-nam.jpg', 2038980, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(22, 'citizen-nj0150-81l-nam', 1, 4, 28, 'citizen-nj0150-81l-nam.jpg', 3060000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(23, 'citizen-nh8394-70h-nam', 1, 4, 24, 'citizen-nh8394-70h-nam.jpg', 3058980, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(24, 'tommy-1710420-nam', 1, 3, 20, 'tommy-1710420-nam.jpg', 3060000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(25, 'tommy-1782110-nu', 2, 3, 21, 'tommy-1782110-nu.jpg', 1938000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(26, 'tommy-1782336-nu', 2, 3, 12, 'tommy-1782336-nu.jpg', 2040000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(27, 'tommy-1782337-nu', 2, 3, 49, 'tommy-1782337-nu.jpg', 1900000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(28, 'tommy-1791807-nam', 1, 3, 20, 'tommy-1791807-nam.jpg', 1927800, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(29, 'tommy-hilfiger-1782511-nu', 2, 3, 19, 'tommy-hilfiger-1782511-nu.jpg', 1938000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(30, 'tommy-hilfiger-1792009-nam', 1, 3, 26, 'tommy-hilfiger-1792009-nam.jpg', 2040000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(31, 'tommy-hilfiger-1792015-nam', 1, 3, 28, 'tommy-hilfiger-1792015-nam.jpg', 1938000, 'Mẫu phiên bản mạ vàng với mẫu kim chỉ nổi bật trên mặt số size 41.7mm đi kèm thiết kế 2 núm vặn điều chỉnh, vỏ máy kim loại mạ bạc kiểu dáng dày dặn của bô máy cơ.'),
(32, 'tommy-1782337-nu', 2, 3, 20, 'tommy-1782337-nu.jpg', 1938000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(33, 'tommy-1791807-nam', 1, 3, 28, 'tommy-1791807-nam.jpg', 2040000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(34, 'tommy-hilfiger-1782511-nu', 2, 3, 30, 'tommy-hilfiger-1782511-nu.jpg', 1900000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(35, 'tommy-hilfiger-1792009-nam', 1, 3, 25, 'tommy-hilfiger-1792009-nam.jpg', 1900000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(36, 'tommy-hilfiger-1792015-nam', 1, 3, 25, 'tommy-hilfiger-1792015-nam.jpg', 2040000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(37, 'g-shock-ga-2100-1a3dr-nam', 1, 2, 27, 'g-shock-ga-2100-1a3dr-nam.jpg', 3150000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(38, 'g-shock-ga-2100-1a4dr-nam', 1, 2, 20, 'g-shock-ga-2100-1a4dr-nam.jpg', 3150000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(39, 'g-shock-gm-5600-1dr-nam', 1, 2, 28, 'g-shock-gm-5600-1dr-nam.jpg', 3248000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(40, 'g-shock-gm-5600g-9dr-nam', 1, 2, 10, 'g-shock-gm-5600g-9dr-nam.jpg', 3358880, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(41, 'g-shock-gm-5600sg-9dr-nam', 1, 2, 29, 'g-shock-gm-5600sg-9dr-nam.jpg', 3150000, 'Mẫu Casio đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(42, 'g-shock-gma-s2100ba-4adr-nu', 2, 2, 20, 'g-shock-gma-s2100ba-4adr-nu.jpg', 3150000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(43, 'g-shock-gm-s2100-3adr-nu', 2, 2, 18, 'g-shock-gm-s2100-3adr-nu.jpg', 3150000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(44, 'g-shock-gm-s2100pg-1a4dr-nu', 2, 2, 20, 'g-shock-gm-s2100pg-1a4dr-nu.jpg', 3150000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(45, 'g-shock-mtg-b1000tj-1adr-nam', 1, 2, 19, 'g-shock-mtg-b1000tj-1adr-nam.jpg', 4480000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(49, 'casio-ltp-v006d-7b2udf-nu', 2, 1, 30, 'casio-ltp-v006d-7b2udf-nu.jpg', 2388000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(50, 'g-shock-gma-s2100ba-4adr-nu', 2, 2, 29, 'g-shock-gma-s2100ba-4adr-nu.jpg', 2128000, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(51, 'casio-mtp-e715l-1avdf-nam', 1, 1, 30, 'casio-mtp-e715l-1avdf-nam.jpg', 2028780, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(52, 'g-shock-gm-s2100-3adr-nu', 2, 2, 25, 'g-shock-gm-s2100-3adr-nu.jpg', 2198900, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(53, 'g-shock-mtg-b1000tj-1adr-nam', 1, 2, 15, 'g-shock-mtg-b1000tj-1adr-nam.jpg', 2088900, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(54, 'casio-ltp-v006d-7b2udf-nu', 2, 1, 32, 'casio-ltp-v006d-7b2udf-nu.jpg', 1224000, 'Mẫu phiên bản mặt kính chất liệu kính Sapphire với kích thước nam tính 40mm, kết hợp cùng mẫu dây đeo kim loại dây vàng demi phong cách thời trang sang trọng.'),
(55, 'g-shock-gma-s2100ba-4adr-nu', 2, 2, 30, 'g-shock-gma-s2100ba-4adr-nu.jpg', 2198900, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.'),
(56, 'g-shock-gm-s2100-3adr-nu', 2, 2, 29, 'g-shock-ga-2100-1a3dr-nam.jpg', 1978900, 'Mẫu đôi thiết kế mỏng thời trang với phần vỏ máy pin chỉ 8mm, mặt số trắng kiểu dáng đơn giản 3 kim 1 lịch.');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNV` int(11) NOT NULL,
  `TaiKhoan` varchar(255) NOT NULL,
  `MatKhau` varchar(255) NOT NULL,
  `Quyen` varchar(100) NOT NULL,
  `TrangThai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`MaNV`, `TaiKhoan`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
(1, 'admin', 'admin', 'Quản trị viên', 1),
(2, 'nv01', 'nv01', 'Nhân viên nhập hàng', 1),
(3, 'quanly', 'quanly', 'Quản lý', 1),
(4, 'nv02', 'nv02', 'Nhân viên bán hàng', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD KEY `cthoadon_ibfk_1` (`MaHD`),
  ADD KEY `cthoadon_ibfk_2` (`MaSP`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `ctphieunhap_ibfk_1` (`MaPN`),
  ADD KEY `ctphieunhap_ibfk_2` (`MaSP`);

--
-- Indexes for table `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`MaGG`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `hoadon_ibfk_1` (`MaKH`),
  ADD KEY `hoadon_ibfk_2` (`MaNV`),
  ADD KEY `hoadon_ibfk_3` (`MaGG`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `fk_chucvu` (`ChucVu`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`Quyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `phieunhap_ibfk_1` (`MaNCC`),
  ADD KEY `phieunhap_ibfk_2` (`MaNV`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `sp_ibfk_1` (`MaLoai`),
  ADD KEY `sp_ibfk_2` (`MaNCC`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `taikhoan_ibfk_2` (`Quyen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `MaGG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`MaGG`) REFERENCES `giamgia` (`MaGG`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `fk_chucvu` FOREIGN KEY (`ChucVu`) REFERENCES `phanquyen` (`Quyen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sp_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sp_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`Quyen`) REFERENCES `phanquyen` (`Quyen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;


# Intro
Dồ án OOP nhóm 11 lớp 63it2 DHXD
Đề tài quản lý phòng tập Gym
Xây dựng theo mô hình DAO

# Chuẩn hóa Database
+ KhachHang (MaKH, Ten, SDT, DiaChi, NamSinh, GioiTinh, CMND)
+ The (MaThe, MaKH, TrangThai, NgayBD, MaDichVu)
+ CTThe (MaThe, ThoiDiemSuDung, )
+ CTDichVu (MaDV, Ten, ThoiGian, Gia)
+ NhanVien (MaNV, Ten, CMND, DiaChi ,SDT, ViTri, NamSinh, GioiTinh)
+ Login (MaNV, TK, MK)
+ HangHoa (MaHang, Ten, Gia, HSD, SoLuong, DVT)
+ ThietBi (MaTB, Ten, NSX, SoLuong, TinhTrang, NgayNhap, GiaNhap)
+ HoaDonTap (MaHoaDon, Ngay, MaNV, MaKH)
+ CTHoaDonTap (MaKH, MaDV, Gia)
+ HoaDonHang (MaHDH, Ngay, MaNV, TenKH, SDT)
+ CTHoaDonHang (MaHDH,TenHang, SoLuong, DVT)
+ HoaDonNhap (MaDonNHap, Ngay, MaNV)
+ CTHoaDonNhap (MaDonNhap, MaSP, TenSP, NhaCungCap, Gia, SoLuong)

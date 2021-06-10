create database gymer_oop

go

create table tbl_KhachHang (
	MaKH int not null,
    Ten nvarchar(256) not null,
    CMND varchar(15) not null,
    SDT varchar(10) not null,
    DiaChi nvarchar(512),
    NamSinh int not null,
    GioiTinh boolean not null,
    primary key (MaKH)
);
create table tbl_DichVu (
	MaDV int not null,
    Ten nvarchar(256) not null,
    ThoiGian int not null,
    Gia int not null,
    primary key (MaDV)
);
create table tbl_The (
	MaThe int not null,
    MaKH int not null,
    TrangThai boolean,
    NgayBD date not null,
    MaDV int not null,
    primary key (MaThe),
    foreign key (MaKH) references tbl_KhachHang (MaKH)
);
create table tbl_CTThe (
    MaThe int not null,
    ThoiDiemSuDung datetime,
    foreign key (MaThe) references tbl_The (MaThe)
);
create table tbl_NhanVien (
	MaNV int not null,
    Ten nvarchar (256) not null,
    CMND varchar(15) not null,
    SDT varchar(10) not null,
    DiaChi nvarchar (512) not null,
    ViTri nvarchar (30) not null,
    NamSinh int not null,
    GioiTinh boolean,
    primary key (MaNV)
);
create table tbl_Login (
	MaNV int not null,
    TK varchar (30) UNIQUE not null,
    hashed_code varchar (50) not null,
    primary key (TK),
    foreign key (MaNV) references tbl_NhanVien (MaNV)
);
create table tbl_HangHoa (
	MaHang int not null,
    Ten nvarchar (256) not null,
    Gia int not null,
    SoLuong int not null,
    DVT nvarchar(10) not null,
    HSD date not null,
    primary key (MaHang)
);
create table tbl_ThietBi (
	MaTB int not null,
    Ten nvarchar (256) not null,
    NSX nvarchar (256) not null,
    SoLuong int not null,
    TinhTrang nvarchar(100) not null,
    NgayNhap date,
    GiaNhap int,
    primary key (MaTB)
);
create table tbl_HoaDonTap (
	MaHoaDonTap int not null,
    Ngay date not null,
    MaNV int not null,
    MaKH int not null,
    TongTien int not null,
    primary key (MaHoaDonTap),
    foreign key (MaNV) references tbl_NhanVien(MaNV),
    foreign key (MaKH) references tbl_KhachHang(MaKH)
);
create table tbl_HoaDonHang (
	MaHoaDonHang int not null,
    Ngay date not null,
    TenKH nvarchar (256) not null,
    SDT varchar (10) not null,
    MaNV int not null,
    TongTien int not null,
    primary key (MaHoaDonHang),
    foreign key (MaNV) references tbl_NhanVien(MaNV)
);
create table tbl_HoaDonNhap (
	MaHoaDonNhap int not null,
    Ngay date not null,
    MaNV int not null,
    TongTien int not null,
    primary key (MaHoaDonNhap),
    foreign key (MaNV) references tbl_NhanVien(MaNV)
);
create table tbl_CTHDNhap (
    MaHoaDonNhap int not null,
    MaHang int not null,
    TenHang nvarchar(256) not null,
    NhaCungCap nvarchar (265) not null,
    Gia int not null,
    SoLuong int not null,
    DVT nvarchar(10) not null,
    foreign key (MaHoaDonNhap) references tbl_HoaDonNhap (MaHoaDonNhap),
    foreign key (MaHang) references tbl_HangHoa (MaHang)
);
create table tbl_CTHDHang (
	MaHoaDonHang int not null,
    MaHang int not null,
    SoLuong int not null,
    foreign key (MaHoaDonHang) references tbl_HoaDonHang (MaHoaDonHang),
    foreign key (MaHang) references tbl_HangHoa (MaHang)
);
create table tbl_CTHDTap (
    MaHoaDonTap int not null,
    MaDV int not null,
    foreign key (MaDV) references tbl_DichVu(MaDV),
    foreign key (MaHoaDonTap) references tbl_HoaDonTap(MaHoaDonTap)
);
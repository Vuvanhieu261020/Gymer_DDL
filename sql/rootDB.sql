create database gymer_oop

go

create table tbl_khachhang (
	MaKH int not null,
    Ten nvarchar(256) not null,
    CMND varchar(15) not null,
    SDT varchar(10) not null,
    DiaChi nvarchar(512),
    NamSinh int not null,
    GioiTinh boolean not null,
    delete_flag bool not null,
    primary key (MaKH)
);
create table tbl_dichvu (
	MaDV int not null,
    Ten nvarchar(256) not null,
    ThoiGian int not null,
    Gia int not null,
    delete_flag bool not null,
    primary key (MaDV)
);
create table tbl_the (
	MaThe int not null,
    MaKH int not null,
    TrangThai boolean,
    NgayBD date not null,
    MaDV int not null,
    primary key (MaThe),
    foreign key (MaKH) references tbl_khachhang (MaKH)
);
create table tbl_ctthe (
    MaThe int not null,
    ThoiDiemSuDung datetime,
    foreign key (MaThe) references tbl_the (MaThe)
);
create table tbl_nhanvien (
	MaNV int not null,
    Ten nvarchar (256) not null,
    CMND varchar(15) not null,
    SDT varchar(10) not null,
    DiaChi nvarchar (512) not null,
    ViTri nvarchar (30) not null,
    NamSinh int not null,
    GioiTinh boolean,
    delete_flag bool not null,
    primary key (MaNV)
);
create table tbl_login (
	MaNV int not null,
    TK varchar (30) UNIQUE not null,
    hashed_code varchar (50) not null,
    primary key (TK),
    foreign key (MaNV) references tbl_nhanvien (MaNV)
);
create table tbl_hanghoa (
	MaHang int not null,
    Ten nvarchar (256) not null,
    Gia int not null,
    SoLuong int not null,
    DVT nvarchar(10) not null,
    HSD date not null,
    delete_flag bool not null,
    primary key (MaHang)
);
create table tbl_thietbi (
	MaTB int not null,
    Ten nvarchar (256) not null,
    NSX nvarchar (256) not null,
    SoLuong int not null,
    TinhTrang nvarchar(100) not null,
    NgayNhap date,
    GiaNhap int,
    primary key (MaTB)
);
create table tbl_hoadontap (
	MaHoaDonTap int not null,
    Ngay date not null,
    MaNV int not null,
    MaKH int not null,
    TongTien int not null,
    primary key (MaHoaDonTap),
    foreign key (MaNV) references tbl_nhanvien(MaNV),
    foreign key (MaKH) references tbl_khachhang(MaKH)
);
create table tbl_hoadonhang (
	MaHoaDonHang int not null,
    Ngay date not null,
    TenKH nvarchar (256) not null,
    SDT varchar (10) not null,
    MaNV int not null,
    TongTien int not null,
    primary key (MaHoaDonHang),
    foreign key (MaNV) references tbl_nhanvien(MaNV)
);
create table tbl_HoaDonNhap (
	MaHoaDonNhap int not null,
    Ngay date not null,
    MaNV int not null,
    TongTien int not null,
    primary key (MaHoaDonNhap),
    foreign key (MaNV) references tbl_nhanvien(MaNV)
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
    foreign key (MaHang) references tbl_hanghoa (MaHang)
);
create table tbl_cthdhang (
	MaHoaDonHang int not null,
    MaHang int not null,
    SoLuong int not null,
    foreign key (MaHoaDonHang) references tbl_hoadonhang (MaHoaDonHang),
    foreign key (MaHang) references tbl_hanghoa (MaHang)
);
create table tbl_cthdtap (
    MaHoaDonTap int not null,
    MaDV int not null,
    foreign key (MaDV) references tbl_dichvu(MaDV),
    foreign key (MaHoaDonTap) references tbl_hoadontap(MaHoaDonTap)
);

USE [master]
GO
/****** Object:  Database [QLMuaBanXe]    Script Date: 6/30/2020 11:10:21 AM ******/
CREATE DATABASE [QLMuaBanXe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLMuaBanXe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLMuaBanXe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLMuaBanXe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLMuaBanXe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLMuaBanXe] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLMuaBanXe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLMuaBanXe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLMuaBanXe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLMuaBanXe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLMuaBanXe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLMuaBanXe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLMuaBanXe] SET  MULTI_USER 
GO
ALTER DATABASE [QLMuaBanXe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLMuaBanXe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLMuaBanXe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLMuaBanXe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLMuaBanXe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLMuaBanXe] SET QUERY_STORE = OFF
GO
USE [QLMuaBanXe]
GO
/****** Object:  Table [dbo].[BaoHanh]    Script Date: 6/30/2020 11:10:21 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaoHanh](
	[MaBaoHanh] [nchar](10) NOT NULL,
	[TenKhachHang] [nchar](30) NULL,
	[NguoikhiemTra] [nvarchar](20) NULL,
	[LinhKien] [nchar](10) NULL,
	[GiaTien] [float] NULL,
	[LiDo] [nchar](10) NULL,
 CONSTRAINT [PK_BaoHanh] PRIMARY KEY CLUSTERED 
(
	[MaBaoHanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/30/2020 11:10:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] NOT NULL,
	[MaXe] [int] NULL,
	[MaKH] [nchar](30) NULL,
	[NgayGiaoDich] [nvarchar](50) NULL,
	[SoLanTra] [int] NULL,
	[TenNhanVien] [nvarchar](20) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/30/2020 11:10:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nchar](30) NOT NULL,
	[TenKH] [nchar](30) NOT NULL,
	[DiaChi] [nchar](10) NULL,
	[SDT] [int] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVienHanhChinh]    Script Date: 6/30/2020 11:10:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVienHanhChinh](
	[MaNV] [int] NULL,
	[TenNV] [nvarchar](20) NOT NULL,
	[ChucVu] [nvarchar](20) NULL,
	[PhongBan] [nvarchar](20) NULL,
	[TrinhdoHV] [nvarchar](20) NULL,
 CONSTRAINT [PK_NhanVienHanhChinh] PRIMARY KEY CLUSTERED 
(
	[TenNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVienKyTHuat]    Script Date: 6/30/2020 11:10:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVienKyTHuat](
	[TenNhanVien] [nvarchar](20) NOT NULL,
	[ChucVu] [nvarchar](10) NULL,
	[BacTho] [int] NULL,
	[SoNamKinhNghiem] [int] NULL,
 CONSTRAINT [PK_NhanVienKyTHuat] PRIMARY KEY CLUSTERED 
(
	[TenNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xe]    Script Date: 6/30/2020 11:10:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[MaXe] [int] NOT NULL,
	[TenXe] [char](20) NULL,
	[NuocSanXuat] [char](20) NULL,
	[LoaiXe] [char](20) NULL,
	[SoPK] [int] NULL,
	[SoKhung] [int] NULL,
	[SoLuong] [int] NULL,
	[MauXe] [char](20) NULL,
	[GiaXe] [float] NULL,
 CONSTRAINT [PK_Xe] PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaXe], [MaKH], [NgayGiaoDich], [SoLanTra], [TenNhanVien]) VALUES (1, 1, N'1                             ', N'1', 1, N'NguyenHuuThang')
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'1                             ', N'B                             ', N'LO        ', 154521)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT]) VALUES (N'KH1234                        ', N'A                             ', N'le        ', 9988755)
GO
INSERT [dbo].[NhanVienHanhChinh] ([MaNV], [TenNV], [ChucVu], [PhongBan], [TrinhdoHV]) VALUES (1234, N'NguyenHuuThang', N'GD', N'Muaban', N'DaiHoc')
INSERT [dbo].[NhanVienHanhChinh] ([MaNV], [TenNV], [ChucVu], [PhongBan], [TrinhdoHV]) VALUES (1144477, N'NguyenNhocBaoDuy', N'PhoGiamDoc', N'TuVan', N'DaiHoc')
INSERT [dbo].[NhanVienHanhChinh] ([MaNV], [TenNV], [ChucVu], [PhongBan], [TrinhdoHV]) VALUES (1245777, N'PhamVanA', N'NhanVien', N'TuVan', N'CaoDang')
GO
INSERT [dbo].[Xe] ([MaXe], [TenXe], [NuocSanXuat], [LoaiXe], [SoPK], [SoKhung], [SoLuong], [MauXe], [GiaXe]) VALUES (1, N'SIRIUS              ', N'Anh                 ', N'SIRIUS              ', 123, 123, 3, N'Vang                ', 123333)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [NuocSanXuat], [LoaiXe], [SoPK], [SoKhung], [SoLuong], [MauXe], [GiaXe]) VALUES (2, N'1                   ', N'1                   ', N'1                   ', 1, 1, 1, N'1                   ', 1)
INSERT [dbo].[Xe] ([MaXe], [TenXe], [NuocSanXuat], [LoaiXe], [SoPK], [SoKhung], [SoLuong], [MauXe], [GiaXe]) VALUES (123, N'SIrius              ', N'NhatBan             ', N'so                  ', 120, 154, 3, N'Trang               ', 200000)
GO
ALTER TABLE [dbo].[BaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_BaoHanh_KhachHang] FOREIGN KEY([TenKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[BaoHanh] CHECK CONSTRAINT [FK_BaoHanh_KhachHang]
GO
ALTER TABLE [dbo].[BaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_BaoHanh_NhanVienKyTHuat] FOREIGN KEY([NguoikhiemTra])
REFERENCES [dbo].[NhanVienKyTHuat] ([TenNhanVien])
GO
ALTER TABLE [dbo].[BaoHanh] CHECK CONSTRAINT [FK_BaoHanh_NhanVienKyTHuat]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang1] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVienHanhChinh] FOREIGN KEY([TenNhanVien])
REFERENCES [dbo].[NhanVienHanhChinh] ([TenNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVienHanhChinh]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Xe] FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Xe]
GO
USE [master]
GO
ALTER DATABASE [QLMuaBanXe] SET  READ_WRITE 
GO

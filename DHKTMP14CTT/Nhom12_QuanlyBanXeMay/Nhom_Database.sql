USE [master]
GO
/****** Object:  Database [QuanLyXeMay]    Script Date: 6/30/2020 11:04:51 AM ******/
CREATE DATABASE [QuanLyXeMay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyXeMay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyXeMay.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyXeMay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyXeMay_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyXeMay] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyXeMay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyXeMay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyXeMay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyXeMay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyXeMay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyXeMay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyXeMay] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyXeMay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyXeMay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyXeMay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyXeMay] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyXeMay] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyXeMay', N'ON'
GO
ALTER DATABASE [QuanLyXeMay] SET QUERY_STORE = OFF
GO
USE [QuanLyXeMay]
GO
/****** Object:  User [QLBH]    Script Date: 6/30/2020 11:04:51 AM ******/
CREATE USER [QLBH] FOR LOGIN [QLBH] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[HangXe]    Script Date: 6/30/2020 11:04:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangXe](
	[MaHangXe] [varchar](50) NOT NULL,
	[TenHangXe] [nvarchar](50) NULL,
	[QuocGia] [nvarchar](50) NULL,
 CONSTRAINT [PK_HangXe] PRIMARY KEY CLUSTERED 
(
	[MaHangXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/30/2020 11:04:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](50) NOT NULL,
	[MaKH] [varchar](50) NULL,
	[MaNV] [varchar](50) NULL,
	[MaXe] [varchar](50) NULL,
	[NgayLap] [date] NULL,
	[GiaBan] [money] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/30/2020 11:04:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [varchar](50) NOT NULL,
	[HoTenDem] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SoDienThoai] [varchar](15) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/30/2020 11:04:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [varchar](50) NOT NULL,
	[HoTenDem] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[SoDienThoai] [varchar](15) NULL,
	[NamKinhNghiem] [int] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XeMay]    Script Date: 6/30/2020 11:04:52 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XeMay](
	[MaXe] [varchar](50) NOT NULL,
	[MaHangXe] [varchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
	[LoaiXe] [bit] NULL,
	[SoPhanKhoi] [int] NULL,
	[TenXe] [nvarchar](50) NULL,
 CONSTRAINT [PK_XeMay] PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe], [QuocGia]) VALUES (N'A123', N'Honda', N'Nhật Bản')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe], [QuocGia]) VALUES (N'A134', N'SYM', N'Trung Quốc')
INSERT [dbo].[HangXe] ([MaHangXe], [TenHangXe], [QuocGia]) VALUES (N'A234', N'Suzuki', N'Nhật Bản')
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'', N'duc', N'duc', N'ben tre', N'0941962957')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'18054321', N'Nguyễn Văn', N'A', N'tp-HCM', N'143434543453')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'18054322', N'Phạm Văn', N'B', N'Bình Dương', N'463453435')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'82bb2888-8dfd-49da-b915-05f2ae0ee478', N'12', N'12', N'12', N'12')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'9c508a5c-a21b-4d3a-9a76-3e266371fe38', N'123', N'123', N'123', N'123')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'9ca090e1-8364-45fb-8a90-9540ee17fe86', N'hg', N'hg', N'jhkhjk', N'3')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'be10ba19-3406-4f53-9d79-dc5034fd6366', N'duc', N'duc', N'ben tre', N'0941962957')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'cdfd744c-1762-4ed0-822f-2df98e45a25f', N'Trường Đức Hoàn', N'Hoàn', N'Bình Dương', N'1241241242')
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTenDem], [Ten], [DiaChi], [SoDienThoai]) VALUES (N'df8b4fc8-b927-4f9e-8b03-8bc0835cfd3d', N'e332', N'e332', N'sd', N'12')
GO
INSERT [dbo].[NhanVien] ([MaNhanVien], [HoTenDem], [Ten], [SoDienThoai], [NamKinhNghiem]) VALUES (N'18054321', N'Trương Đức', N'Hoàn', N'123434354', 2)
INSERT [dbo].[NhanVien] ([MaNhanVien], [HoTenDem], [Ten], [SoDienThoai], [NamKinhNghiem]) VALUES (N'18054322', N'Hà', N'Huy', N'45342312', 5)
GO
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'123', N'A123', N'Cam', 0, 90, N'Exciter')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'18054321', N'A234', N'Cam', 1, 150, N'Exciter')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'A123', N'A123', N'Đỏ', 1, 110, N'Vision')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'A124', N'A134', N'Xanh', 1, 125, N'atila')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'adfwer23423423', N'A123', N'Cam', 0, 90, N'Exciter')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'asfasfqwr24342342', N'A234', N'Cam', 0, 90, N'Exciter')
INSERT [dbo].[XeMay] ([MaXe], [MaHangXe], [MauSac], [LoaiXe], [SoPhanKhoi], [TenXe]) VALUES (N'dfsd34234', N'A123', N'Cam', 0, 90, N'Exciter')
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_XeMay] FOREIGN KEY([MaXe])
REFERENCES [dbo].[XeMay] ([MaXe])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_XeMay]
GO
ALTER TABLE [dbo].[XeMay]  WITH CHECK ADD  CONSTRAINT [FK_XeMay_HangXe] FOREIGN KEY([MaHangXe])
REFERENCES [dbo].[HangXe] ([MaHangXe])
GO
ALTER TABLE [dbo].[XeMay] CHECK CONSTRAINT [FK_XeMay_HangXe]
GO
USE [master]
GO
ALTER DATABASE [QuanLyXeMay] SET  READ_WRITE 
GO

USE [master]
GO
/****** Object:  Database [QuanLyLaoDong]  ******/
CREATE DATABASE [QuanLyLaoDong]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyLaoDong', FILENAME = N'C:\Users\httth\Downloads\QuanLyLaoDong.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyLaoDong_log', FILENAME = N'C:\Users\httth\Downloads\QuanLyLaoDong_log.ldf' , SIZE = 2560KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyLaoDong] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyLaoDong].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyLaoDong] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyLaoDong] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyLaoDong] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyLaoDong] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyLaoDong] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyLaoDong] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyLaoDong] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyLaoDong] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyLaoDong] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyLaoDong] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyLaoDong]
GO
/****** Object:  Table [dbo].[ChuyenMon]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuyenMon](
	[maChuyenMon] [nvarchar](10) NOT NULL,
	[tenChuyenMon] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[maChuyenMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongTrinh]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongTrinh](
	[maCongTrinh] [nchar](10) NOT NULL,
	[tenCongTrinh] [nchar](50) NOT NULL,
	[loaiCongTrinh] [nchar](50) NOT NULL,
	[ngayKhoiCong] [date] NOT NULL,
	[ngayDKHoanThanh] [date] NOT NULL,
	[tinhTP] [nchar](50) NOT NULL,
	[quanHuyen] [nchar](50) NOT NULL,
	[phuongXa] [nchar](50) NOT NULL,
	[trangThai] [nchar](15) NOT NULL,
 CONSTRAINT [PK_CongTrinh] PRIMARY KEY CLUSTERED 
(
	[maCongTrinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DiaChi]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaChi](
	[tinhTP] [nchar](50) NOT NULL,
	[quanHuyen] [nchar](50) NOT NULL,
	[phuongXa] [nchar](50) NOT NULL,
 CONSTRAINT [PK_DiaChi] PRIMARY KEY CLUSTERED 
(
	[tinhTP] ASC,
	[quanHuyen] ASC,
	[phuongXa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LaoDong]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LaoDong](
	[maLaoDong] [nchar](10) NOT NULL,
	[tenLaoDong] [nchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[SDT] [nchar](10) NOT NULL,
	[CMND] [nchar](12) NOT NULL,
	[tinhTP] [nchar](50) NOT NULL,
	[quanHuyen] [nchar](50) NOT NULL,
	[phuongXa] [nchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[maChuyenMon] [nvarchar](10) NULL,
	[trangThai] [bit] NULL,
 CONSTRAINT [PK_LaoDong] PRIMARY KEY CLUSTERED 
(
	[maLaoDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuanLy]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuanLy](
	[maQuanLy] [nchar](8) NOT NULL,
	[tenQuanLy] [nchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[sdt] [nchar](10) NOT NULL,
	[matKhau] [nchar](20) NOT NULL,
 CONSTRAINT [PK_NhanSu] PRIMARY KEY CLUSTERED 
(
	[maQuanLy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM001', N'Phụ hồ')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM002', N'Thợ xây')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM003', N'Thợ điện')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM004', N'Thợ nước')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM005', N'Tài xế máy xúc')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM006', N'Tài xế xe tải')
INSERT [dbo].[ChuyenMon] ([maChuyenMon], [tenChuyenMon]) VALUES (N'CM007', N'Vệ sinh')
GO

INSERT [dbo].[CongTrinh] ([maCongTrinh], [tenCongTrinh], [loaiCongTrinh], [ngayKhoiCong], [ngayDKHoanThanh], [tinhTP], [quanHuyen], [phuongXa], [trangThai]) VALUES (N'CT00000021', N'Xây dựng mới trường mầm non Trường Thọ', N'Dự án đầu tư', CAST(N'2022-12-04' AS Date), CAST(N'2022-01-24' AS Date), N'Thành phố Hồ Chí Minh', N'Quận Bình Thạnh', N'Phường 14', N'Chưa hoàn thành')
INSERT [dbo].[CongTrinh] ([maCongTrinh], [tenCongTrinh], [loaiCongTrinh], [ngayKhoiCong], [ngayDKHoanThanh], [tinhTP], [quanHuyen], [phuongXa], [trangThai]) VALUES (N'CT00000023', N'Trường Mầm non Tuổi Thơ Phường 5 Quận 8', N'Dự án đầu tư', CAST(N'2022-12-09' AS Date), CAST(N'2022-03-23' AS Date), N'Thành phố Hồ Chí Minh', N'Huyện Bình Chánh', N'Xã Tân Quý Tây', N'Chưa hoàn thành')
INSERT [dbo].[CongTrinh] ([maCongTrinh], [tenCongTrinh], [loaiCongTrinh], [ngayKhoiCong], [ngayDKHoanThanh], [tinhTP], [quanHuyen], [phuongXa], [trangThai]) VALUES (N'CT00000024', N'Xây dựng Văn phòng Thanh niên', N'Dự án đầu tư', CAST(N'2022-10-19' AS Date), CAST(N'2022-11-14' AS Date), N'Thành phố Hồ Chí Minh', N'Quận Phú Nhuận', N'Phường 05', N'Chưa hoàn thành')
INSERT [dbo].[CongTrinh] ([maCongTrinh], [tenCongTrinh], [loaiCongTrinh], [ngayKhoiCong], [ngayDKHoanThanh], [tinhTP], [quanHuyen], [phuongXa], [trangThai]) VALUES (N'CT00000025', N'Xây dựng Trường tiểu học An Phú 2', N'Dự án đầu tư', CAST(N'2022-06-16' AS Date), CAST(N'2022-08-15' AS Date), N'Thành phố Hồ Chí Minh', N'Quận Phú Nhuận', N'Phường 11', N'Chưa hoàn thành')
GO
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Đà Nẵng', N'Quận Cẩm Lệ', N'Phường Hòa An')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Đà Nẵng', N'Quận Cẩm Lệ', N'Phường Hòa Phát')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Đà Nẵng', N'Quận Cẩm Lệ', N'Phường Hòa Thọ Đông')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Đà Nẵng', N'Quận Cẩm Lệ', N'Phường Hòa Thọ Tây')
GO

INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Hà Nội', N'Huyện Chương Mỹ', N'Xã Thụy Hương')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Hà Nội', N'Huyện Chương Mỹ', N'Xã Thủy Xuân Tiên')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Hà Nội', N'Huyện Chương Mỹ', N'Xã Tiên Phương')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Thành phố Hà Nội', N'Huyện Chương Mỹ', N'Xã Tốt Động')
GO


INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Phường Cầu Thia')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Phường Pú Trạng')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Phường Tân An')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Phường Trung Tâm')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Xã Nghĩa An')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Xã Nghĩa Lợi')
INSERT [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa]) VALUES (N'Tỉnh Yên Bái', N'Thị xã Nghĩa Lộ', N'Xã Nghĩa Phúc')
GO
INSERT [dbo].[LaoDong] ([maLaoDong], [tenLaoDong], [ngaySinh], [SDT], [CMND], [tinhTP], [quanHuyen], [phuongXa], [gioiTinh], [maChuyenMon], [trangThai]) VALUES (N'LD00000043', N'LƯƠNG THÀNH PHÚC', CAST(N'1995-10-09' AS Date), N'0312128999', N'441040662332', N'Tỉnh Đắk Nông', N'Huyện Krông Nô', N'Xã Tân Thành', 1, N'CM005', 1)
INSERT [dbo].[LaoDong] ([maLaoDong], [tenLaoDong], [ngaySinh], [SDT], [CMND], [tinhTP], [quanHuyen], [phuongXa], [gioiTinh], [maChuyenMon], [trangThai]) VALUES (N'LD00000044', N'NGUYỄN NGỌC ĐẰNG', CAST(N'2000-10-09' AS Date), N'0312132175', N'812482373   ', N'Tỉnh Phú Thọ', N'Huyện Phù Ninh', N'Xã Bình Bộ', 1, N'CM002', 1)
INSERT [dbo].[LaoDong] ([maLaoDong], [tenLaoDong], [ngaySinh], [SDT], [CMND], [tinhTP], [quanHuyen], [phuongXa], [gioiTinh], [maChuyenMon], [trangThai]) VALUES (N'LD00000045', N'HUỲNH VĂN NGÀ', CAST(N'1969-08-12' AS Date), N'0312136921', N'150988284   ', N'Thành phố Hà Nội', N'Quận Cầu Giấy', N'Phường Nghĩa Đô', 1, N'CM006', 1)
INSERT [dbo].[LaoDong] ([maLaoDong], [tenLaoDong], [ngaySinh], [SDT], [CMND], [tinhTP], [quanHuyen], [phuongXa], [gioiTinh], [maChuyenMon], [trangThai]) VALUES (N'LD00000046', N'TRỊNH HẢI ĐĂNG', CAST(N'1967-11-10' AS Date), N'0312138683', N'676307137   ', N'Thành phố Hải Phòng', N'Quận Kiến An', N'Phường Tràng Minh', 1, N'CM006', 1)

GO
INSERT [dbo].[QuanLy] ([maQuanLy], [tenQuanLy], [ngaySinh], [sdt], [matKhau]) VALUES (N'QL000000', N'HOÀNG TỐ THÙY', CAST(N'2001-09-09' AS Date), N'0768817617', N'12345678')
INSERT [dbo].[QuanLy] ([maQuanLy], [tenQuanLy], [ngaySinh], [sdt], [matKhau]) VALUES (N'QL000001', N'PHAN NGUYỄN HOÀI HIỆP', CAST(N'2001-01-01' AS Date), N'0368795645', N'12345678')
INSERT [dbo].[QuanLy] ([maQuanLy], [tenQuanLy], [ngaySinh], [sdt], [matKhau]) VALUES (N'QL000002', N'HUỲNH NGÔ PHÚC HẬU', CAST(N'2001-09-08' AS Date), N'0379862310', N'12345678')
INSERT [dbo].[QuanLy] ([maQuanLy], [tenQuanLy], [ngaySinh], [sdt], [matKhau]) VALUES (N'QL000003', N'LÊ THIỆN NGHĨA', CAST(N'2001-01-04' AS Date), N'0795815992', N'12345678')
   
GO
ALTER TABLE [dbo].[CongTrinh]  WITH CHECK ADD  CONSTRAINT [FK_CongTrinh_DiaChi] FOREIGN KEY([tinhTP], [quanHuyen], [phuongXa])
REFERENCES [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa])
GO
ALTER TABLE [dbo].[CongTrinh] CHECK CONSTRAINT [FK_CongTrinh_DiaChi]
GO
ALTER TABLE [dbo].[LaoDong]  WITH CHECK ADD  CONSTRAINT [FK_LaoDong_ChuyenMon] FOREIGN KEY([maChuyenMon])
REFERENCES [dbo].[ChuyenMon] ([maChuyenMon])
GO
ALTER TABLE [dbo].[LaoDong] CHECK CONSTRAINT [FK_LaoDong_ChuyenMon]
GO
ALTER TABLE [dbo].[LaoDong]  WITH CHECK ADD  CONSTRAINT [FK_LaoDong_DiaChi] FOREIGN KEY([tinhTP], [quanHuyen], [phuongXa])
REFERENCES [dbo].[DiaChi] ([tinhTP], [quanHuyen], [phuongXa])
GO
ALTER TABLE [dbo].[LaoDong] CHECK CONSTRAINT [FK_LaoDong_DiaChi]
GO
USE [master]
GO
ALTER DATABASE [QuanLyLaoDong] SET  READ_WRITE 
GO

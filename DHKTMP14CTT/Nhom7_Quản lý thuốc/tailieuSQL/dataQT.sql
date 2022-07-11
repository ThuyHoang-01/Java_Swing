USE [master]
GO
/****** Object:  Database [QLQT]    Script Date: 30/06/2020 8:29:34 SA ******/
CREATE DATABASE [QLQT]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLQT_DATA', FILENAME = N'D:\PhamAnhTuan_JavaNam2\QLBQT_DATA.MDF' , SIZE = 6144KB , MAXSIZE = 20480KB , FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLBH2_LOG', FILENAME = N'D:\PhamAnhTuan_JavaNam2\QLQT_LOG.LDF' , SIZE = 5120KB , MAXSIZE = 14336KB , FILEGROWTH = 1024KB )
GO
ALTER DATABASE [QLQT] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLQT].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLQT] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLQT] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLQT] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLQT] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLQT] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLQT] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLQT] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLQT] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLQT] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLQT] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLQT] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLQT] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLQT] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLQT] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLQT] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLQT] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLQT] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLQT] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLQT] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLQT] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLQT] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLQT] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLQT] SET RECOVERY FULL 
GO
ALTER DATABASE [QLQT] SET  MULTI_USER 
GO
ALTER DATABASE [QLQT] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLQT] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLQT] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLQT] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLQT] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLQT', N'ON'
GO
USE [QLQT]
GO
/****** Object:  Table [dbo].[DonThuoc]    Script Date: 30/06/2020 8:29:34 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DonThuoc](
	[makhachhang] [char](5) NOT NULL,
	[mathuoc] [char](5) NOT NULL,
	[soluong] [int] NOT NULL,
	[ngaylapdonthuoc] [date] NOT NULL,
 CONSTRAINT [PK_hailoaithuoc] PRIMARY KEY CLUSTERED 
(
	[makhachhang] ASC,
	[mathuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 30/06/2020 8:29:34 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[makhachhang] [char](5) NOT NULL,
	[tenkhachhang] [nvarchar](40) NULL,
	[diachi] [nvarchar](120) NULL,
	[sodienthoai] [char](10) NULL,
	[nguyennhanbenh] [nvarchar](120) NULL,
	[ngaydenquaythuoc] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[makhachhang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 30/06/2020 8:29:34 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Thuoc](
	[mathuoc] [char](5) NOT NULL,
	[tenthuoc] [nvarchar](40) NULL,
	[donvithuoc] [nvarchar](5) NULL,
	[nhacungcap] [nvarchar](50) NULL,
	[hansudung] [date] NULL,
	[dongia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[mathuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[DonThuoc] ([makhachhang], [mathuoc], [soluong], [ngaylapdonthuoc]) VALUES (N'A0001', N'A0001', 30, CAST(N'2020-02-03' AS Date))
INSERT [dbo].[DonThuoc] ([makhachhang], [mathuoc], [soluong], [ngaylapdonthuoc]) VALUES (N'A0001', N'A0003', 20, CAST(N'2020-02-03' AS Date))
INSERT [dbo].[DonThuoc] ([makhachhang], [mathuoc], [soluong], [ngaylapdonthuoc]) VALUES (N'A0002', N'A0002', 20, CAST(N'2020-09-12' AS Date))
INSERT [dbo].[KhachHang] ([makhachhang], [tenkhachhang], [diachi], [sodienthoai], [nguyennhanbenh], [ngaydenquaythuoc]) VALUES (N'A0001', N'Phạm Anh Tuấn', N'32/4 Bình Dương', N'0944734501', N'Đau bao tử', CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([makhachhang], [tenkhachhang], [diachi], [sodienthoai], [nguyennhanbenh], [ngaydenquaythuoc]) VALUES (N'A0002', N'Truong Hong Oanh', N'18/9 Binh Thanh', N'0944734501', N'nhuc dau', CAST(N'2020-02-03' AS Date))
INSERT [dbo].[KhachHang] ([makhachhang], [tenkhachhang], [diachi], [sodienthoai], [nguyennhanbenh], [ngaydenquaythuoc]) VALUES (N'A0003', N'Huy Hoang 1', N'32/8 Quan 1', N'0944556677', N'Tieu Chay', CAST(N'2020-02-03' AS Date))
INSERT [dbo].[KhachHang] ([makhachhang], [tenkhachhang], [diachi], [sodienthoai], [nguyennhanbenh], [ngaydenquaythuoc]) VALUES (N'A0004', N'Ngoc Toi 2', N'32/9 Cu Chi', N'0344556688', N'Ung Thu', CAST(N'2020-05-06' AS Date))
INSERT [dbo].[Thuoc] ([mathuoc], [tenthuoc], [donvithuoc], [nhacungcap], [hansudung], [dongia]) VALUES (N'A0001', N'Paracetamon', N'viên', N'Arshine Pharmaceutical', CAST(N'2021-03-24' AS Date), 650)
INSERT [dbo].[Thuoc] ([mathuoc], [tenthuoc], [donvithuoc], [nhacungcap], [hansudung], [dongia]) VALUES (N'A0002', N'Paradon', N'viên', N'Pharma Hokong', CAST(N'2021-02-03' AS Date), 980)
INSERT [dbo].[Thuoc] ([mathuoc], [tenthuoc], [donvithuoc], [nhacungcap], [hansudung], [dongia]) VALUES (N'A0003', N'Penicilin 1', N'ml', N'Pharmacy Mien Dong', CAST(N'2021-09-09' AS Date), 999)
ALTER TABLE [dbo].[DonThuoc]  WITH CHECK ADD FOREIGN KEY([makhachhang])
REFERENCES [dbo].[KhachHang] ([makhachhang])
GO
ALTER TABLE [dbo].[DonThuoc]  WITH CHECK ADD FOREIGN KEY([mathuoc])
REFERENCES [dbo].[Thuoc] ([mathuoc])
GO
USE [master]
GO
ALTER DATABASE [QLQT] SET  READ_WRITE 
GO

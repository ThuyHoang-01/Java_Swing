USE [QLMBLK]
GO
/****** Object:  Table [dbo].[ChiTietDonHang]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietDonHang](
	[SoHD] [char](5) NOT NULL,
	[MaHang] [char](5) NOT NULL,
	[MucGiamGia] [float] NULL,
 CONSTRAINT [ChiTietDonHang_pk] PRIMARY KEY CLUSTERED 
(
	[SoHD] ASC,
	[MaHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DonDatHang]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DonDatHang](
	[SoHD] [char](5) NOT NULL,
	[MaKH] [char](5) NULL,
	[MANHANVIEN] [char](5) NULL,
	[NgayDatHang] [date] NULL,
	[NgayGiaoHang] [date] NULL,
	[NgayChuyenHang] [date] NULL,
	[NoiNhan] [nvarchar](30) NULL,
 CONSTRAINT [PK_DonDatHang] PRIMARY KEY CLUSTERED 
(
	[SoHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [char](5) NOT NULL,
	[MaHang] [char](5) NULL,
	[MaKH] [char](5) NULL,
	[SoHD] [char](5) NULL,
	[MANHANVIEN] [char](5) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [char](5) NOT NULL,
	[TenKH] [nvarchar](20) NULL,
	[Email] [nvarchar](30) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SoDT] [nvarchar](11) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MatHang]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MatHang](
	[MaHang] [char](5) NOT NULL,
	[TenHang] [nvarchar](20) NULL,
	[NhaCC] [nvarchar](20) NULL,
	[Gia] [float] NULL,
	[SoLuong] [int] NULL,
 CONSTRAINT [PK_MatHang] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 30/06/2020 7:30:47 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MANHANVIEN] [char](5) NOT NULL,
	[TENNHANVIEN] [nvarchar](30) NULL,
	[TIENLUONG] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MANHANVIEN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Email], [DiaChi], [SoDT]) VALUES (N'123  ', N'Nguyễn Việt Tiến', N'Tien@gmail.com', N'Nguyễn Văn Bảo,Gò Vấp', N'034879210')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Email], [DiaChi], [SoDT]) VALUES (N'3    ', N'4', N'4', N'4', N'4')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Email], [DiaChi], [SoDT]) VALUES (N'5    ', N'4', N'4', N'4', N'4')
INSERT [dbo].[MatHang] ([MaHang], [TenHang], [NhaCC], [Gia], [SoLuong]) VALUES (N'3    ', N'1', N'1', 10, 10)
INSERT [dbo].[MatHang] ([MaHang], [TenHang], [NhaCC], [Gia], [SoLuong]) VALUES (N'4    ', N'1', N'1', 10, 10)
INSERT [dbo].[MatHang] ([MaHang], [TenHang], [NhaCC], [Gia], [SoLuong]) VALUES (N'5    ', N'5', N'5', 5, 5)
INSERT [dbo].[MatHang] ([MaHang], [TenHang], [NhaCC], [Gia], [SoLuong]) VALUES (N'6    ', N'7', N'8', 9, 10)
INSERT [dbo].[NHANVIEN] ([MANHANVIEN], [TENNHANVIEN], [TIENLUONG]) VALUES (N'1234 ', N'Nguyễn Mỹ', 3)
INSERT [dbo].[NHANVIEN] ([MANHANVIEN], [TENNHANVIEN], [TIENLUONG]) VALUES (N'12345', N'Duy', 4000)
INSERT [dbo].[NHANVIEN] ([MANHANVIEN], [TENNHANVIEN], [TIENLUONG]) VALUES (N'789  ', N'my', 123)
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_DonDatHang] FOREIGN KEY([SoHD])
REFERENCES [dbo].[DonDatHang] ([SoHD])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_DonDatHang]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_HoaDon] FOREIGN KEY([SoHD])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_MatHang] FOREIGN KEY([MaHang])
REFERENCES [dbo].[MatHang] ([MaHang])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_MatHang]
GO
ALTER TABLE [dbo].[DonDatHang]  WITH CHECK ADD  CONSTRAINT [FK_DonDatHang_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[DonDatHang] CHECK CONSTRAINT [FK_DonDatHang_KhachHang]
GO
ALTER TABLE [dbo].[DonDatHang]  WITH CHECK ADD  CONSTRAINT [FK_DonDatHang_NHANVIEN] FOREIGN KEY([MANHANVIEN])
REFERENCES [dbo].[NHANVIEN] ([MANHANVIEN])
GO
ALTER TABLE [dbo].[DonDatHang] CHECK CONSTRAINT [FK_DonDatHang_NHANVIEN]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_MatHang] FOREIGN KEY([MaHang])
REFERENCES [dbo].[MatHang] ([MaHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_MatHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NHANVIEN] FOREIGN KEY([MANHANVIEN])
REFERENCES [dbo].[NHANVIEN] ([MANHANVIEN])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NHANVIEN]
GO

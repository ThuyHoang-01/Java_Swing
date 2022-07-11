USE [hotelmanagement]
GO
/****** Object:  Table [dbo].[tblBill]    Script Date: 6/30/2020 10:59:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDBooking] [int] NULL,
	[ngayThanhToan] [date] NULL,
	[soTien] [float] NULL,
	[hinhThucThanhToan] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblBill] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBooking]    Script Date: 6/30/2020 10:59:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBooking](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDRoom] [int] NULL,
	[IDUser] [int] NULL,
	[ngayDen] [date] NULL,
	[ngayDi] [date] NULL,
	[gia] [float] NULL,
 CONSTRAINT [PK_tblBooking] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoom]    Script Date: 6/30/2020 10:59:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoom](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[type] [nchar](10) NULL,
	[Price] [float] NULL,
	[tinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblRoom] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 6/30/2020 10:59:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[CMND] [nvarchar](50) NULL,
	[quocTich] [nvarchar](50) NULL,
	[gioiTinh] [nchar](10) NULL,
	[tuoi] [int] NULL,
	[SDT] [nchar](10) NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblRoom] ON 

INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (1, N'12934124332', N'Đơn       ', 4921834, N'Hết')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (2, N'100', N'Đơn       ', 100, N'Còn')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (3, N'42315', N'Đơn       ', 2142341, N'Còn')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (4, N'583295', N'Đơn       ', 423, N'Còn')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (5, N'32458', N'Đơn       ', 9347534, N'Còn')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (6, N'34523', N'Đơn       ', 424, N'Còn')
INSERT [dbo].[tblRoom] ([ID], [name], [type], [Price], [tinhTrang]) VALUES (7, N'32523', N'Đơn       ', 94237, N'Còn')
SET IDENTITY_INSERT [dbo].[tblRoom] OFF
GO
SET IDENTITY_INSERT [dbo].[tblUser] ON 

INSERT [dbo].[tblUser] ([ID], [tenKH], [CMND], [quocTich], [gioiTinh], [tuoi], [SDT]) VALUES (2, N'diep', N'5235234', N'Việt Nam', N'Nam       ', 12, N'52423     ')
INSERT [dbo].[tblUser] ([ID], [tenKH], [CMND], [quocTich], [gioiTinh], [tuoi], [SDT]) VALUES (1002, N'tuong', N'923853', N'Việt Nam', N'Nam       ', 14, N'09528305  ')
SET IDENTITY_INSERT [dbo].[tblUser] OFF
GO
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblBill_tblBooking] FOREIGN KEY([IDBooking])
REFERENCES [dbo].[tblBooking] ([ID])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblBill_tblBooking]
GO
ALTER TABLE [dbo].[tblBooking]  WITH CHECK ADD  CONSTRAINT [FK_tblBooking_tblRoom] FOREIGN KEY([IDRoom])
REFERENCES [dbo].[tblRoom] ([ID])
GO
ALTER TABLE [dbo].[tblBooking] CHECK CONSTRAINT [FK_tblBooking_tblRoom]
GO
ALTER TABLE [dbo].[tblBooking]  WITH CHECK ADD  CONSTRAINT [FK_tblBooking_tblUser] FOREIGN KEY([IDUser])
REFERENCES [dbo].[tblUser] ([ID])
GO
ALTER TABLE [dbo].[tblBooking] CHECK CONSTRAINT [FK_tblBooking_tblUser]
GO

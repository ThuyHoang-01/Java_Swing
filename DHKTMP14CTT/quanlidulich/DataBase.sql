CREATE DATABASE CompanyTouris
USE [CompanyTouris]
GO
/****** Object:  Table [dbo].[CarriageTrip]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CarriageTrip](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](200) NULL,
	[CompanyId] [int] NULL,
	[DepartureDate] [date] NULL,
	[FinishDate] [date] NULL,
	[Address] [nvarchar](100) NULL,
	[Place] [nvarchar](100) NULL,
	[Price] [money] NULL,
 CONSTRAINT [PK_CarriageTrip] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Company]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Phone] [varchar](50) NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
	[Address] [nvarchar](500) NOT NULL,
	[TaxCode] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CompanyTripCustomer]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CompanyTripCustomer](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NULL,
	[CarriageTripId] [int] NULL,
	[IsBuyTicket] [bit] NULL,
	[UserComfirmId] [int] NULL,
 CONSTRAINT [PK_CompanyTripCustomer] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Config]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Config](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](100) NULL,
	[CompanyId] [int] NULL,
 CONSTRAINT [PK_Config] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[LastName] [nvarchar](200) NULL,
	[Email] [nvarchar](100) NULL,
	[Phone] [varchar](50) NULL,
	[UserName] [varchar](100) NOT NULL,
	[Password] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/30/2020 10:28:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[LastName] [nvarchar](200) NULL,
	[Email] [nvarchar](100) NULL,
	[Phone] [varchar](50) NULL,
	[UserName] [varchar](100) NULL,
	[Password] [varchar](100) NULL,
	[CompanyId] [int] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (1, N'Tuyến 1', 3, CAST(N'2020-06-30' AS DateTime), CAST(N'2020-07-05' AS DateTime), N'Đắk Lắk', N'Ko Tam', 500000.0000)
INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (2, N'Tuyến 2', 5, CAST(N'2020-06-30' AS DateTime), CAST(N'2020-07-10' AS DateTime), N'Hà Nội', N'Hồ Gươm', 300000.0000)
INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (3, N'Tuyến 3', 7, CAST(N'2020-04-05' AS DateTime), CAST(N'2020-04-20' AS DateTime), N'Nha Trang', N'Bãi Dài', 100000.0000)
INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (4, N'Tuyến 4', 7, CAST(N'2020-05-08' AS DateTime), CAST(N'2020-05-11' AS DateTime), N'Tây Ninh', N'Bà Đen', 200000.0000)
INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (5, N'Tuyến 5', 5, CAST(N'2020-01-09' AS DateTime), CAST(N'2020-01-11' AS DateTime), N'Cần Thơ', N'Cái Răng', 250000.0000)
INSERT [dbo].[CarriageTrip] ([Id], [Name], [CompanyId], [DepartureDate], [FinishDate], [Address], [Place], [Price]) VALUES (6, N'Tuyến 6', 3, CAST(N'2020-05-02' AS DateTime), CAST(N'2020-05-11' AS DateTime), N'An Giang', N'Tri Tôn', 200000.0000)


GO
SET IDENTITY_INSERT [dbo].[Company] ON 

INSERT [dbo].[Company] ([Id], [Name], [Phone], [Email], [Address], [TaxCode]) VALUES (3, N'Huỳnh Tuấn', N'0909351152', N'huynhtuan@corp.com', N'Eakly - Krông Pắk - ĐắkLắk', N'213-123-222-5524')
INSERT [dbo].[Company] ([Id], [Name], [Phone], [Email], [Address], [TaxCode]) VALUES (5, N'Long Vương', N'079992222', N'longvuong@gmail.com', N'Đăk Lăk', N'211-222-222-222')
INSERT [dbo].[Company] ([Id], [Name], [Phone], [Email], [Address], [TaxCode]) VALUES (7, N'Hoàng Oanh', N'098282828', N'hoangoanh@gmail.com', N'Hà Nội', N'291-2222-222')
SET IDENTITY_INSERT [dbo].[Company] OFF
GO
SET IDENTITY_INSERT [dbo].[CompanyTripCustomer] ON 

INSERT [dbo].[CompanyTripCustomer] ([Id], [CustomerId], [CarriageTripId], [IsBuyTicket], [UserComfirmId]) VALUES (23, 1, 11, 1, NULL)
INSERT [dbo].[CompanyTripCustomer] ([Id], [CustomerId], [CarriageTripId], [IsBuyTicket], [UserComfirmId]) VALUES (24, 1, 7, 1, NULL)
SET IDENTITY_INSERT [dbo].[CompanyTripCustomer] OFF
GO
SET IDENTITY_INSERT [dbo].[Config] ON 

INSERT [dbo].[Config] ([Id], [Name], [CompanyId]) VALUES (2, N'Nguy?n Anh', 3)
INSERT [dbo].[Config] ([Id], [Name], [CompanyId]) VALUES (3, N'Nguy?n Ch?t', 5)
SET IDENTITY_INSERT [dbo].[Config] OFF
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (1, N'Mạnh Nguyễn', N'manhnguyen@gmail.com', N'096478513', N'manh', N'manh123')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (2, N'Hương Phạm', N'huongpham@gmail.com', N'0376444556', N'huongpham', N'manh123')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (8, N'Diệp Đỗ', N'diepDo@gamil.com', N'032222200', N'diepDo12', N'manh123')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (9, N'Nguyên', N'nguyen719@gmail.com', N'09888222', N'ppp', N'8989')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (10, N'manh', N'manh719@gmail.com', N'0974', N'manh12', N'manh123')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (11, N'nam', N'nam@gamil.com', N'09292927', N'nam', N'manh123')
INSERT [dbo].[Customer] ([Id], [LastName], [Email], [Phone], [UserName], [Password]) VALUES (12, N'tuan', N'tuan@gmail.com', N'09282822', N'tuan79', N'manh123')
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([Id], [LastName], [Email], [Phone], [UserName], [Password], [CompanyId]) VALUES (21, N'Nguyễn Văn A', N'nguyenvana@gmail.cpm', N'097511111', N'dangNhap123', N'manh123', 3)
INSERT [dbo].[User] ([Id], [LastName], [Email], [Phone], [UserName], [Password], [CompanyId]) VALUES (22, N'Nguyễn Văn B', N'bb@gmail.com', N'039999999', N'dangNhap23', N'manh123', 3)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[CarriageTrip]  WITH CHECK ADD  CONSTRAINT [FK_CarriageTrip_Company] FOREIGN KEY([CompanyId])
REFERENCES [dbo].[Company] ([Id])
GO
ALTER TABLE [dbo].[CarriageTrip] CHECK CONSTRAINT [FK_CarriageTrip_Company]
GO
ALTER TABLE [dbo].[CompanyTripCustomer]  WITH CHECK ADD  CONSTRAINT [FK_CompanyTripCustomer_CarriageTrip] FOREIGN KEY([CarriageTripId])
REFERENCES [dbo].[CarriageTrip] ([Id])
GO
ALTER TABLE [dbo].[CompanyTripCustomer] CHECK CONSTRAINT [FK_CompanyTripCustomer_CarriageTrip]
GO
ALTER TABLE [dbo].[CompanyTripCustomer]  WITH CHECK ADD  CONSTRAINT [FK_CompanyTripCustomer_Customer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[CompanyTripCustomer] CHECK CONSTRAINT [FK_CompanyTripCustomer_Customer]
GO
ALTER TABLE [dbo].[CompanyTripCustomer]  WITH CHECK ADD  CONSTRAINT [FK_CompanyTripCustomer_User] FOREIGN KEY([UserComfirmId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[CompanyTripCustomer] CHECK CONSTRAINT [FK_CompanyTripCustomer_User]
GO
ALTER TABLE [dbo].[Config]  WITH CHECK ADD  CONSTRAINT [FK_Config_Company] FOREIGN KEY([CompanyId])
REFERENCES [dbo].[Company] ([Id])
GO
ALTER TABLE [dbo].[Config] CHECK CONSTRAINT [FK_Config_Company]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Company] FOREIGN KEY([CompanyId])
REFERENCES [dbo].[Company] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Company]
GO

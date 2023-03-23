USE [AgilityInsight]
GO

/****** Object:  Table [dbo].[SavedScoreCard]    Script Date: 18-01-2023 15:21:07 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DoraMetrics](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TeamId] [nvarchar](200) NOT NULL,
	[SprintId] [nvarchar](50) NOT NULL,
	[DeploymentFrequency] [varchar](100) NOT NULL,
	[LeadTime] [varchar](100) NOT NULL,
	[MeanTime] [varchar](100) NOT NULL,
	[ChangeFailure] [varchar](100) NOT NULL,
	[CreatedDateTime] [datetime] NOT NULL,
	[LastModifiedDate] [datetime] NULL,
	[CreatedBy] [nvarchar](max) NULL,
	[LastModifiedBy] [nvarchar](max) NULL,
 CONSTRAINT [PK_DoraMetrics] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[DoraMetrics] ADD  CONSTRAINT [DF_DoraMetrics_CreatedDateTime]  DEFAULT (getdate()) FOR [CreatedDateTime]
GO



USE [AgilityInsight]
GO

INSERT INTO [dbo].[Quadrants]
           ([Name]
           ,[FieldType]
           ,[IsActive]
           ,[TeamType]
           ,[LastModifiedDate]
           ,[CreatedBy]
           ,[LastModifiedBy]
           ,[CreatedDate])
     VALUES
           ('Change Failure Rate'
           ,3
           ,1
           ,1
           ,NULL
           ,'Manisha Dutt'
           ,NULL
           ,GETDATE())
GO



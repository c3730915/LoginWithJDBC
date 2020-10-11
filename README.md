# 一个用JDBC和druid配合的javaWeb项目

## 安装

克隆项目用IDEA打开即可。项目依赖为tomcat以及在WEB—INF目录下的jar包 需要将jar包下载，添加到模块



## 项目简介

通过数据库连接池实现多次数据库连接，用spring封装JDBC，并且通过调用多个servlet实现对请求的处理，在通过数据库查验后能够返回登陆是否成功。



## 目录结构及描述

- UserDao 用户user的实现类，通过调用JDBCTemplate能够查询到用户是否在数据库中
- User 存储用户当前用户名，密码的类
- UserDaoTest 测试类，调用UserDao判断是否能够成功登录
- Util JDBC的实用工具类，简化登录进行封装处理
- FailServlet SuccessServlet 分别为成功 和失败的servlet，loginservlet会根据登陆结果进行servlet的跳转
- durid.properties 数据库连接池的配置文件，此文件较为重要，并且经过修改后不进行报错
- WEB-INF 存储所需要的jar包

## 版本

V0001

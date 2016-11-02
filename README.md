# CCPX-application
Spring-Hibernate java dynamic web application


README [English](files://README.md) | [中文](files://README-zh.md)

## Feature

1. seller group
2. user group
3. platform group  


## Environment
+ JDK 1.7+ 
+ Apache Tomcat 6+
+ MyEclipse  

## How to Start

1. git clone from github.com:  

    /*
    git clone https://github.com/CCPX-system/CCPX-application.git 
    */
2. import into myeclipse
4. configure parameter
3. deploy into Apache Tomcat 

## Configurations
1. Spring-data.xml
2. Spring-hibernate.xml

## Package
  Attention! please don't change package name.   
  
1. config  
   + add configure file.
2. controller  
   + Spring Controller
3. dao  
    + CRUD operation
4. model
   + entity class mapped from table in database
5. redis
   + cache method ,if you want to add cache in different ways, you can add class in this package. 
6. service
	+ provide service for Controller ,and link with dao class. or other service
7. utils
   + such as date tool
8. WebContent
 	 + bootstrap
   + css
	+ image
	+ images
	+ js
	+ lib 
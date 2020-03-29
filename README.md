# Driving Schoole Manager System

## 一、Background

  Soon, I was about to graduate, facing the problem of graduation design, so with the development background of this project, at first, I just wanted to make a Java Web project based on the Spring boot framework. Due to the requirements of the school, the graduates of this major graduate The design must be related to the embedded or the Internet of Things. I have to improve my ideas. The current project includes the web server inherited by the Spring boot framework, the web front-end page inherited by the vue framework, and embedded devices based on the Stm32F103ZE development board, including , RFID module, LED light, ESP8266 module, etc. The project is being perfected, good luck to me ...


## 二、install
This project contains Java server-side, vue front-end projects, and embedded content developed based on keil5. The following is the installation method

* Get the source code of the project
```bash
$ git clone git@github.com:leleplus/driver.git
```
or
```bash
$ git clone https://github.com/leleplus/driver.git
```

* Compile and run embedded hardware code
> Embedded related code is developed based on keil5, you can also directly download the hex file in the `bin/` directory to the corresponding development board

### (一).STM32_client


```bash
$ cd driver/
```

## Usage
Since the project uses multiple development languages, you need to install the corresponding development environment

* Embedded development board
Install keil5 software


### (二).back_end (Java-Server)
#### 1.development environment
need install
* JDK 1.8+
* maven 3.6.3+
* mysql 5.5.0+,8.0-

#### 2.development project
```bash
$ cd bach_end/driver-manager-system/
$ mvn compile
```

#### 3.run project
```bash
$ mvn spring-boot:run
```

#### 4.build project

if use `war`,config `pom.xml` and need tomcat 8.0+
```xml
<!-- 多模块排除内置tomcat -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>

<!-- 单应用排除内置tomcat -->
<exclusions>
	<exclusion>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<groupId>org.springframework.boot</groupId>
	</exclusion>
</exclusions>
```

```bash
$ mvn package
```

Then open Your browser , input address `http://localhost:6666/swagger-ui.html`


### (三).front_end (driver-ui)

#### 1.development environment
need install
* nodejs 8.0+
* npm 6.0+

#### 2.development project
```bash
$ cd driver-ui
$ npm install
```

if npm download to low, useage
```bash
$ npm install --registry=https://registry.npm.taobao.org
```
#### 3.run project
```bash
$ npm run dev
```

#### 4.build project
```bash
# Test Environment
$ npm run build:stage

# Production Environment
$ npm run build:prod
```

Then open your browser,input address `http://localhost:80`


# Driving Schoole Manager System

## Background

  Soon, I was about to graduate, facing the problem of graduation design, so with the development background of this project, at first, I just wanted to make a Java Web project based on the Spring boot framework. Due to the requirements of the school, the graduates of this major graduate The design must be related to the embedded or the Internet of Things. I have to improve my ideas. The current project includes the web server inherited by the Spring boot framework, the web front-end page inherited by the vue framework, and embedded devices based on the Stm32F103ZE development board, including , RFID module, LED light, ESP8266 module, etc. The project is being perfected, good luck to me ...


## install
This project contains Java server-side, vue front-end projects, and embedded content developed based on keil5. The following is the installation method

* Get the source code of the project
```bash
$ git clone git@github.com:leleplus/driver.git
```
或者
```bash
$ git clone https://github.com/leleplus/driver.git
```

* Compile and run embedded hardware code
> Embedded related code is developed based on keil5, you can also directly download the hex file in the `bin/` directory to the corresponding development board

```bash
$ cd driver/
```

## Usage
Since the project uses multiple development languages, you need to install the corresponding development environment

* Embedded development board
Install keil5 software

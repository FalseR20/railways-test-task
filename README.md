# Тестовое задание БЧ

## Описание

Используемые средства:

- Java 8+;
- Apache Tomcat 8.5;
- MySql 8.

Необходимо разработать и реализовать Web-приложение со следующим функционалом:

- форма аутентификации пользователя;
- отображение списка записей;
- добавление, удаление, редактирование записей;
- в записи должны быть число, текст, дата, картинка;
- данные хранятся в СУБД;
- в текстовых данных должны присутствовать национальные символы.

При реализации предполагается использование Servlet, JSP, ExtJS, Angular, JDBC, Hibernate, JPA, Struts, Spring и/или
другие библиотеки и фреймворки с учетом опыта и целесообразности использования.

Результатом является:

1. скрипт для создания объектов в базе данных;
2. приложение в виде, пригодном для размещения в Apache Tomcat;
3. изменения в конфигурационные файлы MySQL и Apache Tomcat (при необходимости).

## Installation

Copy `.env` example file:

```shell
cp example.env .env
```

Set MySQL:

```shell
sudo mysql
```
```mysql
CREATE DATABASE railways;
CREATE USER 'railways'@'localhost' IDENTIFIED WITH mysql_native_password BY 'YOUR_PASSWORD';
GRANT ALL PRIVILEGES ON railways.* TO 'railways'@'localhost';
```

Then build and run.

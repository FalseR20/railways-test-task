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

Set MySQL:

```shell
sudo mysql
```

```mysql
CREATE DATABASE railways;
CREATE USER 'railways'@'localhost' IDENTIFIED WITH mysql_native_password BY 'YOUR_PASSWORD';
GRANT ALL PRIVILEGES ON railways.* TO 'railways'@'localhost';
```

Then use `.war` file in releases or build yourself:

```shell
./gradlew war
```

Deploy into `Tomcat`:

```shell
sudo mv ./build/libs/railways-test-task-0.0.1-plain.war /opt/tomcat/webapps/railways-test-task.war
```

Also, you need configure application:

```shell
sudo nano /opt/tomcat/webapps/railways-test-task/WEB-INF/classes/application.properties
```

Change MySQL credentials and JWT signing token.

That's all. Enjoy it:)

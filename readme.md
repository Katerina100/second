# Second Project


*Пререквизиты: Java 8, JDK,  Maven, Git*

### Запуск
- С помощью git клонировать проект в локальную директорию;
- Внутри этой директории запустить терминал;
- Мавеном запустить тесты;

```sh
$ git clone git@github.com:Katerina100/second.git
$ mvn compile
$ mvn test
```
### Cтрока запуска maven
 1.0 Запуск тестов на браузере хром с командной строки  -Dtest=TestMobileForm -Dbrowser=chrome verify
 ```sh
 $ mvn -Dtest=GooglePageTestMobileForm -Dbrowser=chrome verify
 $ mvn -Dtest=TestMobileForm -Dbrowser=chrome verify
  $ mvn -Dtest=TestMobileFormRegion -Dbrowser=chrome verify
 ```
   
### Автор
Екатерина Абрамова
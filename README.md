# Дипломный проект профессии «Тестировщик»

## Перед запуском
На вашем ПК должны быть установлены следующие ПО:
- IntelliJ IDEA
- Git
- Docker Desktop
- Google Chrome 

## Инструкция по запуску
1. Склонировать репозиторий и открыть его в приложении IntelliJ IDEA.
(https://github.com/PaulDehant/QaDiplom.git)

3. Открыть Docker;

4. В терминале развернуть контейнер с помощью команды

   docker-compose up

5. В новом терминале запустить целевое приложение:

     для mySQL - java -jar artifacts/aqa-shop.jar --spring.profiles.active=mysql;

     для postgresgl - java -jar artifacts/aqa-shop.jar --spring.profiles.active=postgresql;

6. Открыть браузер и пройти по [ссылке](http://localhost:8080/) 

7. В новом терминале запустить тесты

    для mySQL - ./gradlew test -Durl=jdbc:mysql://localhost:3306/app -Duser=app -Dpassword=pass ;

    для postgresgl - ./gradlew test -Durl=jdbc:postgresql://localhost:5432/app -Duser=app -Dpassword=pass ;

8. В новом терминале сформировать отчет командой

    ./gradlew allureServe .

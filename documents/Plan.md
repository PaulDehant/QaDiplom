###  Перечень автоматизируемых сценариев

####  Позитивные сценарии


1. Обычная покупка картой 1: нажать кнопку "Купить", ввести валидные значения реквизитов карты 1, нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение: "Успешно. Операция одобрена банком".*
2. Покупка в кредит картой 1 нажать кнопку "Купить в кредит", ввести валидные значения реквизитов карты 1, нажать кнопку выдачи кредита.

  *Ожидаемый результат: отображается сообщение: "Успешно. Операция одобрена банком".*
3. Обычная покупка картой 2: нажать кнопку "Купить", ввести валидные значения реквизитов карты 2, кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*
4. Покупка в кредит картой 2: нажать кнопку "Купить в кредит", ввести валидные значения реквизитов карты 2, нажать кнопку выдачи кредита.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

####  Негативные сценарии


1. Обычная покупка картой: нажать кнопку "Купить", ввести невалидные значения поля "Номер карты", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

2. Обычная покупка картой: нажать кнопку "Купить", ввести невалидные значения поля "Месяц", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

3. Обычная покупка картой: нажать кнопку "Купить", ввести невалидные значения поля "Год", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

4. Обычная покупка картой: нажать кнопку "Купить", ввести невалидные значения поля "Владелец", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

5. Обычная покупка картой: нажать кнопку "Купить", ввести невалидные значения поля "CVC/CVV", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

6. Покупка в кредит: нажать кнопку "Купить в кредит", ввести невалидные значения поля "Номер карты", нажать кнопку выдачи кредита.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

7. Покупка в кредит: нажать кнопку "Купить в кредит", ввести невалидные значения поля "Месяц", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

8. Покупка в кредит: нажать кнопку "Купить в кредит", ввести невалидные значения поля "Год", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"


9. Покупка в кредит: нажать кнопку "Купить в кредит", ввести невалидные значения поля "Владелец", нажать кнопку оплаты.

  Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*


10. Покупка в кредит: нажать кнопку "Купить в кредит", ввести невалидные значения поля "CVC/CVV", нажать кнопку оплаты.

  *Ожидаемый результат: отображается сообщение:"Ошибка. Банк отказал в проведении операции"*

### Перечень используемых инструментов с обоснованием выбора
- IntelliJ IDEA 2022.3.2 (Community Edition) — интегрированная среда разработки программного обеспечения
- JUnit. Библиотека для написания и запуска авто-тестов.
- Gradle. Система управления зависимости, которая позволит удобно ставить необходимые фреймворки без проблем с постоянной настройкой зависимостей.
- Selenide. Фреймворк для автоматизированного тестирования веб-приложений.
- Docker Desktop for Windows - система контейнеризации, для подключения БД MySQL и PostgresSQL.
- Git и Github. Система контроля версий, для хранения кодов автотестов и настроек окружения.

### Перечень и описание возможных рисков при автоматизации
- Возможны проблемы с подключением и настройкой тестируемого окружения и БД;
- Риск возникновения ошибок при написании кода самих тестов.
- Большое количество багов, которые увеличат время тестирования.

### Интервальная оценка с учётом рисков в часах
- Подготовка окружения: 48 часа
- Разработка и отладка автотестов: 72 часов
- Разработка отчетности: 15 часов
### План сдачи работ

11.07.2023 - готовность автотестов, результаты прогонов.

15.07.2023 - отчетность по итогам тестирования и автоматизации.
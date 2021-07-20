## Проект с автотестами для tinkoff.ru  
Автотесты реализованы с использованием технологий:  
Java<img src="images/logo/JAVA.svg" width="40" height="40">, Junit5<img src="images/logo/Junit5.svg" width="40" height="40">, Gradle<img src="images/logo/Gradle.svg" width="40" height="40">, Selenide<img src="images/logo/Selenide.svg" width="40" height="40">  
VCS - Github<img src="images/logo/GitHub.svg" width="40" height="40">  
Запуск и прогон автотестов - Jenkins<img src="images/logo/Jenkins.svg" width="40" height="40">, Selenoid<img src="images/logo/Selenoid.svg" width="40" height="40">  
Отчетность - Allure Report <img src="images/logo/Allure Report.svg" width="40" height="40">  
Нотификация - Telegram<img src="images/logo/Telegram.svg" width="40" height="40">  
Хранение и анализ тестов - Allure TestOps<img src="images/logo/Allure TestOps.svg" width="40" height="40">

### Запуск джобы в Jenkins  
  
![JenkinsJob](/images/JenkinsJob.jpg)  
  
Команда запуска тестов:  
> clean test -Dserver=${SERVER} -Dlogin=${LOGIN} -Dpassword=${PASS}  

где SERVER - selenoid.autotests.cloud  
LOGIN - user1  
PASS - 1234  
ALLURE_NOTIFICATIONS_VERSION - 3.1.1  

### Автотесты прогоняются в Selenoid  
  
![Selenoid1](/images/Selenoid1.gif)  
  
(видео прохождения одного из тестов)  
### Формируется Allure отчет  
В Allure отчете к каждому из тестов прикрепляются:
* скриншот последней проверки
* код страницы
* логи браузера
* видео прохождения теста  
  
![AllureReport](/images/AllureReport.jpg)  


### В Telegram приходят уведомления с результатами прохождения автотестов  
  
![telegramNotification](/images/telegramNotification.jpg)
  
### После прогона отчет и автотесты добавляются в Allure TestOps  
  
![TestOps2](/images/TestOps2.jpg)  
![TestOps](/images/TestOps.jpg) 
  
Также в Allure TestOps был добавлен ручной ТК  

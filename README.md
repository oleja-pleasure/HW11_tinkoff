##Проект с автотестами для tinkoff.ru  
Автотесты реализованы с использованием технологий:  
Java, Junit5, Gradle, Selenide  
VCS - Github  
Запуск и прогон автотестов - Jenkins, Selenoid  
Отчетность - Allure report  
Нотификация - Telegram  
Хранение и анализ тестов - Allure TestOps

###Запуск джобы в Jenkins  
![JenkinsJob](/images/JenkinsJob.jpg)  
Команда запуска тестов:  
> clean test -Dserver=${SERVER} -Dlogin=${LOGIN} -Dpassword=${PASS}  

где SERVER - selenoid.autotests.cloud  
LOGIN - user1  
PASS - 1234  
ALLURE_NOTIFICATIONS_VERSION - 3.1.1  

###Автотесты прогоняются в Selenoid  
![Selenoid1](/images/Selenoid1.gif)  
(видео прохождения одного из тестов)  
###Формируется Allure отчет  
![AllureReport](/images/AllureReport.jpg)  
В Allure отчете к каждому из тестов прикрепляются:  
 * скриншот последней проверки  
 * код страницы  
 * логи браузера  
 * видео прохождения теста

###В Telegram приходят уведомления с результатами прохождения автотестов  
![telegramNotification](/images/telegramNotification.jpg)
###После прогона отчет и автотесты добавляются в Allure TestOps  
![TestOps2](/images/TestOps2.jpg)  
![TestOps](/images/TestOps.jpg)  
Также в Allure TestOps был добавлен ручной ТК  




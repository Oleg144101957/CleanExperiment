# CleanExperiment

There is an experiments with Android Clean Architecture (ver 4)


В Clean Architecture добавлен паттерн MVVM 
Измеенена диаграмма


![Screenshot from 2022-07-14 22-41-18](https://user-images.githubusercontent.com/93651407/179034410-86a78517-c0e4-4006-9aff-a41216611396.png)






Приложение было разбито на модули: Domain, Presantatin(App), Data.

В Data слой импортирован модуль Domain

В Presantatin(App) импортированы слои Domain и Data

Data слой не зависит ни от Presantation ни от Data


App слой ссоединяет в себе все компоненты.

![Screenshot from 2022-07-12 13-36-07](https://user-images.githubusercontent.com/93651407/178436195-14daba54-7234-4c14-bc4a-9128a8760cba.png)






UseCases Diagram


![Screenshot from 2022-07-10 15-37-00](https://user-images.githubusercontent.com/93651407/178142804-ad429064-c849-4b2f-b4a3-55dfb43da981.png)

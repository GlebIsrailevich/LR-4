# Краткий отчет по работе с Zooekeeper 
## Работа с Zooekeeper через консоль
1. Запуск интерактивной  сессии 
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/34023480-0ea0-4675-84f2-493113caa25b)
2.  Результат создание нод и изменения версий
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/06f1ddf4-bf65-4853-802b-43e3f6fb21cd)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/447def7a-91bd-4629-8d73-02f21b15cc73)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/d2303253-615d-4f3a-b295-28d5eab63a59)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/9e5fcc05-7edd-4a41-82f9-f0ab9d64414c)
3. Работа с узлами
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/032eac03-e44e-4979-b31c-04f9ad346ddb)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/6b6aee65-6369-47de-9239-4fe51e2c0c9c)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/6773e11b-5ed5-48fc-a399-55e085441a19)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/bb0b5e32-cdfc-4df1-b0ab-589dfa6cd26a)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/09119a9b-65e1-4ed3-bf39-4445b9380d16)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/927404b4-9fe2-4ef5-84f1-56bc0644a77e)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/30023b42-0ff3-4dcb-bc33-b05eeff23285)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/fc810822-a6e6-43f9-ad6c-0e9f13f36e15)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/964c27db-99b5-43ad-9e6e-43155a9e9ec7)
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/3f51b28a-0407-4e8b-bd3f-e8360985a55b)
## Выполнение заданий 
### Задача о философах
У нас есть N философов, обедающих за круглым столом (В нашем случае 5). Перед каждым философом стоит миска спагетти. Между каждой парой соседних философов ставится вилка. Как следствие, у каждого философа есть вилка слева и справа.
Каждый философ поочередно будет есть и думать. Для принятия пищи философу необходимо взять в руки обе вилки (с левой и с правой стороны). Одну вилку не могут использовать одновременно два философа; это значит, что когда философ ест, соседние философы должны думать. После еды каждый философ должен положить вилки, чтобы они могли быть доступны другим философам (включая себя). Если философ пытается есть и у него берут вилку, он должен вернуться к размышлениям.
Проблема состоит в том, чтобы разработать параллельный алгоритм, который заставит философов поочередно есть и думать, следуя вышеуказанным ограничениям, без тупиков и без голодания.
Для решения задания использовался язык Scala и Zooekeeper. 
Результат работы программы выводится в консоль:  
![image](https://github.com/GlebIsrailevich/LR-4/assets/109220001/a35455d7-8926-47bf-8649-9ef6cada0997)
### Двухфазный коммит
Существует два вида потоков Coordinator и Worker (Они располагаются в соответствующих файлах)
В системе управления транзакциями Coordinator создает временный узел и ждет, пока Worker создадут свои узлы и проголосуют. Worker создают временные узлы как дочерние узлы узла Coordinator, и значение узла (commit или abort) устанавливается случайным образом. После получения голосов Coordinator принимает решение на основе относительного большинства и отправляет его дочерним узлам.


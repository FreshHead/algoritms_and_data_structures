# data_structures_coursework
A little GUI program that uses JavaFX. It was made to solve strange coursework task.

## Цель работы:
Получение навыков разработки объектных программ, включая создание набора собственных взаимосвязанных классов для объектной реализации специализированного контейнера. Контейнер предназначен для хранения и обработки данных некоторой информационной задачи. Контейнер представляет собой двухуровневую структуру данных, в которой уровни реализуются разными способами – один статически на базе массива (непрерывная реализация), другой – динамически с использованием адресных связей (связная реализация).``
## Вариант реализации контейнера
Объектная реализация контейнера на основе комбинированной структуры «Динамический список массивов-стеков»

## Вариант информационного наполнения контейнера
Задача «Структура организации», в которой информационные объекты:
* отделы организации (свойства – НазваниеОтдела, ЧислоСотрудников)
* отделы объединяются в рамках объекта Филиал (свойство – НазваниеФилиала)
* филиалы объединяются в рамках объекта-контейнера Организация (свойство – НазваниеОрганизации)

## Требования:
1. Полная объектная реализация с определением классов для всех элементов реализуемой структуры: информационные объекты (обязательно!), объекты-элементы списка (динамическая реализация), объекты-списки, объект-контейнер
2. Имена классов, свойств и методов должны носить содержательный смысл и соответствовать информационной задаче
3. Соблюдение принципа инкапсуляции – использование в классах только закрытых свойств и реализация необходимого набора методов доступа
4. Реализация в классах всех необходимых методов: конструкторы, методы доступа к свойствам, методы добавления и удаления на каждом из двух уровней, метод поиска (при необходимости)
5. Возможность сохранения всей структуры во внешнем файле с обратной загрузкой
6. Наличие модуля, демонстрирующего все возможности созданной библиотеки классов и обладающего удобным оконным пользовательским интерфейсом 
7. Язык и среда разработки – по выбору: Delphi, Java, C++, С#
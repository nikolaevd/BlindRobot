# Blind Robot

Программа управляет роботом, идущим вслепую по лабиринту. Лабиринт состоит из N на M клеток. Каждая из клеток может быть свободной или заблокированной (непроходимой). Все клетки на границе лабиринта непроходимые. Робот начинает работу в свободной клетке, он может переместиться на юг, запад, север или восток в свободную клетку. Робот не имеет оптических сенсоров, только сенсор удара, так что при попытке перемещения в заблокированную клетку сработает сенсор и робот останется в той же клетке. Робот должен побывать во всех проходимых клетках лабиринта. Из начальной клетки гарантированно можно попасть во все достижимые клетки лабиринта.

Протокол взаимодействия.
Программа выводит на стандартный вывод строку с предложением ввести команду и ожидает в стандартном вводе ответ пользователя, затем программа выводит результат выполнения команды и считывает новый ответ пользователя и так далее до тех пор, пока все проходимые клетки лабиринта не будут посещены. Программа завершает работу только в двух случаях: когда все проходимые клетки посещены или отправлена команда DONE. Проходимые клетки могут быть посещены несколько раз. Допустимо передвигаться даже если все проходимые клетки уже посещены.

Входные данные.
Каждая строка входных данных представляет собой команду для робота. Это одна из пяти возможных строк: SOUTH, WEST, NORTH, EAST, или DONE. После ввода DONE программа завершает свою работу.

Выходные данные.
Каждая строка выходных данных представляет собой ответ на действие робота. Это может быть EMPTY если робот успешно переместился в заданном направлении или строка BLOCKED если робот не смог переместиться из-за того, что клетка, в которую он хотел попасть, непроходима.

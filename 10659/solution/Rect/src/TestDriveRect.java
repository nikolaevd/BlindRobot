
class TestDirveRect {
    // main - метод с которого начинается выполнение программы
    public static void main(String[] args) {
        // переменные для хранения вводимых координат
        int x1, y1, x2, y2;
     
        // cоздаем экземпляр класса Input       
        Input in = new Input();
        
        // предлагаем сделать ввод координаты
        // записываем значение координаты в переменную
        in.inputCoords("x1");       
        x1 = in.setReadedInt();
        
        in.inputCoords("y1");
        y1 = in.setReadedInt();
        
        in.inputCoords("x2");
        x2 = in.setReadedInt();
        
        in.inputCoords("y2");
        y2 = in.setReadedInt();
        
        // создаем экземпляр класса Rect
        Rect r = new Rect();
        
        // находим стороны прямоугольника
        // считаем периметр
        // считаем площадь
        r.findSides(x1, y1, x2, y2);
        r.findPerimeter(r.a, r.b);
        r.findSpace(r.a, r.b);
        
        // выводим результаты на экран
        System.out.println("");
        System.out.println("Параметры подсчитанны:");
        System.out.println("a = " + r.a);
        System.out.println("b = " + r.b);
        System.out.println("P = " + r.P);
        System.out.println("S = " + r.S);
    }  
}

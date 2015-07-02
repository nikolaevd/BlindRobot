
class Rect {
    // переменные для хранения длин сторон, периметра и площади
    int a, b, P, S;
       
    // вычисляем длину сторон
    void findSides(int x1, int y1, int x2, int y2){
	a = x2 - x1;
	b = y2 - y1;
    }
	
    // находим периметр
    void findPerimeter(int a, int b){
	P = 2 * a + 2 * b;
    }
	
    // находим площадь
    void findSpace(int a, int b){
	S = a * b;
    }
}

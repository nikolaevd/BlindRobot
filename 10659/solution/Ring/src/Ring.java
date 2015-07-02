
public class Ring {
    void ringS(double R1, double R2){
        double space = 0;
        // подсчитываем площадь каждой окружности
        double roundS1 = 3.14 * Math.sqrt(R1);
        double roundS2 = 3.14 * Math.sqrt(R2);
        
        // находим разницу площадей внешней и внутренней окружности
        space = roundS1 - roundS2;
        
        // выводим на экран разницу площадей внешней и внутренней окружности, являющейся площадью кольца
        System.out.println("Площадь кольца составляет " + space);
    }
}


public class TestDriveRing {
    public static void main(String[] args){
        // переменные для хранения радиусов окружностей
	double R1;
        double R2;
        
        // создаем экзмепляр класса Input
        Input in = new Input();
        
        // считываем пользовательский ввод и записываем в переменные R1 и R2
        in.inputDoubleRad("внешней окружности R1");
        R1 = in.setReadedDouble();
        
        in.inputDoubleRad("внутренней окружности R2");
        R2 = in.setReadedDouble();
        
        // созадем экземпляр класса Ring
        // вызываем метро ringS() подсчитывающий площадь кольца
        Ring r = new Ring();
        r.ringS(R1, R2);
    }
}

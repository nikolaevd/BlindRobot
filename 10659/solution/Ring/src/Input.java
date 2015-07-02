import java.util.Scanner;

class Input {
    // переменная для временного хранения считвыаемых значений пользовательского ввода
    double temp;
    
    // метод для чтеня значений, вводимых пользователем с клавиатуры
    void inputDoubleRad(String s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите радиус " + s + ":");
        if(sc.hasNextDouble()){
            temp = sc.nextDouble();   
        }
        else { 
            // если пользователь совершил не верный ввод, то выводим предупреждение и рекурсивно вызываем функцию inputDoubleRad()
            System.out.println("Вы ввели не вещественное число, повторите ввод!");
            System.out.println("");
            inputDoubleRad(s);
        }
    }
    
    // метод возвращает значение, считанное методом inputDoubleRad()
    double setReadedDouble(){
        return temp;
    }
    
}

import java.util.Scanner;

class Input {
    // переменная для временного хранения считвыаемых значений пользовательского ввода
    int temp;
    
    // метод для чтеня значений, вводимых пользователем с клавиатуры
    void inputCoords(String s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координату " + s + ":");
        if(sc.hasNextInt()){
            temp = sc.nextInt();   
        }
        else { 
            // если пользователь совершил не верный ввод, то выводим предупреждение и рекурсивно вызываем функцию inputCoords()
            System.out.println("Вы ввели не целое число, повторите ввод!");
            System.out.println("");
            inputCoords(s);
        }
    }
    
    // метод возвращает значение, считанное методом inputCoords()
    int setReadedInt(){
        return temp;
    }
    
}

import java.util.Scanner;

class Input {
    // переменная для временного хранения считвыаемых значений пользовательского ввода
    int temp;
    
    // метод для чтеня значений, вводимых пользователем с клавиатуры
    void inputInt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        if(sc.hasNextInt()){
            temp = sc.nextInt();   
        }
        else { 
            // если пользователь совершил не верный ввод, то выводим предупреждение и рекурсивно вызываем функцию inputInt()
            System.out.println("Вы ввели не целое число, повторите ввод!");
            System.out.println("");
            inputInt();
        }
    }
    
    // метод возвращает значение, считанное методом inputInt()
    int setReadedInt(){
        return temp;
    }
    
}

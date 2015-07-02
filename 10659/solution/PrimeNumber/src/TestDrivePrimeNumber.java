
public class TestDrivePrimeNumber {
    public static void main(String[] args){
        // переменная для временного пользовательского ввода
        int num;
        
        // создаем экзепляр класса Input и считываем пользовательский ввод с клавиатуры
        Input in = new Input();
        in.inputInt();
        num = in.setReadedInt();
        
        // создаем экземпляр класса PrimeNumber и определяем, является ли вводимое число простым
        PrimeNumber p = new PrimeNumber();
        p.isPrime(num);
    }
}

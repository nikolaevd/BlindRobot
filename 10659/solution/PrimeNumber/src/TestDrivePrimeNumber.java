
public class TestDrivePrimeNumber {
    public static void main(String[] args){
        
        Input in = new Input();
        PrimeNumber pn = new PrimeNumber();

        for(int i = 1; i < 11; i++){
            System.out.println("Попытка №" + i);

            // считываем пользовательский ввод с клавиатуры
            in.inputInt();
            int num = in.setReadedInt();
        
            // определяем, является ли вводимое число простым
            pn.isPrime(num);
        }
        
        System.out.println("Конец цикла.");
        System.out.println("Количество простых чисел: " + pn.getCount());
    }
}

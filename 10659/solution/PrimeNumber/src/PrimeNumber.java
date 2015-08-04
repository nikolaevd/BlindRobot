
public class PrimeNumber {
    // счетчик подсчитывает количество простых чисел
    private int count
            ;
    // метод определяет, является ли число простым
    public void isPrime(int num){
        // количество делений без остатка
        int withoutTrace = 0;
        
        for(int i = 1; i <= num; i++){
            if(num % i == 0) withoutTrace++;            
        }
        // есди чисдо имеет больше 2-ух делителей не дающих в частном остатка, то значит чисдо не является простым
        if(withoutTrace > 2){
            System.out.println("Число " + num + " не является простым!");
            System.out.println("");
        }
        else {
            System.out.println("Число " + num + " является простым!");
            System.out.println("");
            count++;
        }
    }
    
    public int getCount(){
        return this.count;
    }
}

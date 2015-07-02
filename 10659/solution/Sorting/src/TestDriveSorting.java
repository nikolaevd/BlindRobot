
public class TestDriveSorting {
    public static void main(String[] args){
        // создаем массив для хранения последовательности из трех чисел, вводимых пользователем
        int[] nums = new int[3];
        
        // создаем экземпляр класса Input
        Input in = new Input();
        
        // в цикле трижды вызываем метод для считывания значений, вводимых пользователем 
        for (int i = 0; i < 3; i++){
            in.inputInt();
            // записываем считанные значения в массив nums[]
            nums[i] = in.setReadedInt();
        }
        
        // создаем экхемпляр класса Sorting 
        // передаем массив nums[] в метод sort, для выполнения сортировки чисел по убыванию
        Sorting s = new Sorting();
        s.sort(nums);
        
        // выводим результат на экран
        System.out.println("");
        System.out.println("Набор введенных чисел после упорядочивания по убыванию: ");
        s.printNums(nums);
    }
}

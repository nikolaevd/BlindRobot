
public class Sorting {
 
    // сортируем последовательность чисел в массиве (алгоритм сортировки вставкой)
    void sort(int[] nums){
        for(int i = 1; i < nums.length; i++){
        int currElem = nums[i];
        int prevKey = i - 1;
            while(prevKey >= 0 && nums[prevKey] < currElem){
                nums[prevKey+1] = nums[prevKey];
                nums[prevKey] = currElem;
                prevKey--;
            }
        }
    }
    
    // выводим на экран содержимое массива nums
    void printNums(int[] nums){
        for(int n: nums){
            System.out.println(n);
        }
    } 
}

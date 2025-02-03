import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n = 12;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент  " + i);
            Scanner in = new Scanner(System.in);
            nums[i] = in.nextInt();
        }
        System.out.println("Исходный массив: " + Arrays.toString(nums));
        CombSort(nums);
        System.out.println("Отсортированный массив: " + Arrays.toString(nums));
    }
    public static void CombSort(int[] values) {
        double factor = 1.247; //расстояние между элементами
        int step = values.length - 1;
        do {
            int i = 0;
            while (step + i < values.length) { //находим выходит ли элемент за границы массива 
                if (values[i] > 0 && values[i + step] > 0) { // сортируем только положительные
                    if (values[i] > values[i + step]) { //сравнивание элементы на расстоянии step
                        swap(values, i, i + step); //используем метод для замены элементов
                    }
                }
                i++;
            }
            step /= factor; 
        }
        while (step> 1);//выполняется пока шаг больше 1
        int[] positives = Arrays.stream(values).filter(num -> num > 0).toArray();//добавляем только положительные элементы
        Arrays.sort(positives);//сортируем положительные элементы
        int positiveIndex = 0;
        for (int j = 0; j < values.length; j++) { //добавляем отрицательные элементы на свое место
            if (values[j] > 0) {
                values[j] = positives[positiveIndex++];
            }
        }
    }
    static void swap(int[] sortArr, int i, int j) { //метод для замены элементов местами
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }
}

package ksv;

/**
 * Написать класс Калькулятор (необобщенный),
 * который содержит обобщенные статические методы:
 * sum(), multiply(), divide(), subtract().
 * Параметры этих методов – два числа разного типа,
 * над которыми должна быть произведена операция.
 * Методы должны возвращать результат своей работы.
 * <p>
 * Напишите обобщенный метод compareArrays(),
 * который принимает два массива и возвращает true,
 * если они одинаковые, и false в противном случае.
 * Массивы могут быть любого типа данных,
 * но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
 * <p>
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
 * а также переопределение метода toString(), возвращающее строковое представление пары.
 * Работу сдать в виде ссылки на гит репозиторий.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Calc.divide(20.5, 3));
        System.out.println(Calc.multiply(20, 3));
        System.out.println(Calc.sum(20, 3.1));
        System.out.println(Calc.subtract(20, 5));

        Integer i = Calc.sum(10, 5);

        System.out.println();

        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(String.format("первый %b", compareArrays(arr1, arr2)));

        FirstExampleClass[] arr3 = {new FirstExampleClass(), new FirstExampleClass()};
        SecondExampleClass[] arr4 = {new SecondExampleClass(), new SecondExampleClass()};
        System.out.println(String.format("второй %b", compareArrays(arr3, arr4)));

        FirstExampleClass[] arr5 = {new ThirdExampleClass(), new SecondExampleClass()};
        SecondExampleClass[] arr6 = {new ThirdExampleClass(), new SecondExampleClass()};
        System.out.println(String.format("третий %b", compareArrays(arr5, arr6)));

        System.out.println();

        Pair<String, Integer> pair1 = new Pair<>("first", 1);
        System.out.println(pair1);


    }

    public static <T, Y> boolean compareArrays(T[] arr1, Y[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].getClass().getName().equals(arr2[i].getClass().getName())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public record Pair<T, Y>(T first, Y second) {

        public T getFirst() {
            return first;
        }

        public Y getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "{" + first + ", " + second + "}";
        }
    }
}
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введи размер массива :");
        int n = scanner.nextInt();
        int[] mass = new int[n];
        fillMassByRandom(mass);
        // fillMassByHand(mass, scanner);
        System.out.println(Arrays.toString(mass));

        taskOne(mass);
        taskTwo(mass);
        taskThree(mass);
        taskFour(mass);
    }
        /**
         * @param mass массив для заполнения
         * @apiNote метод будет наполнять массив от -50 до +50 int значениями
         */
        private static void fillMassByRandom(int[] mass) {
            Random random = new Random();
            for (int i = 0; i < mass.length; i++) {
                mass[i] = random.nextInt(20);
            }
        }

        /**
         * @param mass массив для заполнения
         * @apiNote метод будет наполнять массив int значениями из ввода в консоль
         */
        private static void fillMassByHand(int[] mass, Scanner scanner) {
            for (int i = 0; i < mass.length; i++) {
                mass[i] = scanner.nextInt();
            }
        }

        /**
         * @param mass массив для печати
         * @apiNote метод печатает содержимое массива в консоль
         */
        private static void printMass(int[] mass) {
            for (int i = 0; i < mass.length; i++) {
                System.out.print(mass[i] + " ");
            }
            System.out.println();
        }

        /**
         * @param mass входной массив
         * @apiNote Дан массив целых чисел.
         * Найти количество положительных элементов,
         * расположенных на позициях не кратных 3.
         */
        private static void taskOne(int[] mass) {
            int counter = 0;
            for (int i = 0; i < mass.length; i++) {
                if (i % 3 != 0 && mass[i] > 0) {
                    counter++;
                }
            }
            System.out.println("counter = " + counter);
        }

        /**
         * @param mass входной массив
         * @apiNote Дан массив целых чисел.
         * Найти сумму элементов,
         * у которых последняя и предпоследняя цифры равны.
         */
        private static void taskTwo(int[] mass) {
            int sum = 0;
            for (int i = 0; i < mass.length; i++) {
                if (mass[i] % 10 == mass[i] % 100 / 10) {
                    sum += mass[i];
                }
            }
            System.out.println("sum = " + sum);
        }

        /**
         * @param mass входной массив
         * @apiNote Дан массив целых чисел.
         * Если в массиве хотя бы один элемент положительный,
         * то в каждом четном элементе поменять местами последнюю
         * и предпоследнюю цифры.
         */
        private static void taskThree(int[] mass) {
            boolean isPositive = checkIsPositive(mass);
            if (isPositive) {
                for (int i = 0; i < mass.length; i++) {
                    if (mass[i] % 2 == 0) {
                        mass[i] = mass[i] / 100 * 100 +
                                mass[i] % 10 * 10 + mass[i] % 100 / 10;
                    }
                }
                System.out.println("измененный массив выглядит так: " +
                        Arrays.toString(mass));
            } else {
                System.out.println("нет ни 1 позитивного значения!");
            }
        }

        /**
         * @param mass входной массив
         * @return есть ли позитивное значение или нет?
         */
        private static boolean checkIsPositive(int[] mass){
            for (int i = 0; i < mass.length; i++) {
                if (mass[i] > 0) {
                    return true;
                }
            }
            return false;
        }
        /**
         * @param mass входной массив
         * @apiNote Дано два упорядоченных по возрастанию массива целых чисел.
         * Получить третий упорядоченный массив – слияние двух исходных,
         * не используя сортировки.
         */
        private static void taskFour(int[] mass) {
            int[] massTwo = new int[mass.length];
            fillMassByRandom(massTwo);
            Arrays.sort(mass);
            Arrays.sort(massTwo);
            System.out.println(Arrays.toString(mass));
            System.out.println(Arrays.toString(massTwo));

            int[] resultMass = new int[2 * mass.length];
            int mOneIterator = 0;
            int mTwoIterator = 0;
            for (int i = 0; i < resultMass.length; i++) {
                if (mOneIterator < mass.length && mTwoIterator < massTwo.length) {
                    if (mass[mOneIterator] < massTwo[mTwoIterator]) {
                        resultMass[i] = mass[mOneIterator];
                        mOneIterator++;
                    } else {
                        resultMass[i] = massTwo[mTwoIterator];
                        mTwoIterator++;
                    }
                } else {
                    if (mOneIterator < mTwoIterator) {
                        resultMass[i] = mass[mOneIterator];
                        mOneIterator++;
                    } else {
                        resultMass[i] = mass[mTwoIterator];
                        mTwoIterator++;
                    }
                }
            }
        System.out.println("Arrays.toString(resultMass) = " + Arrays.toString(resultMass));
    }
}
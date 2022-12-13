package ClassWork001.Task002;

public class Model {
    /**
     * Опроеделяет сумму последовательностей 3 элементов массива
     * @param array
     * @param count
     * @return возвращает массив сумм из count элнментов исходного массива
     */
    public static int [] getSum(int[] array, int count){
        int size = array.length;
        int resultLenght = size - count + 1;
        int [] result = new int [resultLenght];
        for (int i = 0; i < resultLenght; i++) {
            result[i] = sumItems(array, i, count);
        }

        return result;
    }

        /**
     * Возвращает сумму count элементов начиная с indexFrom
     * @param array
     * @param indexFrom
     * @param count
     * @return Возвращает сумму count элементов начиная с indexFrom
     */
    private static int sumItems(int[] array, int indexFrom, int count) {
		int sum = 0;
		for (int i = indexFrom; i < Math.min(array.length, indexFrom + count); ++i) {
			sum += array[i];
		}
		return sum;
	}


    public static boolean check(int[] array, int count){
        return array.length >= count;
    }
}

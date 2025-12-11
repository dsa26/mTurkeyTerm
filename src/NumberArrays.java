public class NumberArrays {

    public static int[] numbers0To100 = createNumberArray(100);
    public static int[] numbers0To1000 = createNumberArray(1000);
    public static int[] numbers0To10000 = createNumberArray(10000);
    public static int[] numbers0To100000 = createNumberArray(100000);
    public static int[] numbers0To1000000 = createNumberArray(1000000);
    public static int[] numbers0To10000000 = createNumberArray(10000000);


    //array index will be one less than the actual value
    private static int[] createNumberArray(int size) {
        int[] numbers = new int[size];
        for (int i = 1; i <= size; i++) {
            numbers[i - 1] = i;
        }
        return numbers;
    }




}

package ru.geekbrains.seminar_04;

public class Main {
    public static void main(String[] args) {
        String[][] arr0 = new String[][]{
                {"0", "1", "2", "3"},
                {"1", "2", "3", "4"},
                {"2", "3", "4", "s"},
                {"3", "4", "s", "6"}
        };

        String[][] arr1 = new String[][]{
                {"0", "1", "2", "3"},
                {"1", "2", "3", "4"},
                {"2", "3", "4", "5"},
                {"3", "4", "5", "6"}
        };

        try {
            System.out.println("The sum of the array elements is equal to " + arrayConvertingAndCalcSum(arr0));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println("The sum of the array elements is equal to " + arrayConvertingAndCalcSum(arr1));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }


    /**
     *
     * @param arr
     * @return
     * @throws MyArraySizeException
     * @throws MyArrayDataException
     */
    private static int arrayConvertingAndCalcSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int arrSize = 4;
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException(String.format("The dimension of the array must be: %dх%d.", arrSize, arrSize));
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(String.format("The dimension of the array must be: %dх%d.", arrSize, arrSize));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("In position [%d][%d] the source array is not an integer %s.", i, j, arr[i][j]));
                }
            }
        }

        return sum;
    }
}

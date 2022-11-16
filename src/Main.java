public class Main {
    /*Given an array of N numbers, write an algorithm that returns the largest sum of two numbers whose digits add up
    * to the same value. If no numbers' digits add up to the same value, return -1*/


    //find matching pairs
    //maybe start from the highest numbers? actually, one needs to start at one end, the other at the other, as 91 19, etc
    //would sorting be beneficial? we have to check every number anyway ... let's go for an unsorted version

    //track the highest sum so far, and replace when a higher one is found

    private static int findMaxSum(int[] numbers) {
        int max = -1;
        for(int i = 0; i < numbers.length - 1; i ++) {
            int iDigitSum = getSumOfDigits(numbers[i]);
            for(int j = i+1; j < numbers.length; j++) {
                int jDigitSum = getSumOfDigits(numbers[j]);
                if (iDigitSum == jDigitSum && numbers[i] + numbers[j] > max){
                    max = numbers[i] + numbers[j];
                }
            }
        }
        return max;
    }

    private static int getSumOfDigits(Integer element) {
        int total = 0;
        String number = element.toString();
        char[] digits = number.toCharArray();
        for(char digit : digits)
        {

            total += Character.getNumericValue(digit);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] input = {51,32,43};
        int result = findMaxSum(input);
        System.out.println(result);

    }

}

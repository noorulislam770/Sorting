public class Recursion {
    public static void main(String[] args) {
        int sumOfDigit = addDigit(1239849);
        System.out.println("Sum of digit = " + sumOfDigit);


        int fact = factorialTerm(5);
        System.out.println("Factorial Term of 5 = " + fact);

        int favTerm = fabonachiTerm(5, 0,1);
        System.out.println("fabonachi term " + favTerm);
    }


    public static int addDigit(int numberIn){
        if (numberIn <= 9) {
            return numberIn;
        }
        return numberIn % 10 + addDigit(numberIn/10);
    }


    public static int factorialTerm(int numberIn){
        if (numberIn < 2){
            return 1;
        }
        return numberIn * factorialTerm(numberIn-1);
    }

    public static int fabonachiTerm(int numberIn,int prev, int current){
        int sum = current;
        if (numberIn > 0){
            sum = current + prev;
            fabonachiTerm(numberIn - 1, current, sum);   
            return sum;
        }
        return sum;

    }
}

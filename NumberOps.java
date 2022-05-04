public class NumberOps {
    public String decimalToBinary(int decimal, String result) {
        if (decimal == 0) {
            return result;
        }

        result = decimal % 2 + result;
        return decimalToBinary(decimal / 2, result);
    }

    public int sumNatural(int idx) {
        // iterative approach
        // int sum = 0;
        // for (int i = 1; i <= idx; i++) {
        //     sum += i;
        // }
        // return sum;

        // recursive approach
        if (idx <= 1) {
            return idx;
        }
        return idx + sumNatural(idx - 1);
    }

    public static void main(String[] args) {
        NumberOps obj = new NumberOps();
        String result = "";
        System.out.println(obj.decimalToBinary(7, result));
        System.out.println(obj.sumNatural(10));
    }
}
package converter.Parts_combined;


    public class HexTo {


        public String[] hexTo(final String hexadecimalNumber) {
            int decimalNumber;
            decimalNumber = hexadecimalToDecimal(hexadecimalNumber);
            hexadecimalToBinary(decimalNumber);
            hexadecimalToOctal(decimalNumber);
            String[] strAr2 = new String[] {String.valueOf(decimalNumber), hexadecimalToBinary(decimalNumber), hexadecimalToOctal(decimalNumber)};
            return strAr2;
        }
        public static int hexadecimalToDecimal(String s) {

            String digits = "0123456789ABCDEF";
            s = s.toUpperCase();
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int d = digits.indexOf(c);
                val = 16 * val + d;
            }
            return val;
        }

        private static String hexadecimalToBinary(int decimalNumber) {
            int j;
            int quot;
            int i = 1;
            String s = "";
            int[] binaryNumber = new int[100];
            quot = decimalNumber;
            while (quot != 0) {
                binaryNumber[i++] = quot % 2;
                quot = quot / 2;
            }
            for (j = i - 1; j > 0; j--) {
                s += binaryNumber[j];
            }
        return s;
        }

    private static String hexadecimalToOctal(final int decimalNumber) {
        int i = 1;
        int j;
        int quot;
        String s = "";
        int[] octalNumber = new int[100];
        quot = decimalNumber;
        while (quot != 0) {
            octalNumber[i++] = quot % 8;
            quot = quot / 8;
        }
        for (j = i - 1; j > 0; j--) {
            s += octalNumber[j];
        }
        return s;
    }
}

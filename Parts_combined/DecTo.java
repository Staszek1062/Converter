package converter.Parts_combined;


public class DecTo {
    public final String[] decTo(final int decimalNumber) {
      String[] strAr2 = new String[] {decimalToBinary(decimalNumber), decimalToHexdecimal(decimalNumber), decimalToOctal(decimalNumber)};
      return strAr2;
    }

    private static String decimalToBinary(final int decimalNumber) {
        int[] binaryNumber = new int[100];
        int quot;
        int i = 1;
        int j;
        String s = "";
         quot = decimalNumber;
         while (quot != 0) {
            binaryNumber[i++] = quot % 2;
            quot = quot / 2;
         }
         for (j = i - 1; j > 0; j--)
         s += binaryNumber[j];
         return s;

    }

    private static String decimalToOctal(final int decimalNumber) {
        int quot;
        int i = 1;
        int j;
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

    private static String decimalToHexdecimal(final int decimalNumber) {
        int quot;
        int rem;
        String hexdecimalNumber = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        quot = decimalNumber;
         while (quot > 0) {
            rem = quot % 16;
            hexdecimalNumber = hex[rem] + hexdecimalNumber;
            quot = quot / 16;
          }
          return hexdecimalNumber;
    }
}

package converter.Parts_combined;

public class BinTo {
     public final String[] binTo(final int binaryNumber) {
        int decimalNumber;
      decimalNumber = decimal(binaryNumber);
      String[] strAr1 = new String[] {String.valueOf(decimalNumber), hexadecimal(decimalNumber), octal(decimalNumber)};
      return strAr1;
    }


    private static int decimal(final int binaryNumber) {
        int quot;
        int rem;
        int j = 1;
        int decimalNumber = 0;
        quot = binaryNumber;
            while (quot != 0) {
            rem = quot % 10;
            decimalNumber = decimalNumber + rem * j;
            j = j * 2;
            quot = quot / 10;
            }
        return decimalNumber;
    }

    private static String hexadecimal(final int decimalNumber) {
        var hexdecimalNumber = new int[100];
        String s = "";
        int i = 0;
        int quot;
        int j = 1;
        quot = decimalNumber;
            while (quot != 0) {
            hexdecimalNumber[i] = quot % 16;
            quot = quot / 16;
            i++;
        }

        for (j = i - 1; j >= 0; j--) {
            if (hexdecimalNumber[j] <= 9) {
                s +=  hexdecimalNumber[j];
            } else {
                s += (char) (hexdecimalNumber[j] + 55);
            }
        }
        return s;
    }
    
    private static String octal(final int decimalNumber) {
        int[] octalNumber = new int[100];
        int i = 0;
        int j = 1;
        String s = "";
        int quot;
        quot = decimalNumber;
        while (quot > 0) {
            octalNumber[i++] = quot % 8;
            quot = quot / 8;
        }
        for (j = i - 1; j >= 0; j--) {
            s += (octalNumber[j]);
        }
        return s;
    }

}

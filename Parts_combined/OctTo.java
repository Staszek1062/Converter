package converter.Parts_combined;

public class OctTo {

    public String[] octTo(final int octalNumber) {
        long decimalNumber = octalToDecymal(octalNumber);
        String[] strAr2 = new String[] {String.valueOf(decimalNumber),
                String.valueOf(octalToBinary(octalNumber)),
                octalToHexadecimal(decimalNumber) };
       return strAr2;
    }

    private static long octalToDecymal(final int octalNumber) {
        int quot;
        int i = 0;
        long decymalNumber = 0;
        quot = octalNumber;


        while (quot != 0) {
            decymalNumber = (long) (decymalNumber + (quot % 10) * Math.pow(8, i++));
            quot = quot / 10;
        }
        return decymalNumber;
    }

    private static long octalToBinary(final long octalNumber) {
        long[] octalNumberVal = {0, 1, 10, 11, 100, 101, 110, 111 };
        long quot = octalNumber;
        long binaryNumber = 0;
        long place = 1;
        int rem;

        while (quot != 0) {
            rem = (int) quot % 10;
            binaryNumber = octalNumberVal[ rem] * place + binaryNumber;
            quot /= 10;
            place *= 1000;
        }
        return binaryNumber;
    }

    private static String octalToHexadecimal(final long decymalNumber) {
        String hexadecymalNumber = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        long quot;
        int rem;
        quot = decymalNumber;
        while (quot > 0) {
            rem = (int) quot % 16;
            hexadecymalNumber = hex[rem] + hexadecymalNumber;
            quot = quot / 16;
        }
    return hexadecymalNumber;
    }
}

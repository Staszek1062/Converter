package converter.Parts_combined;

public class OctTo {

    public String[] octTo(final int oct_num) {
        long decimalNumber = octalToDecymal(oct_num);
        String[] strAr2 = new String[] {String.valueOf(decimalNumber),
                String.valueOf(octalToBinary(oct_num)),
                octalToHexadecimal(decimalNumber) };
       return strAr2;
    }

    private static long octalToDecymal(final int oct_num) {
        int quot;
        int i = 0;
        long dec_num = 0;
        quot = oct_num;


        while (quot != 0) {
            dec_num = (long) (dec_num + (quot % 10) * Math.pow(8, i++));
            quot = quot / 10;
        }
        return dec_num;
    }

    private static long octalToBinary(final long oct_num) {
        long[] oct_num_val = { 0, 1, 10, 11, 100, 101, 110, 111 };
        long quot = oct_num;
        long bin_num = 0;
        long place = 1;
        int rem;

        while (quot != 0) {
            rem = (int)quot % 10;
            bin_num = oct_num_val[ rem] * place + bin_num;
            quot /= 10;
            place *= 1000;
        }
        return bin_num;
    }

    private static String octalToHexadecimal(final long dec_num) {
        String hex_num = "";
        char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        long quot;
        int rem;
        quot=dec_num;
        while(quot>0) {
            rem =(int) quot % 16;
            hex_num = hex[rem] + hex_num;
            quot = quot / 16;
        }
    return hex_num;
    }
}

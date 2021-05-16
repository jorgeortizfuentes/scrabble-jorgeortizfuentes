package cl.uchile.dcc.scrabble.gui;

public class BinUtilities {

    public static int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    private static int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    private static int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private static int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }


    public static String positiveIntToBinary(int n){
        String binary = "";
        int rest;
        while (n != 0) {
            rest = n % 2;
            binary = rest + binary;
            n = (n- rest) / 2 ;
        }
        return binary;
    }

    public static String twosComplement(String binary){
        String new_binary = "";
        int len = binary.length();
        boolean found = false;
        for (int i = len-1; i > -1; i--) {
            if (binary.charAt(i) == '0' & !found) {
                new_binary =  0 + new_binary;
            } else {
                boolean equals = binary.charAt(i) == '1';
                if (equals & !found) {
                    new_binary =  1 + new_binary;
                    found = true;
                } else if (equals) {
                    new_binary =  0 + new_binary;
                }else {
                    new_binary = 1 + new_binary;
                }
            }
        }
        return new_binary;
    }

    public static String intToBinary(int n){
        int absN = Math.abs(n);
        String binary = BinUtilities.positiveIntToBinary(absN);
        int len = binary.length();

        if (n < 0){
            String new_binary = BinUtilities.twosComplement(binary);
            binary = "1".repeat(16-len) + new_binary;
        } else {
            binary = "0".repeat(16-len) + binary;
        }
        return binary;
    }

}

package cl.uchile.dcc.scrabble.types;

/**
 * Implementation of the <i>BinUtilities</i>. These allow you to perform auxiliary operations
 * between numbers and binaries numbers.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class BinUtilities {

  /**
   * Transforms a binary in java string format to a positive or negative int
   *
   * @param binary string with zeros and ones
   * @return a java int number
   */
  public static int binaryToInt(String binary) {
    if (bitToInt(binary.charAt(0)) == 0) {
      return positiveBinToInt(binary);
    } else {
      return negativeBinaryToInt(binary);
    }
  }

  /**
   * Transforms a negative binary in java string format to negative int
   *
   * @param binary string with zeros and ones
   * @return a negative java int number
   */
  private static int negativeBinaryToInt(String binary) {
    int n = binary.length() - 1;
    int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
    for (int i = n, j = 0; i > 0; i--, j++) {
      w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
    }
    return w;
  }

  /**
   * Transforms a positive binary in java string format to positive int
   *
   * @param binary string with zeros and ones
   * @return a positive java int number
   */
  private static int positiveBinToInt(String binary) {
    int w = 0;
    for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
      w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
    }
    return w;
  }

  /**
   * Transforms a bit to int
   *
   * @param bit a char bit
   * @return a int with zero or one
   */
  private static int bitToInt(char bit) {
    return bit == '0' ? 0 : 1;
  }

  /**
   * Transforms a positive int to binary
   *
   * @param n a positive int
   * @return binary in java string format
   */
  private static String positiveIntToBinary(int n) {
    String binary = "";
    int rest;
    while (n != 0) {
      rest = n % 2;
      binary = rest + binary;
      n = (n - rest) / 2;
    }
    return binary;
  }

  /**
   * Transform a binary in string format to its twos complement
   *
   * @param binary binary string with zeros and ones
   * @return binary twos complement java string
   */
  private static String twosComplement(String binary) {
    String new_binary = "";
    int len = binary.length();
    boolean found = false;
    for (int i = len - 1; i > -1; i--) {
      if (binary.charAt(i) == '0' & !found) {
        new_binary = 0 + new_binary;
      } else {
        boolean equals = binary.charAt(i) == '1';
        if (equals & !found) {
          new_binary = 1 + new_binary;
          found = true;
        } else if (equals) {
          new_binary = 0 + new_binary;
        } else {
          new_binary = 1 + new_binary;
        }
      }
    }
    return new_binary;
  }

  /**
   * Transforms any int to a binary
   *
   * @param n any java int, positive or negative
   * @return binary string with zeros and ones
   */
  public static String intToBinary(int n) {
    int absN = Math.abs(n);
    String binary = BinUtilities.positiveIntToBinary(absN);

    if (n < 0) {
      String new_binary = BinUtilities.twosComplement(binary);
      binary = "1" + new_binary;
    } else {
      binary = "0" + binary;
    }
    return binary;
  }
}

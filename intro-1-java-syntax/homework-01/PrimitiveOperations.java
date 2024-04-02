public class PrimitiveOperations {
  public static void main(String[] args) {
    int integer = 10;
    double decimal = 5.0;
    System.out.println(integer);
    System.out.println(decimal);

    double multiply = integer * decimal;
    System.out.println(multiply);

    double convertedInteger = (double) integer;
    System.out.println(convertedInteger);

    int convertedDecimal = (int) decimal;
    System.out.println(convertedDecimal);

    char character = 'A';
    System.out.println(character);

    char lowercaseCharacter = (char) (character + 32);
    System.out.println(lowercaseCharacter);
  }
}

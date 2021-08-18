package utills;

public class Utils {


  // Generate the random String
  public static String generateRandomString(int count) {  // Pass the count, How many character you want in that string
    final String ALPHA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwzyz";
    StringBuilder stringBuilder = new StringBuilder();
    while (count-- != 0) {
      int character = (int) (Math.random() * ALPHA_STRING.length());
      stringBuilder.append(ALPHA_STRING.charAt(character));
    }
    return stringBuilder.toString();
  }
}

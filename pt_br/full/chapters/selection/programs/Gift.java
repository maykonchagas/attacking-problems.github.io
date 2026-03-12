import java.util.Scanner;

public class Gift {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter a year: ");
    int year = in.nextInt();
    in.close();

    String gift;

    gift = getGiftStatement(year);
    System.out.println("The gift for anniversary " + year + " is " + gift + " (statement version)");

    gift = getGiftExpression(year);
    System.out.println(
        "The gift for anniversary " + year + " is " + gift + " (expression version)");
  }

  private static String getGiftStatement(int year) {
    String gift;

    switch (year) {
      case 1:
        gift = "Paper";
        break;
      case 2:
        gift = "Cotton";
        break;
      case 3:
        gift = "Leather";
        break;
      case 4:
        gift = "Fruit";
        break;
      case 5:
        gift = "Wood";
        break;
      case 6:
        gift = "Candy / Iron";
        break;
      case 7:
        gift = "Wool / Copper";
        break;
      case 8:
        gift = "Bronze / Pottery";
        break;
      case 9:
        gift = "Pottery / Willow";
        break;
      case 10:
        gift = "Tin / Aluminum";
        break;
      case 11:
        gift = "Steel";
        break;
      case 12:
        gift = "Silk / Linen";
        break;
      case 13:
        gift = "Lace";
        break;
      case 14:
        gift = "Ivory";
        break;
      case 15:
        gift = "Crystal";
        break;
      case 20:
        gift = "China";
        break;
      case 25:
        gift = "Silver";
        break;
      case 30:
        gift = "Pearl";
        break;
      case 35:
        gift = "Coral";
        break;
      case 40:
        gift = "Ruby";
        break;
      case 45:
        gift = "Sapphire";
        break;
      case 50:
        gift = "Gold";
        break;
      case 55:
        gift = "Emerald";
        break;
      case 60:
        gift = "Diamond";
        break;
      default:
        gift = "No traditional gift";
        break;
    }
    return gift;
  }

  private static String getGiftExpression(int year) {
    String gift =
        switch (year) {
          case 1 -> "Paper";
          case 2 -> "Cotton";
          case 3 -> "Leather";
          case 4 -> "Fruit";
          case 5 -> "Wood";
          case 6 -> "Candy / Iron";
          case 7 -> "Wool / Copper";
          case 8 -> "Bronze / Pottery";
          case 9 -> "Pottery / Willow";
          case 10 -> "Tin / Aluminum";
          case 11 -> "Steel";
          case 12 -> "Silk / Linen";
          case 13 -> "Lace";
          case 14 -> "Ivory";
          case 15 -> "Crystal";
          case 20 -> "China";
          case 25 -> "Silver";
          case 30 -> "Pearl";
          case 35 -> "Coral";
          case 40 -> "Ruby";
          case 45 -> "Sapphire";
          case 50 -> "Gold";
          case 55 -> "Emerald";
          case 60 -> "Diamond";
          default -> "No traditional gift";
        };
    return gift;
  }
}

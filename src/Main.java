import java.util.Scanner;
import java.util.Random;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String [] array = {"Rock", "Paper", "Scissors"};


    public static void main(String[] args) {
        String playerWantToPlayAgain = "yes";

        while (playerWantToPlayAgain.equalsIgnoreCase("yes")) {
            play();

            System.out.println("Do you want to play again (yes/no): ");
            playerWantToPlayAgain = scanner.nextLine();

            while (!playerWantToPlayAgain.equalsIgnoreCase("yes") &&
                    !playerWantToPlayAgain.equalsIgnoreCase("no")) {
                System.out.println("Incorrect input, please choose between yes/no:");
                playerWantToPlayAgain = scanner.nextLine();
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    static int findIndexInArrayIgnoreCase(String elementToFind, String[] array){
        boolean isFound = false;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(elementToFind.equalsIgnoreCase(array[i])){
                isFound = true;
                index = i;
                break;
            }
        }
        if(!isFound){
            System.out.println("Element not found");
        }
        return(index);
    }

    static int displayPlayMessageAndReturnIndex(){
        System.out.print("Enter your move (");
        for(String element : array) {
            System.out.print(element + ", ");
        }
        System.out.print("): ");
        String playerInput = scanner.nextLine();
        int playerInputIndex = findIndexInArrayIgnoreCase(playerInput, array);
        System.out.println();
        return(playerInputIndex);
    }

    static boolean winOrLose(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();

        return switch (playerChoice) {
            case "rock" -> computerChoice.equals("scissors");
            case "paper" -> computerChoice.equals("rock");
            case "scissors" -> computerChoice.equals("paper");
            default -> false;
        };
    }


    static void play(){
        int playerChoiceIndex = -1;
        while(playerChoiceIndex == -1){
            playerChoiceIndex = displayPlayMessageAndReturnIndex();
            if(playerChoiceIndex == -1){
                System.out.println("Incorrect value, try again");
            }
        }
        Random random = new Random();
         int computerRandomIndex = random.nextInt(0, array.length);
         String computerChoice = array[computerRandomIndex];
         String playerChoice = array[playerChoiceIndex];
         System.out.println("Computer choice: " + computerChoice);

         if(playerChoice.equals(computerChoice)){
             System.out.println("DRAW");
             return;
         }

         boolean result = winOrLose(playerChoice, computerChoice);
         System.out.println(result ? "You win ! \uD83D\uDE00" : "You loose \uD83D\uDE14");
     };
}

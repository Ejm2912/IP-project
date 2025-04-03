import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
public class Main {
    // Display ASCII Art at the beginning
    public static void displayAsciiArt() {
        System.out.println("""
                 __        ___   _ _____ _____ _        ___  _____ 
                \\ \\      / / | | | ____| ____| |      / _ \\|  ___|
                 \\ \\ /\\ / /| |_| |  _| |  _| | |     | | | | |_   
                  \\ V  V / |  _  | |___| |___| |___  | |_| |  _|  
                 __\\_/\\_/_ |_|_|_|_____|_____|_____|__\\___/|_|    
                |  ___/ _ \\|  _ \\_   _| | | | \\ | | ____|         
                | |_ | | | | |_) || | | | | |  \\| |  _|           
                |  _|| |_| |  _ < | | | |_| | |\\  | |___          
                |_|   \\___/|_| \\_\\|_|  \\___/|_| \\_|_____|         
                """);
    }

    //Display closing message
    public static void closeGame() {
        System.out.println("""
                ______
                                |      |
                                |      O
                                |     /|\\\\
                                |     / \\\\
                                |
                                =========  """);
    }

    public static class Player {
        private String name; // The player's name
        private int score; // The player's score

        // Constructor (a special method to create player objects)
        public Player(String name) {
            this.name = name;
            this.score = 0; // Start with a score of 0
        }

        // Method to get the player's name
        public String getName() {
            return name;
        }

        // Method to get the player's score
        public int getScore() {
            return score;
        }

        // Method to add to the player's score
        public void addScore(int amount) {
            score += amount;
        }
    }

    public static int spinWheel(){
        Random random = new Random();
        return (random.nextInt(10) + 1) * 100;
    }

    public static void catsAndPhrases() {

        char chara;
        String line;
        Scanner in = new Scanner(System.in);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        System.out.println();
        System.out.println("Welcome to Wheel of Fortune! Spin the wheel and guess the phrase to win big money!");
        displayAsciiArt();
        System.out.println("Here is your category.");
        Random random = new Random();
        int randomCat = random.nextInt(9);
        String test = " ";

        if (randomCat == 0) {
            System.out.println("Around The House");
            int randomPhrase1 = random.nextInt(4);
            if (randomPhrase1 == 0) {
                test = "Cozy Fireplace Mantel";
            }
            if (randomPhrase1 == 1) {
                test = "Stack Of Fluffy Towels";
            }
            if (randomPhrase1 == 2) {
                test = "Decorative Throw Pillows";
            }
            if (randomPhrase1 == 3) {
                test = "Squeaky Rocking Chair";
            }
        } else if (randomCat == 1) {
            System.out.println("Food and Drink");
            int randomPhrase2 = random.nextInt(4);
            if (randomPhrase2 == 0) {
                test = "Ice-Cold Lemonade";
            }
            if (randomPhrase2 == 1) {
                test = "Crispy Chicken Tenders";
            }
            if (randomPhrase2 == 2) {
                test = "Freshly Baked Apple Pie";
            }
            if (randomPhrase2 == 3) {
                test = "Spaghetti With Meatballs";
            }
        } else if (randomCat == 2) {
            System.out.println("Before and After");
            int randomPhrase3 = random.nextInt(4);
            if (randomPhrase3 == 0) {
                test = "Golden Retriever Puppy Love";
            }
            if (randomPhrase3 == 1) {
                test = "Apple Pie Chart";
            }
            if (randomPhrase3 == 2) {
                test = "Rock Climbing Gym Membership";
            }
            if (randomPhrase3 == 3) {
                test = "Chocolate Bar Exam";
            }
        } else if (randomCat == 3) {
            System.out.println("In The Kitchen");
            int randomPhrase4 = random.nextInt(4);
            if (randomPhrase4 == 0) {
                test = "Stainless Steel Toaster";
            }
            if (randomPhrase4 == 1) {
                test = "Nonstick Frying Pan";
            }
            if (randomPhrase4 == 2) {
                test = "Measuring Cups And Spoons";
            }
            if (randomPhrase4 == 3) {
                test = "Spice Rack Organizer";
            }
        } else if (randomCat == 4) {
            System.out.println("Best Seller(s)");
            int randomPhrase5 = random.nextInt(4);
            if (randomPhrase5 == 0) {
                test = "The Great Gatsby";
            }
            if (randomPhrase5 == 1) {
                test = "New York Times Bestseller List";
            }
            if (randomPhrase5 == 2) {
                test = "To Kill A Mockingbird";
            }
            if (randomPhrase5 == 3) {
                test = "The Catcher In The Rye";
            }
        } else if (randomCat == 5) {
            System.out.println("Character(s)");
            int randomPhrase6 = random.nextInt(4);
            if (randomPhrase6 == 0) {
                test = "The Three Musketeers";
            }
            if (randomPhrase6 == 1) {
                test = "Sherlock Holmes And Dr. Watson";
            }
            if (randomPhrase6 == 2) {
                test = "Romeo And Juliet";
            }
            if (randomPhrase6 == 3) {
                test = "The Hardy Boys";
            }
        } else if (randomCat == 6) {
            System.out.println("Fictional Character(s)");
            int randomPhrase7 = random.nextInt(4);
            if (randomPhrase7 == 0) {
                test = "Harry Potter And The Sorcerer’s Stone";
            }
            if (randomPhrase7 == 1) {
                test = "Winnie The Pooh";
            }
            if (randomPhrase7 == 2) {
                test = "SpongeBob SquarePants";
            }
            if (randomPhrase7 == 3) {
                test = "Katniss Everdeen";
            }
        } else if (randomCat == 7) {
            System.out.println("Event(s)");
            int randomPhrase8 = random.nextInt(4);
            if (randomPhrase8 == 0) {
                test = "High School Graduation";
            }
            if (randomPhrase8 == 1) {
                test = "Surprise Birthday Party";
            }
            if (randomPhrase8 == 2) {
                test = "Thanksgiving Day Parade";
            }
            if (randomPhrase8 == 3) {
                test = "New Year's Eve Celebration";
            }
        } else {
            System.out.println("Movie Quotes");
            int randomPhrase9 = random.nextInt(4);
            if (randomPhrase9 == 0) {
                test = "May the Force be with you.  Star Wars";
            }
            if (randomPhrase9 == 1) {
                test = "I'll be back.  The Terminator";
            }
            if (randomPhrase9 == 2) {
                test = "You can't handle the truth!   A Few Good Men ";
            }
            if (randomPhrase9 == 3) {
                test = "There's no place like home.  The Wizard of Oz";
            }
        }
        System.out.println("Here is your phrase");


        String hiddenTest = test.replaceAll("[a-zA-z]", "_");
        System.out.println(hiddenTest);

        System.out.println();
        System.out.println("Guess the Phrase!");


        boolean guess = true;
        boolean[] guessedChars = new boolean[test.length()];
        int currentPlayer = 1;

        while (guess) {

            System.out.println("Player " + (currentPlayer == 1 ? player1.getName() : player2.getName()) + "'s turn!");
            System.out.println(player1.getName() + " score: $" + player1.getScore());
            System.out.println(player2.getName() + " score: $" + player2.getScore());

            System.out.println("Guess a letter!");
            chara = in.nextLine().charAt(0);

            if (test.contains(Character.toString(chara))) {
                for (int i = 0; i < test.length(); i++) {
                    if (test.charAt(i) == chara) {
                        guessedChars[i] = true;
                        if (currentPlayer == 1) {
                            player1.addScore(spinWheel()); // Add score for player 1
                        } else {
                            player2.addScore(spinWheel()); // Add score for player 2
                        }
                    }
                }
            }

            StringBuilder currentGuess = new StringBuilder();
            for (int i = 0; i < test.length(); i++) {
                if (guessedChars[i]) {
                    currentGuess.append(test.charAt(i));
                } else {
                    currentGuess.append('_');
                }
            }

            hiddenTest = currentGuess.toString();
            System.out.println(hiddenTest);

            if (!test.contains(Character.toString(chara))) {
                System.out.println("Wrong guess spin again!");
            }

            System.out.println("Do you want to solve the phrase?(Type yes or no)");
            line = in.nextLine();

            if (Objects.equals(line, "yes")) {
                guess = false;
                System.out.println("You have 3 guesses if you get them wrong you lose!");

                for (int i = 0; i < 3; i++) {
                    line = in.nextLine();
                    if (Objects.equals(line, test)) {
                        System.out.print("You just won Wheel of Fortune! Congratulations!");
                        if (currentPlayer == 1) {
                            player1.addScore(1000);
                        } else {
                            player2.addScore(1000);
                        }
                        break; // only break when the answer is correct.
                    } else {
                        if (i < 2) {
                            System.out.println("You have " + (2 - i) + " guesses remaining.");
                            System.out.println("Would you like a hint? (Note all preivious hints will" +
                                    " show for extra help.)");
                            line = in.nextLine();
                            if (line.equalsIgnoreCase("yes")) {
                                    System.out.println("Here is hint one : " + test.substring(0, 5));
                                if (i == 1) {
                                    System.out.println("Here is a hint two: " + test.substring(0, 10));
                                }
                            }




                    } else {
                            System.out.println("You lose! Too bad!");
                            System.out.println("The correct phrase is: " + test);
                            closeGame();
                        }
                    }


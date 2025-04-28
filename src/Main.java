


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

    public static void catsAndPhrases() {

        char chara;
        String line;
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to Wheel of Fortune! Spin the wheel and guess the phrase to win big money!");
        displayAsciiArt();

         // NEW: Select difficulty
        System.out.println("\nSelect Difficulty: (easy, hard, impossible)");
        String difficulty = in.nextLine().toLowerCase();
        int allowedGuesses = 3; // default to hard
        if (difficulty.equals("easy")) {
            allowedGuesses = 5;
        } else if (difficulty.equals("hard")) {
            allowedGuesses = 3;
        } else if (difficulty.equals("impossible")) {
            allowedGuesses = 1;
        } else {
            System.out.println("Invalid difficulty, defaulting to hard mode.");
        }
        
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

        while (guess) {
            System.out.println("guess a letter!");
            chara = in.nextLine().charAt(0);

            if (test.contains(Character.toString(chara)))
                for (int i = 0; i < test.length(); i++) {
                    if (test.charAt(i) == chara) {
                        guessedChars[i] = true;
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
                line = in.nextLine();

                if (Objects.equals(line, test)) {
                    System.out.print("You just won Wheel of Fortune! Congratulations!");
                } else {
                    System.out.println("You have 2 guesses remaining.");
                }

                line = in.nextLine();
                if (Objects.equals(line, test)) {
                    System.out.print("You just won Wheel of Fortune! Congratulations!");
                } else {
                    System.out.println("You have 1 guesses remaining.");


                    line = in.nextLine();
                    if (Objects.equals(line, test)) {
                        System.out.print("You just won Wheel of Fortune! Congratulations!");
                        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\"");
                        closeGame();
                    } else {
                        System.out.println("You lose! Too bad!");
                        System.out.println("The correct phrase is: " + test);
                        closeGame();
                    }

                    if (Objects.equals(line, "no")) {
                        guess = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        catsAndPhrases();
    }
}

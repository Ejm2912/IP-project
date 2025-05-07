import java.util.*;
import java.util.Random;

public class Main {

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
    public class WheelOfFortune {

        static String[] wheelArt = {
                " ___________________________",
                "|       WHEEL OF FORTUNE    |",
                "|---------------------------|",
                "|  1 |   $500     🪙        |",
                "|---------------------------|",
                "|  2 | Lose Turn   ❌       |",
                "|---------------------------|",
                "|  3 | Free Spin   🔄       |",
                "|---------------------------|",
                "|  4 | Jackpot     💎       |",
                "|___________________________|",
                "             ▼               ",

                "         [ SPIN! ]           "
        };






        public static void animateWheelSpin() {
            for (int i = 0; i < 3; i++) {
                clearScreen();
                for (String line : wheelArt) {
                    System.out.println(line);
                }
                System.out.println("\nSpinning" + ".".repeat(i + 1));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public static void clearScreen() {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

        public static String spinWheel() {
            animateWheelSpin(); // show the ASCII art spinning

            // Corrected wheel sections
            String[] wheelSections = {"$500", "LOSE A TURN", "FREE SPIN", "JACKPOT"};
            Random random = new Random();
            int landedIndex = random.nextInt(wheelSections.length);
            String result = wheelSections[landedIndex];

            System.out.println("🌀 Wheel lands on: " + result);

            return result; // Return the result instead of forcing an integer conversion
        }

        public static void main(String[] args) {
            spinWheel();
        }
    }


    public static void catsAndPhrases() {
        Scanner in = new Scanner(System.in);

        // Player setup
        System.out.println("Enter Player 1's name:");
        String playerOneName = in.nextLine();

        System.out.println("Enter Player 2's name:");
        String playerTwoName = in.nextLine();

        Map<String, Integer> turnCount = new HashMap<>();
        turnCount.put(playerOneName, 0);
        turnCount.put(playerTwoName, 0);

        String[] players = {playerOneName, playerTwoName};
        Map<String, Integer> playerScores = new HashMap<>();
        playerScores.put(playerOneName, 1000);
        playerScores.put(playerTwoName, 1000);

        // Track guessed letters

        Set<Character> guessedLetters = new HashSet<>();


        int currentPlayer = 0;
        int currentTurnPoints = 0;

        System.out.println("\nWelcome to Wheel of Fortune! Spin the wheel and guess the phrase to win big money!");
        displayAsciiArt();

        // Random category and phrase selection
        //TODO: This could be an array of lists
        System.out.println("\nHere is your category:");
        Random random = new Random();
        Map<Integer, List<String>> categoryPhrases = new HashMap<>();
        Map<Integer, String> categoryNames = new HashMap<>();

        categoryNames.put(0, "Around The House");
        categoryPhrases.put(0, Arrays.asList("Cozy Fireplace Mantel", "Stack Of Fluffy Towels", "Decorative Throw Pillows", "Squeaky Rocking Chair"));

        categoryNames.put(1, "Food and Drink");
        categoryPhrases.put(1, Arrays.asList("Ice-Cold Lemonade", "Crispy Chicken Tenders", "Freshly Baked Apple Pie", "Spaghetti With Meatballs"));

        categoryNames.put(2, "Before and After");
        categoryPhrases.put(2, Arrays.asList("Golden Retriever Puppy Love", "Apple Pie Chart", "Rock Climbing Gym Membership", "Chocolate Bar Exam"));

        categoryNames.put(3, "In The Kitchen");
        categoryPhrases.put(3, Arrays.asList("Stainless Steel Toaster", "Nonstick Frying Pan", "Measuring Cups And Spoons", "Spice Rack Organizer"));

        categoryNames.put(4, "Best Seller(s)");
        categoryPhrases.put(4, Arrays.asList("The Great Gatsby", "New York Times Bestseller List", "To Kill A Mockingbird", "The Catcher In The Rye"));

        categoryNames.put(5, "Character(s)");
        categoryPhrases.put(5, Arrays.asList("The Three Musketeers", "Sherlock Holmes And Dr. Watson", "Romeo And Juliet", "The Hardy Boys"));

        categoryNames.put(6, "Fictional Character(s)");
        categoryPhrases.put(6, Arrays.asList("Harry Potter And The Sorcerer’s Stone", "Winnie The Pooh", "SpongeBob SquarePants", "Katniss Everdeen"));

        categoryNames.put(7, "Event(s)");
        categoryPhrases.put(7, Arrays.asList("High School Graduation", "Surprise Birthday Party", "Thanksgiving Day Parade", "New Year's Eve Celebration"));

        categoryNames.put(8, "Movie Quotes");
        categoryPhrases.put(8, Arrays.asList("May the Force be with you.  Star Wars", "I'll be back.  The Terminator", "You can't handle the truth!   A Few Good Men", "There's no place like home.  The Wizard of Oz"));

// Pick a random category and phrase
        int randomCat = random.nextInt(categoryPhrases.size());
        System.out.println(categoryNames.get(randomCat));

        List<String> phrases = categoryPhrases.get(randomCat);
        String test = phrases.get(random.nextInt(phrases.size()));


        String hiddenTest = test.replaceAll("[a-zA-Z]", "_");
        boolean[] guessedChars = new boolean[test.length()];
        boolean guess = true;

        System.out.println("\nHere is your phrase:");
        System.out.println(hiddenTest);

        while (guess) {
            String currentPlayerName = players[currentPlayer];
            currentTurnPoints = 0; // Reset per turn points
            turnCount.put(currentPlayerName, turnCount.get(currentPlayerName) + 1);

            System.out.println("\n" + currentPlayerName + "'s turn!");
            System.out.println(playerOneName + " score: $" + playerScores.get(playerOneName));
            System.out.println(playerTwoName + " score: $" + playerScores.get(playerTwoName));
            System.out.println("Choose an action:");
            System.out.println("1. Spin and guess a consonant");
            System.out.println("2. Buy a vowel ($250)");
            System.out.println("3. Solve the puzzle");
            System.out.println("4. Give up");

            String choice = in.nextLine();

            switch (choice) {
                case "1":
                    // Spin the wheel and get the result as a String
                    String spinResult = WheelOfFortune.spinWheel();

                    // Default spinAmount
                    int spinAmount = 0;

                    // Determine points or action based on spin result
                    if (spinResult.startsWith("$")) {
                        spinAmount = Integer.parseInt(spinResult.replace("$", ""));
                    } else if (spinResult.equals("JACKPOT")) {
                        spinAmount = 1000;
                        System.out.println("💎 JACKPOT! You win 1000 points!");
                    } else if (spinResult.equals("FREE SPIN")) {
                        System.out.println("🔄 FREE SPIN! You get another turn!");

                    } else if (spinResult.equals("LOSE A TURN")) {
                        System.out.println("❌ LOSE A TURN!");
                        currentPlayer = (currentPlayer + 1) % 2;
                        continue;
                    }

                    System.out.println("Wheel spun: " + spinResult);
                    System.out.println("Letters guessed so far: " + guessedLetters);
                    System.out.println("Guess a consonant:");

                    String consonantInput = in.nextLine();
                    if (consonantInput.length() != 1 || !Character.isLetter(consonantInput.charAt(0))) {
                        System.out.println("❌ Please enter a single letter.");
                        break;
                    }

                    char guessedChar = Character.toLowerCase(consonantInput.charAt(0));
                    if ("aeiou".indexOf(guessedChar) != -1) {
                        System.out.println("That's a vowel — use option 2 to buy one.");
                        break;
                    }

                    if (guessedLetters.contains(guessedChar)) {
                        System.out.println("❌ You already guessed that letter!");
                        break;
                    }

                    guessedLetters.add(guessedChar);
                    boolean found = false;

                    for (int i = 0; i < test.length(); i++) {
                        if (Character.toLowerCase(test.charAt(i)) == guessedChar) {
                            guessedChars[i] = true;
                            found = true;
                        }
                    }

                    if (found) {
                        playerScores.put(currentPlayerName, playerScores.get(currentPlayerName) + spinAmount);
                        System.out.println("✅ Correct! You earned $" + spinAmount);
                    } else {
                        System.out.println("❌ Incorrect guess.");
                    }

                    break;


                case "2":
                    // Handle buying a vowel
                    System.out.println("Enter a vowel to buy (a, e, i, o, u):");
                    String vowelInput = in.nextLine();
                    if (vowelInput.length() != 1 || !"aeiou".contains(vowelInput.toLowerCase())) {
                        System.out.println("❌ Invalid vowel.");
                        break;
                    }

                    char vowelChar = vowelInput.toLowerCase().charAt(0);
                    if (guessedLetters.contains(vowelChar)) {
                        System.out.println("❌ You already guessed that letter!");
                        break;
                    }

                    if (playerScores.get(currentPlayerName) < 250) {
                        System.out.println("Not enough money to buy a vowel.");
                        break;
                    }

                    guessedLetters.add(vowelChar);
                    playerScores.put(currentPlayerName, playerScores.get(currentPlayerName) - 250);
                    boolean foundVowel = false;

                    for (int i = 0; i < test.length(); i++) {
                        if (Character.toLowerCase(test.charAt(i)) == vowelChar) {
                            guessedChars[i] = true;
                            foundVowel = true;
                        }
                    }

                    if (foundVowel) {
                        System.out.println("✅ Correct vowel!");
                    } else {
                        System.out.println("❌ No match.");
                    }
                    break;

                case "3":
                    // Handle solving the puzzle
                    System.out.println("Enter your solution (you get up to 3 tries):");
                    boolean solved = false;

                    for (int i = 0; i < 3; i++) {
                        String attempt = in.nextLine();
                        if (attempt.toLowerCase().equals(test.toLowerCase())) {
                            System.out.println("🎉 Correct! You solved it!");
                            int currentScore = playerScores.getOrDefault(currentPlayerName, 0);
                            playerScores.put(currentPlayerName, currentScore + 1000);
                            solved = true;
                            guess = false; // Signal the end of the current guessing round
                            break;
                        } else {
                            if (i < 2) {
                                System.out.println("❌ Wrong! You have " + (2 - i) + " guesses left.");
                            } else {
                                System.out.println("❌ Failed to solve. Turn passes.");
                            }
                        }
                    }

                    if (!solved && guess) {
                        currentPlayer = (currentPlayer + 1) % 2;
                    }

                    break;

                case "4":
                    System.out.println(currentPlayerName + " gave up. Game over.");
                    System.out.println("The correct phrase was: \"" + test + "\"");
                    closeGame();
                    guess = false;
                    System.out.println("\n🏆 Final Scores:");
                    System.out.println(playerOneName + ": $" + playerScores.get(playerOneName));
                    System.out.println(playerTwoName + ": $" + playerScores.get(playerTwoName));
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            // Update phrase
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

            System.out.println("Do you want to solve the phrase? (yes/no)");
            String solve = in.nextLine();

            if (solve.toLowerCase().equals("yes")) {
                System.out.println("Enter your solution:");
                boolean solved = false;

                for (int i = 0; i < 3; i++) {
                    String attempt = in.nextLine();
                    if (attempt.toLowerCase().equals(test.toLowerCase())) {
                        System.out.println("🎉 Correct! You solved it!");
                        int currentScore = playerScores.getOrDefault(currentPlayerName, 0);
                        playerScores.put(currentPlayerName, currentScore + currentTurnPoints + 1000);
                        solved = true;
                        guess = false;
                        break;
                    } else {
                        if (i < 2) {
                            System.out.println("❌ Wrong! You have " + (2 - i) + " guesses left.");
                        } else {
                            System.out.println("❌ Failed to solve. Turn passes.");
                        }
                    }
                }

                if (!solved && guess) {
                    currentPlayer = (currentPlayer + 1) % 2; // Switch player after failed solve
                }
            } else {
                // Switch turn if player chooses not to solve
                currentPlayer = (currentPlayer + 1) % 2;
            }
            // Check if a player has run out of money
            if (playerScores.get(currentPlayerName) <= 0) {
                System.out.println(currentPlayerName + " has run out of money! Game over.");
                closeGame();
                break;
            }

            // Check if both players have used 10 turns
            if (turnCount.get(playerOneName) >= 10 && turnCount.get(playerTwoName) >= 10) {
                System.out.println("Both players reached 10 turns. Game over!");
                closeGame();
                break;
            }

        }

        // Show final scores
        System.out.println("\n🏆 Final Scores:");
        System.out.println(playerOneName + ": $" + playerScores.get(playerOneName));
        System.out.println(playerTwoName + ": $" + playerScores.get(playerTwoName));
    }

    public static void main(String[] args) {
        catsAndPhrases();
    }
}

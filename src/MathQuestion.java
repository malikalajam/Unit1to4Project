import java.util.Scanner;

class MathQuestion {
    private int num1, num2;

    public void generateNumbers() {
        num1 = (int) (Math.random() * 100) + 1;
        num2 = (int) (Math.random() * 100) + 1;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
    private int score;

    public MathQuestion() {
        this.score = 0;
    }

    public String introduceUser() {
        return "Welcome to the Math Trivia!\nYou will be asked a series of questions; As you get more and more questions correct, the math will get more and more difficult! GOOD LUCK!";
    }

    public String askQuestion(String operation, int num1, int num2) {
        return "What is " + num1 + " " + operation + " " + num2 + "?";
    }

    public String checkAnswer(double userAnswer, double correctAnswer) {
        if (Math.abs(userAnswer - correctAnswer) < 0.01) {
            score++;
            return "Correct! You will now move on.";
        } else {
            return "Incorrect! Try again.";
        }
    }

    public String playGame() {
        Scanner scanner = new Scanner(System.in);
        MathQuestion mathQuestion = new MathQuestion();

        System.out.println(introduceUser());


        mathQuestion.generateNumbers();
        System.out.println(askQuestion("+", mathQuestion.getNum1(), mathQuestion.getNum2()));
        int userAnswer = getUserInput(scanner);
        System.out.println(checkAnswer(userAnswer, mathQuestion.getNum1() + mathQuestion.getNum2()));


        mathQuestion.generateNumbers();
        System.out.println(askQuestion("-", mathQuestion.getNum1(), mathQuestion.getNum2()));
        userAnswer = getUserInput(scanner);
        System.out.println(checkAnswer(userAnswer, mathQuestion.getNum1() - mathQuestion.getNum2()));


        mathQuestion.generateNumbers();
        System.out.println(askQuestion("*", mathQuestion.getNum1(), mathQuestion.getNum2()));
        userAnswer = getUserInput(scanner);
        System.out.println(checkAnswer(userAnswer, mathQuestion.getNum1() * mathQuestion.getNum2()));


        mathQuestion.generateNumbers();
        int denominator;
        do {
            mathQuestion.generateNumbers();
            denominator = mathQuestion.getNum2();
        } while (denominator == 0);

        double correctAnswer = (double) mathQuestion.getNum1() / denominator;
        System.out.println(askQuestion("/", mathQuestion.getNum1(), denominator));
        double userAnswerDouble = getUserInputDouble(scanner);
        System.out.println(checkAnswer(userAnswerDouble, correctAnswer));

        scanner.close();

        return "Game Over! Your final score is: " + score;
    }

    private int getUserInput(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.nextInt();
    }

    private double getUserInputDouble(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.nextDouble();
    }
}
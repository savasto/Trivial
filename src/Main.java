import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

         List<Question> questions= createQuestion();
        System.out.println("Lista de preguntas" );
        List<Boolean> answerIsCorrect = showQuestions(questions);
        int numberCorrectAnswer = getContCorrect(answerIsCorrect);
        int score = getScoreCorrectAnswer(answerIsCorrect,questions);

        System.out.println("The number of questions answered correctly are: "+numberCorrectAnswer+
                " the final score is: " + score );
    }

    private static int getScoreCorrectAnswer(List<Boolean> answerIsCorrect, List<Question> questions) {

        int score=0;
        for(int sizeLimit= answerIsCorrect.size(), cont=0 ;cont < sizeLimit;cont++){
            if(answerIsCorrect.get(cont)){
                score += questions.get(cont).getScore();
            }
        }
        return score;
    }


    private static int getContCorrect(List<Boolean> answerIsCorrect) {
        int numberCorrectAnswer=0;
        for (Boolean currentIsTrue:answerIsCorrect) {
            if (currentIsTrue){
                numberCorrectAnswer++;
            }

        }
        return numberCorrectAnswer;
    }

    private static boolean answerQuestions(Question currentQuestion) {

            if(currentQuestion.isTrue()==writeAnswer()){
                System.out.println("You got the right answer");
                return true;

            }
            else{
                System.out.println("You got the incorrect answer");
                return false;
            }
    }

    private static boolean writeAnswer() {
        System.out.println("Is true or false?");
        return (new Scanner(System.in).nextLine()).equalsIgnoreCase("S");
    }

    private static List<Boolean> showQuestions(List<Question> questions) {


        List<Boolean> answerIsCorrect = new ArrayList<>();
        for (Question currentQuestion:questions) {
            System.out.println(currentQuestion);
             answerIsCorrect.add(answerQuestions(currentQuestion));
        }
        return answerIsCorrect;
    }

    private static List<Question> createQuestion() {

        List<Question> questions = new ArrayList<>();
            questions.add(new Question("La capital de Mexico es Ciudad de Mexico?", true,2));
            questions.add(new Question("La capital de Noruega es Oslo?", true,2));
            questions.add(new Question("La capital de Polonia de Varsovia?", true,2));
            questions.add(new Question("La capital de Alemania es Bonn?", false,2));
            questions.add(new Question("La capital de Francia es Paris?", true,2));
            return questions;
    }




}

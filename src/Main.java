import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

         List<Question> questions= createQuestion();
        System.out.println("Lista de preguntas" );
        int contCorrect = showQuestions(questions);
        System.out.println("The number of questions answered correctly are: "+contCorrect);
    }

    private static int answerQuestions(Question currentQuestion,int contCorrect) {

            if(currentQuestion.isTrue()==writeAnswer()){
                contCorrect++;
            }

        return contCorrect;
    }

    private static boolean writeAnswer() {
        System.out.println("Is true or false?");
        return (new Scanner(System.in).nextLine()).equalsIgnoreCase("S");
    }

    private static int showQuestions(List<Question> questions) {
        int contCorrect=0;
        for (Question currentQuestion:questions) {
            System.out.println(currentQuestion);
            contCorrect = answerQuestions(currentQuestion,contCorrect);
        }
        return contCorrect;
    }

    private static List<Question> createQuestion() {

        List<Question> questions = new ArrayList<>();
            questions.add(new Question("La capital de Mexico es Ciudad de Mexico?", true));
            questions.add(new Question("La capital de Noruega es Oslo?", true));
            questions.add(new Question("La capital de Polonia de Varsovia?", true));
            questions.add(new Question("La capital de Alemania es Bonn?", false));
            questions.add(new Question("La capital de Francia es Paris?", true));
            return questions;
    }




}

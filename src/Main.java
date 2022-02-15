import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	List<Question> questions = new ArrayList<>();
        questions =  createQuestion(questions);
        System.out.println("Lista de preguntas" );
        showQuestions(questions);
        int contCorrect = answerQuestions(questions);
        System.out.println("The number of questions answered correctly are: "+contCorrect);
    }

    private static int answerQuestions(List<Question> questions) {
        int contCorrect=0;
        for (Question currentQuestion:questions) {
            if(currentQuestion.isTrue()==writeAnswer()){
                contCorrect++;
            }
        }
        return contCorrect;
    }

    private static boolean writeAnswer() {
        System.out.println("Is true or false?");
        return (new Scanner(System.in).nextLine()).equalsIgnoreCase("S");
    }

    private static void showQuestions(List<Question> questions) {
        for (Question currentQuestion:questions) {
            System.out.println(currentQuestion);
        }
    }

    private static List<Question> createQuestion(List<Question>questions) {


            questions.add(new Question("La capital de Mexico es Ciudad de Mexico?", true));
            questions.add(new Question("La capital de Noruega es Oslo?", true));
            questions.add(new Question("La capital de Polonia de Varsovia?", true));
            questions.add(new Question("La capital de Alemania es Bonn?", false));
            questions.add(new Question("La capital de Francia es Paris?", true));
            return questions;
    }




}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	List<Question> questions = new ArrayList<>();
        questions =  createQuestion(questions);
        System.out.println("Lista de preguntas" );
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

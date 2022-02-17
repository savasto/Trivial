import java.util.*;

public class Main {
    private static final int MAX_SCORE = 10;

    public static void main(String[] args) {


        Score score = new Score();

        Map<String, List<Question>> mapQuestion = createHashMap();
        while (score.getScore() <= MAX_SCORE && !mapQuestion.isEmpty()) {
            List<Question> questionsInCategory = chooseCategory(mapQuestion);

            answerQuestions(questionsInCategory, score);

            mapQuestion.remove(questionsInCategory.get(0).getCategory());
        }
        showScore(score);
    }

    private static void showScore(Score score) {
        System.out.println(score);
    }

    private static Map<String, List<Question>> createHashMap() {
        List<Question> questions = createQuestion();
        List<Question> listQuestionGeography = createListCategory(questions, "Geography");
        List<Question> listQuestionAstronomy = createListCategory(questions, "Astronomy");


        return insertInHashMap(listQuestionGeography, listQuestionAstronomy);
    }

    private static List<Question> chooseCategory(Map<String, List<Question>> mapQuestion) {
        System.out.println("Choose category");
        List<Question> questions = new ArrayList<>();

        System.out.println("1- Geography");
        System.out.println("2- Astronomy");

        do {
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1 -> questions = mapQuestion.get("Geography");
                case 2 ->
                    questions = mapQuestion.get("Astronomy");

            }
            if (questions == null) {
                System.out.println("Don't have elements");
            }
        }
        while (questions == null);
        return questions;
    }

    private static List<Question> createListCategory(List<Question> questions, String category) {
        List<Question> listQuestionGeography = new ArrayList<>();
        for (Question currentQuestion : questions) {
            if (currentQuestion.getCategory().equalsIgnoreCase(category)) {
                listQuestionGeography.add(currentQuestion);
            }
        }
        return listQuestionGeography;
    }

    private static Map<String, List<Question>> insertInHashMap(List<Question> listQuestionGeography, List<Question> listQuestionAstronomy) {
        Map<String, List<Question>> mapQuestion = new HashMap<>();
        mapQuestion.put("Geography", listQuestionGeography);
        mapQuestion.put("Astronomy", listQuestionAstronomy);
        return mapQuestion;
    }




    private static void answeringQuestions(Question currentQuestion, Score score) {

        if (currentQuestion.isTrue() == writeAnswer()) {
            System.out.println("You got the right answer");
            score.setScore(currentQuestion.getScore());
            score.setCountAnswerCorrect(1);

        } else {
            System.out.println("You got the incorrect answer");
        }
    }

    private static boolean writeAnswer() {
        System.out.println("Is true or false?");
        return (new Scanner(System.in).nextLine()).equalsIgnoreCase("S");
    }

    private static void answerQuestions(List<Question> questions, Score scoreIsCorrect) {


        for (Question currentQuestion : questions) {
            System.out.println(currentQuestion);
            answeringQuestions(currentQuestion, scoreIsCorrect);
        }
    }

    private static List<Question> createQuestion() {

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("La capital de Mexico es Ciudad de Mexico?", true, 2, "Geography"));
        questions.add(new Question("La capital de Noruega es Oslo?", true, 2, "Geography"));
        questions.add(new Question("La capital de Polonia de Varsovia?", true, 2, "Geography"));
        questions.add(new Question("Segundo planeta del Sistema solar es Venus", true, 1, "Astronomy"));
        questions.add(new Question("Marte es el cuarto planeta del Sistema Solar", true, 1, "Astronomy"));
        return questions;
    }


}

import java.util.*;

public class Main {
    private static final int MAX_SCORE = 10;

    public static void main(String[] args) {


        Score score = new Score();

        Map<String, List<Question>> mapQuestion = initAllQuestions();
        while (!hasWon(score) && !mapQuestion.isEmpty()) {
            try {
                List<Question> questionsInCategory = chooseCategory(mapQuestion);

                answerQuestions(questionsInCategory, score);

                removeQuestionFromCategory(mapQuestion, questionsInCategory);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("You have to put a number!");
            }
        }
        showScore(score);
    }

    private static void removeQuestionFromCategory(Map<String, List<Question>> mapQuestion, List<Question> questionsInCategory) {
        mapQuestion.remove(questionsInCategory.get(0).getCategory());
    }

    private static boolean hasWon(Score score) {
        return score.getScore() >= MAX_SCORE;
    }

    private static void showScore(Score score) {
        System.out.println(score);
    }

    private static Map<String, List<Question>> initAllQuestions() {

        List<Question> questions = createQuestion();
        Map<String, List<Question>>  listOfQuestions = new HashMap<>();
        for (Question currentQueslistOfQuestionstion: questions) {

            if(listOfQuestions.isEmpty()){
                listOfQuestions.put(currentQueslistOfQuestionstion.getCategory(), insertListInHashMap(questions,currentQueslistOfQuestionstion.getCategory()));
            }
            if(!listOfQuestions.containsKey(currentQueslistOfQuestionstion.getCategory()))
                listOfQuestions.put(currentQueslistOfQuestionstion.getCategory(), insertListInHashMap(questions,currentQueslistOfQuestionstion.getCategory()));
        }

        return listOfQuestions;
    }

    private static List<Question> insertListInHashMap(List<Question> questions, String category) {
        List<Question> questionFromCategory = new ArrayList<>();
        for (Question currentQuestion:questions  ) {
                if (currentQuestion.getCategory().equalsIgnoreCase(category)){
                    questionFromCategory.add(currentQuestion);
                }
        }
        return questionFromCategory;
    }

    private static List<Question> chooseCategory(Map<String, List<Question>> mapQuestion) throws NullPointerException {
        System.out.println("Choose category");
        List<Question> questions = new ArrayList<>();

        System.out.println("1- Geography");
        System.out.println("2- Astronomy");




            int choose = new Scanner(System.in).nextInt();
            switch (choose) {

                case 1 -> questions = mapQuestion.get("Geography");
                case 2 -> questions = mapQuestion.get("Astronomy");


            }

            if (questions == null) {
                throw new NullPointerException("Don't have questions");//   System.out.println("Don't have elements");
            }

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

    /*private static Map<String, List<Question>> insertInHashMap(List<Question> listQuestionGeography, String category) {
        Map<String, List<Question>> mapQuestion = new HashMap<>();
        mapQuestion.put("Geography", listQuestionGeography);

        return mapQuestion;
    }*/


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

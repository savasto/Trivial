public class Question {
    private String question;
    private boolean isTrue;
    private int score;
    private String category;


    public Question(String question, boolean isTrue, int score, String category) {
        this.question = question;
        this.isTrue = isTrue;
        this.score = score;
        this.category=category;
    }

    @Override
    public String toString() {
        return "Question  " +
                "" + question + " (score by question = "+ score  +'\'' ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }
}

public class Question {
    private String question;
    private boolean isTrue;
    private int score;


    public Question(String question, boolean isTrue, int score) {
        this.question = question;
        this.isTrue = isTrue;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Question  " +
                "" + question + " score by question "+ score  +'\'' ;
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


}

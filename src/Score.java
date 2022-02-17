public class Score {
    private int countAnswerCorrect;
    private int score;

    public Score() {
        this.countAnswerCorrect = 0;
        this.score = 0;
    }

    public int getCountAnswerCorrect() {
        return countAnswerCorrect;
    }

    public void setCountAnswerCorrect(int countAnswerCorrect) {
        this.countAnswerCorrect += countAnswerCorrect;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return  "The number of questions answered correctly are: " + this.countAnswerCorrect +
        " the final score is: "+ this.score ;
    }
}

public class Score {
    private double countAnswerCorrect;
    private int score;

    public Score() {
        this.countAnswerCorrect = 0;
        this.score = 0;
    }

    public double getCountAnswerCorrect() {
        return countAnswerCorrect;
    }

    public void setCountAnswerCorrect(double countAnswerCorrect) {
        this.countAnswerCorrect += countAnswerCorrect;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
    public double calculateStadistic(double numberOfQuestions){
        return (this.countAnswerCorrect/numberOfQuestions)*100;
    }
    @Override
    public String toString() {
        return  "The number of questions answered correctly are: " + this.countAnswerCorrect +
        " the final score is: "+ this.score ;
    }
}

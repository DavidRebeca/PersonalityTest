import java.util.ArrayList;

public class QuizQuestion {

    private String question;
    private ArrayList<String> answers=new ArrayList<>();

    public QuizQuestion() {
    }

    public QuizQuestion(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}

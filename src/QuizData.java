

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizData {
    private ArrayList<QuizQuestion> quizDataList=new ArrayList<>();

    public QuizData(ArrayList<QuizQuestion> quizDataList) {
        this.quizDataList = quizDataList;
    }

    public ArrayList<QuizQuestion> getQuizDataList() {
        return quizDataList;
    }

    public void setQuizDataList(ArrayList<QuizQuestion> quizDataList) {
        this.quizDataList = quizDataList;
    }



    public void print() {
        for (QuizQuestion q: quizDataList){
            System.out.println(q.getQuestion());
            System.out.println(q.getAnswers().get(0));
            System.out.println(q.getAnswers().get(1));
            System.out.println(q.getAnswers().get(2));
            System.out.println(q.getAnswers().get(3));
            System.out.println(q.getAnswers().get(4));
            System.out.println();

        }
    }

    public QuizData() {
    }
    public boolean readAllQuizData(){
        try {
            File myObj = new File("quiz_data.txt");
            Scanner myReader = new Scanner(myObj);

            boolean question=true;
            int counter=0;
            int index=0;
            ArrayList<String> answers=new ArrayList<>();
            String questionText=null;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(question){
                    questionText=data;
                    answers=new ArrayList<>();
                    question=false;
                }
                else{
                 answers.add(counter, data);
                 counter++;
                 if(counter==5){
                     QuizQuestion quizQuestion=new QuizQuestion();
                     quizQuestion.setAnswers(answers);
                     quizQuestion.setQuestion(questionText);
                     quizDataList.add(index, quizQuestion);
                     index++;
                     counter=0;
                     question=true;
                 }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;

    }
}

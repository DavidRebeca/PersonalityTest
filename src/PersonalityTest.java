import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalityTest extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton radioButton[]=new JRadioButton[6];
    JButton buttonNext, buttonResult, buttonReset, buttonExit;
    ButtonGroup bg;
    QuizData quizData;
    TestResult testResult;
    int current=0;
    int f[]=new int[6];

    PersonalityTest(String s){
        super(s);
        label=new JLabel();
        add(label);
        quizData=new QuizData();
        testResult=new TestResult();

        quizData.readAllQuizData();

        bg= new ButtonGroup();

        for(int i=0; i<6; i++){
            radioButton[i]= new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }

        buttonNext=new JButton("NEXT");
        buttonResult= new JButton("RESULT");

        buttonReset=new JButton("RESET");
        buttonExit= new JButton("EXIT");

        buttonResult.setVisible(false);
        buttonReset.setVisible(false);
        buttonExit.setVisible(false);

        buttonResult.addActionListener(this);
        buttonNext.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonExit.addActionListener(this);

        add(buttonNext);
        add(buttonResult);
        add(buttonReset);
        add(buttonExit);

        setData();
        label.setBounds(30, 30, 450, 20);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[0].setFont(new Font("Verdana", Font.BOLD, 14));
        radioButton[1].setBounds(50, 110, 450, 20);
        radioButton[1].setFont(new Font("Verdana", Font.BOLD, 14));
        radioButton[2].setBounds(50, 140, 450, 20);
        radioButton[2].setFont(new Font("Verdana", Font.BOLD, 14));
        radioButton[3].setBounds(50, 170, 450, 20);
        radioButton[3].setFont(new Font("Verdana", Font.BOLD, 14));
        radioButton[4].setBounds(50, 200, 450, 20);
        radioButton[4].setFont(new Font("Verdana", Font.BOLD, 14));

        buttonNext.setBounds(200, 250, 100, 30);
        buttonNext.setBackground(Color.orange);
        buttonResult.setBounds(200, 240, 100, 30);
        buttonResult.setBackground(Color.green);
        buttonReset.setBounds(60, 240, 100, 30);
        buttonReset.setBackground(Color.cyan);
        buttonExit.setBounds(370, 240, 100, 30);
        buttonExit.setBackground(Color.RED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(550, 400);

    }
    void setData(){

        radioButton[5].setSelected(true);
        if(current<5){
            label.setText(quizData.getQuizDataList().get(current).getQuestion());

            radioButton[0].setText(quizData.getQuizDataList().get(current).getAnswers().get(0));
            radioButton[1].setText(quizData.getQuizDataList().get(current).getAnswers().get(1));
            radioButton[2].setText(quizData.getQuizDataList().get(current).getAnswers().get(2));
            radioButton[3].setText(quizData.getQuizDataList().get(current).getAnswers().get(3));
            radioButton[4].setText(quizData.getQuizDataList().get(current).getAnswers().get(4));
            label.setBounds(30, 30, 450, 20);
            radioButton[0].setVisible(true);
            radioButton[1].setVisible(true);
            radioButton[2].setVisible(true);
            radioButton[3].setVisible(true);
            radioButton[4].setVisible(true);
        }
        else{
            if(current==5) {

                label.setBounds(60, 40, 400, 200);
                label.setText("<html>"+getResult()+"<html>");
                radioButton[0].setVisible(false);
                radioButton[1].setVisible(false);
                radioButton[2].setVisible(false);
                radioButton[3].setVisible(false);
                radioButton[4].setVisible(false);

            }
        }
    }


     public void calculateFrequency(){
        if(current==0) {
             if(radioButton[0].isSelected())
                f[0]++;
            if(radioButton[1].isSelected())
                 f[1]++;
            if(radioButton[2].isSelected())
                 f[2]++;
            if(radioButton[3].isSelected())
                f[3]++;
            if(radioButton[4].isSelected())
                f[4]++;
        }
        if(current==1) {
            if(radioButton[0].isSelected())
                f[0]++;
            if(radioButton[1].isSelected())
                f[2]++;
            if(radioButton[2].isSelected())
                f[4]++;
            if(radioButton[3].isSelected())
                f[3]++;
            if(radioButton[4].isSelected())
                f[1]++;
        }
        if(current==2) {
            if(radioButton[0].isSelected())
                f[1]++;
            if(radioButton[1].isSelected())
                f[3]++;
            if(radioButton[2].isSelected())
                f[2]++;
            if(radioButton[3].isSelected())
                f[0]++;
            if(radioButton[4].isSelected())
                f[4]++;
        }
        if(current==3) {
            if(radioButton[0].isSelected())
                f[2]++;
            if(radioButton[1].isSelected())
                f[1]++;
            if(radioButton[2].isSelected())
                f[3]++;
            if(radioButton[3].isSelected())
                f[0]++;
            if(radioButton[4].isSelected())
                f[4]++;
        }
        if(current==4) {
            if(radioButton[0].isSelected())
                f[3]++;
            if(radioButton[1].isSelected())
                f[1]++;
            if(radioButton[2].isSelected())
                f[4]++;
            if(radioButton[3].isSelected())
                f[2]++;
            if(radioButton[4].isSelected())
                f[0]++;
        }

    }

    public String getResult(){
        int maxi=-1;
        for(int i=0; i<4; i++)
            if(f[i]>maxi)
                maxi=f[i];
        testResult.readResults();
        if(maxi==f[0]){
            return testResult.getResults().get(0);
        }
        if(maxi==f[1]){
            return testResult.getResults().get(1);
        }
        if(maxi==f[2]){
            return testResult.getResults().get(2);
        }
        if(maxi==f[3]){
            return testResult.getResults().get(3);
        }
        if(maxi==f[4]){
            return testResult.getResults().get(4);
        }
       return null;
    }
   public void resetTest(){
        current=0;
        setData();
        for(int i=0; i<5; i++)
            f[i]=0;
       buttonReset.setVisible(false);
       buttonExit.setVisible(false);
       buttonNext.setEnabled(true);
       buttonNext.setVisible(true);
   }
   @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==buttonNext) {
            if (radioButton[0].isSelected() || radioButton[1].isSelected() || radioButton[2].isSelected() || radioButton[4].isSelected() || radioButton[3].isSelected()) {
                calculateFrequency();
                current++;
                setData();
                if (current == 4) {
                    buttonNext.setEnabled(false);
                    buttonNext.setVisible(false);
                    buttonResult.setVisible(true);
                    buttonResult.setText("RESULT");
                }

            }
        }
        if(e.getActionCommand().equals("RESULT")){
            calculateFrequency();
            current++;
            String s=new String();
            s=getResult();
            setData();
            buttonResult.setVisible(false);
            buttonReset.setText("RESET");
            buttonExit.setText("EXIT");
            buttonReset.setVisible(true);
            buttonExit.setVisible(true);

        }
        if(e.getActionCommand().equals("RESET")) {
           resetTest();
        }
       if(e.getActionCommand().equals("EXIT")) {
         System.exit(0);
       }

   }


}








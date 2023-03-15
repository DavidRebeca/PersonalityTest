import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestResult{

    private ArrayList<String>  results=new ArrayList<>();

    public TestResult(ArrayList<String> results) {
        this.results = results;
    }

    public TestResult() {
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }
    public Boolean readResults(){
        try {
            File myObj = new File("results.txt");
            Scanner myReader = new Scanner(myObj);
            int index=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                results.add(index, data);
                index++;
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;

    }
}

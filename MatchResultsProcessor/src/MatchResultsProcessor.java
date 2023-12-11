import java.io.*;
import java.util.regex.*;

public class MatchResultsProcessor {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\shust\\Desktop\\matches.txt";
        String outputFilePath = "C:\\Users\\shust\\Desktop\\two_word_teams.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            Pattern pattern = Pattern.compile("[A-Za-z]+ [A-Za-z]+");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    writer.write(matcher.group() + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

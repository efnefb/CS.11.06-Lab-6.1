import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int one = challengeOne("inputOneTwo.txt");
        int two = challengeTwo("inputOneTwo.txt");
        int three = challengeThree("inputThreeFour.txt");
        int four = challengeFour("inputThreeFour.txt");
        writeFileAllAnswers("AdventureTime.txt",one,two,three,four);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int numLines = countLinesInFile(fileName);
        scanner.close();
        Scanner scanner1 = new Scanner(file);
        int[] data = new int[numLines];
        for(int i =0; i<numLines;i++){
            data[i] = Integer.parseInt(scanner1.nextLine());
        }
        scanner1.close();

        int increases = 0;
        for(int i=1;i<=numLines-1;i++){
            if(data[i]-data[i-1]>0) increases++;
        }

        return increases;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int numLines = countLinesInFile(fileName);
        scanner.close();
        Scanner scanner1 = new Scanner(file);
        int[] data = new int[numLines];
        for(int i =0; i<numLines;i++){
            data[i] = Integer.parseInt(scanner1.nextLine());
        }
        scanner1.close();

        int[] windowSum = new int[data.length-2];
        for (int i = 0; i<=data.length-3;i++){
            windowSum[i] = data[i] + data[i+1] + data[i+2];
        }

        int increases = 0;
        for (int i=1; i<=windowSum.length-1;i++){
            if (windowSum[i]-windowSum[i-1]>0) increases ++;
        }

        return increases;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner  = new Scanner(file);
        int numlines = countLinesInFile(fileName);
        String[][] directions = new String[numlines][2];
        for (int i = 0; i<numlines; i++){
            String direction = scanner.nextLine();
            String[] direction1 = direction.split(" ");
            directions[i] = direction1;
        }
        scanner.close();
        int hor = 0;
        int depth = 0;
        for (int i = 0; i<numlines; i++){
            if (directions[i][0].equals("forward")){
                int amount = Integer.parseInt(directions[i][1]);
                hor += amount;
            }
            if (directions[i][0].equals("down")){
                depth += Integer.parseInt(directions[i][1]);
            }
            if (directions[i][0].equals("up")){
                depth -= Integer.parseInt(directions[i][1]);
            }
        }
        return hor * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner  = new Scanner(file);
        int numlines = countLinesInFile(filename);
        String[][] directions = new String[numlines][2];
        for (int i = 0; i<numlines; i++){
            String direction = scanner.nextLine();
            String[] direction1 = direction.split(" ");
            directions[i] = direction1;
        }
        scanner.close();
        int hor = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i<numlines; i++){
            if (directions[i][0].equals("down")){
                aim += Integer.parseInt(directions[i][1]);
            }
            if (directions[i][0].equals("up")){
                aim -= Integer.parseInt(directions[i][1]);
            }
            if (directions[i][0].equals("forward")){
                int amount = Integer.parseInt(directions[i][1]);
                hor += amount;
                depth = depth + aim*amount;
            }
        }
        return hor * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
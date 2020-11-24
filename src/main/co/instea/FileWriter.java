    package main.co.instea;

    import java.io.*;
    import java.util.Scanner;

    public class FileWriter {
        public static final String outputFile = "c:/Users/duris/IdeaProjects/GitHubProject/vystup.txt";

        public static void main(String[] args) throws IOException {
            System.out.println("Enter text");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            writingIntoFile(outputFile, line);
        }
        public static void listOfCommands(){
            System.out.println("Here is a list of commands");
            System.out.println("* 'h' for help");
            System.out.println("* 'q' to quit the program");
            System.out.println("* 'set' to set read/write mode, e.g. 'set -r console -w file'");
        }

        public static void writingIntoFile(String outputFile, String line) throws IOException {
            java.io.FileWriter w = new java.io.FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(w);

            bw.write(line + "\n");

            // closing of file is needed, so the data will be written to the disc
            bw.flush();
            bw.close();
        }
        public static String[] readFromFile(String inputFile) throws IOException {
            FileReader r = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(r);

            // count of non-empty lines in file
            //so we know what size of array to be returnde
            int countOfLines = 0;
            String line = "";
            // if line == null, then there is the end of file
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    countOfLines++;
                }
            }

            int i = 0;

            br.close();

            // we need to close the access to the file
            // and newly initialize it so we can get to the beginning of the file

            r = new FileReader(inputFile);
            br = new BufferedReader(r);

            // allocating array in size of non-empty lines of file
            String[] result = new String[countOfLines];
            line = "";

            // loading lines
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    result[i] = line;
                    i++;
                }
            }

            // closing file
            br.close();

            // returning respective array
            return result;
        }






    }

import java.io.*;

public class FileOperationsUtility {

    public static void main(String[] args) throws IOException {

        /* We need to provide file path as the parameter:
        double backquote is to avoid compiler interpret words
        like \test as \t (ie. as a escape sequence) */

        FileReader reader = new FileReader("C:\\Users\\ausaf\\Downloads\\train.dat");
        BufferedReader br = new BufferedReader(reader);

        FileWriter writer = new FileWriter("C:\\Users\\ausaf\\Downloads\\test.txt");
        BufferedWriter bw = new BufferedWriter(writer);

        String line;
        //int count = 0;
        while ((line = br.readLine()) != null) {
            //String line = br.readLine();
            //count++;
            //System.out.println(line);
            String[] arrTest = line.split(" ");
            bw.write(arrTest[0]);
            //bw.flush();
        }
        bw.close();
        writer.close();
        reader.close();
    }
}

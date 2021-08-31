import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {
    public static String[] read() {

        String[] arr = new String[5];
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\810631\\Desktop\\exel.txt"))) {

            for (int i = 0; i < 5; i++) {
                String s = br.readLine();
                arr[i] = s;

            }

            System.out.println(Arrays.toString(arr));

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return arr;
    }
}

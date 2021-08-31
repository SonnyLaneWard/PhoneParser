import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
    public static ArrayList<String> read() {
        ArrayList<String> arr = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\810631\\Desktop\\test.txt"))) {


           for(int i =0; i < 6000000; i++)
           {
               String s = br.readLine();
               if ( s ==null)
               {
                   break;
               }
                arr.add(s);

            }

            System.out.println(arr);

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return arr;
    }
}

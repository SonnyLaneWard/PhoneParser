import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Reader {
    public static ArrayList<String> read() throws URISyntaxException, UnknownHostException {
        ArrayList<String> arr = new ArrayList<>();
        String machine = InetAddress.getLocalHost().getHostName();



        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/"+ "810631" + "/Desktop/test.txt"))) {
           // C:\Users\810631\Desktop\exel.txt

           for(int i =0; i < 10000; i++)
           {
               String s = br.readLine();
               if (Objects.equals(s, ""))
               {
                   continue;
               }
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

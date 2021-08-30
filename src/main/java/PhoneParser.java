import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class PhoneParser {

    public static void main(String[] args) throws IOException {

       /* try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sin\\Desktop\\exel.txt")))
        {
            String [] arr = new String[6];
            for (int i=0; i<6; i++)
            {
                String s = br.readLine();
                arr[i] = s;

            }
            System.out.println(Arrays.toString(arr));
        */
         String [] arr = Reader.read();


            for (int i=0; i< arr.length; i++)
            {

                String g = arr[i];
                char[] c_arr = g.toCharArray();
                if (c_arr[0] == '+')
                {
                    c_arr[0] = '8';
                    arr[i]= Arrays.toString(c_arr);
                    arr[i] = arr[i].replaceAll("[,]", "");
                    arr[i] = arr[i].replace("[", "");
                    arr[i] = arr[i].replace("]", "");
                    arr[i] = arr[i].replaceAll("\\s","");
                }
            }

            Writer.write(arr);

        }

    }


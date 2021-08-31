import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PhoneParser {

    public static void main(String[] args) throws IOException {

        ArrayList<String> arr = Reader.read(); //DATA


            for (int i=0; i< arr.size(); i++)
            {


                String g = arr.get(i);
                char[] c_arr = g.toCharArray();

                if (c_arr[0] == '+')
                {
                    c_arr[0] = '8';



                      System.arraycopy(c_arr, 2, c_arr, 1, c_arr.length-2);
                    c_arr =Arrays.copyOf(c_arr,c_arr.length-1);

                    String st = Arrays.toString(c_arr);



                    arr.set(i, st);


                }




                }

        Writer.write(arr);//OUTPUT
        System.out.println(arr);
            }



        }




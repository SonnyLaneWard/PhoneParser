import java.io.IOException;
import java.util.Arrays;

public class PhoneParser {

    public static void main(String[] args) throws IOException {

           String [] arr = Reader.read(); //DATA


            for (int i=0; i< arr.length; i++)
            {

                String g = arr[i];
                char[] c_arr = g.toCharArray();

                if (c_arr[0] == '+')
                {
                    c_arr[0] = '8';



                      System.arraycopy(c_arr, 2, c_arr, 1, c_arr.length-2);
                    c_arr =Arrays.copyOf(c_arr,c_arr.length-1);

                    arr[i]= Arrays.toString(c_arr);
                    arr[i] = arr[i].replaceAll("[,]", "");
                    arr[i] = arr[i].replace("[", "");
                    arr[i] = arr[i].replace("]", "");
                    arr[i] = arr[i].replaceAll("\\s","");

                }

                for (int k = 0; k < c_arr.length; k ++) {


                    if ((c_arr[k] == '(')|(c_arr[k] == ')')|(c_arr[k] == '-'))

                    {

                        for (int j = 1; j < c_arr.length; j++) {
                            c_arr[j] = c_arr[j - 1];
                        }
                        arr[i] = Arrays.toString(c_arr);
                        arr[i] = arr[i].replaceAll("[,]", "");
                        arr[i] = arr[i].replace("[", "");
                        arr[i] = arr[i].replace("]", "");
                        arr[i] = arr[i].replaceAll("\\s", "");
                    }


                }

            }

            Writer.write(arr);//OUTPUT
        System.out.println(Arrays.toString(arr));

        }

    }


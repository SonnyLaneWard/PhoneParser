import java.util.ArrayList;
import java.util.Arrays;

public class PhoneParser {

    public static void main(String[] args) {

        ArrayList<String> arr = Reader.read(); //DATA


        for (int i=0; i< arr.size(); i++)
        {


            String g = arr.get(i);

            int index = g.indexOf(',');
            if (index != -1)
            {
                g = g.substring(0,index);
            }



            char[] c_arr = g.toCharArray();



            if (c_arr[0] == '8')
            {
                c_arr =Arrays.copyOf(c_arr,c_arr.length+1);
                System.arraycopy(c_arr, 0, c_arr, 1, c_arr.length-1);
                c_arr[0] = '+';
                c_arr[1] = '7';



            }
            String st = Arrays.toString(c_arr);

            st = st.replaceAll("[,]", "");
            st = st.replace("[", "");
            st = st.replace("]", "");
            st = st.replace("(", "");
            st = st.replace(")", "");
            st = st.replace("-", "");
            st = st.replaceAll("\\s", "");

            st = st.replaceAll("[^\\d]", "");
            st = "+" + st;




            arr.set(i, st);



        }

        Writer.write(arr);//OUTPUT
        System.out.println(arr);
    }



}


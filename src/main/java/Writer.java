import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {


    public static void write(ArrayList<String>arr) {
        String username = System.getProperty("user.name");

        System.out.println(username);

        try(FileWriter writer = new FileWriter("C:/Users/" + username + "/Desktop/" + PhoneParser.name2 + ".txt", false))
        {
            for (int i=0; i< arr.size(); i++)
            {
                writer.write(arr.get(i) + "\n");
            }




            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

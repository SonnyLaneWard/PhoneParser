import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {


    public static void write(ArrayList<String>arr)
    {
        try(FileWriter writer = new FileWriter("C:\\Users\\810631\\Desktop\\notes3.txt", false))
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

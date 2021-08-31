import java.io.FileWriter;
import java.io.IOException;

public class Writer {


    public static void write(String arr [])
    {
        try(FileWriter writer = new FileWriter("C:\\Users\\810631\\Desktop\\notes3.txt", false))
        {
            for (int i=0; i< arr.length; i++)
            {
                writer.write(arr[i] + "\n");
            }




            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

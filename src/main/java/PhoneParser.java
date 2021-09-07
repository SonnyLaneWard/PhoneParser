import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class PhoneParser extends  Application{
    static String name1;
    static String name2;

    public static void main(String[] args) {

       Application.launch(args);

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


    @Override
    public void start(Stage stage) throws Exception {
        // установка надписи
        Text text = new Text("Data input");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(200);   // установка положения надписи по оси X

        Button btn = new Button();
        btn.setText("OK");
        btn.setLayoutX(200);
        btn.setLayoutY(450);

        Label label = new Label();
        label.setText("Input file name");
        Label label2 = new Label();
        label2.setText("Output file name");

        TextField textField = new TextField();
        TextField textField2 = new TextField();


        GridPane gridpane = new GridPane();
        gridpane.add(text,2 ,1);
        gridpane.add(btn,2,2);
        gridpane.add(label,2,3);
        gridpane.add(textField,2,4);
        gridpane.add(label2,2,5);
        gridpane.add(textField2,2,6);


        Scene scene = new Scene(gridpane);
        stage.setScene(scene);
        stage.setTitle("Phone Parser");
        stage.setWidth(200);
        stage.setHeight(200);
        stage.show();


        btn.setOnAction(event -> {
             name1 = textField.getText();
             name2 = textField2.getText();

        });


    }
}


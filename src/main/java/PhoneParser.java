import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
        text.setFill(Color.color(0.5, 0.5, 0.7, 0.9));
        text.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.ITALIC, 30));
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(200);   // установка положения надписи по оси X


        Button btn = new Button();
        btn.setText("OK");
        btn.setLayoutX(200);
        btn.setLayoutY(450);

        Label label = new Label();
        label.setText("Input file name");
        label.setFont(Font.font("Lucida Grande", FontWeight.MEDIUM, FontPosture.REGULAR, 16));
        label.setTextFill(Color.color(0.5, 0.5, 0.5));
        Label label2 = new Label();
        label2.setText("Output file name");
        label2.setFont(Font.font("Lucida Grande", FontWeight.MEDIUM, FontPosture.REGULAR, 16));
        label2.setTextFill(Color.color(0.5, 0.5, 0.5));

        TextField textField = new TextField();
        TextField textField2 = new TextField();


        GridPane gridpane = new GridPane();
        gridpane.add(text,2 ,1);
        gridpane.add(btn,2,6);
        gridpane.add(label,2,2);
        gridpane.add(textField,2,3);
        gridpane.add(label2,2,4);
        gridpane.add(textField2,2,5);


        Scene scene = new Scene(gridpane);
        scene.setFill(Color.color(0.5, 0.5, 0.333, 0.3));
        stage.setScene(scene);

        stage.setTitle("Phone Parser");
        stage.setWidth(180);
        stage.setHeight(250);
        stage.show();


        btn.setOnAction(event -> {
             name1 = textField.getText();
             name2 = textField2.getText();
             btn.setVisible(false);

        });


    }
}


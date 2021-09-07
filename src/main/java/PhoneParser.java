import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;


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

        String username = System.getProperty("user.name");
        Text text2 = new Text("Hello " + username);
        text2.setFill(Color.color(0.5, 0.5, 0.7, 0.9));
        text2.setFont(Font.font("Lucida Grande", FontWeight.BOLD, FontPosture.ITALIC, 20));



        Button btn = new Button();
        btn.setText("   Convert   ");
        btn.setTextAlignment(TextAlignment.CENTER);
        btn.setStyle("#iphone {\n" +
                "    -fx-background-color: \n" +
                "        #516175,\n" +
                "        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
                "        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n" +
                "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
                "    -fx-background-radius: 5,5,4;\n" +
                "    -fx-padding: 7 30 7 30;\n" +
                "    -fx-text-fill: #202224;\n" +
                "    -fx-font-family: \"Lucida Grande\";\n" +
                "    -fx-font-size: 16px;\n" +
                "    -fx-text-fill: gray;\n" +
                "}");


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
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setBlendMode(BlendMode.MULTIPLY);
        gridpane.setHgap(3);
        gridpane.setVgap(3);

        gridpane.add(text2,2 ,2);
        gridpane.add(text,2 ,1);
        gridpane.add(btn,2,7);
        GridPane.setHalignment(btn, HPos.CENTER);
        gridpane.add(label,2,3);
        gridpane.add(textField,2,4);
        gridpane.add(label2,2,5);
        gridpane.add(textField2,2,6);


        Scene scene = new Scene(gridpane);


        stage.setScene(scene);

        stage.setTitle("Phone Parser");
        stage.setWidth(320);
        stage.setHeight(320);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);

        stage.show();


        btn.setOnAction(event -> {
             name1 = textField.getText();
             name2 = textField2.getText();
             btn.setVisible(false);
             text2.setText("SUCCEED!");

        });


    }
}


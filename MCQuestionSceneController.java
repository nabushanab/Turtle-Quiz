import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MCQuestionSceneController {

    public static Client client;
    public static int counter = 0;


    @FXML
    private Label Question;

    @FXML
    private Button OptionA;

    @FXML
    private Button OptionB;

    @FXML
    private Button OptionC;

    @FXML
    private Button OptionD;

    public void initialize() throws IOException, ClassNotFoundException {
        //local host : 127.0.0.1
        //other host : 128.255.17.151
        client = new Client("127.0.0.1");
        System.out.println("Initialized");

    }

    //setquestions method allows server input to dictate question
    private void setQuestions() {
        Question.setText(client.currentMCQuestion.getQuestion());
        OptionA.setText(client.currentMCQuestion.getOpt1());
        OptionB.setText(client.currentMCQuestion.getOpt2());
        OptionC.setText(client.currentMCQuestion.getOpt3());
        OptionD.setText(client.currentMCQuestion.getOpt4());
    }



    //method if a is pressed
    public void aPressed() {
        client.sendData(1);
        setQuestions();
        counter++;

        //check if client needs to be moved to new scene
        if(counter > 3) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("TFQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("TF");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //method if b is pressed
    public void bPressed() {
        client.sendData(2);
        setQuestions();
        counter++;

        //check if client needs to change scenes
        if(counter > 3) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("TFQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("TF");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void cPressed() {
        client.sendData(3);
        setQuestions();
        counter++;

        if(counter > 3) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("TFQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("TF");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void dPressed() {
        client.sendData(4);
        setQuestions();
        counter++;

        if(counter > 3) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("TFQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("TF");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


}

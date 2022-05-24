import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageQuestionSceneController {


    @FXML
    private ImageView Image;

    @FXML
    private TextField Question;

    @FXML
    private Button OptionA;

    @FXML
    private Button OptionB;

    @FXML
    private Button OptionC;

    @FXML
    private Button OptionD;


    //set questions method to allow server to set questions
    private void setQuestions(){
        Question.setText(MCQuestionSceneController.client.currentImageQuestion.getQuestion());
        OptionA.setText(MCQuestionSceneController.client.currentImageQuestion.getOpt1());
        OptionB.setText(MCQuestionSceneController.client.currentImageQuestion.getOpt2());
        OptionC.setText(MCQuestionSceneController.client.currentImageQuestion.getOpt3());
        OptionD.setText(MCQuestionSceneController.client.currentImageQuestion.getOpt4());

        //make image
        try {
            javafx.scene.image.Image tempimg = new Image(new FileInputStream(MCQuestionSceneController.client.currentImageQuestion.getImage()));
            Image.setImage(tempimg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //send data to server based on answer
    public void aPressed() {
        MCQuestionSceneController.client.sendData(1);
        setQuestions();
        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 8) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("ScoreScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Scoreboard");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //send data to server based on answer
    public void bPressed() {
        MCQuestionSceneController.client.sendData(2);
        setQuestions();

        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 8) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("ScoreScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Scoreboard");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

    //send data to server based on answer
    public void cPressed() {
        MCQuestionSceneController.client.sendData(3);
        setQuestions();

        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 8) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("ScoreScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Scoreboard");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //send data to server based on answer
    public void dPressed() {
        MCQuestionSceneController.client.sendData(4);
        setQuestions();

        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 8) {
            try {
                Parent root;
                Scene scene;

                root = FXMLLoader.load(getClass().getResource("ScoreScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Scoreboard");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

}

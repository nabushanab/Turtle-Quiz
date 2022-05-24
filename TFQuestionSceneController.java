import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TFQuestionSceneController {

    @FXML
    private Label Question;

    @FXML
    private Button True;

    @FXML
    private Button False;

    //set question from server input
    private void setQuestions() {
        Question.setText(MCQuestionSceneController.client.currentTFQuestion.getQuestion());
    }

    //send data to server based on answer

    public void truePressed() {
        MCQuestionSceneController.client.sendData(1);
        setQuestions();
        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 6) {
            try {
                Parent root;
                Scene scene;
                //change to image one
                root = FXMLLoader.load(getClass().getResource("ImageQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Image");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //send data to server based on answer

    public void falsePressed() {
        MCQuestionSceneController.client.sendData(2);
        setQuestions();
        MCQuestionSceneController.counter++;

        if(MCQuestionSceneController.counter > 6) {
            try {
                Parent root;
                Scene scene;
                //change to image one
                root = FXMLLoader.load(getClass().getResource("ImageQuestionScene.fxml"));
                scene = new Scene(root);
                ClientTest.bigstage.setTitle("Image");
                ClientTest.bigstage.setScene(scene);
                ClientTest.bigstage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

}

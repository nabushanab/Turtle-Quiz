import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientTest extends Application {

    public static Stage bigstage;

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            bigstage = stage;
            Parent root;
            Scene scene;

            root = FXMLLoader.load(getClass().getResource("MCQuestionScene.fxml"));
            scene = new Scene(root);
            bigstage.setTitle("Question");
            bigstage.setScene(scene);
            bigstage.show();

        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

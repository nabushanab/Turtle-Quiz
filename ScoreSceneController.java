import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ScoreSceneController {

    @FXML
    private Button RefreshButton;

    @FXML
    private TextArea ScoreList;

    //refresh method allows client to update the scoreboard
    public void refresh(){
        MCQuestionSceneController.client.sendData(99);
        ScoreList.clear();
        ScoreList.setText(MCQuestionSceneController.client.playerScore);
    }

}



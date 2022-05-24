import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    //member variables
    private Socket connection;      // connection to server
    public ObjectOutputStream output; // output stream to server
    public ObjectInputStream input; // input stream from server
    private String Host;            // host name for server
    public QuestionList.multChoiceQuestion currentMCQuestion;
    public QuestionList.tfQuestion currentTFQuestion;
    public QuestionList.imageQuestion currentImageQuestion;
    public String playerScore;
    public int counter = 0;



    //constructor
    public Client(String host) {
        Host = host;        // set name of server
        startClient();      //start the client
    }



    // start the client thread
    public void startClient() {
        // connect to server and get streams
        try {
            //make connection to server
            connection = new Socket(InetAddress.getByName(Host), 23622);
            System.out.println("Connected to server");

            //get streams for input and output
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            System.out.println("Made streams");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }




    //method to send data to server
    public void sendData(int out){
        // send object to server
        try {
            output.write(out);
            output.flush();
        }
        catch (IOException ioException) {
            System.out.println("Error sending data.");
            ioException.printStackTrace();
        }

        try{
            //if statements to check which type of input the server is sending
            if(counter < 3){
                currentMCQuestion = (QuestionList.multChoiceQuestion) input.readObject();
                counter++;
            }
            else if(counter < 6){
                currentTFQuestion = (QuestionList.tfQuestion) input.readObject();
                counter++;
            }
            else if(counter < 8){
                currentImageQuestion = (QuestionList.imageQuestion) input.readObject();
                counter++;
            }
            else{
                playerScore = (String) input.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


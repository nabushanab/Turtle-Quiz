import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server  {
    //member variables
    private Player[] players; // array of Players
    private ServerSocket server; // server socket to connect with clients
    private ExecutorService runGame; // will run players


    // set up game server and GUI that displays messages
    public Server() {
        // create ExecutorService with a thread for each player
        runGame = Executors.newFixedThreadPool(3);

        players = new Player[3]; // create array of players

        try {
            server = new ServerSocket(23622, 2); // set up ServerSocket
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }

    }

    //connect players as they join
    public void execute() {
        // wait for each client to connect
        for (int i = 0; i < players.length; i++) {
            // wait for connection, create Player, start runnable
            try {
                players[i] = new Player(server.accept(), i);
                runGame.execute(players[i]); // execute player runnable

            }
            catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
    }

    //method to generate a random multiple choice method
    public QuestionList.multChoiceQuestion generateMCQuestion(){
        SecureRandom rand = new SecureRandom();
        QuestionList.intializemcq();
        return QuestionList.mcq[rand.nextInt(10)];
    }

    //method to generate a random T/F question
    public QuestionList.tfQuestion generateTFQuestion(){
        SecureRandom rand = new SecureRandom();
        QuestionList.intializetf();
        return QuestionList.tf[rand.nextInt(10)];
    }

    //method to generate a random Image question
    public QuestionList.imageQuestion generateImageQuestion() throws FileNotFoundException {
        SecureRandom rand = new SecureRandom();
        QuestionList.intializeimage();
        return QuestionList.imageq[rand.nextInt(5)];
    }


    // private inner class Player manages each Player as a runnable
    private class Player implements Runnable {
        //member variables
        private Socket connection; // connection to client
        private ObjectInputStream input; // input from client
        private ObjectOutputStream output; // output to client
        private int playerNumber; // tracks which player this is
        private QuestionList.multChoiceQuestion currentMCQuestion;
        private QuestionList.tfQuestion currentTFQuestion;
        private QuestionList.imageQuestion currentImageQuestion;
        private int score = 0;
        private int choice = 5;


        // set up Player thread in the constructor
        public Player(Socket socket, int number) {
            playerNumber = number; // store this player's number
            connection = socket; // store socket for client

            // obtain streams from Socket
            try{
                input = new ObjectInputStream(connection.getInputStream());
                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }


        // control thread's execution
        public void run() {
            try {
                int pnum = playerNumber + 1;
                System.out.println("Player " + pnum + " connected");

                currentMCQuestion = generateMCQuestion();
                int ans = 0;

                //for loop for multip choice questions
                for(int i = 0; i<3; i++) {

                    //read client input
                        choice = input.read();
                        System.out.println("Player " + pnum + ": " + choice);

                    //check if answer is correct
                        if (choice == ans) {
                            score++;
                            System.out.println("Correct!");
                        }

                        System.out.println("Score of Player" + pnum + ": " + score);

                        currentMCQuestion = generateMCQuestion();
                        ans = currentMCQuestion.getCorrectAns();
                        output.writeObject(currentMCQuestion);
                        output.flush();
                    }

                currentTFQuestion = generateTFQuestion();
                ans = 0;

                //for loop for True/false questions
                for(int i = 0; i < 3; i++){
                    choice = input.read();
                    System.out.println("Player " + pnum + ": " + choice);


                    //check if answer is correct
                    if (choice == ans) {
                        score++;
                        System.out.println("Correct!");
                    }

                    System.out.println("Score of Player" + pnum + ": " + score);

                    currentTFQuestion = generateTFQuestion();
                    ans = currentTFQuestion.getCorrectAns();
                    output.writeObject(currentTFQuestion);
                    output.flush();
                }

                currentImageQuestion = generateImageQuestion();
                ans = 0;

                //loop for image questions
                for(int i = 0; i < 2; i++){
                    choice = input.read();
                    System.out.println("Player " + pnum + ": " + choice);


                    //check if answer is correct
                    if (choice == ans) {
                        score++;
                        System.out.println("Correct!");
                    }

                    System.out.println("Score of Player" + pnum + ": " + score);

                    currentImageQuestion = generateImageQuestion();
                    ans = currentImageQuestion.getCorrectAns();
                    output.writeObject(currentImageQuestion);
                    output.flush();
                }

                //update the scoreboard once
                StringBuilder temp = new StringBuilder("");
                for (Player player : players) {
                    if (player != null) {
                        int pn = player.playerNumber + 1;
                        temp.append("\nPlayer" + pn + ": " + player.score);
                    }
                }

                output.writeObject(temp.toString());
                output.flush();

                //update scoreboard everytime client presses refresh
                for(int i = 0; i < 100; i++) {
                    int refresh = input.read();
                    System.out.println(refresh);
                    if (refresh == 99) {
                        temp = new StringBuilder("");
                        for (Player player : players) {
                            if (player != null) {
                                int pn = player.playerNumber + 1;
                                temp.append("\nPlayer" + pn + ": " + player.score);
                            }
                        }

                        output.writeObject(temp.toString());
                        output.flush();
                    }
                }

            }
            catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}

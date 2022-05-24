import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class QuestionList {


    //multiple choice question stuff

    public static multChoiceQuestion[] mcq = new multChoiceQuestion[10];

    public static void intializemcq(){
        mcq[0] = new multChoiceQuestion("What is not a type of sea turtle?", "Loggerhead", "Galapagos","Hawksbill","Diamondback",2);
        mcq[1] = new multChoiceQuestion("What kind of trees do koalas live in?", "Eucalyptus", "Willow","Redwood","Maple",1);
        mcq[2] = new multChoiceQuestion("What is the name of the adult turtle in Finding Nemo?", "Crush", "Squirt","Dude","Bruce",1);
        mcq[3] = new multChoiceQuestion("What is the name of the kid turtle in Finding Nemo?", "Munchkin", "Squirt","Dude","Bruce",2);
        mcq[4] = new multChoiceQuestion("What ability do sea turtles lack?", "Hold their breath", "Swim fast","Retract their heads","Lay eggs",3);
        mcq[5] = new multChoiceQuestion("Which Teenage Mutant Ninja Turtle has the purple mask?", "Leonardo", "Raphael","Michaelangelo","Donatello",4);
        mcq[6] = new multChoiceQuestion("How long can a turtle's shell be?", "1 ft", "2 ft","3 ft","4 ft",3);
        mcq[7] = new multChoiceQuestion("What is a sea turtle's favorite snack?", "Sea star", "Sea Sponge","Sea Urchin","Sea Anemone",2);
        mcq[8] = new multChoiceQuestion("Around how long do sea turtles live for?", "100 years", "200 years","50 years","150 years",1);
        mcq[9] = new multChoiceQuestion("What are sea turtles sometimes referred to as?", "The ocean's daredevil", "The ocean's janitor","The ocean's garbage ","The ocean's lawnmower",4);
    }


    public static class multChoiceQuestion implements Serializable {
        private String question;
        private String opt1;
        private String opt2;
        private String opt3;
        private String opt4;
        private int correctAns;

        multChoiceQuestion(String quest, String o1, String o2, String o3, String o4, int correct){
            question = quest;
            opt1 = o1;
            opt2 = o2;
            opt3 = o3;
            opt4 = o4;
            correctAns = correct;
        }

        public String getQuestion(){return question;}
        public String getOpt1(){return opt1;}
        public String getOpt2(){return opt2;}
        public String getOpt3(){return opt3;}
        public String getOpt4(){return opt4;}
        public int getCorrectAns(){return correctAns;}

    }

    //true false question stuff
    public static tfQuestion[] tf = new tfQuestion[10];

    public static void intializetf(){
        tf[0] = new tfQuestion("Black sea turtles live in the Atlantic", 2);
        tf[1] = new tfQuestion("Six out of seven sea turtle species are endangered", 1);
        tf[2] = new tfQuestion("Sea turtles can go up to 3 months without food", 1);
        tf[3] = new tfQuestion("Sea turtles can travel 5,000 miles a day", 2);
        tf[4] = new tfQuestion("Sea turtles have been around since the time of dinosaurs", 1);
        tf[5] = new tfQuestion("Turtles live on land", 2);
        tf[6] = new tfQuestion("A baby sea turtle is called a hatchling", 1);
        tf[7] = new tfQuestion("A group of turtles is called a bale", 1);
        tf[8] = new tfQuestion("Turtles can change their shells", 2);
        tf[9] = new tfQuestion("Turtles are born on land", 1);
    }


    public static class tfQuestion implements Serializable{
        private String question;
        private String opt1;
        private String opt2;
        private int correctAns;

        tfQuestion(String quest, int correct){
            question = quest;
            opt1 = "True";
            opt2 = "False";
            correctAns = correct;
        }

        public String getQuestion(){return question;}
        public String getOpt1(){return opt1;}
        public String getOpt2(){return opt2;}
        public int getCorrectAns(){return correctAns;}

    }

    public static imageQuestion[] imageq = new imageQuestion[5];

    public static void intializeimage() throws FileNotFoundException {
        imageq[0] = new imageQuestion("What kind of turtle is this?", "Loggerhead", "Painted", "Snapping", "Trick question, its a tortoise", 4, "src/imgs/Tort.jpg");
        imageq[1] = new imageQuestion("What kind of food is this?", "Sandwich", "Burger", "Wrap", "Trick question, its a turtle", 4, "src/imgs/food.jpeg");
        imageq[2] = new imageQuestion("What is this turtle's name?", "Franklin", "Abigail", "Noah", "USeong", 1, "src/imgs/frank.jpg");
        imageq[3] = new imageQuestion("What game is this turtle from?", "Sonic", "Mario", "Donkey Kong", "Shaun White Snowboarding", 2,"src/imgs/koopa.jpeg");
        imageq[4] = new imageQuestion("What type of martial arts does he teach?", "Karate", "Muay Tai", "Kung Fu", "Jiu Jitsu", 3, "src/imgs/oogway.jpg");
    }


    public static class imageQuestion implements Serializable{
        private String question;
        private String opt1;
        private String opt2;
        private String opt3;
        private String opt4;
        private int correctAns;
        private String image;

        imageQuestion(String quest, String o1, String o2, String o3, String o4, int correct, String imag){
            question = quest;
            opt1 = o1;
            opt2 = o2;
            opt3 = o3;
            opt4 = o4;
            correctAns = correct;
            image = imag;
        }

        public String getQuestion(){return question;}
        public String getOpt1(){return opt1;}
        public String getOpt2(){return opt2;}
        public String getOpt3(){return opt3;}
        public String getOpt4(){return opt4;}
        public int getCorrectAns(){return correctAns;}
        public String getImage() { return image; }
    }
}

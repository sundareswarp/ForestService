import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class ForestService {
    static Scanner input = new Scanner(System.in);
    static Forest forest;
    public static void main(String[] args) {
        String op;
        while(true) {
            System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it : ");
            op = input.nextLine();
            op = op.toLowerCase();
            switch(op) {
                case "d" : display();
                break;
                case "n" : newForest();
                break;
                case "y" : simGrowth();
                break;
                case "r": reap();
                break;
                case "s" : save();
                break;
                case "l" : load();
                break;
                case "x" : exitForestService();
                break;
                default :
                    System.out.println("ERROR: Invalid Option!");
            }

        }

    }
    static boolean checkForest() {
        if(forest == null) return false;
        else return true;
    }
    static void display() {
        if(checkForest()) forest.displayForest();
        else System.out.println("No Forest");
    }
    static void newForest() {
        System.out.print("What is the name of the forest : ");
       //input.nextLine();
        String name = input.nextLine();
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        forest = new Forest(name);
    }
    static void simGrowth() {
        if(checkForest()) {
            forest.simGrowthOfForest();
        }else {
            System.out.println("No Forest");
        }
    }
    static void reap() {
        if(checkForest()) {
            System.out.println("What height to reap at : ");
            try {
                int n = input.nextInt();
                forest.reapForest(n);
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Height!");
                input.next();
            }
        }
        else System.out.println("No Forest");
    }
    static void save() {
        if (checkForest()) {
            forest.saveForest();
        }else {
            System.out.println("No forest");
        }
    }
    static void load() {
        System.out.print("Enter the forest name : ");
        String fName = input.nextLine();
        forest = Forest.loadForest(fName, forest);
    }
    static void exitForestService() {
        System.out.println("Good Bye");
        exit(0);
    }
}

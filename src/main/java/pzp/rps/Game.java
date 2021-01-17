package pzp.rps;

import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String []args){
        String result=playgame(0);
        System.out.println(result);
    }
    public static String playgame(int user){
        //User input
        //System.out.println("Please enter what you want to output: if you want to output rocks, please input 0, if you want to output scissors, please input 1, if you want to output cloth, please input 2");
        //System generated
        Random xx    =    new Random();    //Declare a random number
        int number    =    xx.nextInt(3);    //Assign random number to number
        //Compare
        if(user==0 && number==0){
            return  "You are a stone, the system is a stone, and the two sides are tied.";
        }
        else if(user==1 && number==0){
            return  "You made scissors, and the system made rocks. You lost.";
        }
        else if(user==2 && number==0){
            return "You are cloth, the system is stones, you win.";
        }
        else if(user==0 && number==1){
            return  "You got rocks, and the system got scissors. You won.";
        }
        else if(user==1 && number==1){
            return "You are a stone, the system is a stone, and the two sides are tied.";
        }
        else if(user==2 && number==1){
            return "You got cloth, and the system got scissors. You lost.";
        }
        else if(user==0 && number==2){
            return "You are the stone, the system is the cloth, you lose.";
        }
        else if(user==1 && number==2){
            return "You got scissors, and the system got cloth. You won.";
        }
        else{
            return "You have cloth, and the system has cloth. The two sides draw.";
        }
    }

}
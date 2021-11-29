/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code4_1001582645;

import java.util.Random;
import java.util.Scanner;

/**Anusha Majeed        
 *1001582645
 * @author anush
 */
public class Code4_1001582645 {

    /**
     * @param user
     * @param args the command line arguments
     * @return 
     */
    public static int menu ()
        {
            Scanner in = new Scanner(System.in);
            
            System.out.println("Pick a question to answer");
            System.out.println();
            System.out.println("1.   Will I graduate?");
            System.out.println();
            System.out.println("2.   Will I find a job specific to my major when I graduate?");
            System.out.println();
            System.out.println("3.   Will I get to meet Kendrick Lamar?");
            System.out.println();
            System.out.println("4.   Will I get a raise at my current job?");
            System.out.println();
            System.out.println("5.   Will I ever get over my caffeine addiction?");
            System.out.println();
            System.out.println();
            System.out.print("Your choice : ");
            int menuChoice = in.nextInt();
            System.out.println();
            
            while ( menuChoice < 1 || menuChoice >5)
            {
                System.out.println("Invalid input. Please reenter.");
                menuChoice = in.nextInt();
            }
            
            return menuChoice;
        }
    public static void main(String[] args) {
        //call on menu and deliver response 
        Random rn = new Random();
        Scanner in = new Scanner(System.in);
        int response = rn.nextInt(20)+1;
        int menuChoice = menu();
        
        
        //create a switch statement for magic 8 ball responses
        switch (response)
        {
            case 1:
                System.out.println("It is certain.");
                break;
            case 2:
                System.out.println("It is decidedly so.");
                break;
            case 3:
                System.out.println("Without a doubt.");
                break;
            case 4:
                System.out.println("Yes - definitely.");
                break;
            case 5:
                System.out.println("You may rely on it.");
            case 6:
                System.out.println("As I see it, yes.");
                break;
            case 7:
                System.out.println("Most likely.");
                break;
            case 8:
                System.out.println("Outlook good.");
            case 9:
                System.out.println("Yes.");
                break;
            case 10:
                System.out.println("Signs point to yes.");
                break;
            case 11:
                System.out.println("Reply hazy, try again.");
                break;
            case 12: 
                System.out.println("Ask again later.");
                break;
            case 13:
                System.out.println("Better not tell you now.");
                break;
            case 14:
                System.out.println("Cannot predict now.");
                break;
            case 15:
                System.out.println("Concentrate and ask again.");
                break;
            case 16:
                System.out.println("Don't count on it.");
                break;
            case 17:
                System.out.println("My reply is no.");
                break;
            case 18:
                System.out.println("My sources say no.");
                break;
            case 19:
                System.out.println("Outlook not so good.");
                break;
            case 20:
                System.out.println("Very doubtful.");
                break;
            default :
                System.out.println("You didn't enter a number between 1 and 5.");
        }  
    }
}
        
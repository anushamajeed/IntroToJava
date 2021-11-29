/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code2_1001582645;
import java.util.Scanner;

/**Anusha Majeed
 * AXM2645
 * 1001582645
 * @author anush
 */
public class Code2_1001582645 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String user;
        
        //ask user what their weekend plans are
        System.out.println("You are making plans and find out that your friends might visit.");
        System.out.println("You need to figure out your options for the weekend.");
        System.out.println("Enter YES or NO");
        user = in.next();
        
        //create if statement to see if program should continue
        if (user.charAt(0) == 'y' || user.charAt(0) == 'Y')
        {
            System.out.println("Your friends love to go to the movies, so if they visit, you will all go to the movies.");
            System.out.println("But, if they don't visit, what will you do with your weekend?");
        }
        else
        {
            return;
        }
  
        //create if statement to find weekend plans
        System.out.println("Did your friends visit?");
        user = in.next();
        
        if (user.charAt(0) == 'y' || user.charAt(0) == 'Y')
        {
            System.out.println("Weekend plans - have fun at the movies with your friends!");
        }
        else if (user.charAt(0) == 'n' || user.charAt(0) == 'N')
        {       
           System.out.println("Your friends weren't able to visit so you need to make alternate plans.");
           System.out.println("Is the weather nice?");
           user = in.next();
        
            if (user.charAt(0) == 'y' || user.charAt(0) == 'Y')
            {
                System.out.println("Weekend plans - ride bike in the park!");
            }
               else if (user.charAt(0) == 'n' || user.charAt(0) == 'N')
                {
                    System.out.print("Oh, so the weather is bad.");
                    System.out.print(" Do you have enough money to go shopping?\n");
                    user = in.next();
                    
                    if (user.charAt(0) == 'y' || user.charAt(0) == 'Y')
                    {
                       System.out.println("Weekend plans - go shopping - don't spend too much!!"); 
                    }
                    else
                            {
                              System.out.println("Weekend plans - stay home and play video games!!");
                            }
                }       
            }
        }
    }


    
    
        
                
   

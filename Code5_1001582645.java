/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code5_1001582645;
import java.util.Scanner;
import java.util.Random;

/**Anusha Majeed
 *1001582645
 * @author anush
 */
public class Code5_1001582645 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // JavaSlam
    int [] dice = {0,0,0,0,0};
    int [] howMany = {0,0,0,0,0,0}; 
    int numberOfRolls = 0, numberOfReRolls = 3, ofAKind = 0, FullHouse = 0, 
        TwoPair = 0, JavaSlam = 0, LargeStraight = 0, SmallStraight = 0, i = 0;
    boolean happy = true;
    String user;
    Scanner in = new Scanner(System.in);
    
    do 
    {
        RollDice(dice);
        System.out.println("You rolled");
        PrintRoll(dice);
        numberOfRolls++;
        
        
        for (i = 0; i < NUMBEROFFACES; i++)
        {
            howMany[i] = HowMany(dice, i + 1);
        }
        
        //check each cell of howMany
        for (i =0; i < NUMBEROFFACES; i++)
        {
            if(howMany[i] == 3)
            {
                FullHouse = FullHouse + 3;
            }
            if(howMany[i] == 2)
            {
                FullHouse = FullHouse + 2;
                TwoPair++;
            }
            if(howMany[i] == 5)
            {
                JavaSlam++;
            }
            if(howMany[i] == 1)
            {
               LargeStraight++; 
            }
            else if(howMany[i] == 0 && LargeStraight > 0 && LargeStraight < 5)
            {
                LargeStraight = 0;
            }
            if(howMany[i] >= 1)
            {
                SmallStraight++;
            }
            else if(howMany[i] == 0 && SmallStraight > 0 && SmallStraight < 4)
            {
                SmallStraight = 0;
            }
            if(howMany[i] == 4)
            {
               ofAKind = 4; 
            }
            if(howMany[i] == 3)
            {
                ofAKind = 3;
            }
        }
        //print out results of looping over the howMany array
        if(LargeStraight == 5)
        {
            System.out.println("Large Straight");
        }
        else if (SmallStraight >= 4)
        {
            System.out.println("Small Straight");
        }
        else if (FullHouse == 5)
        {
            System.out.println("Full House");
        }
        else if (JavaSlam == 1)
        {
            System.out.println("JavaSlam!!");
        }
        else if (ofAKind == 4)
        {
            System.out.println("Four of a kind");
        }
        else if (ofAKind == 3)
        {
            System.out.println("Three of a kind");
        }
        else if (TwoPair == 2)
        {
            System.out.println("Two Pair");
        }
        else
        {
            System.out.println("You have nothing");
        }
        
        //ask player if they want to reroll if they have any left
        if(numberOfRolls != numberOfReRolls)
        {
            System.out.println("Do you want to reroll?");
            user = in.next();
            char userChar = user.charAt(0);
            
            if(userChar == 'y' || userChar == 'Y')
            {
                happy = false;
            }
            else
            {
                happy = true;
            }
            
        }
        ofAKind = 0;
        FullHouse = 0;
        TwoPair = 0;
        JavaSlam = 0;
        LargeStraight = 0;
        SmallStraight = 0;    
    }
    while(happy == false && numberOfRolls < numberOfReRolls);
   
    }
    
    final static int NUMBEROFDICE = 5;
    final static int NUMBEROFFACES = 6;
    
    public static void RollDice(int [] dice)
    {
        
        for (int i = 0; i < NUMBEROFDICE; i++)
        {
           Random rn = new Random(); 
           int randomFace = rn.nextInt(NUMBEROFFACES)+1;
           dice[i] = randomFace;
        }
    }
    
    public static void PrintRoll(int [] dice)
    {
        for (int i = 0; i < NUMBEROFDICE; i++)
        {
            System.out.println(dice[i]); 
        }
    }
    
    public static int HowMany(int [] dice, int face)
    {
        int howManyFaces = 0;
        
        for (int i = 0; i < NUMBEROFDICE; i++)
        {
            if (dice[i] == face)
            {
                howManyFaces++;
            }
        }
        return howManyFaces;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code6_1001582645;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *Anusha Majeed
 * 1001582645
 * axm2645
 * @author anush
 */
public class Code6_1001582645 {
    
        final static int MAX_ROWS = 9;
        final static int MAX_COLS = 9;
        final static int TICKET_LIMIT = 4;
        final static double ADULT_TICKET_PRICE = 7.50;
        final static double CHILD_TICKET_PRICE = 5.50;
        final static double SENIOR_TICKET_PRICE = 2.55;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Movie theater code
        Scanner in = new Scanner(System.in);
        int seats, rows;
        
        //ask user for # of rows
        System.out.print("How many rows does your movie theater have? (1-9) ");
        rows = in.nextInt();
        
        //check if rows are in range
        if(rows > MAX_ROWS || rows < 0)
        {
            do
            {
                System.out.println("Rows must be between 1 and 9. Please reenter.");
                rows = in.nextInt();
            }
             while(rows > MAX_ROWS || rows < 0);
        }
       
        //ask user for # of seats
        System.out.print("How many seats are there per row? (1-9) ");
        seats = in.nextInt();
        
        //check if seats are in range
        if(seats < 0 || seats > MAX_COLS)
        {
            do
            {
                System.out.println("Columns must be between 1 and 9. Please reenter.");
                seats = in.nextInt();
            }
            while(seats < 0 || seats > MAX_COLS);
        }
        
        
        //intitialize 2D char array and array list
        char [][] MovieTheater = new char [rows][seats];
        ArrayList<String> TicketList = new ArrayList<String>();
        
        //fill MovieTheater with O
        FillMovieTheater(MovieTheater);
        
        //call ticket menu
        int ticketChoice = ChooseTicketMenu();
        
        
        //ask user how many tickets they want
        int tickets;
        System.out.print("How many tickets would you like to purchase? (limit 4) ");
        tickets = in.nextInt();
        System.out.println();
        
        //see if tickets are in range
        if(tickets > TICKET_LIMIT)
        {
           do
           {
                System.out.print("This is a special showing - limit of 4 tickets per purchase ");
                tickets = in.nextInt();
           }
           while (tickets > TICKET_LIMIT);
        }
        if (tickets < 1)
        {
            System.out.println("No movie for you!");
        }
        
       
        //ask user for seat choice
        String seatChoice;
        int intSeatCol, intSeatRow;
        double ticketCost = 0.0, totalCost = 0.0;
        char seatRow;
        boolean notSold = true;
        for (int i = 0; i < tickets; i++)
        {
            do
            {
                do
                {
                    PrintSeatMap(MovieTheater);
                    System.out.println();
                    System.out.println("Enter seat choice by entering the row and seat - A1");
                    System.out.println();
                    System.out.println("Please pick a seat");
                    seatChoice = in.next();
                    seatChoice = seatChoice.toUpperCase();
                    String seatCol = seatChoice.substring(1, seatChoice.length());
                    intSeatCol = Integer.parseInt(seatCol);
                    seatRow = seatChoice.charAt(0);
                    intSeatRow = ((int) seatRow) - 65;
                    intSeatCol = intSeatCol - 1;
                    
                    //validate seat choice
                    if(intSeatRow < 0 || intSeatRow > rows || intSeatCol < 0 || intSeatCol > seats )
                    {
                        System.out.println();
                        System.out.println("Invalid seat. Please choose again.");
                        seatChoice = in.next();
                        System.out.println();
                    }
                }while (intSeatRow < 0 || intSeatRow > rows || intSeatCol < 0 || intSeatCol > seats );
                
                //check if seat is sold
                if (MovieTheater[intSeatRow][intSeatCol] == 'O')
                {
                    notSold = false;
                    MovieTheater[intSeatRow][intSeatCol] = 'X';
                    TicketList.add(seatChoice);
                    System.out.println();
                    
                    //calculate ticket cost
                    switch (ticketChoice)
                    {
                        case 1:
                            ticketCost = tickets * ADULT_TICKET_PRICE;
                            break;
                        case 2:
                            ticketCost = tickets * CHILD_TICKET_PRICE;
                            break;
                        case 3:
                            ticketCost = tickets * SENIOR_TICKET_PRICE;
                            break;
                    }
                    totalCost = totalCost + ticketCost;
                }    
                else 
                {
                    System.out.println();
                    System.out.printf("Seat %s is already sold. Pick another seat.", seatChoice); 
                    System.out.println();
                    System.out.println();
                }
            }while(notSold);   
        }
        //print total cost
        System.out.println();
        System.out.printf("Your total cost is $%.2f ", totalCost);
        System.out.println();
        System.out.println();
                    
        //print ticket list
        System.out.print("Here's your tickets - [ ");
        for (int count = 0; count < TicketList.size(); count++)
        {
            System.out.print(TicketList.get(count) + " " );
        }
        System.out.println("]");
        System.out.println();
        System.out.println("Enjoy your movie!");
    }       
     
    public static void FillMovieTheater (char [][] MovieTheater)
    {
        for (int i = 0; i < MovieTheater.length; i++)
        {  
           for (int j = 0; j < MovieTheater[0].length; j++) 
           {
               MovieTheater[i][j] = 'O';  
           }
        }
    }
    
    public static int ChooseTicketMenu ()
    {
        Scanner in = new Scanner(System.in);
        int ticketChoice;
        
        System.out.println("\nTicket Menu");
        System.out.println("");
        System.out.printf("1. Adult  (12+)      $%.2f\n", ADULT_TICKET_PRICE);
        System.out.printf("2. Child  (Under 12) $%.2f\n", CHILD_TICKET_PRICE);
        System.out.printf("3. Senior (Over 55)  $%.2f\n", SENIOR_TICKET_PRICE);
        System.out.print("\nWhat type of ticket do you wish to purchase? ");
        ticketChoice = in.nextInt();
       
        //ask for choice and see if it is in range
        if(ticketChoice < 1 || ticketChoice > 3)
        {
            do
            {
                System.out.print("Please choose only 1, 2, or 3 ");
                ticketChoice = in.nextInt();
            }
            while(ticketChoice < 1 || ticketChoice > 3);
        }
        return ticketChoice;
    }
    
    public static void PrintSeatMap(char [][] MovieTheater)
    {
        //print seat numbers
        for(int countcol = 0; countcol < MovieTheater[0].length; countcol++)
        {
            int seatNum = countcol + 1;
            System.out.printf("\tSeat %d", seatNum);
        }  
        System.out.println();
            
            //print row letters and O's
            for(int i = 0; i < MovieTheater.length; i++)
            {
                String seatChar = String.valueOf((char)(i + 65));
                System.out.printf("Row %s \t", seatChar);
                for (int j = 0; j < MovieTheater[0].length; j++)
                {
                    System.out.printf("%c\t", MovieTheater[i][j]);
                }
                System.out.println();
            } 
    }    
        
}
    
    

    


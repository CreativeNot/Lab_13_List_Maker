import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ":");
            retString = pipe.nextLine();
        }
        while (retString.length() == 0);

        return retString;
    }

    /**
     * Gets an integer from the user
     * @param pipe input from user
     * @param prompt asks the user a question
     * @return returns
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int userInput = 0;
        String trash = " ";
        boolean keepGoing = false;

        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextInt())
            {
                userInput = pipe.nextInt();
                pipe.nextLine();
                keepGoing = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid integer, try again!");
            }
        }while (!keepGoing);

        return userInput;

    }

    /**
     * Gets a double from the user and loops until correct
     * @param pipe input from user
     * @param prompt "Please enter a number"
     * @return returns a double from the user
     */
    public static double getDouble(Scanner pipe,String prompt)
    {
       double userInput = 0;
       String trash = "";
       boolean keepGoing = false;

       do{
           System.out.print("\n" + prompt + ":");
           if(pipe.hasNextDouble())
           {
               userInput = pipe.nextDouble();
               pipe.nextLine();
               keepGoing = true;
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println(trash + " is not a valid response, try again!");
           }
       }while (!keepGoing);

       return userInput;
    }

    /**
     * Makes the user enter a range between two values
     * @param pipe input from user
     * @param prompt "Please give a value within the range of numbers"
     * @param low lowest number in range
     * @param high highest number in range
     * @return Returns the number if it is within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash;
        boolean keepGoin = false;

        do
        {
            System.out.print("\n" + prompt + ":");
            if(pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                if(retInt >= low && retInt <= high)
                {
                    keepGoin = true;
                }
                else
                {
                    System.out.println("\nPlease enter a number between " + low + " and " + high + "!");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\n" + trash + " is not a valid input, try again!");
            }

        }
        while(!keepGoin);
        return retInt;

    }

    /**
     * Makes the user give a double in a certain range of numbers
     * @param pipe input from user
     * @param prompt "Please gjve a number within the range"
     * @param low lowest number in range
     * @param high highest number in range
     * @return Returns number if in range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDbl = 0;
        String trash;
        boolean keepGoin = false;

        do
        {
            System.out.print("\n" + prompt + ":");
            if(pipe.hasNextDouble())
            {
                retDbl = pipe.nextDouble();
                if(retDbl >= low && retDbl <= high)
                {
                    keepGoin = true;
                }
                else
                {
                    System.out.println("\nPlease enter a number between " + low + " and " + high + "!");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\n" + trash + " is not a valid input, try again!");
            }

        }
        while(!keepGoin);
        return retDbl;
    }

    /**
     * Simple Yes or No program
     * @param pipe User input
     * @param prompt "Please enter [Y/N]
     * @return returns Yes or No as a boolean
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retYN = false;
        boolean keeper = false;
        String userResponse;

        do
        {
            System.out.print("\n" + prompt + ":");
            userResponse = pipe.nextLine();
            if(userResponse.equalsIgnoreCase("Y"))
            {
                retYN = true;
                keeper = true;
            }
            else if (userResponse.equalsIgnoreCase("N"))
            {
                retYN = false;
                keeper = true;
            }
            else
            {
                System.out.println(userResponse + " is not a valid response, must put [Y/N]");
            }
        }
        while (!keeper);

        return retYN;
    }

    /**
     * Inputs a string that matches the regEx
     * @param pipe input from the user
     * @param prompt prompt for user
     * @param regEx java regex pattern
     * @return String returned that matches the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;
        String trash = "";
        String retString;

        do
        {
            System.out.print(prompt + " " + regEx + ": ");
            retString = pipe.nextLine();

            if (retString.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Enter a matching pattern not: " + trash);
            }
        }
        while (!done);

        return retString;
    }

    /**
     * This prints out a centered header
     * @param msg
     */
    public static void prettyHeader(String msg)
    {
        int whiteSpace = (53 - msg.length()) / 2;

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
        System.out.print("\n***");

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
    }

}
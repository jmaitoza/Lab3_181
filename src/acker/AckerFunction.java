package acker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AckerFunction
{
    private static int spaces = 0;
    private static int numberOfInvocations = 0;

    // getter for data field "numberOfInvocations"
    public static int countOfInvocations()
    {
        return numberOfInvocations;
    }

    public static int acker(int m, int n)
    {
        int result = 0;
        numberOfInvocations++;
        printSpaces();
        System.out.println("Enter method acker: m = " + m + ", n = " + n);

        spaces += 4;

        if (m == 0)
        {
          result = n + 1;
        }
        else if ((n == 0) && (m > 0))
        {
          result = acker(m - 1, 1);
        }
        else if ((m > 0) && (n > 0))
        {
          result = acker(m - 1, acker(m, n - 1));
        }

        spaces -= 4;
        printSpaces();
        System.out.println("Leave method acker: acker("+m+", "+n+") = " + result);
        return result;
    }

    // indent the trace messages according to how "deep" the current recursive call is
    private static void printSpaces()
    {
        for (int i = 0; i < spaces; i++)
            System.out.print(" ");
    }

    public static void main(String[] args) throws IOException, NumberFormatException
    {
        //TODO: read two nonnegtive intergers from stardard input and
        //      call the recursive method acker(int, int).
        //        Output the total number of method invocations.

        int m;
        int n;
        int result;
        BufferedReader ackerInput = new BufferedReader(new InputStreamReader(System.in));
        String[] strAck;

        // Takes user input first as an array of Strings and then converts to them to a list to parse the integers
        while (true)
        {
            System.out.println("Input two numbers seperated by a space, or type q to quit");
            strAck = ackerInput.readLine().split(" ");
            List<String> ackList = new ArrayList<>(Arrays.asList(strAck));

            if (ackList.contains("q") || ackList.contains("Q"))
            {
                System.out.println("Exiting...");
                System.exit(0);
            }

            // search in array index 0 and 1 for m and n respectively, ignoring other characters inputted as well as whitespace
            try
            {
                m = Integer.parseInt(ackList.get(0));
                n = Integer.parseInt(ackList.get(1));

                if ((m < 0) || (n < 0))
                {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException nfe) //throws exception if m or n are not integers
            {
                System.out.println("Must input an integer!\n");
                continue;
            } catch (IllegalArgumentException ie)
            {
                System.out.println("M and N must be positive integers!\n");
                continue;
            } catch (IndexOutOfBoundsException ibe)
            {
                System.out.println("Must input more than one integer!");
                continue;
            }

            result = acker(m,n);
            System.out.println("Total number of invocations: " + countOfInvocations() + ", Result: " + result + "\n");
            numberOfInvocations = 0;
        }
    }
}



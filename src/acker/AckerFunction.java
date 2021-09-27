package acker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;

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
        //TODO: implement the Ackermann's function to trace the method invocation
        //      history and count the total number of invocations.

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

    public static void main(String[] args)
    {

        //TODO: read two nonnegtive intergers from stardard input and
        //      call the recursive method acker(int, int).
        //        Output the total number of method invocations.

        int m = 0;
        int n = 0;
        BufferedReader ackerInput = new BufferedReader(new InputStreamReader(System.in));
        int[] ackArr = new int[0];
        String[] strAck = new String[0];
        System.out.println("Input two numbers seperated by a space");

//        try
//        {
//            strAck = ackerInput.readLine().split(" ");
//        } catch (NumberFormatException | IOException e)
//        {
//            System.out.println("Must input an integer!");
//        }

//        try
//        {
//            strAck = ackerInput.readLine().split(" ");
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }


        try
        {
            strAck = ackerInput.readLine().split(" ");

            for(int i = 0; i < strAck.length; i++)
            {
                m = Integer.parseInt(strAck[0]);
                n = Integer.parseInt(strAck[1]);
            }
            if (m < 0 || n <0)
                throw new IllegalArgumentException();
        } catch (IOException e)
        {
            System.out.println("Must input an integer!");
        } catch (IllegalArgumentException ie)
        {
            System.out.println("M and N must be positive integers!");
        }





        //TODO: add exception handling for:
        //       - when either m or n is >  0
        //       - when m or n is not an int
        //       - when user wants to quit the program

        int result = acker(m,n);
        System.out.println("Total number of invocations: " + countOfInvocations() + ", Result: " + result);
    }
}



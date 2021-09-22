package acker;

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

        //TODO: implement the Ackermann's function to trace the method invocation
        //      history and count the total number of invocations.

        /*
         * First implement the base case
         **/

        //if m = 0; -> n+1
        //if n = 0; -> acker(m-1,1)
        //otherwise; -> acker(m-1,acker(m,n-1))

        /*
        once you reach the first case where m = 0, n is then computed as n+1 and stored as the result value,
        and the acker function steps one line out
        */

         if (m == 0)
         {
             result = n += 1;
         }
         else if ((n == 0) && (m > 0))
         {
             return acker(m - 1, 1);
         }
         else if ((m > 0) && (n > 0))
         {
             return acker(m - 1, acker(m, n - 1));
         }

        return result;

         //
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

    }
}



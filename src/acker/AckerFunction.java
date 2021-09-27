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

        int m,n = 0;
        int result = acker(1,2);
        System.out.println("Total number of invocations: " + numberOfInvocations + ", Result: " + result);
    }
}



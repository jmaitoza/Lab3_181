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
        //      history and count the totoal number of invocations.

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

    }
}



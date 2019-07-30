package CH03.common;

public class Id
{
    private static int counter = 0;
    private int id;

    public Id()
    {
        id = ++counter;
    }

    public int getId()
    {
        return id;
    }

    public static int getCounter()
    {
        return counter;
    }
}

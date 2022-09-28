


/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{

    public static String getLastTwo(String s)
    {
        String result = "";
        int len =s.length();
        int start = len-2;
        result = s.substring(start,len);
        return result;
    }

    public static String replaceFirstTwo(String s)
    {
        String result = s;
        if (s.length()>1)  // not a length 1;
        {
            String lastTwo = getLastTwo(s);
            String lastPart = s.substring(2);
            result = lastTwo+lastPart;
        }

        return result;
    }

}

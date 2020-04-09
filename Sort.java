import java.util.*;

public class Sort
{
    public static void selectionSort(ArrayList<String> list)
    {
        int startIndex = 0;
        int smallestIndex = 0;

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = startIndex; j < list.size(); j++)
            {
                if (isBeforeNeedle(list.get(smallestIndex), list.get(j)))
                {
                    smallestIndex = j;
                }
            }

            Collections.swap(list, i, smallestIndex);
            startIndex++;
            smallestIndex = startIndex;
        }
    }



    public static boolean isBeforeNeedle(String test, String needle) // 2 words
    {
        boolean before = false;
        boolean done = false;

        for (int i = 0; i < test.length() - 1; i++)
        {
            if (!done && positionOfLetter(test.substring(i, i + 1), needle.substring(i, i + 1)) == 1)
            {
                done = true;
                before = true;
            }
            if (!done && positionOfLetter(test.substring(i, i + 1), needle.substring(i, i + 1)) == -1)
            {
                done = true;
                before = false;
            }
        }

        return before;
    }

    public static int positionOfLetter(String testLetter, String needleLetter) // -1 = before, 0 = same, 1 = after
    {
        String[] alphabet = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        // nothing comes before something so "" is inclded
        int foundtest = -1;
        int foundneedle = -1;

        for (int i = 0; i < alphabet.length; i++)
        {
            foundtest = (alphabet[i].equals(testLetter)) ? i : foundtest;
            foundneedle = (alphabet[i].equals(needleLetter)) ? i : foundneedle;
        }

        if (foundtest < foundneedle)
        return -1;
        if (foundtest > foundneedle)
        return 1;

        return 0;
    }

    public static void main(String[] args)
    {
        ArrayList<String> fruits = new ArrayList<String>(Arrays.asList("mango", "banana", "strawberry", "cherry", "lime", "pear", "apple", "watermelon", "lemon", "blueberry", "orange"));

        selectionSort(fruits);
        System.out.println(fruits.toString());
    }
}
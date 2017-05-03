package ir.mimrahe.inwords;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h3>Android Library "InWords"</h3>
 * is a tool which show in words equal of a digit or number
 * call this tool as static class
 * <b>Usage</b>
 * {@code import ir.mimrahe.inwords.InWords;}
 * {@code String inwordsResult = InWords.from(getApplicationContext(), numberInLongType);}
 *
 * @author mohsen ranjbar
 * @version 1.0
 * @since 2017
 */
public class InWords {
    // class prototype is singleton
    // singleton instance
    private static final InWords ourInstance = new InWords();

    private static InWords getInstance() {
        return ourInstance;
    }

    private InWords() {
    }

    /**
     * gets context and number then results in string contains in words of number
     *
     * @param context android.content.Context ApplicationContext
     * @param number long
     * @return String
     */
    public static String from(Context context, long number){
        // if number equals zero then return "zero"
        if (number == 0){
            return context.getResources().getString(R.string.inwords_n0);
        }
        // split number 3 digits by 3 into array list
        ArrayList<Long> splited = new ArrayList<>();
        do{
            splited.add(number % 1000);
            number /= 1000;
        } while(number != 0);
        // get splited numbers in words and save into new array list
        ArrayList<String> collected = new ArrayList<>();
        for (long num: splited){
            collected.add(getInstance().getInWords(context, num));
        }
        // add postfix for numbers
        String[] names = context.getResources().getStringArray(R.array.inwords_names);
        for (int i = 0; i < collected.size(); i++){
            if (!collected.get(i).isEmpty()){
                collected.set(i, collected.get(i) + " " + names[i]);
            }
        }
        String result = "";
        if (!collected.isEmpty()){
            // remove empty items in collected
            while(collected.remove(""));
            // reverse collected for fix order
            Collections.reverse(collected);
            // join collected into string with delimiter "and"
            String delimiter = context.getString(R.string.inwords_3digits_delimiter);
            if(delimiter.isEmpty()){
                delimiter = " ";
            } else {
                delimiter = " " + delimiter + " ";
            }
            result = TextUtils.join(delimiter, collected);
        }
        return result;
    }

    /**
     * gets context and 3digit number and results in string contains in words of 3digit number
     *
     * @param context android.content.Context ApplicationContext
     * @param number long
     * @return String
     */
    private String getInWords(Context context, long number){
        if (number == 0){
            return "";
        }
        // string resources contains 0-900 in words
        String[] array0_19strings = context.getResources().getStringArray(R.array.inwords_no0_19);
        String[] array20_90strings = context.getResources().getStringArray(R.array.inwords_no20_90);
        String[] array100_900strings = context.getResources().getStringArray(R.array.inwords_no100_900);
        ArrayList<String> result = new ArrayList<>();
        int mod100 = (int) number % 100;
        int mod10;
        // if last 2 digit is between 9 and 20
        if (mod100 > 9 && mod100 < 20){
            result.add(array0_19strings[mod100]);
            number /= 100;
        } else {
            // last 2 digit is higher than 19 and last 1 digit is lower than 10
            // last digit
            mod10 = (int) number % 10;
            if (mod10 != 0){
                result.add(array0_19strings[mod10]);
            }
            // second digit
            number /= 10;
            mod10 = (int) number % 10;
            if(mod10 != 0){
                result.add(array20_90strings[mod10]);
            }
            number /= 10;
        }
        // third digit
        mod10 = (int) number % 10;
        if (mod10 != 0){
            result.add(array100_900strings[mod10]);
        }
        // join digits by delimiter and return string contains in words of 3digit number
        if (!result.isEmpty()){
            Collections.reverse(result);
            String delimiter = context.getString(R.string.inwords_digits_delimiter);
            if(delimiter.isEmpty()){
                delimiter = " ";
            } else {
                delimiter = " " + delimiter + " ";
            }
            return TextUtils.join(delimiter, result);
        }
        return "";
    }
}

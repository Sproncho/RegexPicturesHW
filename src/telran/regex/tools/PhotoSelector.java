package telran.regex.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoSelector {
    public static String[] selectPictures(String[] pictures,String regex) {
        //по хорошему бы использовать лист
        Pattern pattern = Pattern.compile(regex);
        boolean[] matches = new boolean[pictures.length];
        int counter = 0;
        Matcher matcher;
        for (int i = 0; i < pictures.length; i++) {
            matcher = pattern.matcher(pictures[i]);
            boolean found = matcher.find();
            matches[i] = found;
            counter += found?1:0;
        }
        int ind = 0;
        String[] res = new String[counter];
        for (int i = 0; i < pictures.length; i++) {
            if(matches[i]){
                res[ind] = pictures[i];
                ind++;
            }
        }
        return res;
    }

}

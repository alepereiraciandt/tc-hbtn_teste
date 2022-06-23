import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    public boolean checkUser(String username) {

        Pattern p = Pattern.compile("[^a-z\\d ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(username);
        boolean anySpecialCharFound = m.find();

        if (username.length() > 8 && !anySpecialCharFound)
            return true;

        return false;
    }

    public boolean checkPassword(String password) {

        Pattern p = Pattern.compile("[^a-z\\d ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean anySpecialCharFound = m.find();


        if (password.chars().anyMatch(Character::isUpperCase)
            && password.chars().anyMatch(Character::isDigit)
                && anySpecialCharFound
                    && password.length() >= 8)
            return true;


        return false;
    }
}

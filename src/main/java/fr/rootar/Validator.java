package fr.rootar;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidMail(String infoEmail){
    String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return Pattern.compile(regex)
            .matcher(infoEmail)
                .matches();
    }
}

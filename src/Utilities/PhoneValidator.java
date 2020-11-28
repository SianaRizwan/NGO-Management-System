package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private Pattern pattern;
private  Matcher matcher;
    private static final String EMAIL_PATTERN =
            "88?[0][1][0-9]{9}|[0][1][0-9]{9}";

    public PhoneValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }


    public boolean validate(final String hex) {
          matcher=pattern.matcher(hex);
        return matcher.find() && matcher.group().equals(hex);

    }
}

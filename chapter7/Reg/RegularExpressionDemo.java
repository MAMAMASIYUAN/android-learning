import java.util.regex.Pattern;
public class RegularExpressionDemo {

    public static void main(String[] args) {
        String testString = "tesads";
        System.out.println(Validator.isUsername(testString));
        testString = "xxx@yy.com";
        System.out.println(Validator.isEmail(testString));
    }
}

/**

    Refer from https://github.com/gmle/Regular_Expression/blob/master/Validator.java
 */
class Validator {
    /**
     * ?????????????????
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * ????????????????
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * ?????????????????
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * ????????????????
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * ????????????????
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
    /**
     * ????????????????
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * ????????????URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * ????????????IP???
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * §µ???????
     *
     * @param username
     * @return §µ?????????true???????false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * §µ??????
     *
     * @param password
     * @return §µ?????????true???????false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * §µ???????
     *
     * @param mobile
     * @return §µ?????????true???????false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * §µ??????
     *
     * @param email
     * @return §µ?????????true???????false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * §µ?üM??
     *
     * @param chinese
     * @return §µ?????????true???????false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * §µ??????
     *
     * @param idCard
     * @return §µ?????????true???????false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * §µ??URL
     *
     * @param url
     * @return §µ?????????true???????false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * §µ??IP???
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
}
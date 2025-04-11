import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tokenGenerator {
    private static final String CHARS="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH =10;
    private static final SecureRandom randNum = new SecureRandom();

    public static String generateToken(){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<TOKEN_LENGTH;i++){
            sb.append(CHARS.charAt(randNum.nextInt(CHARS.length())));
        }
        sb.insert(3,"$");   //Adds '$' as 4th char for token verification
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        sb.append("_").append(timestamp);
        return sb.toString();
    }
}

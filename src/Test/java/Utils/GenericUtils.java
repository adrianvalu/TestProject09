
package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class GenericUtils {

    public static String createRandomString(int charCount) {
        StringBuilder sb = new StringBuilder();
        String charset = "abcdefghijklmnopqrstuvwxyz";
        charset += charset.toUpperCase();
        for (int i = 0; i < charCount; i++) {
            Random r = new Random();
            char x = charset.toCharArray()[r.nextInt(charset.length())];
            sb.append(x);
        }
        return sb.toString();
    }

    public static String createBaseUrl(String configFile) {
        String urlBase = "";
        try {
            Properties appProps = new Properties();
            appProps.load(Files.newInputStream(Paths.get(configFile)));
            urlBase = appProps.getProperty("protocol") + "://" + appProps.getProperty("hostname") + ":" + appProps.getProperty("port");
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        return urlBase;
    }
}
package helpers;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Base64;

import static helpers.jaskdjaiurqasdasjdaksjaskdjaiurqasdasjdaks.getsheet;

public class download {
    public static void Locators() throws IOException, InterruptedException, GeneralSecurityException {

        String Currentdir = System.getProperty("user.dir");
        String filePath = Currentdir+ "/src/test/resources/locators.xlsx";
        getsheet("1pJ-vCAqB2vWb5UZVVuNEmf_qY4IRRQz1VrD2AVCSltk", filePath);
    }
    public static void main(String[] args) throws IOException {

    }
}

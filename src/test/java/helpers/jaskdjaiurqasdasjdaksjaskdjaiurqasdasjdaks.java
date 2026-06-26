package helpers;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class jaskdjaiurqasdasjdaksjaskdjaiurqasdasjdaks {
    private static final String APPLICATION_NAME = "Google Sheets Download";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_PATH = "automation-498906-994c89044c97.json";

    public static Drive getDriveService() throws IOException, GeneralSecurityException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        // Load service account credentials (legacy GoogleCredential instead of GoogleCredentials)
        GoogleCredential credential = GoogleCredential
                .fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE_READONLY));

//        System.out.println("Service Account: " + credential.getServiceAccountId());

        return new Drive.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void getsheet(String fileId, String filePath) throws IOException, GeneralSecurityException {
        Drive service = getDriveService();

        // Export as XLSX or CSV
        String exportMimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; // XLSX
        // String exportMimeType = "text/csv"; // CSV

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            service.files()
                    .export(fileId, exportMimeType)
                    .executeMediaAndDownloadTo(outputStream);
        }

       // System.out.println("Sheet downloaded to: " + filePath);
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {
    }
}
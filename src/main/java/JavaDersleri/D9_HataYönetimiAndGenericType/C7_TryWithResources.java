package JavaDersleri.D9_HataYönetimiAndGenericType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class C7_TryWithResources {
    public static void main(String[] args) {
        // try-with-resources ile otomatik kaynak yönetimi sağlanır.
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            // Dosya satır satır okunur.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Hata yakalanır ve kullanıcıya bilgi verilir.
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
} 
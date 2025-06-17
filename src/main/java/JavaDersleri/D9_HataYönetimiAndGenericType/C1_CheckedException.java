package JavaDersleri.D9_HataYönetimiAndGenericType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class C1_CheckedException {
    // Dosya okuma işlemi yapan metot. Checked Exception (IOException) fırlatabilir.
    public static void readFile(String fileName) throws IOException {
        // Dosyayı okumak için BufferedReader kullanılır.
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        // Dosya satır satır okunur ve ekrana yazdırılır.
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        // Kaynak serbest bırakılır.
        reader.close();
    }

    public static void main(String[] args) {
        try {
            // Var olmayan bir dosya okunmaya çalışılırsa IOException fırlatılır.
            readFile("data.txt");
        } catch (IOException e) {
            // Hata yakalanır ve kullanıcıya bilgi verilir.
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
} 
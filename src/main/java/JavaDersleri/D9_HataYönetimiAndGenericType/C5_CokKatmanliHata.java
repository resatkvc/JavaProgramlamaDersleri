package JavaDersleri.D9_HataYönetimiAndGenericType;

import java.io.IOException;

public class C5_CokKatmanliHata {
    // İlk katmanda IOException fırlatan metot.
    public static void methodA() throws IOException {
        throw new IOException("Dosya bulunamadı");
    }

    // İkinci katmanda methodA çağrılır ve hata zinciri devam eder.
    public static void methodB() throws IOException {
        methodA();
    }

    public static void main(String[] args) {
        try {
            // Çok katmanlı hata zinciri başlatılır.
            methodB();
        } catch (IOException e) {
            // Hata zincirinin en sonunda hata yakalanır ve bilgi verilir.
            System.out.println("Hata zinciri: " + e.getMessage());
        }
    }
} 
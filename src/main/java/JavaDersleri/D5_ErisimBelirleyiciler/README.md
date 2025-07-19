# D5_ErisimBelirleyiciler

Bu klasörde Java'da erişim belirleyiciler (public, protected, default, private) ile ilgili örnekler ve gerçek bir e-ticaret sistemi modellemesi bulunmaktadır.

## C1_Public.java
Public erişim belirleyicisinin temel kullanımını, değişken, metot ve constructor seviyesinde örnekler ile gösterir. Public üyeler her yerden erişilebilir.

## C2_Protected.java
Protected erişim belirleyicisinin temel kullanımını, alt sınıflardan ve aynı paket içinden erişim örnekleriyle gösterir.

## C3_Default.java
Default (package-private) erişim belirleyicisinin sadece aynı paket içinden erişilebildiğini örnekler.

## C4_Private.java
Private erişim belirleyicisinin sadece tanımlandığı sınıf içinden erişilebildiğini, encapsulation ve factory metot örnekleriyle gösterir.

---

## EticaretSistemi Alt Klasörü
E-ticaret sistemi örneği ile erişim belirleyicilerin gerçek bir projede nasıl kullanıldığını gösterir.

- **Urun.java**: Ürün bilgilerini tutan temel sınıf. Farklı erişim seviyelerinde değişkenler ve metotlar içerir.
- **ElektronikUrun.java**: Urun sınıfından türeyen, elektronik ürünlere özel alanlar ve işlemler ekleyen alt sınıf.
- **EticaretTest.java**: Erişim belirleyicilerin pratikte nasıl çalıştığını gösteren test sınıfı. 
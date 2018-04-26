public class Main {

    public static void main(String[] args) {
        KontaktNett kontaktNett = new KontaktNett();
        kontaktNett.fillTestData();
        String mistenkt1 = "Narren";
        String mistenkt2 = "Kongen";
        System.out.println(mistenkt1 + " har hatt direkte kontakt med" + kontaktNett.finnDirekteKontakter(mistenkt1, 0));

        System.out.println(mistenkt1 + " kan ha hatt kontakt med " + kontaktNett.finnAlleKontakter(mistenkt1, 10));
    }
}
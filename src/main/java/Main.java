import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Korzystając z pętli wypisz liczby od -20 do 20. Następnie wypisz:

        for (int i = -20; i < 21; i++) {
            System.out.println(i);
        }

        System.out.println();

//        6 pierwszych liczb

        for (int i = -20; i < -14; i++) {
            System.out.println(i);
        }

        System.out.println();

//        6 ostatnich liczb

        for (int i = 15; i < 21; i++) {
            System.out.println(i);
        }

        System.out.println();

//        wszystkie parzyste liczby

        for (int i = -20; i < 21; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println();

//        wszystkie liczby oprócz cyfry 5

        for (int i = -20; i < 21; i++) {
            if (i == 5) {
                continue;
            } else {
                System.out.println(i);
            }
        }

        System.out.println();

//        wszystkie liczby do cyfry 7 włącznie

        for (int i = -20; i < 8; i++) {
            System.out.println(i);
        }

        System.out.println();

//        wszystkie liczby podzielne przez 3

        for (int i = -20; i < 21; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

        System.out.println();

//        sumę wszystkich liczb

        int sum = 0;
        for (int i = -20; i < 21; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println();

//        sumę liczb większych lub równych 4

        sum = 0;
        for (int i = -20; i < 21; i++) {
            if (i >= 4) {
                sum += i;
            }
        }
        System.out.println(sum);
        System.out.println();

//        wszystkie liczby oraz ich potęgi

        for (int i = -20; i < 21; i++) {
            System.out.println(i + " Sqrt: " + Math.pow(i, 2));
        }

        System.out.println();


//        wszystkie liczby oraz ich wartość modulo 10

        for (int i = -20; i < 21; i++) {
            System.out.println(i + " % 10 = " + i % 10);
        }

        System.out.println();

//        Korzystając z klasy oferującej operacje na dacie i czasie pobierz aktualny czas (godzinę, minutę i sekundę) oraz wypisz te wartości używając znaków \*, których liczba równa się danej wartości. Dla utrudnienia, w jednym wierszu może być maksymalnie 10 znaków *.
//
//        Przykład dla wartości 15:03:28.
//
//
//        Aktualny czas: 15:03:28
//
//        Godzina:
//**********
//*****
//
//        Minuta:
//***
//
//        Sekunda:
//**********
//**********
//********

        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println(time);
        System.out.println("Hour:");
        for (int i = 0; i < time.getHour(); i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print("*");
        }

        System.out.println();

        System.out.println("Minute:");
        for (int i = 0; i < time.getMinute(); i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print("*");
        }

        System.out.println();

        System.out.println("Second:");
        for (int i = 0; i < time.getSecond(); i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print("*");
        }

        System.out.println();

        System.out.println();


//        Strona z kalendarza dla miesiąca stycznia, gdzie 1 stycznia wypada w środę, dla aktualnej daty 16 stycznia może wyglądać jak poniżej:
//
//
//        Pn Wt Śr Cz Pt Sb Nd
//\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-
//                1  2  3  4  5
//        6  7  8  9 10 11 12
//        13 14 15[16]17 18 19
//        20 21 22 23 24 25 26
//        27 28 29 30 31
//        wyświetl powyższą stronę używając pętli oraz dodatkowych instrukcji
//
//        dostosuj kod, by 1 stycznia mógł wypadać dowolnego dnia tygodnia
//
//        pobierz dane (korzystając z klasy oferującej operacje na dacie i czasie) o aktualnej dacie i wyświetl dla niej stronę z kalendarz

        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj rok: ");
        int year = scanner.nextInt();
        System.out.print("Podaj miesiąc (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Podaj dzień: ");
        int day = scanner.nextInt();


        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


        System.out.println("Data: " + dateFormat.format(calendar.getTime()));


        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        System.out.println("Pn Wt Śr Cz Pt Sb Nd");
        System.out.println("-------------------");


        int offset = (firstDayOfWeek + 5) % 7;

        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }


        for (int dayOfMonth = 1; dayOfMonth <= numDaysInMonth; dayOfMonth++) {
            System.out.printf("%2d ", dayOfMonth);


            if ((dayOfMonth + offset) % 7 == 0) {
                System.out.println();
            }
        }
    }
}

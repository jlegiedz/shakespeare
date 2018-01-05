Książka do analizy: https://www.gutenberg.org/ebooks/100 (Dzieła zebrane Szekspira)
Wersja Plain Text: http://www.gutenberg.org/cache/epub/100/pg100.txt

Przygotowanie
Stworzyć pusty projekt Mavenowy. Przez konwencję groupId/artifactId piszemy małymi literami, przez specyfikację nie mogą zawierać spacji.
Znów przez konwencję nie należy umieszczać plików bez żadnego pakietu nad nimi.
Przestawić Mavena na Javę 8 i UTF-8 (properties ze slajdów albo wyklikać)
Opcjonalnie: dodać zależności w Mavenie (pom.xml): np. vavr dla bardziej funkcyjnego podejścia - https://mvnrepository.com/
Implementacja
wczytać plik
zliczyć wystąpienia słów, pomijając wielkość znaków, interpunkcję itp. (na start wystarczy podział po spacjach, potem można ulepszać)
posortować wyniki
wyświetlić najpopularniejsze 20 słów (z liczbami)

Pytania pomocnicze:
czego użyć do wczytania pliku?
w jakiej strukturze trzymać wyniki?

Przydatne klasy/interfejsy: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html, https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

Ustalenie ścieżki do pliku

Przykładowa ścieżka do pliku na Windowsie:
C:\\Users\\Rent\\Desktop\\szekspir.txt (zobaczcie we właściwościach pliku jego prawdziwą ścieżkę, polska wersja systemu może “kłamać”, podwójcie backslashe)

Korzystając z przenośnej definicji katalogu użytkownika:
String filePath = System.getProperty("user.home") + "\\Desktop\\Szekspir.txt";
File file = new File(filePath);
(źródło: http://stackoverflow.com/questions/585534/what-is-the-best-way-to-find-the-users-home-directory-in-java)

Niemal całkiem przenośnie:
File source = Paths.get(System.getProperty("user.home"), "Desktop", "Szekspir.txt").toFile();

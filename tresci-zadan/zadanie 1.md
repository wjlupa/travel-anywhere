
# Zadanie 1

## Termin wykonania:

Do 29 październik 2025, 23:59 (commit/commity wmergowane do głównej gałęzi repozytorium)

## Forma wykonania:

Plik z testami (txt, md, adoc) zawierający przypadki testowe (rozpisane jak w poniższym przykładzie) zmergowany do gałęzi głównej repozytorium zespołów. Nazwa pliku: `zadanie_1_czesc_XX.{rozszerzenie}`.

Opcjonalnie: chętni mogą się pokusić o zautomatyzowanie testów - w takim przypadku commit zmergowany do gałęzi głównej powinien zawierać w swojej nazwie/opisie informację której części zadania dotyczy.

Defekty w aplikacji znalezione podczas wykonywania zadań należy zaraportować tworząc plik `zadanie_1_blad_XX.{rozszerzenie}`.

## Kontekst, warunki wstępne:

Podczas wykonywania zadań bazujemy na:

-   informacjach z pierwszych zajęć
-   wiedzy zdobytej podczas dotychczasowej edukacji
-   wymaganiach opisanych w `project_requirements.md`
-   aplikacji z repozytorium `travel_anywhere`

Pamiętajcie proszę, z czego składa się przypadek testowy: w minimalnej wersji będzie to:

-   identyfikator testu (unikalny)
-   warunki wejściowe
-   kroki testowe
-   oczekiwany rezultat

Dla wymagań funkcjonalnych:

```
Aplikacja po uruchomienu posiada dwa pola przyjmujące liczby całkowite.
Po kliknięciu `oblicz` lub wciśnieciu `enter` w trzecim polu aplikacja zwraca wynik dzielenia pierwszej liczby przez drugą.
```

przykładowe przypadki testowe mogłyby wyglądać tak:

```
- identyfikator testu: dzielenie_przez_1
- warunki wejściowe: uruchom aplikacje
- kroki testowe:
  - w pierwsze pole wpisz `4`
  - w drugie pole wpisz `1`
  - wciśnij `enter`
- oczekiwany rezultat:
  - w polu zawierającym wynik pojawia się liczba `4`
- identyfikator testu dzielenie_przez_0
- warunki wejściowe: uruchom aplikacje
- kroki testowe:
  - w pierwsze pole wpisz `4`
    - w drugie pole wpisz `0`
      - kliknij przycisk `oblicz`
      - oczekiwany rezultat
        - w polu zawierającym wynik pojawia się informacja, że dzielenie przez 0 nie jest możliwe
```


## Zadanie 1, część 1:

Wykorzystując technikę _klas równoważności_ zaprojektuj _minimalną_ ilość przypadków testowych pokrywających następujące wymaganie:

```
- Jako turysta-podróżnik wybierający się do punktu Lon2, Lat2 chciałbym wiedzieć gdzie znajduje się najbliższy hotel.
```

Domyślny promień poszukiwań wynosi 30km.
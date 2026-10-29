# Zadanie 1, część 2

Wykorzystując technikę _Analizy wartości brzegowych_ zaprojektuj _minimalną_ ilość przypadków testowych pokrywających następujące wymaganie:

```
- Jako turysta-podróżnik wybierający się do punktu Lon2, Lat2 chciałbym wiedzieć gdzie znajduje się najbliższy hotel.
```

Domyślny promień poszukiwań wynosi 30km.

## Rozwiązanie

### 1. identyfikator testu: 121_zero_hoteli
- warunki wejściowe:
    - uruchom aplikację zgodnie z README
    - pobierz token ATK do obsługi API oraz zaloguj się nim
- kroki testowe
    - kliknij na środek Morza Śródziemnego
- oczekiwany rezultat:
    - na liście nie wyświetla się żaden hotel


### 2. identyfikator testu: 122_jeden_hotel

- warunki wejściowe:
    - uruchom aplikację zgodnie z README
    - pobierz token ATK do obsługi API oraz zaloguj się nim
- kroki testowe
    - kliknij na Linton w Północnej Dakocie
- oczekiwany rezultat:
    - na liście wyświetla się tylko jeden hotel w Linton, który jest jednocześnie najbliższym hotelem

### 3. identyfikator testu: 123_duzo_hoteli

- warunki wejściowe:
    - uruchom aplikację zgodnie z README
    - pobierz token ATK do obsługi API oraz zaloguj się nim
- kroki testowe
    - kliknij na centrum Krakowa
- oczekiwany rezultat:
    - na liście wyświetla się wiele hoteli. Lista posortowana jest rosnąco wg odległości, zatem pierwszy element listy stanowi najbliższy hotel

# Zadanie 1, część 4

Wykorzystując technikę _przypadków testowych_ zaprojektuj 3 testy pokrywające najistotniejsze (w ocenie Waszego zespołu) wymagania opisane w `project_requirements.md`

## Rozwiązanie

User Story:

```
- Jako użytkownik aplikacji chcę móc filtrować wyniki wyszukiwania za pomocą przycisków radiowych dla kategorii: hotel, air, rail, car.
```

### 1. identyfikator testu: 141_uzytkownik_niezalogowany

- warunki wejściowe:
    - uruchom aplikację zgodnie z README
- kroki testowe
    - pomiń logowanie do aplikacji za pomocą klucza
    - wybierz jedną z opcji: `hotel, air, rail, car`
    - kliknij na centrum Krakowa
- oczekiwany rezultat:
    - na mapie ani na liście nie wyświetlają się wybrane usługi. Na interfejsie wyświetla się wiadomość `"Failed to fetch locations. You may not be logged in."`

### 2. identyfikator testu: 142_brak_opcji_filtrowania

- warunki wejściowe:
    - uruchom aplikację zgodnie z README
- kroki testowe
    - zaloguj się do aplikacji za pomocą klucza
    - odznacz wszystkie opcje filtrowania
    - kliknij na centrum Krakowa
- oczekiwany rezultat:
    - na mapie ani na liście nie wyświetlają się żadne usługi

### 3. identyfikator testu: 143_wybrano_filtrowanie

- warunki wejściowe:
    - uruchom aplikację zgodnie z README
- kroki testowe
    - zaloguj się do aplikacji za pomocą klucza
    - wybierz jedną z opcji: `hotel, air, rail, car`
    - kliknij na centrum Krakowa
- oczekiwany rezultat:
    - na mapie i na liście nie wyświetlają się najbliższe usługi w wybranej kategorii

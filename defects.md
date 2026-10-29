1. POST /booking zwraca

```
Booking created successfully with ID: 56b7a20d-5854-475b-a12a-322f73b1e63f
```

a w OpenAPI jest że ma być to JSON i przykład:

```
{
  "id": "bckg68b42-f06a-4d22-aa8a-2f0c23fe69b4"
}
```

no i tak samo pewnie wszystkie błędy nie zwracają JSONów:

```
409 CONFLICT "A booking already exists for this email within the specified date range.
```
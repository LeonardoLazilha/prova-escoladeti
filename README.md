# Backend | Escola de TI 2024

Leonardo Lazilha RA 22003838-2

## Rotas 🚏

### Post
```http://localhost:8080/computador```

```
{
    "nome": "MacBook Pro",
    "cor": "Cinza Espacial",
    "dataFabricacao": 2023,
    "perifericos": [
        {
            "nome": "Magic Mouse"
        }
    ]
}
```

### Get
```http://localhost:8080/computador```

### Put
```http://localhost:8080/computador/{id}```

```
{
  "nome": "MacBook Pro M2",
  "cor": "Silver",
  "perifericos": [
    {
      "nome": "Magic Mouse 2"
    }
  ]
}

```

### Delete
```http://localhost:8080/computador/{id}```



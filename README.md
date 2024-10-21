# Read Me

The original idea is from  
https://medium.com/@truongbui95/practical-guide-to-getting-started-with-spring-boot-and-netflix-dgs-cd16c51ec5a0

Go to
http://localhost:8080/graphiql

```
query {
  shops {
    id,
    name,
    email,
    phone,
    state,
    city,
    street,
    items {
      id
    }
  }
}
```
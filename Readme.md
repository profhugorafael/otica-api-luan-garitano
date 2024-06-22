## http 

http://www.google.com/search

http -> protocolo

"/search" -> recurso

http methods = GET, POST, PUT, DELETE, PATCH

## requisicao = verbo + rota

GET + /products

POST + /products

resposta -> headers + body + statusCode

- [privacidade] [keywords] [variavel/metodo]

## Composicao
```java
class Personagem {
    private int vida;
    private int ataque;
    private int defesa;
}

class Arqueiro extends Personagem {
    private String nome;
    private Arco arco;
}

class Arco {
    private int numeroDeFlechas;
}
```

## Ordem recomendada

- Model: Product
- Repository (acesso ao DB): ProductRepository
- Service(regras e logicas): ProductService
- Controller(fornece as funcionalidas): ProductController

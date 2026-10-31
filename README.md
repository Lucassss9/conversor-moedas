# 💱 Conversor de Moedas API

API REST desenvolvida em **Java 21** com **Spring Boot** para conversão de moedas em tempo real, integrando a **AwesomeAPI** e aplicando **Padrões de Projeto (Design Patterns)** com persistência em banco de dados.

Projeto desenvolvido para o Desafio de Projeto da [DIO (Digital Innovation One)](https://dio.me): **Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Cloud OpenFeign** (cliente HTTP declarativo para consumo de API externa)
- **Spring Data JPA** (persistência e mapeamento de entidades)
- **H2 Database** (banco de dados em memória)
- **Lombok** (eliminação de código boilerplate)
- **AwesomeAPI** (API pública com cotações de moedas em tempo real)

---

## 🏛️ Padrões de Projeto (Design Patterns) Implementados

1. **Singleton:**
   - O `ConversorService` e o `CotacaoClient` são gerenciados pelo Spring com `@Service` e `@FeignClient`, garantindo uma única instância em memória compartilhada por toda a aplicação.
2. **Facade (Fachada):**
   - O método `realizarConversor()` no `ConversorService` atua como uma fachada que abstrai toda a complexidade do sistema: consulta à API externa, cálculo com `BigDecimal` e persistência no banco de dados. O `ConversorController` interage apenas com essa interface simples.

---

## 🔄 Fluxo de Funcionamento

```text
[Cliente / Postman]
       │
       ▼  POST /conversor?moeda=USD&valor=100
[ConversorController]
       │
       ▼  realizarConversor("USD", 100)
[ConversorService (Facade)]
       ├── 1. Chama CotacaoClient (OpenFeign) ──► AwesomeAPI (busca cotação ao vivo)
       ├── 2. Calcula a conversão com precisão (BigDecimal e RoundingMode.HALF_UP)
       └── 3. Salva a Transacao no banco H2 (TransacaoRepository)
       │
       ▼  Retorna JSON com comprovante e ID gerado
[Cliente recebe o resultado]
```

---

## 📖 Como Usar a API

### **Realizar Conversão**
- **Método:** `POST`
- **URL:** `http://localhost:8080/conversor`
- **Parâmetros (Query Params):**
  - `moeda`: Código da moeda desejada (`USD`, `EUR`, `BTC`).
  - `valor`: Valor em Reais (BRL) a ser convertido.

#### **Exemplo de Chamada:**
```http
POST http://localhost:8080/conversor?moeda=USD&valor=100
```

#### **Exemplo de Retorno (Status 200 OK):**
```json
{
  "id": 1,
  "moeda": "USD",
  "valorOriginal": 100,
  "valorConvertido": 18.38,
  "data": "2026-10-30"
}
```

---

## 🛠️ Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/conversor-moedas.git
   ```
2. Entre na pasta:
   ```bash
   cd conversor-moedas
   ```
3. Execute o projeto via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   *(ou rode a classe `ConversorMoedasApplication` pela sua IDE).*

---

## 👤 Autor

Desenvolvido por **Lucas** durante a formação Java na **DIO**.

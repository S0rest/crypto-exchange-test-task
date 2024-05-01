# Crypto-exchange-test-task
## Requirements  
- **Java 20**
- **Gradle 8.7**
- **Spring Boot 3.2.2**

## Description  
The project integrates with the binance API, fills the database with currency pairs and updates the data after a specific time interval. For more detailed testing, you can open swagger (http://localhost:8080/docs  or http://localhost:8080/swagger-ui/index.html#/)

### Endpoints:  
Base URL: http://localhost:8080/api/v1/
```
GET /price/markPrice
``` 
### Query Parameters: 
- offset
- pageSize

Example: http://localhost:8080/api/v1/price/markPrice?offset=0&pageSize=10

### Dependencies:
- **spring-boot-web** 
- **spring-boot-data**
- **lombok**
- **open-api**
- **validation-api** 
- **flyway**
- **postgresql** 
- **retrofit**  

## Contacts & Links:  
GitHub: https://github.com/S0rest  
Email: orest77798@gmail.com  
Telegram: @S0rest  
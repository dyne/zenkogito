# ZenKogito

## Running

- Compile and Run

Start a restroom container in the docker-compose directory using
```
docker compose up
```
Then you can build the application
```
mvn clean compile spring-boot:run    
```

## PoC

Open the [swagger](http://localhost:8080/swagger-ui/index.html) and you can find two examples using the POST request:

- pubgen which doesn't require any data
- verify that takes as input `{\r\n\t\"myStringArray\": [\r\n\t\t\"Hello World! This is my string array, element [0]\",\r\n\t\t\"Hello World! This is my string array, element [1]\",\r\n\t\t\"Hello World! This is my string array, element [2]\"\r\n\t],\r\n\t\"myStringArray.eddsa-signature\": \"4P3ZB2rAoeMah7WXwenTuJgzENJxF9HGis1UU8392ydz6PYJjjJ3ZM8BtiGd69zr3NEAacaqwzpasGkkUEJoQYDP\"\r\n}`

# reactive-spring-boot-client-server


## Requirements

1. Java - 11.*
2. Maven - 3.x.x
3. MongoDB - 3.x.x

## Local run

```bash
mvn spring-boot:run
```

The server will start at <http://localhost:8081>.

## Exploring the Rest API

The application consumes REST APIs from reactive-spring-boot-server

```
1. GET /tweets - Get All Tweets

2. POST /tweets - Create a new Tweet

```

# Docker integration

## Dockerfile

### Building the Docker image (reactive-spring-boot-client)
- `docker build -t reactive-spring-boot-client .` 

### Running the docker image in the background, in detached mode
- `docker run -p 8081:8081 reactive-spring-boot-client`

## Docker Compose(/docker)

- `docker-compose up`

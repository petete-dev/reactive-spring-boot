# reactive-spring-boot


## Requirements
1. Java - 11.*
2. Maven - 3.x.x
3. MongoDB - 3.x.x

## Local run

```bash
mvn spring-boot:run
```

The server will start at <http://localhost:8080>.

## Exploring the Rest API

The application defines following REST APIs

```
1. GET /tweets - Get All Tweets

2. POST /tweets - Create a new Tweet

3. GET /tweets/{id} - Retrieve a Tweet by Id

4. PUT /tweets/{id} - Update a Tweet

5. DELETE /tweets/{id} - Delete a Tweet

6. GET /stream/tweets - Stream tweets to the browser
```

# Docker integration

## Dockerfile

### Building the Docker image
- `docker build -t reactive-spring-boot-server .` 

### Running the docker image in the background, in detached mode
- `docker run -p 8080:8080 reactive-spring-boot-server`

## Docker Compose(/docker)

- `docker-compose up`

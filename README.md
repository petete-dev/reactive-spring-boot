# Spring Boot Reactive PoC


Proof of concept of a server exposing Reactive REST services and a client consuming them.

# Docker integration

## Dockerfile

### Run MONGO using Docker for Windows
- `docker volume create --name=mongodata` 
- `docker run -d -p 27017:27017 -v mongodata:/data/db mongo`

## Docker Compose(/docker)

- `docker-compose up`
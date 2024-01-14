# Inventory Tool - Backend

## Description

## Instillation

### Create Database Docker Container

```shell
docker run --name pgdb -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5432:5432 -d postgres:16.1-alpine3.19
```

```shell
docker run --name modb -p 27017:27017 -d mongo:latest
```
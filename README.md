# redis-geocoding

An app to demonstrate Spring Data JPA integration with Redis. It uploads 50 locations to Redis and exposes and endpoint to query the data

## Run Redis instance

```console
docker run -d -p 6379:6379 --name redis redis
```

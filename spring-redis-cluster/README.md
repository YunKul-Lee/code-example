## Run Redis
```bash
docker-compose up -d redis1 redis2 redis3 redis4 redis5 redis6
```

## Create Redis Cluster on Docker
```bash
docker exec -it redis1 bash

redis-cli --cluster create redis1:6379 redis2:6379 redis3:6379 redis45:6379 redis5:6379 redis6:6379 --cluster-replicas 1
```
# Redis Object Model(Redis OM) with Spring Boot

## Annotations

### @Indexed
인덱스 스키마에서 각 @Indexed 어노테이션 속성마다 검색 필드를 추가한다.

### @Searchable
이 어노테이션은 전체 텍스트 검색기능을 제공한다.

<hr/>

## Docker Compose


```dockerfile
version: '3'

services:
  redis:
    image: redis/redis-stack
    container_name: redis
    ports:
      - 6379:6379

  redis-insight:
    image: redislabs/redisinsight
    container_name: redis-insight
    ports:
      - 8001:8001

```

### 실행 
```bash
docker-compose up -d
```

<hr/>
## Spring Boot Application

### Dependencies
* Spring Boot : 3.1.5
* JDK : 17

```groovy
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'com.redis.om:redis-om-spring:0.8.7'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
}
```
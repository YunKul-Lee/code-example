FROM gradle:8.5.0 AS builder

# 빌드 디렉토리 정의
WORKDIR /build

# docker 캐시 사용
COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /build
RUN gradle clean build --parallel

# base image
FROM amazoncorretto:17
WORKDIR /app

# JAR file path
ARG JAR_FILE=/build/build/libs/*.jar

# Copy JAR file from the build context into Docker image
COPY --from=builder ${JAR_FILE} /application.jar

CMD apt-get update -y

USER nobody
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]
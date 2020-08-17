FROM openjdk:12-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/eurekaservice
ARG JAR_FILE
ADD ${JAR_FILE} /usr/local/eurekaservice/
ADD dockerfile/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
FROM openjdk:12-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/settingsservice
ARG JAR_FILE
ADD ${JAR_FILE} /usr/local/settingsservice/
ADD dockerfile/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
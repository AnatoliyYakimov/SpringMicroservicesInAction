#!/bin/sh
getPort() {
    echo $1 | cut -d : -f 3 | xargs basename
}

echo "********************************************************"
echo "Starting Eureka Server "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom \
     -Dspring.profiles.active=$PROFILE -jar /usr/local/eurekaservice/@project.build.finalName@.jar
FROM adoptopenjdk/openjdk11
MAINTAINER zy
ARG JAVA_OPTS="-Xmx256M"
ENV JAVA_OPTS=$JAVA_OPTS
ARG RUN_ARGS="--spring.profiles.active=dev"
ENV RUN_ARGS=$RUN_ARGS
COPY target/*.jar /dota-auth.jar
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /dota-auth.jar $RUN_ARGS"]
#ENTRYPOINT ["/bin/sh","-c",doc,"$RUN_ARGS"]
#ENTRYPOINT exec java -Dspring.cloud.nacos.discovery.server-addr=192.168.123.13:8848 $JAVA_OPTS -jar /dota-auth.jar
#ENTRYPOINT exec java  $JAVA_OPTS -jar /dota-auth.jar --spring.cloud.nacos.discovery.server-addr=192.168.123.13:8848

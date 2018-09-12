FROM java:8-jre

ENV JAR_PATH="/app/unicomer-poc-gzip.jar"
ADD ./target/*.jar $JAR_PATH

ENV JAVA_OPTS="-Xmx200m"

ARG DEBUG_PORT
ENV DEBUG_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"

ENTRYPOINT java $JAVA_OPTS $DEBUG_OPTS -jar $JAR_PATH

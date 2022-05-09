FROM krebs9691/ubu18_jdk11:temp

LABEL Axel Krebs

EXPOSE 1099 5701 9990 8080 44444

ARG ZIP_FILE_NAME

COPY ${ZIP_FILE_NAME} .

ADD install.sh .
RUN chmod -x=5 install.sh

RUN ./install.sh ${ZIP_FILE_NAME}

# Since this is a post-Java 9 JDK, Hazelcast needs some access rights..
ENV JAVA_OPTS="--add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED"

#USER 'karaf'
#CMD [ "/bin/bash", "-c", "start" ]

CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

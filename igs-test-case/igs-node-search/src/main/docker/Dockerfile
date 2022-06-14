FROM axel9691/openjdk:17

LABEL Axel Krebs

ARG ZIP_FILE_NAME
ARG USER_NAME
ARG PASS_WORD

COPY ${ZIP_FILE_NAME} .

ADD install.sh .
RUN chmod -x=5 install.sh
RUN sed -i -e 's/\r$//' install.sh
RUN ./install.sh  ${ZIP_FILE_NAME} ${USER_NAME} ${PASS_WORD}

# Since this is a post-Java 9 JDK, Hazelcast needs some access rights..
ENV JAVA_OPTS="--add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED"

USER ${USER_NAME}

#ENTRYPOINT ["/bin/bash","karaf server"]
CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

EXPOSE 1099 5701 9990 8080 8081 44444
FROM axel9691/openjdk:17

LABEL Axel Krebs

EXPOSE 8080 8081

ADD install.sh .
RUN chmod -x=5 install.sh
RUN sed -i -e 's/\r$//' install.sh
RUN ./install.sh

CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

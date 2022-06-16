FROM axel9691/neo4j:4.4.6

LABEL Axel Krebs

EXPOSE 1099 7474

ADD install.sh .
RUN chmod -x=5 install.sh
RUN sed -i -e 's/\r$//' install.sh
RUN ./install.sh

CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

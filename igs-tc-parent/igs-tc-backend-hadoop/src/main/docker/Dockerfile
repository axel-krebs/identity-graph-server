FROM axel9691/openjdk:1.8.0_312

LABEL Axel Krebs

ARG TAR_FILE
ARG USER_NAME
ARG PASS_WORD

ADD core-site.xml .
ADD hdfs-site.xml . 
ADD mapred-site.xml . 
ADD yarn-site.xml . 
ADD install.sh .
COPY ${TAR_FILE} .

RUN chmod -x=5 install.sh 
RUN sed -i -e 's/\r$//' install.sh
RUN ./install.sh ${TAR_FILE} ${USER_NAME} ${PASS_WORD}

USER ${USER_NAME}

#ENTRYPOINT ["/bin/bash","-c","source /home/$USER_NAME/.bashrc & $HADOOP_HOME/sbin/start-dfs.sh"]
CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

EXPOSE 1099 9000

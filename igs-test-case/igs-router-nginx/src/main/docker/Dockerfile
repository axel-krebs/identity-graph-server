FROM axel9691/nginx:1.20.2

LABEL My NGINX

ADD nginx.conf /etc/nginx/nginx.conf
ADD proxy.conf /etc/nginx/proxy.conf
ADD mime.types /etc/nginx/mime.types

# App will be served statically
ADD ./app/ /usr/share/nginx/html/

ENTRYPOINT [ "/bin/bash", "-c", "nginx & tail -f /var/log/nginx/error.log" ]
#CMD [ "/bin/bash", "-c", "tail -f /dev/null" ]

EXPOSE 8080 8081
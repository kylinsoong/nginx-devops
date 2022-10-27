#FROM nginx:1.21.3-alpine
FROM nginx:1.21.3

WORKDIR /app/html

ADD html/index.html /app/html
ADD html/two.html   /app/html
ADD html/man.html   /app/html

COPY conf/basic.conf /etc/nginx/conf.d/ 

# Variables
COPY conf/variables.conf /etc/nginx/conf.d/

# proxy_redirect
COPY conf/proxyRedirect.conf /etc/nginx/conf.d/

# regexp
COPY conf/basic.conf /etc/nginx/conf.d/

# security
COPY conf/sec.conf  /etc/nginx/conf.d/
COPY files/.htpasswd /etc/nginx

# WebSocket
COPY conf/ws.conf /etc/nginx/conf.d/

EXPOSE 8001-8020

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]

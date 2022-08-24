#FROM nginx:1.21.3-alpine
FROM nginx:1.21.3

WORKDIR /app/html

ADD html/admin.html /app/html
ADD html/index.html /app/html
ADD html/two.html   /app/html
ADD html/man.html   /app/html

COPY conf/backend.conf /etc/nginx/conf.d/ 
COPY conf/basic.conf /etc/nginx/conf.d/ 

COPY files/.httpwd /etc/nginx

# HTTP Basic Authentication
COPY conf/secBaseAuth.conf /etc/nginx/conf.d/
COPY files/.htpasswd /etc/nginx
 
# request_time vs upstream_response_time
COPY conf/times.conf /etc/nginx/conf.d/

EXPOSE 8008-8010

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]

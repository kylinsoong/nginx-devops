FROM nginx:1.21.3-alpine

WORKDIR /app/html

ADD html/admin.html /app/html
ADD html/index.html /app/html
ADD html/two.html   /app/html
ADD html/man.html   /app/html

COPY conf/backend.conf /etc/nginx/conf.d/ 
COPY conf/basic.conf /etc/nginx/conf.d/ 

COPY files/.httpwd /etc/nginx 

EXPOSE 8008

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]

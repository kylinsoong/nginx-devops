FROM nginx:1.21.3-alpine

COPY basic.conf /etc/nginx/conf.d/ 

EXPOSE 8008

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]

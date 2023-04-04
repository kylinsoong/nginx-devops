FROM cloudadc/nginx-alpine:0.2

WORKDIR /app/os/images

ADD tmp/1.png /app/os/images
ADD tmp/2.png /app/os/images
ADD tmp/3.png /app/os/images
ADD tmp/4.png /app/os/images
ADD tmp/5.png /app/os/images

WORKDIR /app/os/vedio
ADD tmp/1.mp4 /app/os/vedio
ADD tmp/2.mp4 /app/os/vedio
ADD tmp/3.mp4 /app/os/vedio

WORKDIR /app/os/docs
ADD tmp/1.docx /app/os/docs
ADD tmp/2.docx /app/os/docs
ADD tmp/3.docx /app/os/docs
ADD tmp/1.pptx /app/os/docs
ADD tmp/2.pptx /app/os/docs
ADD tmp/3.pptx /app/os/docs
ADD tmp/1.pdf /app/os/docs
ADD tmp/2.pdf /app/os/docs
ADD tmp/3.pdf /app/os/docs

WORKDIR /app/os/html
ADD tmp/1.html /app/os/html
ADD tmp/2.html /app/os/html
ADD tmp/3.html /app/os/html
ADD tmp/4.html /app/os/html
ADD tmp/5.html /app/os/html
ADD tmp/6.html /app/os/html
ADD tmp/7.html /app/os/html
ADD tmp/8.html /app/os/html
ADD tmp/9.html /app/os/html
ADD tmp/10.html /app/os/html


COPY api-gateway/cache/backend.conf /etc/nginx/conf.d/


EXPOSE 8090

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]

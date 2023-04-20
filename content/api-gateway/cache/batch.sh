#! /bin/bash

IP=$1
PORT=$2

if [[ -z "$IP" ]] || [[ -z "$PORT" ]] 
then
  echo "Auguments: [NGINX IP] [NGINX PORT] "
  exit
fi

for j in {1..10}
do
   echo "$j times to execute"
   for i in {1..10} ; do curl -s http://$IP:$PORT/images/$i.png -o /dev/null ; done
   for i in {1..3} ; do curl -s http://$IP:$PORT/docs/$i.docx -o /dev/null ; done
   for i in {1..3} ; do curl -s http://$IP:$PORT/docs/$i.pptx -o /dev/null ; done
   for i in {1..3} ; do curl -s http://$IP:$PORT/docs/$i.pdf -o /dev/null ; done
   for i in {1..4} ; do curl -s http://$IP:$PORT/vedio/$i.mp4 -o /dev/null ; done
   for i in {1..10} ; do curl -s http://$IP:$PORT/html/$i.html -o /dev/null ; done
   curl -s --cookie "nocache=1" http://$IP:$PORT/html/10.html -o /dev/null
   curl -s --cookie "nocache=any" http://$IP:$PORT/html/10.html -o /dev/null
   curl -s http://$IP:$PORT/html/10.html?nocache=1 -o /dev/null
   curl -s http://$IP:$PORT/html/10.html?nocache=any -o /dev/null
   curl -s -H "cachepurge: 1" http://$IP:$PORT/html/10.html -o /dev/null
   curl -s -H "cachepurge: any" http://$IP:$PORT/html/10.html -o /dev/null
   curl -s --cookie "notcache=1" http://$IP:$PORT/html/1.html -o /dev/null
   curl -s --cookie "notcache=any" http://$IP:$PORT/html/1.html -o /dev/null
   curl -s http://$IP:$PORT/html/1.html?notcache=1 -o /dev/null
   curl -s http://$IP:$PORT/html/1.html?notcache=any -o /dev/null
   curl -s -H "authorization: YWRtaW46YWRtaW4K" http://$IP:$PORT/html/1.html -o /dev/null
done

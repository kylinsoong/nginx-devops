== Nginx DevOps Demo

== Build

[source, bash]
.*Build*
----
docker build -t nginx-demo .
----

[source, bash]
.*Tag*
----
docker tag nginx-demo:latest cloudadc/nginx-demo:1.0.1
----

== Run

[source, bash]
.*Start*
----
docker run -itd --rm --name test -p 8008:8008 cloudadc/nginx-demo:1.0.1
----

[source, bash]
.*Test*
----
curl 127.0.0.1:8008/help
----


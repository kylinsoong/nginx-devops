== Nginx DevOps Demo

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


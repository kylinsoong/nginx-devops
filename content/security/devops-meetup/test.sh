#! /bin/bash 

set -e
set -x

# Normal Request for Foo
curl -H "X-Forwarded-For: 165.194.100.101" -H "Host: foo.apps.example.com"  "http://192.168.75.200:30080/foo"
curl -H "X-Forwarded-For: 12.104.10.91" -H "Host: foo.apps.example.com"  "http://192.168.75.200:30080/foo/test"

# Attack Request for Foo
curl -H "X-Forwarded-For: 99.104.10.91" -H "Host: foo.apps.example.com"  "http://192.168.75.200:30080/foo/test.db"
curl -H "X-Forwarded-For: 23.55.47.50" -H "Host: foo.apps.example.com"  "http://192.168.75.200:30080/foo/devops/login?<script>"

# Normal Request for Bar
curl -H "Host: bar.apps.example.com"  "http://192.168.75.200:30080/bar"
curl -H "Host: bar.apps.example.com"  "http://192.168.75.200:30080/bar/test"

# Attack Request for Bar: XFF SQL Injection
curl -H "X-Forwarded-For: select * from t where 1 =1 " -H "Host: bar.apps.example.com"  "http://192.168.75.200:30080/bar"

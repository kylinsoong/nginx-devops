#!/bin/bash

curl http://10.1.10.201:8011/
curl http://10.1.10.201:8011/version ; echo

curl -s -G http://10.1.10.201:8011/foo --data-urlencode "foo=您好" ; echo
curl -s -G http://10.1.10.201:8011/dec_foo -d "foo=%E6%82%A8%E5%A5%BD" ; echo

curl -G http://10.1.10.201:8011/jwt -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImV4cCI6MTU4NDcyMzA4NX0.eyJpc3MiOiJuZ2lueCIsInN1YiI6ImFsaWNlIiwiZm9vIjoxMjMsImJhciI6InFxIiwienl4IjpmYWxzZX0.Kftl23Rvv9dIso1RuZ8uHaJ83BkKmMtTwch09rJtwgk" ; echo
curl -G http://10.1.10.201:8011/jwt -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImtpZCI6IjAwMDEifQ.eyJuYW1lIjoiQ2xvdWRhZGMgU3lzdGVtIiwic3ViIjoiY2xvdWRhZGMiLCJpc3MiOiJNeSBBUEkgR2F0ZXdheSJ9.mrxpQNel2N5apjLjjkwHVh7fsnnGYBThGhgRr61o_wE" ; echo

SECRET=changeme
SECRET_KEY=$(echo -n $SECRET | base64 | tr '+/' '-_' | tr -d '=')
API_SECRET_JWK='{"keys":
    [{
        "k":"CHANGEME",
        "kty":"oct",
        "kid":"0001"
    }]
}'
API_SECRET_JWK=$(echo $API_SECRET_JWK | sed "s|CHANGEME|$SECRET_KEY|g")
JWT_HEADER=$(echo -n '{"typ":"JWT","alg":"HS256","kid":"0001"}' | base64 | tr '+/' '-_' | tr -d '=')
JWT_PAYLOAD=$(echo -n '{"name":"Kylin System","sub":"kylin","iss":"Kylin API Gateway"}' | base64 | tr '+/' '-_' | tr -d '=')
HEADER_PAYLOAD=$JWT_HEADER.$JWT_PAYLOAD
JWT_SIGNATURE=$(echo -n $HEADER_PAYLOAD | openssl dgst -binary -sha256 -hmac $SECRET | base64 | tr '+/' '-_' | tr -d '=')
API_KEY=$(echo $HEADER_PAYLOAD.$JWT_SIGNATURE)
curl -G http://10.1.10.201:8011/jwt -H "Authorization: Bearer $API_KEY" ; echo


#!/bin/bash

SECRET=$1
HEADER='{
  "alg": "HS256",
  "typ": "JWT",
  "kid": "0001"
}'
PAYLOAD='{
  "sub": "API Security",
  "name": "API Security Authentication",
  "iss": "ACME Corp",
  "iat": 1676612736,
  "exp": 1781791512,
  "uid": "bbc123456"
}'

if [[ -z "$SECRET" ]]
then
  echo "Auguments: [SECRET]"
  exit
fi 

SECRET_KEY=$(echo -n $SECRET | base64 | tr '+/' '-_' | tr -d '=')
API_SECRET_JWK='{"keys":
    [{
        "k":"CHANGEME",
        "kty":"oct",
        "kid":"0001"
    }]
}'
API_SECRET_JWK=$(echo $API_SECRET_JWK | sed "s|CHANGEME|$SECRET_KEY|g")
echo $API_SECRET_JWK > api.security.jwk
echo "generated api.security.jwk"
#JWT_HEADER=$(echo -n $HEADER | base64 | tr '+/' '-_' | tr -d '=')
#JWT_PAYLOAD=$(echo -n $PAYLOAD | base64 | tr '+/' '-_' | tr -d '=')
#HEADER_PAYLOAD=$JWT_HEADER.$JWT_PAYLOAD
#JWT_SIG=$(echo -n $HEADER_PAYLOAD | openssl dgst -binary -sha256 -hmac $SECRET | base64 | tr '+/' '-_' | tr -d '=')
#JWT=$HEADER_PAYLOAD.$JWT_SIG
#echo $JWT

#!/bin/bash

SECRET=$1

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
echo $API_SECRET_JWK > nginx.jwk
echo "generate nginx.jwk, content:"
echo "$(cat nginx.jwk)"


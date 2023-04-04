#!/bin/bash

mkdir tmp
curl -s -k https://freetestdata.com/wp-content/uploads/2021/09/png-5mb-1.png -o tmp/a.png
for i in {1..5} ; do cp tmp/a.png tmp/$i.png ; done

curl -s -k https://freetestdata.com/wp-content/uploads/2022/02/Free_Test_Data_10MB_MP4.mp4 -o tmp/a.mp4
for i in {1..3} ; do cp tmp/a.mp4 tmp/$i.mp4 ; done

curl -s -k https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_1MB_DOCX-1.docx -o tmp/a.docx
for i in {1..3} ; do cp tmp/a.docx tmp/$i.docx ; done

curl -s -k https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_1MB_PDF.pdf -o tmp/a.pdf
for i in {1..3} ; do cp tmp/a.pdf tmp/$i.pdf ; done

curl -s -k https://freetestdata.com/wp-content/uploads/2021/09/Free_Test_Data_1MB_PPTX.pptx -o tmp/a.pptx
for i in {1..3} ; do cp tmp/a.pptx tmp/$i.pptx ; done

curl -s -k https://freetestdata.com/wp-content/uploads/2023/03/Sample_HTML_for_testing.html -o tmp/a.html
for i in {1..10} ; do cp tmp/a.html tmp/$i.html ; done

docker build -t cloudadc/osdata:1.0.0 -f Dockerfile.os .
docker push cloudadc/osdata:1.0.0

rm -fr tmp/

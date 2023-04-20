#!/bin/bash

curl http://localhost:8008/regexpNone
curl http://localhost:8008/regexpNonehello
curl http://localhost:8008/regexpNone/hello

curl http://localhost:8008/regexpNone/web
curl http://localhost:8008/regexpNone/webhello
curl http://localhost:8008/regexpNone/web/hello

curl http://localhost:8008/regexpRxp
curl http://localhost:8008/regexpRxphello
curl http://localhost:8008/regexpRxp/hello

curl http://localhost:8008/regexpRxp/web
curl http://localhost:8008/regexpRxp/webhello
curl http://localhost:8008/regexpRxp/web/hello

curl http://localhost:8008/regexpEq

curl http://localhost:8008/regexpInsensitive
curl http://localhost:8008/reGExpInsenSItiVe
curl http://localhost:8008/reGExpInsenSItiVe/hEllo

curl http://localhost:8008/regexpLocationBlock

curl http://localhost:8008/helloworld.gif
curl http://localhost:8008/hello/world.gif
curl http://localhost:8008/hello/world/test.gif
curl http://localhost:8008/hello/wold/test.jpg
curl http://localhost:8008/hello/wold/test.jpeg
curl http://localhost:8008/hello/wold/test.png
curl http://localhost:8008/hello/wold/test.css
curl http://localhost:8008/hello/wold/test.js
curl http://localhost:8008/hello/wold/test.ico

curl http://localhost:8008/site/012345678abcefghigklmnopqrstuvwx/index.php
curl http://localhost:8008/site/abcefghigklmnopqrstuvwx012345678/index.php
curl http://localhost:8008/site/test01/index.php
curl http://localhost:8008/site/01test/index.php
curl http://localhost:8008/site/x/index.php

curl http://localhost:8008/docs/123/index.html
curl http://localhost:8008/docs/abc/index.html
curl http://localhost:8008/docs/ax8/index.html
curl http://localhost:8008/docs/ax8/index.html?name=yes

curl http://localhost:8008/edu/aa/index.html
curl http://localhost:8008/edu/aaa/index.html
curl http://localhost:8008/edu/aaaa/index.html
curl http://localhost:8008/edu/a8/index.html
curl http://localhost:8008/edu/ax8/index.html
curl http://localhost:8008/edu/ax08/index.html
curl http://localhost:8008/edu/ax08/index.html?name=yes

curl http://localhost:8008/foo/
curl http://localhost:8008/foo/a
curl http://localhost:8008/foo/1
curl http://localhost:8008/foo/abcf
curl http://localhost:8008/foo/abcf/test

curl http://localhost:8008/bar/a
curl http://localhost:8008/bar/1
curl http://localhost:8008/bar/abcf
curl http://localhost:8008/bar/abcf/test

curl http://localhost:8008/zoo
curl http://localhost:8008/zoo/

curl http://localhost:8008/moo/


# api-result

## test

### demo

http://localhost:8080/api/demo

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 18 Jun 2022 09:29:55 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
"code": "SUCCESS",
"msg": "Success",
"success": true,
"header": null,
"body": null
}

### err msg

http://localhost:8080/api/err-msg

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 18 Jun 2022 09:31:35 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
"code": "ERROR",
"msg": "test error!",
"success": false,
"header": null,
"body": null
}

### page

http://localhost:8080/api/page-response

HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 18 Jun 2022 09:32:42 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
"code": "SUCCESS",
"msg": "Success",
"success": true,
"header": null,
"body": {
"content": [
"u1",
"u2",
"u3"
],
"current": 1,
"pageSize": 10,
"totalRow": 3,
"totalPages": 1
}
}
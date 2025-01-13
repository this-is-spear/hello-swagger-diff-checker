


```plaintext
oasdiff diff  ./swagger-sample/swagger-develop.json ./swagger-sample/swagger-test.json 

~/Documents/GitHub/hello-swagger-diff-checker git:[main]
oasdiff diff ./swagger-sample/swagger-develop.yaml ./swagger-sample/swagger-test.yaml
paths:
    modified:
        /hello:
            operations:
                modified:
                    GET:
                        responses:
                            modified:
                                "200":
                                    content:
                                        mediaTypeModified:
                                            '*/*':
                                                schema:
                                                    type:
                                                        added:
                                                            - string
                                                        deleted:
                                                            - integer
                                                    format:
                                                        from: int32
                                                        to: ""
endpoints:
    modified:
        ?   method: GET
            path: /hello
        :   responses:
                modified:
                    "200":
                        content:
                            mediaTypeModified:
                                '*/*':
                                    schema:
                                        type:
                                            added:
                                                - string
                                            deleted:
                                                - integer
                                        format:
                                            from: int32
                                            to: ""
```

```plaintext

oasdiff breaking ./swagger-sample/swagger-develop.yaml ./swagger-sample/swagger-test.yaml
1 changes: 1 error, 0 warning, 0 info
error   [response-body-type-changed] at ./swagger-sample/swagger-test.yaml      
        in API GET /hello
                the response's body type/format changed from 'integer'/'int32' to 'string'/'' for status '200'

```


### 필요한 라이브러리 설치

참고 자료 : https://github.com/springdoc/springdoc-openapi-gradle-plugin

```shell
brew install oasdiff
```

### Diff

변경 부분 확인이 가능하다.

```shell
oasdiff diff ./swagger-sample/swagger-develop.yaml ./swagger-sample/swagger-test.yaml
```

응답 값

```plaintext
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


### Breaking Changes

```shell
oasdiff breaking ./swagger-sample/swagger-develop.yaml ./swagger-sample/swagger-test.yaml
```

```plaintext
1 changes: 1 error, 0 warning, 0 info
error   [response-body-type-changed] at ./swagger-sample/swagger-test.yaml      
        in API GET /hello
                the response's body type/format changed from 'integer'/'int32' to 'string'/'' for status '200'
```
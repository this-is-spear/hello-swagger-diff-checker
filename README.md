

### 필요한 라이브러리 설치

참고 자료 : https://github.com/springdoc/springdoc-openapi-gradle-plugin

```shell
brew install oasdiff
```


### Git Actions 기능

참고 자료 : https://github.com/oasdiff/oasdiff-action/blob/main/.github/workflows/test.yaml

```yaml
name: 'Test oasdiff actions'
on:
  pull_request:
  push:
jobs:
  oasdiff_diff:
    runs-on: ubuntu-latest
    name: Test diff action
    steps:
      - name: checkout
        uses: actions/checkout@v4
      - name: Running OpenAPI Spec breaking action
        uses: oasdiff/oasdiff-action/breaking@main
        with:
          base: 'swagger-sample/swagger-develop.yaml'
          revision: 'swagger-sample/swagger-test.yaml'
```

<img width="1504" alt="스크린샷 2025-01-13 오후 11 18 51" src="https://github.com/user-attachments/assets/e8a7fc45-cee7-438c-a098-cc1ab6eb05f4" />


### CLI 기능

#### Diff

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

#### Breaking Changes

```shell
oasdiff breaking ./swagger-sample/swagger-develop.yaml ./swagger-sample/swagger-test.yaml
```

```plaintext
1 changes: 1 error, 0 warning, 0 info
error   [response-body-type-changed] at ./swagger-sample/swagger-test.yaml      
        in API GET /hello
                the response's body type/format changed from 'integer'/'int32' to 'string'/'' for status '200'
```

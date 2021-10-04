## Reproduction

- Create clean Micronaut project with `mn create-app --build=maven mn-graal-jsoncreator-sample` (commit #080237e)
- Add `@JsonValue` / `@JsonCreator` annotations inside an enum that's used as part of a JSON Request Body (commit #44712db)
- _(The default jar build works as expected)_
- Build with GraalVM: `mvn clean package -Dpackaging=native-image`
- Run the app `target/mn-graal-jsoncreator-sample`
- Call the endpoint:
    ```
    POST http://127.0.0.1:8080/
    Content-Type: application/json
    
    {
      "type": "one"
    }
    ```

- Error response:
    ```
    HTTP/1.1 400 Bad Request
    Content-Type: application/json
    date: Mon, 4 Oct 2021 13:41:56 GMT
    content-length: 341
    connection: keep-alive
    
    {
      "message": "Bad Request",
      "logref": null,
      "path": null,
      "_links": {
        "self": {
          "href": "/",
          "templated": false,
          "type": null,
          "deprecation": null,
          "profile": null,
          "name": null,
          "title": null,
          "hreflang": null
        }
      },
      "_embedded": {
        "errors": [
          {
            "message": "Required argument [SampleDto sampleDto] not specified",
            "logref": null,
            "path": "/sampleDto",
            "_links": {},
            "_embedded": {}
          }
        ]
      }
    }
    ```

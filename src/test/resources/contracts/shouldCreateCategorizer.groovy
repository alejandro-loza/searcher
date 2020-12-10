package mx.finerio.searcher

org.springframework.cloud.contract.spec.Contract.make {
    description("""
Represents a fetch to resource
```
when:
    wants to fetch an category
then:
    service'd fetch an user
```
""")

    request {
        method 'GET'
        urlPath('/api/v1/categorize') {

            queryParameters {
                parameter 'userId': 1
                parameter 'description': equalTo("rap")

            }
        }
    }
    response {
        status OK()
        body([[
                "id":1,
                "userId":1587567125458,
                "description":"RAPPI",
                "categoryId":1587567125458,
                "dateCreated":"2020-12-09T22:12:52.216+0000",
                "lastUpdated":"2020-12-09T22:12:52.216+0000"
        ]])
        headers {
            contentType('application/json')
        }

    }
}
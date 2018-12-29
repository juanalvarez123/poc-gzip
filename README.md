# poc-gzip

Proof of concept for GZIP compression and decompression in Rest APIs.

**unicomer user service** is an API created for testing purposes.

## Facts

1) From unicomer user service to poc-gzip API - SYNCHRONOUSLY: Using the EndPointUtil.java class uses a RestEasy implementation. In theory (https://docs.jboss.org/resteasy/docs/3.0.21.Final/userguide/html/gzip.html), ReastEasy is capable to support compression (for sending requests) and decompression (entry responses).
2) From unicomer user service to poc-gzip API - ASYNCHRONOUSLY: Using the Spring's AsyncRestTemplate.java class.
3) From poc-gzip API to unicomer user service - SYNCHRONOUSLY: Using the Spring's RestTemplate.java class.

NOTE: I can't found documentation for requests compression and decompression and just this workaround: https://stackoverflow.com/questions/37415294/how-to-zip-compress-http-request-with-spring-resttemplate. The official documentation for SpringBoot only talks about responses compression: https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/htmlsingle/#how-to-enable-http-response-compression

## Tests

These is what I tested so far:

### Case 1

Unicomer user service calls SYNCHRONOUSLY to poc-gzip API without gzip requests.
What happen: The unicomer user service requests were no compressed, next the poc-gzip API was capable to receive the entry request, process it and returns a gzip response. The unicomer user service was capable to receive and process gzip responses from poc-gzip API.
What I modified: Nothing.
Status: OK.

### Case 2

Unicomer user service calls SYNCHRONOUSLY to poc-gzip API with gzip requests.
What happen: The unicomer user service requests were compressed, next the poc-gzip API was not capable to receive the entry request because it had the compressed format. I tried to create a filter, configure undertow and figure out with another approaches with no success. The main reason is because the gzip uncompression for entry requests is responsability for the container (https://github.com/spring-projects/spring-boot/issues/11827), it must not be a manual process from API side. The unicomer user service was no capable to receive the response from poc-gzip API.
What I modified: The EndPointUtil.java, RestRequest.java and RestRequestBuilder.java were modified. You can set a "Content-Encoding: gzip" header for a RestRequest.java object, but the ClientInvocation.java class LOC 330 is overriding the "Content-Encoding" header.
Status: FAIL.

### Case 3

Unicomer user service calls ASYNCHRONOUSLY to poc-gzip API without gzip requests.
What happen: The unicomer user service requests were no compressed, next the poc-gzip API was capable to receive the entry request, process it and returns a gzip reponse. The unicomer user service was capable to receive and process gzip responses from poc-gzip API.
What I modified: Nothing.
Status: OK.

### Case 4

Unicomer user service calls ASYNCHRONOUSLY to poc-gzip API with gzip requests.
What happen: The unicomer user service requests were compressed (It is supposed to be compressed only using "Content-Encoding: gzip" header ?), next the poc-gzip API was capable to receive the entry request, process it and returns a gzip response. The unicomer user service was capable to receive and process gzip responses from poc-gzip API.
What I modified: Nothing.
Status: OK, but I'm not 100% sure that the unicomer user service requests were compressed.

### Case 5

poc-gzip API calls SYNCHRONOUSLY to unicomer user service with gzip requests.
What happen: I tried to use HttpHeaders.java class to put the "Content-Encoding: gzip" header in the poc-gzip API request, but the HttpHeaders.java doesn't have a method to do that. Then this case was not possible to verify it.
What I modified: Nothing.
Status: FAIL, not possible to verify it.

## Conclusions

* There are no standard way to send requests in gzip format, all information found is related manually process and no much information to do it in the right way.
* If we want gzip enconding for REQUESTS, we need to do it manually.
* Unicomer user service is capable to receive and process gzip responses with both imlpementations (RestEasy and AsyncRestTemplate).

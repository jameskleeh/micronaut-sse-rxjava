# micronaut-sse-rxjava
Micronaut example event flow to SSE

Steps to exercise the example:

1. ./gradlew run
2. Open localhost:8080 in any non IE browser
3. curl -X POST -d '{"name":"John"}' -H "Content-Type: application/json" http://localhost:8080/author/publish
4. View the event was received and output to the page

Explanation:

Static resources is used to render an `index.html` page when accessing the root `/` URL. That page also brings in an `sse.js` file that uses the standard Server Sent Event API in JavaScript to listen for events and display them on the page.

An `AuthorService` is responsible for allowing subscribers to a stream of `Author` objects. The `AuthorController` returns a modified stream that wraps each author into an `Event`. An endpoint on the `AuthorController` allows `Author` objects to be sent via JSON and added onto the stream. Anywhere else in the code the `AuthorService` could be used to publish events. Anywhere else in the code one could subscribe to those events and receive `Author` objects.

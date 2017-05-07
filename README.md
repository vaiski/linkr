# Linkr

URL shortener implemented using [Scala](https://www.scala-lang.org/), [Akka HTTP](http://akka.io/), [Cassandra](http://cassandra.apache.org/), and [Phantom](https://github.com/outworkers/phantom).

This example project should give you an idea how to use Cassandra and Akka HTTP together. It is not intended to be used in production but rather as a learning resource.

## Getting Started

Make sure you have Scala, git, and sbt installed.

Clone the repository and go to the project directory:

```
git clone https://github.com/vaiski/linkr.git
cd linkr
```

Run the service using `sbt`:

```
sbt run
```

The service listens by default port `5000`.

## Usage and Functionality

### Create a Short Link

Create a short link by making a POST request to `/links` with your favourite command line tool (personally, I prefer the awesome [HTTPie](https://httpie.org/), but the examples use cURL for its ubiquity): 

```bash
curl -is -H "Content-Type: application/json" \
         -X POST http://localhost:5000/links \
         -d '{"id": "myblog", "url": "https://vaiski.com"}'
```

The server should respond with the created shortlink resource:

```
HTTP/1.1 200 OK
Content-Length: 77
Content-Type: application/json
Date: Sun, 07 May 2017 20:04:14 GMT
Server: akka-http/10.0.6

{
    "createdAt": "2017-05-07T19:59:44Z",
    "id": "myblog",
    "url": "https://vaiski.com"
}
```

### Access a Link

Navigate with your web browser to http://localhost:5000/myblog or make a `GET` request using command line:

```bash
curl -is http://localhost:5000/myblog
```

The server should respond with a redirection to the target URL:

```
HTTP/1.1 301 Moved Permanently
Content-Length: 0
Content-Type: application/json
Date: Sun, 07 May 2017 20:07:20 GMT
Location: https://vaiski.com
Server: akka-http/10.0.6

```

### Show Link Information

To get the link details, make a `GET` request to the `/links/<link_id>` URL:

```bash
curl -is http://localhost:5000/links/myblog
```

The service should return the details of the shortlink resource:

```
HTTP/1.1 200 OK
Content-Length: 77
Content-Type: application/json
Date: Sun, 07 May 2017 20:04:36 GMT
Server: akka-http/10.0.6

{
    "createdAt": "2017-05-07T19:59:44Z",
    "id": "myblog",
    "url": "https://vaiski.com"
}
```

## Acknowledgments

This project draws from the great examples and conventions presented by [Daniela Sfregola](https://danielasfregola.com/) in her blog post [How to build a REST API with Akka Http](https://danielasfregola.com/2016/02/07/how-to-build-a-rest-api-with-akka-http/) and the related [GitHub repository](https://github.com/DanielaSfregola/quiz-management-service/tree/master/akka-http-crud).

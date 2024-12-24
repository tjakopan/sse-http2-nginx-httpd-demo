Demo of running a backend behind either nginx or httpd with HTTP/2 support and server sent events. nginx does not 
support HTTP/2 when proxy-ing, although it supports HTTP/2 from the client to nginx.

# Certificates

In order to regenerate certificate if it expires, run the following:
```shell
openssl genrsa -out ./certs/server.key 2048
openssl req -new -x509 -key ./certs/server.key -out ./certs/server.crt -days 365 -subj "/CN=localhost"
```

# Running
There are a couple of run profiles in the .run directory which are recognized by IntelliJ IDEA Ultimate:
- demo - runs demo application with /demo (GET) and /demo/sse (server sent events) on localhost:8080
- nginx - starts nginx from docker-compose.yaml
- httpd - starts httpd from docker-compose.yaml
- demo-with-nginx - starts demo and nginx
- demo-with-httpd - starts demo and http
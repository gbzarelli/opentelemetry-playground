# Project One

Studies about OpenTelemetry Architecture with Prometheus using Frameworks;

## Studies Links

- [OpenTelemetry Collector, Deployment Methods & Production Ready | The OpenTelemetry Bootcamp](https://www.youtube.com/watch?v=L_gjG4BjvSE)
- [aspecto-io/opentelemetry-bootcamp](https://github.com/aspecto-io/opentelemetry-bootcamp)
- [About OpenTelemetry in Quarkus](https://quarkus.io/guides/opentelemetry)
    - [brunobat/quarkus-observability-demo](https://github.com/brunobat/quarkus-observability-demo)
    - [Quarkiverse - Micrometer Registry OTLP](https://quarkiverse.github.io/quarkiverse-docs/quarkus-micrometer-registry/dev/micrometer-registry-otlp.html)


## Tecnologies

- Infraestructure
    - OpenTelemetry Collector
    - Prometheus
    - Jaeger Tracing
- Application: [Java Quarkus sample1](./apps/java-quarkus-sample1/)
    - Quarkus 2.14.1.Final
        - Quarkus Open Telemetry
        - Quarkus Micrometer Registry OTLP - 2.12.0

## Architecture

<image src=../docs/project_one.png height=200>

## How to Run

### Build Project

Move to project folder:

```shell script
cd ./apps/java-quarkus-sample1
```

Build the project:

```shell script
./mvnw clean package
```

### Builde and run docker:

Build docker image

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t helpdev/java-quarkus-sample1-jvm .
```

Execute the docker-compose

```shell script
docker-compose up -d
```

## Send requests to trace

The docker-compose up 3 apps, service 1 calls service 2, and service 2 calls service 3 to simulate a long trace. The services run at port `8080`, `8081` and `8082`.

Sample to call a request:

```shell script
curl --request 'GET' http://localhost:8080/hello
```

## How to visualize the traces

Access the Jaeger in your browser: [http://localhost:16686](http://localhost:16686)


<image src=../docs/trace.png height=200>

## How to visualize the prometheus metrics

Access the Prometheus in your browser: [http://localhost:9090/](http://localhost:9090/)

<image src=../docs/prometheus.png height=200>

Note: All metrics collected will be exported to the Prometheus with a prefix configured in [collector-gateway.yml](./config/collector-gateway.yml) file at `exporters.prometheus.namespace`


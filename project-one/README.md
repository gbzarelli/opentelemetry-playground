# Project One

Studies about OpenTelemetry Architecture with Prometheus using Frameworks;

## Studies Links

- [OpenTelemetry Collector, Deployment Methods & Production Ready | The OpenTelemetry Bootcamp](https://www.youtube.com/watch?v=L_gjG4BjvSE)
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
        - Quarkus Micrometer Registry OTLP

## Architecture

<image src=../docs/project_one.png height=200>

## Run

- Build project Docker image:

Move to project folder:

```shell script
cd ./apps/java-quarkus-sample1
```

Build the project:

```shell script
./mvnw clean package
```

Build docker image:

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t helpdev/java-quarkus-sample1-jvm .
```

- Execute the docker-compose


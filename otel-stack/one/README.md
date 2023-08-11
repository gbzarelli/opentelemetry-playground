# Stack One

Studies about OpenTelemetry Architecture with Prometheus using Frameworks;

## Studies Links

- [OpenTelemetry Collector, Deployment Methods & Production Ready | The OpenTelemetry Bootcamp](https://www.youtube.com/watch?v=L_gjG4BjvSE)
- [aspecto-io/opentelemetry-bootcamp](https://github.com/aspecto-io/opentelemetry-bootcamp)
- [About OpenTelemetry in Quarkus](https://quarkus.io/guides/opentelemetry)
    - [brunobat/quarkus-observability-demo](https://github.com/brunobat/quarkus-observability-demo)
    - [Quarkiverse - Micrometer Registry OTLP](https://quarkiverse.github.io/quarkiverse-docs/quarkus-micrometer-registry/dev/micrometer-registry-otlp.html)


## Tecnologies

- OpenTelemetry Collector (distributed architecture with agent and gateway)
- Prometheus
- Jaeger Tracing
- Grafana

## Architecture

<image src=./docs/project_one.png height=200>

## How to visualize the prometheus metrics

Access the Prometheus in your browser: [http://localhost:9090/](http://localhost:9090/)

<image src=./docs/prometheus.png height=200>

Note: All metrics collected will be exported to the Prometheus with a prefix configured in [collector-gateway.yml](config/collector-gateway.yml) file at `exporters.prometheus.namespace`

## Services

- Prometheus: [http://localhost:9090/](http://localhost:9090/)
- Grafana: [http://localhost:3000/](http://localhost:3000/)
- Jeager: [http://localhost:16686/](http://localhost:16686/)

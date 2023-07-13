# invitae-lab-platform-exercise - Variant Service

A `Variant` is broadly defined as an alteration in a DNA nucleotide sequence. The `Variant Service` is intended to serve
as the source repository for billions of variants across the globe.

Some of a `Variant`'s attributes include:

```
- Gene	
- Nucleotide Change	
- Protein Change	
- Last Evaluated
```

A `json` representation of a sample variant:

```json
{
  "gene": "PGAM4",
  "nucleotideChange": "NG_013224.2:g.(?_4960)_(103567_105489)dup,NC_000023.11:g.(?_77910656)_(78009263_78011185)dup",
  "proteinChange": "NG_013224.2,NC_000023.11",
  "lastEvaluated": "2017-09-14"
}
```

## Tech Stack

This project is bootstrapped using the `Spring-Boot` and `Kotlin` stack. Please attempt to incorporate
language/framework idioms and best practices.

Tasks:

1. Build a REST endpoint that enables creation of a variant. The variant is saved in the service's persistence store - a
   Postgres database. What choices would you make for the database connectivity (JDBC, JPA, etc.)? Why? What does the
   schema of the `Variant` table look like? What would be the "type" of the primary key (Variant `id`)? Also store a
   Variant creation `timestamp`. Please use `flyway` for managing db migrations.

2. Broadcast a `VariantEvent` to a `Kafka` topic after a `Variant` record is saved, for interested downstream consumers.
   For this contrived example, the event shape consists of all `Variant` attributes from the DB table. What library
   would you choose for the integration with `Kafka` (`spring-cloud-stream`, `spring-kafka`, etc.)? Why? What is your
   strategy for broadcasting events? What are some considerations? What serialization format would you choose -
   plaintext (`json`, etc.) vs binary (`protobuf`, `avro`, `thrift`, etc.)?

Please treat these tasks as production-grade software (unit tests, etc.).

## Docker Environment

A fully dockerized environment is provided with all the batteries:

```shell
$ docker-compose up -d
```

### Rancher Desktop
Download [Rancher Desktop](https://rancherdesktop.io/) and follow their [installation instructions](https://docs.rancherdesktop.io/tutorials/working-with-images/)

```shell
$ nerdctl compose up -d
```

### For faster development cycles, consider running the `lab-platform-exercise` locally instead of in docker

```shell
$ docker-compose -f docker-compose-without-app.yml up -d 
```
(or)
```shell
$ nerdctl compose -f docker-compose-without-app.yml up -d
```
`$ ./gradlew bootRun`

## Kafka UI

The Kafka UI can be accessed at http://localhost:3030/. Of particular interest will be the Topics UI, which lists the
topics and the messages on each. It can be accessed at http://localhost:3030/kafka-topics-ui/#/.

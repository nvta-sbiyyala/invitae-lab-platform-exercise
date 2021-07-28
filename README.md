# invitae-lab-platform-exercise - Variant Service
A `Variant` is broadly defined as an alteration in a DNA nucleotide sequence. The `Variant Service` is intended to serve
as the source repository for billions of variants across the globe.

Some of a `Variant`'s attributes include:
```shell
- Gene	
- Nucleotide Change	
- Protein Change	
- Last Evaluated

```
A `json` representation of a sample variant:
```shell
{
  "gene": "PGAM4",
  "nucleotideChange": "NG_013224.2:g.(?_4960)_(103567_105489)dup,NC_000023.11:g.(?_77910656)_(78009263_78011185)dup",
  "proteinChange": "NG_013224.2,NC_000023.11",
  "lastEvaluated": "2017-09-14"
}
```

## Tech stack
This project is bootstrapped using the `Spring-Boot` and `Kotlin` stack. Please attempt to incorporate language/framework 
idioms and best practices. 

Tasks:
1. REST API to create a variant: Create an endpoint that enables creation of a variant. The variant is saved in the 
   service's persistence store - a postgres database. For this you'll need to support integration with a `pg` database - 
   what choices would you make for the database connectivity (JDBC, JPA etc.)? why? what does the `relation` schema of the
   `Variant Table` look like? (eg: `id` data type) would you want to use any db migration tooling (`flyway`, `liquidbase` etc.)? 
   
2. Broadcast a `VariantEvent` to a `kafka` topic after a `Variant record` is saved, for interested downstream consumers. 
   The event shape has an "emit" `timestamp` and `variant ID` fields in addition to the attributes of a `Variant`. 
   What library support would you choose for spring integration with `Kafka` (`spring-cloud-stream`, `spring-kafka`etc.)? why? 
   what is your strategy to broadcast events? what are some considerations? what serialization format would you choose - 
   plaintext (eg: `json` etc.) vs binary (eg: `protobuf`, `avro`, `thrift` etc.)? 

Please treat these tasks as production-grade software (Unit tests, etc.)    

## Docker environment 
A fully dockerized environment is provided with all the batteries
`$ docker-compose up`

## Service's actuator API
`$ curl http://localhost:8080/api/meta/`

## Kafka
### Control center
http://localhost:9021/ 
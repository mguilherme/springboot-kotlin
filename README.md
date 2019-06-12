# Spring boot Kotlin
Spring boot with kotlin example.
This example will pre-populate the database with a few dummy data.

## Pre-requisites
   
* IDE of your choice (IntellijIDEA is preferred)
* Postgresql database up and running

## Setup
The easiest way is to run a Postgresql instance is through docker:

```bash
docker run -d --name postgres -p 5432:5432 -v ~/Docker/postgresql/data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres postgres

```

Then create a `test` database with `spring_boot_demo` schema.

## TBD
* Unit testing


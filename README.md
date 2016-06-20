# README #

### Quick summary ###
.NET Engineer coding challenge #1

I managed to implement service layer for adding graphs based on Elasticsearch storage. Storage is embedded so its setup during running webapi module automatically. 

Unfortunately amount of work required for whole challenge in my opinion requires much more time (much more than expected 3-4 hours) to do it properly instead of implementing it in rush.  Thats way I focused on testing  service layer, as its main component which should guarantee that bad state is not persisted, and basic domain model should allow to extend this application further.


### What I need to run it? ###
Requirements are:

* Java 1.8

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

* Apache maven

https://maven.apache.org/install.html


### Build and run it from root project directory ###



Node xmls are in /ott-interview/loader/src/main/resources, provide absolute path for this directory for laoder to load it eg. 


```
#!bash

mvn package
java -jar webapi/target/ott-webapi-1.0.0-SNAPSHOT.jar
java -jar loader/target/ott-loader-1.0.0-SNAPSHOT-jar-with-dependencies.jar load {path_to_ott-interview_dir}\loader\src\main\resources
```

Check browser at 

```
#!bash

http://localhost:40000/graph
```

graph with all nodes and edges laoded should be displayed.



### TODO ###

* implement searching shortest path in graph
* implement UI application based on some MVP or MVVM  pattern e.g. using JavaFX powered by HTTP service


### Improvements ###

* add interfaces for domain model so, it will be extendable by other types of graphs
* use graph ids in HTTP api instead of hardcoded so many graphs can be added, and API will be accessed in more RESTful way
* define Elasticsearch schema mapping for graph storage for better performance, now its using default
* add application logs to trace data flow
* add tests in data loader module and refactor it to have more cohesive componenents
* add xsd schema validation
* add more tests for negative paths
* make it runnable as a one command
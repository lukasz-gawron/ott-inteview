# README #

### Quick summary ###

I managed to implement service layer for adding graphs based on Elasticsearch storage. Unfortunately amount of work required for whole challenge in my opinion requires much more time to do it properly instead of implementing it in rush.  Thats way I focused on testing  service layer, as its main component which should guarantee that bad state is not persisted, and basic domain model should allow to extend this application further.


### What I need to run it? ###
Requirements are:

* Java 1.8

https://www.java.com/pl/download/

* Apache maven

https://maven.apache.org/install.html


### Build and run it from root project directory ###




```
#!bash

mvn package
java -jar webapi/target/ott-webapi-1.0.0-SNAPSHOT.jar
java -jar loader/target/ott-loader-1.0.0-SNAPSHOT-jar-with-dependencies.jar load <absolute path to directory with node xmls>
```





### TODO ###

* searching shortest path in graph
* implement UI application based on some MVP or MVVM  pattern e.g. using JavaFX powered by HTTP service
* add tests in data loader module, add abstraction layer on accessing file system to make file loading testable
* make it runnable as a one command
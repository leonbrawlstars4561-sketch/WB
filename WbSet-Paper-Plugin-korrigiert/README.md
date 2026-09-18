# WbSet Paper Plugin

## Command

`/wbset <Radius>`

Beispiel:

`/wbset 100`

Der Mittelpunkt wird auf die aktuelle X/Z-Position des Spielers gesetzt.
Der eingegebene Wert ist der Radius in jede Richtung.

Radius 100 = 200 Blöcke Durchmesser.

## Bauen

Voraussetzungen:
- Java 21
- Maven

Im Projektordner:

`mvn clean package`

Die fertige JAR befindet sich danach in:

`target/WbSet-1.0.0.jar`

## Installation

Die JAR in den `plugins`-Ordner deines Paper-Servers kopieren und den Server neu starten.

PlaceholderAPI wird für dieses Plugin nicht benötigt.

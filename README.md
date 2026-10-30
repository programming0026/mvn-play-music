# Reproducir música con MIDI

Toca el "Himno de la Alegría" usando el sintetizador MIDI incluido en Java (`javax.sound.midi`), sin dependencias externas.

## Características

- Clase `Music` reutilizable: `sound(nota, duración)`.
- Notas definidas como constantes (DO, RE, SOL...) y duraciones (blanca, negra, corchea).
- Implementa `AutoCloseable` para cerrar el sintetizador.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Notas

- Necesita una salida de audio.
- Los números de nota siguen el estándar MIDI: 60 es el do central.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-play-music-1.0.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.


# Bewerbung

Dieses Projekt dient dazu, meine Bewerbungsunterlagen auf eine professionelle und innovative Weise zu präsentieren. Das Programm ermöglicht es, verschiedene Dokumente aus der Cloud abzurufen und bietet eine interaktive Benutzeroberfläche zur Navigation durch die Bewerbung.

## Projektstruktur

Das Projekt besteht aus den folgenden Hauptkomponenten:

1. **Bewerbung.java**: Hauptklasse, die die Benutzerinteraktion und den Zugriff auf die Dokumente steuert.
2. **Mail.java**: Klasse zum Senden von vordefinierten E-Mails für Zusagen und Absagen.
3. **pom.xml**: Maven-Projektdatei zur Verwaltung der Abhängigkeiten und des Build-Prozesses.

## Funktionen

- **Über mich**: Zeigt eine ausführliche Beschreibung meiner Qualifikationen und Erfahrungen.
- **Deckblatt anzeigen**: Öffnet das Deckblatt der Bewerbung.
- **Lebenslauf anzeigen**: Öffnet den Lebenslauf.
- **Zeugnisse und Zertifikate anzeigen**: Öffnet die Zeugnisse und Zertifikate.
- **Bewerbungsunterlagen herunterladen**: Lädt alle Bewerbungsunterlagen in den Download-Ordner des Benutzers herunter.
- **Antworten**: Ermöglicht das Senden einer vorgefertigten E-Mail mit einer Zusage oder Absage.

## Voraussetzungen

- Java 11 oder höher
- Maven

## Konfiguration

1. **AWS Zugangsdaten**: Die Zugangsdaten für AWS (Access Key und Secret Key) sind im Code hartkodiert.
2. **Maven**: Stellen Sie sicher, dass Maven installiert ist und korrekt konfiguriert wurde.

## Installation und Ausführung

1. **Klonen Sie das Repository**:
   ```sh
   git clone https://github.com/C10wN95/bewerbung.git
   cd bewerbung
   ```

2. **Bauen Sie das Projekt mit Maven**:
   ```sh
   mvn clean install
   ```

3. **Führen Sie das Programm aus**:
   ```sh
   mvn exec:java -Dexec.mainClass="com.msy.bewerbung.Bewerbung"
   ```

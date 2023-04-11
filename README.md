# Ferienwohnung Finder - Room Database

In dieser Aufgabe wird eine App zum Anzeigen von Ferienwohnungen programmiert. Die Aufgabe ist es sich um die Datenbankanbindung zu kümmern.


<img src=app/src/main/res/drawable/img.png width="40%" height="40%" style="display:block; margin:auto;"></img>

- Öffne das Projekt “FerienwohnungFinder” 
- Öffne die Datei “AppartmentData” und schreibe die Entity für die Datenbank. Folgende Informationen sollen enthalten sein:
    - Tabellenname = “appartment_table”
    - id ist Primary Key, auto generated
    - title, address als Strings
    - sleepRooms, size, persons, pricePerNight, image als Integer
    - petsAllowed als Boolean


- Öffne als nächstes die Datei “AppartmentDao”. Hier sollen folgende Funktionen an die entsprechenden Stellen die mit todo beschrieben sind eingefügt werden:
    - insertItem() zum Einfügen eines AppartmentData Datensatzes in die DB 
    - getAllItems() um alle Datensätze aus der Datenbank zu erhalten (als Liste aus lauter AppartmentData)
    - getCount() um die Anzahl der Datensätze in der Datenbank zurückzugeben


- Kommen wir nun zur Datei “Repository”. Hier ist folgendes zu bearbeiten:
    - Schreibe eine Funktion, die alle Items der Tabelle zurückgibt: getAllItems()
    - Schreibe eine Funktion, die die Anzahl aller Elemente in der Tabelle zurückgibt: getCount()
    - Schreibe eine Funktion prepopulateDB() welche die Datenbank mit Daten befüllt. Das Befüllen erfolgt nur, wenn die Anzahl der Elemente in der Tabelle gleich 0 ist. Die Datensätze heißen appartment1, apparment2, …, appartment6 und sind unter “data -> exampleData -> AppartmentsExampleData” zu finden


- Abschließend muss in der Datei “AppartmentDatabase” alles nötige geschrieben werden, damit das Programm die Instanz dieser Datenbank erhält. Orientiere dich hierzu an den Vorlesungsfolien
 

- Wenn alles richtig implementiert wurde, lässt sich das Programm nun ordnungsgemäß starten. Achte hierbei auf folgende Punkte:
    - Es werden keine Elemente doppelt angezeigt
    - Das Programm arbeitet flüssig
    - Das Programm sollte nicht abstürzen und auch nach dem Schließen sich wieder sauber öffnen
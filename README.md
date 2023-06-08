# Ferienwohnung Finder - Room Database

SyntaxBnB ist eine Firma die Ferienwohnungen anbietet.
Du sollst dich in dieser Aufgabe um die Datenbankanbindung kümmern.


- Öffne die Datei “AppartmentData” und schreibe die Entity für die Datenbank. Folgende Informationen sollen enthalten sein:
  - Tabellenname = “appartment_table”
  - id ist Primary Key, auto generated
  - title, address als Strings
  - sleepRooms, size, persons, pricePerNight, image als Integer
  - petsAllowed als Boolean


- Erstelle unter "data -> exampleData -> AppartmentsExampleData" 6 Datensätze mit beliebigen Werten
  (Du kannst Bilder aus "res -> drawable" für deine Datensätze verwenden).
  - Die Datensätze heißen appartment1, apparment2, …, appartment6.


- Öffne als nächstes die Datei “AppartmentDao”. Hier sollen die folgenden Funktionen an den
  entsprechenden Stellen, die mit 'TODO' beschrieben sind, eingefügt werden.
  - insertItem(), zum Einfügen eines AppartmentData Datensatzes in die DB
  - getAllItems(), um alle Datensätze aus der Datenbank zu erhalten (als Liste vom Typ AppartmentData)
  - getCount(), um die Anzahl der Datensätze in der Datenbank zurückzugeben


- Kommen wir nun zur Datei “Repository”. Hier ist folgendes zu bearbeiten:
  - Schreibe eine Funktion, die alle Elemente der Tabelle zurückgibt: getAllItems()
  - Schreibe eine Funktion, die die Anzahl aller Elemente in der Tabelle zurückgibt: getCount()
  - Schreibe eine Funktion prepopulateDB(), welche die Datenbank mit Elemente befüllt.  
    Das Befüllen erfolgt nur, wenn die Datenbank leer ist.


- Nun muss in der Datei “AppartmentDatabase” alles nötige geschrieben werden, damit das Programm die Instanz dieser Datenbank erhält.


- Abschließend muss noch der RecyclerView-Adapter "AppartmentAdapter" angepasst werden, sodass er die Datensätze
  richtig darstellen kann.


- Wenn alles richtig implementiert wurde, lässt sich das Programm nun ordnungsgemäß starten. Achte hierbei auf folgende Punkte:
  - Es werden keine Elemente doppelt angezeigt
  - Das Programm arbeitet flüssig, der Nutzer kann sich die Angebote anschauen.
  - Das Programm sollte nicht abstürzen und auch nach dem Schließen sich wieder sauber öffnen
  - Das Programm sollte in etwa so aussehen:

<img src=app/src/main/res/drawable/img.png width="30%" height="30%" style="display:block; margin:auto;"></img>

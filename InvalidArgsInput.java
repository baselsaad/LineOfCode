
/**
 * Beschreiben Sie hier die Klasse InvalidArgsInput.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class InvalidArgsInput extends RuntimeException
{
    public InvalidArgsInput(){
        super("Geben Sie bitte mindestens eine Datei zu lesen"
                +"\n(Beispiel: java LOCAuswertung example.txt)");
    }
}

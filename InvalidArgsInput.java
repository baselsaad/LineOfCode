/**
 * Spezifische Ausnahmenklasse falls keine Datei uebergegeben wird
 * 
 * @author (Basel) , (Anas) 
 * @version (06.02.2022)
 */
public class InvalidArgsInput extends RuntimeException
{
    public InvalidArgsInput(){
        super("Geben Sie bitte mindestens eine Datei zu lesen"
                +"\n(Beispiel: java LOCAuswertung example.txt)");
    }
}

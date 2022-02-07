import java.io.IOException;

/**
 * Spezifische Ausnahmenklasse falls die Datei nicht gelesen werden kann
 * 
 * @author (Basel) , (Anas) 
 * @version (06.02.2022)
 */
public class NotReadAbleFileException extends RuntimeException
{
    public NotReadAbleFileException (String file){
        super("\nDie Datei "+file+" ist nicht lesbar!"); 
    }
}

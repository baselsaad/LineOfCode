import java.io.*;

/**
 * Spezifische Ausnahmenklasse falls die Datei nicht gefunden wird 
 * 
 * @author (Basel) , (Anas) 
 * @version (06.02.2022)
 */
public class NotFindFileException extends RuntimeException 
{
    public NotFindFileException (String filename){
        super("\nDie Datei: "+filename+" koennte nicht gelesen bzw. gefunden werden!");
    }
}

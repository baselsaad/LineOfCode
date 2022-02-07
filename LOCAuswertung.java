import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * LOCAuswertung zaehlt die Anzahl an relevanten Codezeilen in den Java-Quelltexten
 * 
 * @author (Basel) , (Anas) 
 * @version (06.02.2022)
 */
public class LOCAuswertung
{
    //private:
    private int numberOfFiles;
    private int totalLines;
    private static final int MIN_INPUT = 0;
    private static final String COMMENT = "//";

    /**
     * die Methode liest und zaehlt wie viele Zeilen in einer Script gefunden werden
     * (Kommentare mit "//" oder leere Zeilen werden ignoriert)
     * 
     * @param inputfile , Name bzw. Verzeichnis der Datei 
     * @return Zeichenkette mit der gelesenen Zeilen
     */
    public String readFilesAsString(String fileName) throws NotFindFileException,NotReadAbleFileException{
        File file = new File(fileName);

        if (!file.exists() || file == null){
            throw new NotFindFileException(file.getAbsolutePath());
        }else if (!file.isFile() || !file.canRead() ){
            throw new NotReadAbleFileException(file.getAbsolutePath());
        }

        int lineCounter = 0;
        try (BufferedReader bufferdreader = new BufferedReader (new FileReader(file))){
            String line = "";

            while((line = bufferdreader.readLine()) != null){
                if (!line.strip().isEmpty() && !line.strip().startsWith(COMMENT)){
                    lineCounter++;
                }
            }

        }catch(IOException e){
            System.out.println(e);
        }

        totalLines += lineCounter;
        numberOfFiles++;
        return (fileName+": "+lineCounter+" LOC\n");
    }


    /**
     * @param args array mit alle uebergegebenen dateien
     * @return Zeichenkette mit der Ergebniss von gelesenen Werten 
     */
    private String read(String[] args) {
        checkArgs(args);
        String line = "";

        int i = 0;
        while(i < args.length){
            try{
                line += readFilesAsString(args[i]);
                i++;
            }catch (NotFindFileException e){
                System.out.println(e.getMessage());
                i++;
            }catch(NotReadAbleFileException e){
                System.out.println(e.getMessage());
                i++;
            }
        }
        return(line+"\n"+"Gesammt:\n"+ numberOfFiles+" Dateien"+ "\t"+totalLines+" LOC");
    }

    /**
     * startet das Programm
     * @param args-array wird beim Aufrufen von Main methode uebergegeben
     */
    public void start(String[] args){
        System.out.println("Auswertung Lines of Code (LOC)");
        try{
            System.out.println(read(args));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new LOCAuswertung().start(args);
    }

    
    //---------------------Hilfs-Methoden-------------------------------------------
    /**
     * @param ueberpruefen ob args min. aus einer Parameter besteht
     */
    private void checkArgs(String[] args){
        if (args.length <= MIN_INPUT){
            throw new InvalidArgsInput(); 
        }
    }

}

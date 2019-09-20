package parser;

import java.io.File;
import java.io.FileNotFoundException;

public class Scan {
    
    Scan(String search) throws FileNotFoundException{
        File actual;
        actual = new File("C:\\Users\\kalio\\Pictures\\JavaDocs");
        for( File f : actual.listFiles()){
            String ubicacion = "C:\\Users\\kalio\\Pictures\\JavaDocs\\"
                    + f.getName();
            System.out.println("*****************************************");
            System.out.println(f.getName());
            System.out.println("*****************************************");
            Open o = new Open(ubicacion, search);
        }
    }
}
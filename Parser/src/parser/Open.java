package parser;





/* TO DO: Upper or lower case text. 
    Line search. Page search. Word, excel read  */






import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Open{
    public File archivo;
    public String ubicacion, search;
   
    Open(String ubicacion, String search) throws FileNotFoundException{
        archivo = new File(ubicacion);
        if(ubicacion.contains(".txt")){
            openTxt(archivo, search);
        } else if(ubicacion.contains(".pdf")){
            openPDF(archivo, ubicacion, search);
        } else if(ubicacion.contains(".docx")){
            System.out.println("Word file");
        }
    }
    
    private void openTxt(File archivo, String search){
        try (Scanner sc = new Scanner(archivo)) {
                while(sc.hasNext()){
                    System.out.println(sc.next());
                    //if(sc.next().contains(search)){
                    //    System.out.println(search);
                    //}
                }
            } catch (FileNotFoundException e){
                System.out.println("Error");
            }
    }
    
    private void openPDF(File archivo, String ubicacion, String search){
        PDFManager pdfManager = new PDFManager();
            pdfManager.setFilePath(ubicacion);
            try {
                String text = pdfManager.toText();
                Scanner sc = new Scanner(text);
                while(sc.hasNext()){
                    //System.out.println(sc.next());
                    if(sc.next().contains(search)){
                        System.out.println(search);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error");
            }
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class saveGame {
  dialogController dialogController;
  
  //JButton SpeicherButton = new JButton("Speichern");
   
  
    public String getDialog(){
      
     int index_int = dialogController.dialogIndex;
     String index = Integer.toString(index_int);
        return index;
    }


    public void saveGameCreate(){
   try {
      File saveFile = new File("savegame.txt"); // Create File object
      if (saveFile.createNewFile()) {           // Try to create the file
        System.out.println("File created: " + saveFile.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("Save File konnte nicht erstellt werden");
      e.printStackTrace(); // Print error details
    }
    }

    public void SaveGameWrite(){
        
        try{
        FileWriter SaveWrite = new FileWriter("savegame.txt");
        String gameindex = this.getDialog();
        SaveWrite.write(gameindex);
        SaveWrite.close();
        } catch (IOException e) {
        System.out.println("Save File konnte nicht beschrieben werden");
         e.printStackTrace(); // Print error details
        }

    }


    public int SaveGameRead(){
      try {
        int value = Integer.parseInt(Files.readString(Path.of("savegame.txt")));
        return value;
      } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
        return 0;
      }
    }
    

}


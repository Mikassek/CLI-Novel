import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class saveGame {
    dialogController dialogController;
    String savePath = "saves/savegame.txt";

    public String getDialog() {
        int index_int = dialogController.dialogIndex;
        String index = Integer.toString(index_int);
        return index;
    }

    public void saveGameCreate() {
        try {
            File saveFile = new File(savePath);
            if (saveFile.createNewFile()) {
                System.out.println("File created: " + saveFile.getName());
            } else {
            }
        } catch (IOException e) {
            System.out.println("Save File konnte nicht erstellt werden");
            e.printStackTrace();
        }
    }

    public void SaveGameWrite() {
        try {
            FileWriter SaveWrite = new FileWriter(savePath);
            String gameindex = this.getDialog();
            SaveWrite.write(gameindex);
            SaveWrite.close();
        } catch (IOException e) {
            System.out.println("Save File konnte nicht beschrieben werden");
            e.printStackTrace();
        }
    }

    public int SaveGameRead() {
        try {
            int value = Integer.parseInt(Files.readString(Path.of(savePath)));
            return value;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

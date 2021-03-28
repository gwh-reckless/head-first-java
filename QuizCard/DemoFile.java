import java.io.File;

public class DemoFile {
    public static void main(String[] args) {
        // Make a File object representing an existing file
        File f = new File("MyCode.txt");

        // Make a new directory
        File dir = new File("Chapter7");
        dir.mkdir();

        // List the contents of a directory
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]);
            }
        }

        // Get the absolute path of a file or directory
        System.out.println(dir.getAbsolutePath());

        // Delete a file or directory (returns true if successful)
        boolean isDeleted = f.delete();
    }
}

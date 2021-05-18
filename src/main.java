import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class main {

    static Path createTempPath(String fileName) throws IOException {
        Path tempPath = Files.createTempFile(fileName, ".txt");
        tempPath.toFile().deleteOnExit();
        return tempPath;
    }

    public static void main(String[] args) throws IOException {

        Path file1 = createTempPath("a");
        Path file2 = createTempPath("b");
        Path file3 = createTempPath("c");

        Files.writeString(file1, "abcd");
        Files.writeString(file2, "abcd");
        Files.writeString(file3, "abcdefgh");
        System.out.println("Jesli mismatch zwraca '-1' to pliki sa identyczne, jesli zwraca liczbe calkowita to wskazuje ona na pozycje w ktorej pliki sie roznia.");
        long mismatch = Files.mismatch(file1, file2);
        System.out.println("File1 x File2 = " + mismatch);
        mismatch = Files.mismatch(file1, file3);
        System.out.println("File1 x File3 = " + mismatch);
    }
}


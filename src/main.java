import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class main {

    static Path createTempPath(String fileName) throws IOException {
        Path tempPath = Files.createTempFile(fileName, ".txt");
        tempPath.toFile().deleteOnExit();
        return tempPath;
    }

    public static void main(String[] args) throws IOException {
        // zad4
        Path file1 = createTempPath("a");
        Path file2 = createTempPath("b");
        Path file3 = createTempPath("c");

        Files.writeString(file1, "abcd");
        Files.writeString(file2, "abcd");
        Files.writeString(file3, "abcdefgh");
        System.out.println("If mismatch returns -1, files are the same. otherwise it returns index of position that first change occurs.");
        long mismatch = Files.mismatch(file1, file2);
        System.out.println("File1 x File2 = " + mismatch);
        mismatch = Files.mismatch(file1, file3);
        System.out.println("File1 x File3 = " + mismatch + "\n");
        // zad3
        boolean isThisStringBlank = " ".isBlank();
        boolean isThisStringEmpty = " ".isEmpty();
        Stream<String> thisStringHasThisAmountOfLines = "AB\nAB\nAB".lines();
        String stringAfterStripping  = " DB ".strip();
        String stringAfterStrippingOnlyLeading = " DB ".stripLeading();
        String stringAfterStrippinngOnlyTrailing = " DB ".stripTrailing();
        String stringAfterRepeatingFiveTimes = "==".repeat(5);

        System.out.println("Is this string blank?"); // " "
        if(isThisStringBlank) { System.out.println("Y"); } else { System.out.println("N"); }
        System.out.println("Is this string empty?"); // " "
        if(isThisStringEmpty) { System.out.println("Y"); } else { System.out.println("N"); }
        System.out.println("How many lines this string has?"); // "AB\nAB\nAB"
        System.out.println(thisStringHasThisAmountOfLines.count());
        System.out.println("How this string looks like after stripping?"); // " DB "
        System.out.println(stringAfterStripping);
        System.out.println("How this string looks like after stripping its leading?"); // " DB "
        System.out.println(stringAfterStrippingOnlyLeading);
        System.out.println("How this string looks like after stripping its trailing?"); // " DB "
        System.out.println(stringAfterStrippinngOnlyTrailing);
        System.out.println("How this string looks like after repeating its five times?"); // "=="
        System.out.println(stringAfterRepeatingFiveTimes);
    }
}


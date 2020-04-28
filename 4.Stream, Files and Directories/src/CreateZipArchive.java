import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("files.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream("4.Stream, Files and Directories - Copy.iml");
        zos.putNextEntry(new ZipEntry("4.Stream, Files and Directories - Copy.iml"));
        zos.write(fis.readAllBytes());
        zos.close();
        fis.close();
        fos.close();
    }
}

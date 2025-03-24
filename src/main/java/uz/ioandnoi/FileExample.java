package uz.ioandnoi;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws IOException {
//        File file = new File("io");
//        System.out.println("File exists "+file.exists());
//        boolean newFile = file.createNewFile();
//        System.out.println("File created "+newFile);
//        System.out.println("File exists "+file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());


//
//        File file2 = new File("io", "child/child2/child3");
//        System.out.println("File exists "+file2.exists());
//        System.out.println(file2.mkdirs());

        File file = new File("io", "readme2.txt");
        System.out.println("File exists "+file.exists());

        System.out.println(file.renameTo(new File("io", "readme.txt")));
//        System.out.println(file.length());
//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        System.out.println(new Date(file.lastModified()));



//        if (file.canRead()){
//            System.out.println("File can read");
//        }else {
//            System.err.println("File can not read");
//        }

//        System.out.println(file.canExecute());
//        file.deleteOnExit();
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getParentFile());
//        System.out.println(file.getParent());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());

    }
}

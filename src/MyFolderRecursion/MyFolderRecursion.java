package MyFolderRecursion;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class MyFolderRecursion {

    public static void main(String[] args) throws IOException {

        String link = "D:\\123\\";
        Path path = Paths.get(link);

        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(path, myFileVisitor);

        List<String> list = myFileVisitor.getList();

        for (String string: list){
            System.out.println(string);
        }
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path>{

    private List<String> list = new LinkedList<>();

    public List<String> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String string = file.getFileName().toString();
        list.add(string);
        //System.out.println(string);

        return FileVisitResult.CONTINUE;
    }
}

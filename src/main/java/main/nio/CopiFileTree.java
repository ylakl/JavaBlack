package main.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopiFileTree {
    public static void main(String[] args) throws IOException {
        Path s = Paths.get("C:\\Users\\Yulia\\Documents\\0");
        Path d = Paths.get("C:\\Users\\Yulia\\Documents\\r");
       Files.walkFileTree(s,new MyFileVisitor(s,d));
    }
}
class MyFileVisitor extends SimpleFileVisitor<Path>{
    Path sourse;
    Path dest;

    public MyFileVisitor(Path sourse, Path dest) {
        this.sourse = sourse;
        this.dest = dest;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDest = dest.resolve(sourse.relativize(dir));
        Files.copy(dir,newDest,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDest = dest.resolve(sourse.relativize(file));
        Files.copy(file,newDest,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}
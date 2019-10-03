import isel.poo.fs.*;

public class TestFS {
    public static void main(String[] args) {
        Entry file = new File("aula.txt", 100);
        Dir disk = new Dir("C:");
        Dir dir = new Dir("POO");

        disk.add(new File("file.txt", 1024));
        disk.add(dir);
        disk.add(new Dir("Empty"));
        dir.add(file);
        dir.add(new File("Str.java", 2340));
        disk.add(new Link("file.lnk",file));

        // C:{file.txt;POO{aula.txt;Str.java};Empty{};file.lnk->C:/POO/aula.txt}
        System.out.println( disk.getTree() );
        System.out.println("POO size="+dir.getSize()); // POO size = 2440
        System.out.println("C: size="+disk.getSize()); // C: size = 3464
        System.out.println("path = "+file.getPath()); // path = C:/POO/aula.txt
    }
}

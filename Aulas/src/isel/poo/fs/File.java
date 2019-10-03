package isel.poo.fs;

public class File extends Entry {
    public final int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }
    @Override
    public int getSize() { return size; }
}

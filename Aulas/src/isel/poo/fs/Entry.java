package isel.poo.fs;


public abstract class Entry extends Object {
    public final String name;
    protected Dir parent;
    protected Entry next;

    protected Entry(String name) {
        this.name = name;
    }

    public int getSize() { return 0; }

    public String getTree() { return name; }

    final public String getPath() {
        return (parent==null) ? name : parent.getPath() + "\\" + name;
    }
}

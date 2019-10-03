package isel.poo.fs;

public class Link extends Entry {
    private final Entry source;

    public Link(String name, Entry source) {
        super(name);
        this.source = source;
    }
    @Override
    public String getTree() {
        return super.getTree()+"->"+source.getPath();
    }
}

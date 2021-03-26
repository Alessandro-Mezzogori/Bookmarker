package Mezzogori.Alessandro.BookmarkerDatabase;

public class Site {
    long id;
    String name;
    String url;

    public Site(String name, String url){
        this.name = name;
        this.url = url;
    }

    public Site(long id, String name, String url){
        this.id = id;
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " URL: " + url;
    }
}

package cn.javabs.book.entity;
/*
* 实体类
*/
public class Book {
    private int id;             //ISBN书号    UUID通用唯一标识码
    private String bookName;
    private String bookDescription;
    private double bookPrice;
    private String publish;         //出版社
    private String author;          //作者

    //  d://abc/123/dog.png = 路径 + 图片名称
    private String path;            //图片路径
    private String photoName;       //图片名称

    private Category category;      //与分类有关联

    public Book(int id, String bookName, String bookDescription, double bookPrice, String publish, String author, String path, String photoName, Category category) {
        this.id = id;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.publish = publish;
        this.author = author;
        this.path = path;
        this.photoName = photoName;
        this.category = category;
    }

    public Book(String bookName, String bookDescription, double bookPrice, String publish, String author, String path, String photoName, Category category) {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.publish = publish;
        this.author = author;
        this.path = path;
        this.photoName = photoName;
        this.category = category;
    }

    public Book() {
        super();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookPrice=" + bookPrice +
                ", publish='" + publish + '\'' +
                ", author='" + author + '\'' +
                ", path='" + path + '\'' +
                ", photoName='" + photoName + '\'' +
                ", category=" + category +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

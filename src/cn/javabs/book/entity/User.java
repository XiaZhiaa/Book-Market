package cn.javabs.book.entity;

public class User {

    private Integer id;
    private String  name;//  人名
    private String  username;// 登录的用户名
    private String  password;
    private String  birthday;// 出生日期
    private String  email;
    private String  phone;

    private  int    type;// type: 1-管理员 、 0-普通用户  数据库方向：默认是0

    public User(Integer id) {
        this.id = id;
    }

    public User() {
        super();
    }

    public User(String name, String username, String password, String birthday, String email, String phone, int type) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public User(Integer id, String name, String username, String password, String birthday, String email, String phone, int type) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

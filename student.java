package StudentManageSystem;

public class student {

    private String name;
    private String id;  //为了方便都用string类型的
    private String age;
    private String address;

    public student() {
    }

    public student(String name, String id, String age, String address) {
        this.name = name;  //姓名
        this.id = id;      //学号
        this.age = age;    //年龄
        this.address = address;  //地址
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}

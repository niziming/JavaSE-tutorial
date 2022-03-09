package chap24;

public class Student {
    private String name;
    private int age;

    // public static ModuleDescriptor.Builder builder(){
        // return new ModuleDescriptor.Builder();
    // }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

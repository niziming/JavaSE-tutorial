// package itcast.chap26annotation;
//
// public class Person {
//     @Deprecated
//     String name;
//     int age;
//     @Override
//     public String toString(){
//         return name + " : " + age;
//     }
//
//     public String getName() {
//         return name;
//     }
//     @Deprecated(forRemoval=true, since = "Jdk1.9")
//     public void setName(String name) {
//         this.name = name;
//     }
//
//     public int getAge() {
//         return age;
//     }
//
//     public void setAge(int age) {
//         this.age = age;
//     }
//
//     // @SuppressWarnings("unchecked")
//     @SuppressWarnings({"deprecation"})
//     public static void main(String[] args) {
//         Person person = new Person();
//         person.age = 10;
//         person.name = "hello";
//         System.out.println(person);
//     }
// }

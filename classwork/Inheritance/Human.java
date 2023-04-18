public class Human {
    private String name;
    private int age;
    
    public Human() {
        this.name = "";
        this.age = 0;
    }
    
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

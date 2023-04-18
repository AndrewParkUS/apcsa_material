public class Beethoven extends German {
    private String symphony;
    
    public Beethoven() {
        super();
        this.symphony = "";
    }
    
    public Beethoven(String name, int age, String city, String symphony) {
        super(name, age, city);
        this.symphony = symphony;
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I composed " + symphony + ".");
    }
}

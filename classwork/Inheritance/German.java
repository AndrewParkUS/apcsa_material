public class German extends Human {
    private String city;
    
    public German() {
        super();
        this.city = "";
    }
    
    public German(String name, int age, String city) {
        super(name, age);
        this.city = city;
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("Guten tag! I come from " + city + ".");
    }
}

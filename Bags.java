public class Bags extends LeatherGoods {
    private String typeOfBag;

    public Bags(){
        super();
        this.typeOfBag = "";

    }

    public Bags(String t, double p, String c, int l, int cn, int ic, String tb){
        super(t, p, c, l, cn, ic);
        this.typeOfBag = tb;
    }

    public String getTypeOfBag(){
        return this.typeOfBag;
    }

    public void setTypeOfBag(String tb){
        this.typeOfBag = tb;
    }

    public String toString(){
        return "\nItem type: bags"
        + super.toString() 
        + "\nType of bag: " + this.typeOfBag;
    }
}

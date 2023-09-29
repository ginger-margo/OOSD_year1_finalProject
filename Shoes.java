public class Shoes extends LeatherGoods{
    private int size;
    private String fit;
    
    public Shoes(){
        super();
        this.size = 0;
        this.fit = "";
    }

    public Shoes(String t, double p, String c, int l, int cn, int ic, int cz, String ft){
        super(t, p, c, l, cn, ic);
        this.size = cz;
        this.fit = ft;
    }

    public int getSize(){
        return this.size;
    }

    public String getFit(){
        return this.fit;
    }

    public void setSize(int cz){
        this.size = cz;
    }

    public void setFit(String ft){
        this.fit = ft;
    }

    public String toString(){
        return "\nItem type: shoes"
        + super.toString() 
        + "\nSize: " + this.size
        + "\nFit: " + this.fit;
    }

}


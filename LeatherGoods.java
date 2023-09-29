import java.io.*;

//Filatova Margarita d21124435

class LeatherGoods implements Serializable{
    private String typeOfLeather;
    private double price;
    private String color;
    private int leftInStock;
    private int count;
    private int itemCode;

    public LeatherGoods () {
        this.typeOfLeather = "";
        this.price = 0;
        this.color = "";
        this.leftInStock = 0;
        this.count = 0;
        this.itemCode = 0;
    }
    public LeatherGoods (String t, double p, String c, int l, int cn, int ic) {
        this.typeOfLeather = t;
        this.price = p;
        this.color = c;
        this.leftInStock = l;
        this.count = cn;
        this.itemCode = ic;
    }

    public String getTypeOfLeather(){
        return this.typeOfLeather;
    }

    public double getPrice(){
        return this.price;
    }

    public String getColor(){
        return this.color;
    }

    public int getLeftInStock(){
        return this.leftInStock;
    }

    public int getCount(){
        return this.count;
    }

    public int getItemCode(){
        return this.itemCode;
    }

    public void setTypeOfLeather(String t){
        this.typeOfLeather = t;
    }

    public void setPrice(double p){
        this.price = p;
    }

    public void setColor(String c){
        this.color = c;
    }

    public void setLeftInStock(int l){
        this.leftInStock = l;
    }

    public void setCount(int cn){
        this.count = cn;
    }

    public void setItemCode(int ic){
        this.itemCode = ic;
    }

    public String toString(){
        return "\nItem code: " + this.itemCode 
        + "\nPrice: " + this.price
        + "\nColor: " + this.color
        + "\nLeft in stock: " + this.leftInStock;
    }
}

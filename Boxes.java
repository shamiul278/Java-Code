import java.lang.*;

public class Boxes {
    private double length;
    private double width;
    private double height;
    
    public void setLength(double l){
        length = l;
    }
    
    public void setWidth(double w){
        width = w;
    }
    public void setHeight(double h){
        height = h;
    }
    
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    
    public static void main(String args[]){
        
        Boxes[] boxes = new Boxes[3];

        boxes[0] = new Boxes();
		boxes[1] = new Boxes();
		boxes[2] = new Boxes();
		
        boxes[0].setLength(50);
        boxes[0].setWidth(155);
        boxes[0].setHeight(150);
        
        
		boxes[1].setLength(26);
        boxes[1].setWidth(70);
        boxes[1].setHeight(12);
        
        
        boxes[2].setLength(1);
        boxes[2].setWidth(30);
        boxes[2].setHeight(49);


        System.out.println("Box " + (0) + ": Length = " + boxes[0].getLength() + ", Height = " + boxes[0].getHeight() + ", Width = " + boxes[0].getWidth());
		System.out.println("Box " + (1) + ": Length = " + boxes[1].getLength() + ", Height = " + boxes[1].getHeight() + ", Width = " + boxes[1].getWidth());
		System.out.println("Box " + (2) + ": Length = " + boxes[2].getLength() + ", Height = " + boxes[2].getHeight() + ", Width = " + boxes[2].getWidth());
        
    }   
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/**
 * Created by Francis on 1/18/2017.
 */
public class Member {
    public int rank;
    public BufferedImage image;
    public String name;
    private boolean chosen ;
    private double prob1,prob2,prob3,prob4,prob5,prob6;

    public Member(BufferedImage image, String name){
        this.image=image;
        this.name=name;
    }

    public Member( String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void isChosen(){
        chosen=true;
    }

    public void setProbs(double p1,double p2,double p3, double p4, double p5, double p6){
        prob1 =p1;
        prob2=p2;
        prob3=p3;
        prob4=p4;
        prob5=p5;
        prob6=p6;

    }


}

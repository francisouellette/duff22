import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Francis on 1/18/2017.
 */


public class draft extends JFrame {
    private Ecouteur ec;
    private  JPanel comboPanel,listPanel;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
    private JComboBox comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox8,comboBox9,comboBox10,comboBox11,comboBox12;
    private JButton confirm;
    private JList order;
    private Member[] tabMember;
    public static void main(String[] args) {
        draft frame = new draft();
    }

    public draft() {

        tabMember = new Member[12];
        tabMember=generateMembers();



        JFrame guiFrame = new JFrame();

        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Draft Reddit");
        guiFrame.setSize(800,400);
        guiFrame.setLocationRelativeTo(null);

        comboPanel = new JPanel();
        comboPanel.setLayout(new GridLayout(14,2));
        comboPanel.setVisible(true);


        Member[] members = generateMembers();
        ec = new Ecouteur();

        String labels[] = new String[12];
        int i=0;
        for (Member m : members){
            labels[i] = m.name;
            i++;
        }

        label1 = new JLabel("First Place : ");
        comboPanel.add(label1);
        comboBox1 = new JComboBox(labels);
        comboPanel.add(comboBox1);

        label2 = new JLabel("Second Place : ");
        comboPanel.add(label2);
        comboBox2 = new JComboBox(labels);
        comboBox2.setSelectedIndex(1);
        comboPanel.add(comboBox2);

        label3 = new JLabel("Third Place : ");
        comboPanel.add(label3);
        comboBox3 = new JComboBox(labels);
        comboPanel.add(comboBox3);
        comboBox3.setSelectedIndex(2);

        label4 = new JLabel("Fourth Place : ");
        comboPanel.add(label4);
        comboBox4 = new JComboBox(labels);
        comboPanel.add(comboBox4);
        comboBox4.setSelectedIndex(3);

        label5 = new JLabel("Fifth Place : ");
        comboPanel.add(label5);
        comboBox5= new JComboBox(labels);
        comboPanel.add(comboBox5);
        comboBox5.setSelectedIndex(4);

        label6 = new JLabel("Sithx Place : ");
        comboPanel.add(label6);
        comboBox6 = new JComboBox(labels);
        comboPanel.add(comboBox6);
        comboBox6.setSelectedIndex(5);

        label7 = new JLabel("Seventh Place : ");
        comboPanel.add(label7);
        comboBox7 = new JComboBox(labels);
        comboBox7.setSelectedIndex(7);
        comboPanel.add(comboBox7);
        comboBox7.setSelectedIndex(6);

        label8 = new JLabel("Eighth Place : ");
        comboPanel.add(label8);
        comboBox8 = new JComboBox(labels);
        comboPanel.add(comboBox8);
        comboBox8.setSelectedIndex(7);


        label9 = new JLabel("Ninth Place : ");
        comboPanel.add(label9);
        comboBox9 = new JComboBox(labels);
        comboPanel.add(comboBox9);
        comboBox9.setSelectedIndex(8);

        label10 = new JLabel("Tenth Place : ");
        comboPanel.add(label10);
        comboBox10 = new JComboBox(labels);
        comboPanel.add(comboBox10);
        comboBox10.setSelectedIndex(9);

        label11 = new JLabel("Eleventh Place: ");
        comboPanel.add(label11);
        comboBox11 = new JComboBox(labels);
        comboPanel.add(comboBox11);
        comboBox11.setSelectedIndex(10);

        label12 = new JLabel("Twelth Place: ");
        comboPanel.add(label12);
        comboBox12 = new JComboBox(labels);
        comboPanel.add(comboBox12);
        comboBox12.setSelectedIndex(11);


        confirm = new JButton("Confirm");
        confirm.addActionListener(ec);

        listPanel = new JPanel();
        listPanel.setVisible(false);
        JLabel listLbl = new JLabel("DRAFT RESULT:");
        JList order = new JList();
        order.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        listPanel.add(listLbl);
        listPanel.add(order);

        guiFrame.add(comboPanel, BorderLayout.NORTH);
        guiFrame.add(confirm,BorderLayout.SOUTH);
        guiFrame.add(listPanel, BorderLayout.CENTER);
        //guiFrame.add(vegFruitBut,BorderLayout.SOUTH);

        //Display the window.
        guiFrame.setVisible(true);
    }


    private class Ecouteur implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calculatePicks();
            double round1= 20+13.5+11.5+9.5+8.5+7.5;

            System.out.println(round1);
            listPanel.setVisible(!listPanel.isVisible());
            comboPanel.setVisible(!comboPanel.isVisible());

            String[] test = {"Asparagus", "Beans", "Broccoli", "Cabbage"
                    , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
                    , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
                    , "Turnip"};

            order =new JList(test);
        }
    }


    public String[] calculatePicks(){
        System.out.println(tabMember.length);
        for(int i = 0; i<tabMember.length;i++){
            if(tabMember[i].getName()==comboBox1.getSelectedItem()){
                tabMember[i].setRank(12);
            }
            if(tabMember[i].getName()==comboBox2.getSelectedItem()){
                tabMember[i].setRank(11);
            }
            if(tabMember[i].getName()==comboBox3.getSelectedItem()){
                tabMember[i].setRank(10);
            }
            if(tabMember[i].getName()==comboBox4.getSelectedItem()){
                tabMember[i].setRank(9);
            }
            if(tabMember[i].getName()==comboBox5.getSelectedItem()){
                tabMember[i].setRank(8);

            }
            if(tabMember[i].getName()==comboBox6.getSelectedItem()){
                tabMember[i].setRank(7);
            }
            if(tabMember[i].getName()==comboBox7.getSelectedItem()){
                tabMember[i].setRank(6);
                tabMember[i].setProbs(7.5,7.8,8.2,0,0,17.5);

            }
            if(tabMember[i].getName()==comboBox8.getSelectedItem()){
                tabMember[i].setRank(5);
                tabMember[i].setProbs(8.5,8.8,9,0,9.1,35.5);


            } if(tabMember[i].getName()==comboBox9.getSelectedItem()){
                tabMember[i].setRank(4);
                tabMember[i].setProbs(9.5,9.7,9.8,3.1,27.3,33.2);

            }
            if(tabMember[i].getName()==comboBox10.getSelectedItem()){
                tabMember[i].setRank(3);
                tabMember[i].setProbs(11.5,11.4,11.3,14.2,37.8,13.8);
            }
            if(tabMember[i].getName()==comboBox11.getSelectedItem()){
                tabMember[i].setRank(2);
                tabMember[i].setProbs(13.5,13.1,12.5,35.2,25.8,0);
            }
            if(tabMember[i].getName()==comboBox12.getSelectedItem()){
                tabMember[i].setRank(1);
                tabMember[i].setProbs(20,17.5,15,47.5,0,0);
            }

            for(Member mem:tabMember){
                System.out.println(mem.getName() + " RANK : " +mem.rank);
            }



        }

        String[] members = new String[12];
        return members;
    }

    public static Member[] generateMembers(){
        Member tabMember[] = new Member[12];

        Member itsy = new Member("BennGuin MaDallascar ");
        Member jimmy = new Member("King of the North");

        Member francis = new Member("Montreal Poutine");

        Member nathan = new Member("Matthes and al ");

        Member guillen = new Member("Racoon McJesus");

        Member stef = new Member("No pucks given");

        Member ben = new Member("Tarasenkshow");

        Member thomas = new Member("Norris Side");

        Member maxwell = new Member("Mad Maxwell");

        Member curtis = new Member("Dont Toews me bro");

        Member jonas = new Member("You saad bro");

        Member david = new Member("Cursed Frogurt");

        tabMember[0]=maxwell;
        tabMember[1]=david;
        tabMember[2]=itsy;
        tabMember[3]=jimmy;
        tabMember[4]=francis;
        tabMember[5]=guillen;
        tabMember[6]=thomas;
        tabMember[7]=curtis;
        tabMember[8]=jonas;
        tabMember[9]=ben;
        tabMember[10]=stef;
        tabMember[11]=nathan;


        return tabMember;

    }
    public static Member[] generateMemberswithPhoto(){
        BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;
        Member tabMember[] = new Member[12];
        try {
            img1 = ImageIO.read(new File("image\\itsy.jpg"));
            Member itsy = new Member(img1,"BennGuin MaDallascar ");
            tabMember[0]=itsy;

            img2 = ImageIO.read(new File("image\\itsy.jpg"));
            Member jimmy = new Member(img2,"King of the North");
            tabMember[1]=jimmy;

            img3 = ImageIO.read(new File("image\\itsy.jpg"));
            Member francis = new Member(img3,"Montreal Poutine");
            tabMember[2]=francis;

            img4 = ImageIO.read(new File("image\\itsy.jpg"));
            Member nathan = new Member(img4,"Matthes and al ");
            tabMember[3]=nathan;

            img5 = ImageIO.read(new File("image\\itsy.jpg"));
            Member guillen = new Member(img5,"Racoon McJesus");
            tabMember[4]=guillen;

            img6 = ImageIO.read(new File("image\\itsy.jpg"));
            Member stef = new Member(img6,"No pucks given");
            tabMember[5]=stef;

            img7 = ImageIO.read(new File("image\\itsy.jpg"));
            Member ben = new Member(img7,"Tarasenkshow");
            tabMember[6]=ben;

            img8 = ImageIO.read(new File("image\\itsy.jpg"));
            Member thomas = new Member(img8,"Norris Side");
            tabMember[7]=thomas;

            img9 = ImageIO.read(new File("image\\itsy.jpg"));
            Member maxwell = new Member(img9,"Mad Maxwell");
            tabMember[8]=maxwell;

            img10 = ImageIO.read(new File("image\\itsy.jpg"));
            Member curtis = new Member(img10,"Dont Toews me bro");
            tabMember[9]=curtis;


            img11 = ImageIO.read(new File("image\\itsy.jpg"));
            Member jonas = new Member(img11,"You saad bro");
            tabMember[10]=jonas;

            img12 = ImageIO.read(new File("image\\itsy.jpg"));
            Member david = new Member(img12,"Cursed Frogurt");
            tabMember[11]=david;

        }
        catch (IOException e){
            System.out.println("error");
            return null;
        }
        System.out.println("done");
        return tabMember;
    }

    }

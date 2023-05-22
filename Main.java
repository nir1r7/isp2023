import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
    JFrame frame;

    JButton[] levels = {new JButton("Level 1"), new JButton("Level 2"), new JButton("Level 3")};

    boolean l2 = true;
    boolean l3 = true;

    public Main() {
        frame = new JFrame("ISP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new GridLayout());

        mainmenu();

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == levels[0]){
            level1();
        }
        else if (e.getSource() == levels[1] && l2){
            level2();
        }
        else if (e.getSource() == levels[2] && l3){
            level3();
        }
    }

    public static int strength() {
        return (int) (256 * Math.random());
    }

    public void mainmenu(){
        JPanel mainmenu = new JPanel(new GridLayout(5,3));

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(3,1));

        for (int i = 0; i < levels.length; i++){

            levels[i].addActionListener(this);
            levels[i].setFont(new Font("Serif", Font.PLAIN, 18));
            menu.add(levels[i]);

        }

        JLabel title = new JLabel("Main Menu", 0 );
        title.setFont(new Font("Serif", Font.BOLD, 34));

        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());

        mainmenu.add(title);

        mainmenu.add(new Empty());
        mainmenu.add(new Empty());

        mainmenu.add(menu);

        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());
        mainmenu.add(new Empty());

        frame.add(mainmenu);
    }

    public void level1(){
        frame.setSize(800, 501);
        frame.getContentPane().removeAll();
        
        JPanel intro = new JPanel(new GridLayout(4,3));

        intro.add(new JLabel("Level 1: Introduction", 0));

        intro.add(new Empty()); intro.add(new Empty());
        intro.add(new Empty()); intro.add(new Empty());

        JPanel op1Container = new JPanel(new GridLayout(3,1));
        op1Container.add(new Empty());
        op1Container.add(new JButton("Yes!"));
        op1Container.add(new Empty());

        JPanel op2Container = new JPanel(new GridLayout(3,1));
        op2Container.add(new JButton("Not really..."));
        op2Container.add(new Empty());
        op2Container.add(new Empty());

        intro.add(op1Container);
        intro.add(new Empty()); intro.add(new Empty());
        intro.add(op2Container);

        intro.add(new JLabel("TESTINGZ 3", 0));
        intro.add(new JLabel("TESTINGZ 3", 0));
        intro.add(new JLabel("TESTINGZ 3", 0));

        frame.add(intro);

        frame.setSize(800, 500);
    }

    public void level2(){
        frame.setSize(800, 501);
        frame.getContentPane().removeAll();
        frame.add(new JLabel("TESTINGZ 2", 0));
        frame.setSize(800, 500);
    }

    public void level3(){
        frame.setSize(800, 501);
        frame.getContentPane().removeAll();

        frame.setSize(800, 500);
    }

    class Empty extends JComponent {
        int w;
        int h;

        public Empty(){
            w = 10;
            h = 10;
        }

        public void paint(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, w, h);
        }
    }

}

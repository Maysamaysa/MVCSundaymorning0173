import javax.swing.*;
import java.awt.*;
//view แสดงผลหนเาจอต่างๆผ
public class View {
    JFrame frame;
    JTextField idinput;
    JButton checkb;
    JLabel resultLabel;
    JLabel type;
    //frame//pop up repair in Con
    public View() {
        frame = new JFrame("MVC Sunday ข้อ 2");
        frame.setSize(500, 250);
        frame.setLayout(new GridLayout(5, 1));
        frame.setLocationRelativeTo(null);
        idinput = new JTextField();
        type = new JLabel("Suit Type: -", SwingConstants.CENTER);
        checkb = new JButton("checking");
        resultLabel = new JLabel("Id?", SwingConstants.CENTER);
        frame.add(new JLabel("please input Id int 6 digit:"));
        frame.add(idinput);
        frame.add(checkb);
        frame.add(resultLabel);
        frame.add(type);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
//for controller
    public String getSuitId() {
        return idinput.getText().trim();
    }

    public void setResult(String message) {
        resultLabel.setText(message);
    }

    public void setSuitType(String type1) {
        type.setText("Suit Type: " + type1);
    }

    public JButton getcheckb() { return checkb; }
}

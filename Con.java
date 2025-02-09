import javax.swing.*;
import java.util.List;
/*Controller
    ตัวควบคุม,บังคับมปุ่มๆ
*/
public class Con {
    View view;
    List<suit> suits;

    public Con(View view) {
        this.view = view;
        this.suits = Dbmanage.loadSuits();//load suit

        view.getcheckb().addActionListener(e -> checkSuit());//กดปุ่มละทำงาน
    }
//check and report
    void checkSuit() {
        String suitId = view.getSuitId();
        for (suit suit1 : suits) {
            if (suit1.getId().equals(suitId)) {
                view.setSuitType(suit1.getType());
                if (suit1.check()) {
                    view.setResult("Avialiable");
                } else showRepairDialog(suit1);
                return;
            }
        }
        if(view.getSuitId().length()!=6){
            view.setResult("Please input valid int Id 6 digits no 0 in first");
            try {
                Integer.parseInt(view.getSuitId());
            } catch (Exception e) {
                view.setResult("int Only plz");
            }
        }else view.setResult("404 Not found!");
    }
//show pop up window
    void showRepairDialog(suit suit) {
        JDialog repairDialog = new JDialog();
        repairDialog.setTitle("need repair");
        repairDialog.setSize(300, 150);
        repairDialog.setLayout(null);
        repairDialog.setModal(true);
        JLabel message = new JLabel("It need to be fix");
        message.setBounds(50, 20, 220, 30);
        repairDialog.add(message);
        JButton repairButton = new JButton("fix");
        repairButton.setBounds(90, 60, 100, 30);
        repairDialog.add(repairButton);
        repairButton.addActionListener(e -> {
            suit.repair();
            Dbmanage.saveSuits(suits);
            repairDialog.dispose();
            view.setResult("repair complete new Dura : " + suit.getDurability());
        });

        repairDialog.setLocationRelativeTo(null);
        repairDialog.setVisible(true);
    }
}

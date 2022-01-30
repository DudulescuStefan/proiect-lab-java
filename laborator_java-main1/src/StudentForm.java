import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentForm {
    public StudentForm(JFrame Owner, User u) {
        this.Owner = Owner;
        Owner.setSize(new Dimension(500, 500));
        FileDataManager DataManager = new FileDataManager();
        Curs[] cursuri = DataManager.createCoursesData();
        String prenume = new String();
        String nume = new String();
        User user = new User();

        HashMap<String, String> hashMap = u.menuStrategy.getAccountHolderInformation();

        for (String string : hashMap.keySet()) {
            prenume = string;
            System.out.println(prenume);
        }

        for (String string : hashMap.values()) {
            nume = string;
            System.out.println(nume);
        }

        String fnume = nume;
        String fprenume = prenume;

        studentfield.setText("Conectat ca " + nume + " " + prenume);

        noteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringBuilder c = new StringBuilder();
                System.out.println(c);
                boolean foundStud = false;
                for (Curs curs : cursuri) {

                    System.out.println(c);

                    for (Student s : curs.studenti) {

                        if (s.nume.compareTo(fprenume) == 0 && s.prenume.compareTo(fnume) == 0) {
                            c.append("Nota la " + curs.nume + ": " + curs.nota.get(s));
                            foundStud = true;
                            System.out.println(s.nume);
                        }

                    }
                }

                if (foundStud) {
                    JOptionPane.showMessageDialog(null, c.toString());
                }

                else JOptionPane.showMessageDialog(null, "Nu a fost gasit studentul");

            }

        });

    }

    public JPanel getPanel4() {
        return Panel4;
    }

    private JPanel Panel4;
    private JButton profesoriButton;
    private JButton cursuriButton;
    private JButton noteButton;
    private JLabel studentfield;
    private JButton medieButton;
    private JFrame Owner;
}

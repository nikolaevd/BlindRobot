package pathbuilder;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class PathBuilderGUI {
    private JButton button;
    private JTextField textField;
    private JTextArea textArea;
    
    public void buildGUI(){
        JFrame frame = new JFrame("PathBuilder");
        
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();
        
        JLabel label1 = new JLabel("Взять данные из:");
        JLabel label2 = new JLabel("Результат: ");
        
        textField = new JTextField("src\\resources\\test.txt", 20);
        textArea = new JTextArea(4, 20);
        
        button = new JButton("Старт");
        
        panelCenter.add(label1);
        panelCenter.add(textField);
        panelCenter.add(label2);
        panelCenter.add(textArea);
        panelSouth.add(button);
        
        button.addActionListener(new ButtonListner());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(BorderLayout.CENTER, panelCenter);
        frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
        
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    
    class ButtonListner implements ActionListener {
        public void actionPerformed(ActionEvent event){
            PathBuilder pb = new PathBuilder(textField.getText());
            pb.go();
           
            textArea.insert(pb.getPathToDesiredFile(), 0);
            textArea.insert("\n", pb.getPathToDesiredFile().length());
        }
    }
}

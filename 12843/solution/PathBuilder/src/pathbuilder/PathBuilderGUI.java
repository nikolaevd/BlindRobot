package pathbuilder;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class PathBuilderGUI {
    private JButton button;
    
    public void buildGUI(){
        JFrame frame = new JFrame("PathBuilder");
        
        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();
        
        JLabel label1 = new JLabel("Укажите полный или относительный путь к файлу.");
        JLabel label2 = new JLabel("Путь: ");
        JTextField textField = new JTextField("src\\resources\\test.txt", 25);
        
        button = new JButton("Старт");
        
        panelNorth.add(label1);
        panelCenter.add(label2);
        panelCenter.add(textField);
        panelSouth.add(button);
        
        button.addActionListener(new ButtonListner());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(BorderLayout.NORTH, panelNorth);
        frame.getContentPane().add(BorderLayout.CENTER, panelCenter);
        frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
        
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    
    class ButtonListner implements ActionListener {
        public void actionPerformed(ActionEvent event){
            button.setText("Я смогу!");
        }
    }
}

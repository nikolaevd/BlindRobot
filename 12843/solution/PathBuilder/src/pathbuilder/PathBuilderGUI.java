package pathbuilder;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class PathBuilderGUI {
    private JButton button;
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    public void buildGUI(){
        JFrame frame = new JFrame("PathBuilder");
        
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();
        
        textField = new JTextField("src\\resources\\test.txt", 20);
        textArea = new JTextArea(10, 20);
        scrollPane = new JScrollPane(textArea);
        
        
        button = new JButton("Определить путь");
        
        panelCenter.add(textField);
        panelCenter.add(scrollPane);
        panelSouth.add(button);
        
        button.addActionListener(new ButtonListner());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(BorderLayout.CENTER, panelCenter);
        frame.getContentPane().add(BorderLayout.SOUTH, panelSouth);
        
        frame.setSize(350, 300);
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

package pathtofile;

import javax.swing.*;
import java.awt.event.*;

public class PathToFileBuilder {
    public void go(){
        JFrame frame = new JFrame("Найти путь к файлу");
        JLabel label = new JLabel("Укажите путь");
        JFileChooser fileChooser = new JFileChooser();
        JButton button1 = new JButton("Открыть");
        JButton button2 = new JButton("Пуск");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(label);
        frame.getContentPane().add(fileChooser);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}

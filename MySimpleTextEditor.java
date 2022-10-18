import javax.swing.*;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;

public class MySimpleTextEditor  implements ActionListener {
    JFrame frame;
    JTextArea textarea;
    JMenuBar menuBar;
    int font_size=16;
    MySimpleTextEditor(){
        frame = new JFrame("My Simple Text Editor");
        frame.setSize(800,800);
        frame.setVisible(true);
         textarea =new JTextArea("Created with Love By Rauch Rodrigues");
        textarea.setFont(new Font("Verdana", Font.PLAIN, font_size));
        frame.add(textarea);
         menuBar = new JMenuBar();
        menuBar.setBackground(Color.CYAN);




        JMenu filemenu = new JMenu("File Menu");
        JMenu editmenu = new JMenu("Edit Menu");
        JMenu colormenu = new JMenu("Color Menu");
        JMenu fontmenu = new JMenu("Font Menu");
        menuBar.add(filemenu);
        menuBar.add(editmenu);
        menuBar.add(colormenu);
        menuBar.add(fontmenu);
        JMenuItem open = new JMenuItem("Open File");
        JMenuItem save = new JMenuItem("Save File");
        JMenuItem print = new JMenuItem("Print File");
        JMenuItem New = new JMenuItem("New File");
        filemenu.add(open);
        filemenu.add(save);
        filemenu.add(print);
        filemenu.add(New);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        New.addActionListener(this);
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem close = new JMenuItem("Close");
        editmenu.add(cut);
        editmenu.add(copy);
        editmenu.add(paste);
        editmenu.add(close);

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);

        JMenuItem white = new JMenuItem("White");
        JMenuItem black = new JMenuItem("Black");
        JMenuItem yellow = new JMenuItem("Yellow");
        JMenuItem red = new JMenuItem("Red");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem cyan= new JMenuItem("Cyan");
        JMenuItem pink = new JMenuItem("Pink");
        colormenu.add(white);
        colormenu.add(black);
        colormenu.add(yellow);
        colormenu.add(red);
        colormenu.add(green);
        colormenu.add(cyan);
        colormenu.add(pink);
        white.addActionListener(this);
        black.addActionListener(this);
        yellow.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        cyan.addActionListener(this);
        pink.addActionListener(this);

        JMenuItem plain = new JMenuItem("Plain");
        JMenuItem bold = new JMenuItem("Bold");
        JMenuItem italic = new JMenuItem("Italic");
        JMenuItem fontincrease= new JMenuItem("Increase by 1");
        JMenuItem fontdecrease = new JMenuItem("Decrease by 1");
        fontmenu.add(plain);
        fontmenu.add(bold);
        fontmenu.add(italic);
        fontmenu.add(fontincrease);
        fontmenu.add(fontdecrease);
        plain.addActionListener(this);
        bold.addActionListener(this);
        italic.addActionListener(this);
        fontincrease.addActionListener(this);
        fontdecrease.addActionListener(this);
        frame.setJMenuBar(menuBar);
        frame.show();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) {
        MySimpleTextEditor editor1 = new MySimpleTextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s= e.getActionCommand();
        if(s=="Cut"){
           textarea.cut();
        }
        else if (s=="Paste") {
            textarea.paste();
        }
        else if (s=="Copy") {
            textarea.copy();
        }
        else if (s=="Save File") {
            JFileChooser fileChooser = new JFileChooser("C:");
            int ans= fileChooser.showOpenDialog(null);
            if(ans==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file,false));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.write(textarea.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (s=="Print File") {
            try {
                textarea.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (s=="Open File") {
            JFileChooser fileChooser =new JFileChooser("C:");
            int ans= fileChooser.showOpenDialog(null);
            if(ans==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try {
                    String s1="",s2="";
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while((s1=reader.readLine())!=null){
                        s2+=s1+"\n";
                    }
                     textarea.setText(s2);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (s=="New File") {
            JFileChooser fileChooser = new JFileChooser("C:");
            int ans= fileChooser.showOpenDialog(null);
            if(ans==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file,false));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.write(textarea.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            textarea.setText("");
        }
        else if (s=="Close"){
            frame.setVisible(false);
        }
        else if(s=="Black"){
            textarea.setBackground(Color.BLACK);
        }
        else if(s=="Yellow"){
            textarea.setBackground(Color.YELLOW);
        }
        else if(s=="Red"){
            textarea.setBackground(Color.RED);
        }
        else if(s=="Green"){
            textarea.setBackground(Color.GREEN);
        }
        else if(s=="White"){
            textarea.setBackground(Color.white);
        }
        else if(s=="Cyan"){
            textarea.setBackground(Color.cyan);
            menuBar.setBackground(Color.white);
        }
        else if(s=="Pink"){
            textarea.setBackground(Color.pink);
        }
        else if (s=="Plain") {
            textarea.setFont(new Font("Verdana", Font.PLAIN, font_size));
        }
        else if (s=="Bold") {
            textarea.setFont(new Font("Verdana", Font.BOLD, font_size));
        }
        else if (s=="Italic") {
            textarea.setFont(new Font("Verdana", Font.ITALIC, font_size));
        }
        else if (s=="Increase by 1") {
            textarea.setFont(new Font("Verdana", Font.PLAIN, ++font_size));
        }
        else if (s=="Decrease by 1") {
            textarea.setFont(new Font("Verdana", Font.PLAIN, --font_size));
        }

    }
}

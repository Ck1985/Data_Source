package networkStreams.urlViewer;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;
import outputStreams.JStreamedTextArea;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class URLViewer extends JFrame implements ActionListener {
    private JTextField theURL = new JTextField();
    private JButton loadButton = new JButton("Load");
    private JStreamedTextArea theDisplay = new JStreamedTextArea(60,72);
    public URLViewer() {
        super("URL Viewer");
        this.getContentPane().add(BorderLayout.NORTH,theURL);
        JScrollPane pane = new JScrollPane(theDisplay);
        this.getContentPane().add(BorderLayout.CENTER,pane);
        Panel south = new Panel();
        south.add(loadButton);
        this.getContentPane().add(BorderLayout.SOUTH,south);
        theURL.addActionListener(this);
        loadButton.addActionListener(this);
        this.setLocation(50,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    public void actionPerformed(ActionEvent event) {
        try {
            URL url = new URL(theURL.getText());
            InputStream input = url.openStream();
            OutputStream output = theDisplay.getOutput();
            theDisplay.setText(" ");
            for (int c = input.read(); c != -1; c = input.read()) {
                output.write(c);
            }
            input.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    public static void main(String[] args) {
        final URLViewer me = new URLViewer();
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                me.show();
            }
        });
    }
}

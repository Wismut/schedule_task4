package com.tasker.database;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class TestFrame extends JFrame {

    public void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        /*String[] columnNames = {
                "ID",
                "Time",
                "Path"
        };

        String[][] data = {
                {"", "", ""},
        };*/

        DefaultTableModel myModel = new DefaultTableModel();
        JTable myTable = new JTable(myModel);
        Vector newRow = new Vector();
        // Добавляем новую строку
        myModel.getDataVector().add(newRow);
        // Метод выравнивает добавленную строку по ширине таблицы и оповещает всех
        // слушателей о том что таблица изменилась.
        myModel.newRowsAdded(new TableModelEvent(myModel));


        JButton BtnExe = new JButton("Add exe file");
        BtnExe.setAlignmentY(LEFT_ALIGNMENT);

        JButton BtnOK = new JButton("OK");
        BtnOK.setAlignmentY(CENTER_ALIGNMENT);

        JButton BtnDEL = new JButton("Delete");
        BtnDEL.setAlignmentY(RIGHT_ALIGNMENT);


        //JTable table = new JTable(data, columnNames);

        //JScrollPane scrollPane = new JScrollPane(table);

        BtnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });


        //mainPanel.add(scrollPane);
        mainPanel.add(BtnExe);
        mainPanel.add(BtnOK);
        mainPanel.add(BtnDEL);
        frame.add(mainPanel);
        frame.setPreferredSize(new Dimension(600, 250));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //setPreferredSize(new Dimension(400, 160));
    }

    /*public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame testFrame = new TestFrame();
                testFrame.createGUI();
            }
        });
    }*/
}


package com.tasker.database;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Time;
import java.util.Date;

import javax.swing.*;

public class InputWindow extends JFrame {
    int id = 0;
    String path = "";
    String time = "";

    public InputWindow() {
        super("Select the file and time");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel_table = new JPanel();
        panel_table.setLayout(new BoxLayout(panel_table, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel path_program = new JLabel();
        path_program.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(path_program);

        String[] columnNames = {
                "ID",
                "Time",
                "Path"
        };

        String[][] data = {
                {"", "", ""},

        };

        JTable table_task = new JTable(data, columnNames);
        //panel_table.add(table_task);

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        final JTextField start_date = new JTextField();

        final JLabel format_time = new JLabel("Please, insert time in the format HH:MM:SS");
        format_time.setAlignmentX(CENTER_ALIGNMENT);

        JButton BtnExe = new JButton("Add exe file");
        BtnExe.setAlignmentX(CENTER_ALIGNMENT);

        JButton BtnDelete = new JButton("Clear all data");
        BtnExe.setAlignmentX(CENTER_ALIGNMENT);

        JButton BtnAdd = new JButton("OK");
        BtnAdd.setAlignmentX(CENTER_ALIGNMENT);

        BtnExe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    path_program.setText(file.getAbsolutePath());
                }
            }
        });

        BtnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataBase db = new DataBase();
                db.ClearDB();
            }
        });

        BtnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataBase dataBase = new DataBase();
                try {
                    dataBase.InsertData(path_program.getText(), Time.valueOf(start_date.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Incorrect time", "Warning!", JOptionPane.INFORMATION_MESSAGE);
                }
                int hh_temp  = Time.valueOf(start_date.getText()).getHours();
                int mm_temp  = Time.valueOf(start_date.getText()).getMinutes();
                int ss_temp  = Time.valueOf(start_date.getText()).getSeconds();
                long milliseconds_before_start = (hh_temp * 3600 + mm_temp * 60 + ss_temp) * 1000;
                long current_millisecond = (new Date().getHours() * 3600 + new Date().getMinutes() * 60 + new Date().getSeconds()) * 1000;
                new RunPrograms(milliseconds_before_start - current_millisecond, path_program.getText());
            }
        });

        panel.add(BtnExe);
        panel.add(format_time);
        panel.add(start_date);
        panel.add(BtnAdd);
        panel.add(BtnDelete);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);
        //getContentPane().add(panel_table);

        setPreferredSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void runWindow() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new InputWindow();
            }
        });
    }
}

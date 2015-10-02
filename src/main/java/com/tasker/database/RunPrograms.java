package com.tasker.database;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class RunPrograms {
    Timer timer;

    public RunPrograms(long time_to_start, String path) {
        timer = new Timer();
        timer.schedule(new AlarmTask(path), time_to_start);
        System.out.println(time_to_start);
    }

    public class AlarmTask extends TimerTask {
        String path;

        public AlarmTask(String path) {
            this.path = path;
        }

        public void run() {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }

            try {
                desktop.open(new File(path));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            timer.cancel();
        }
    }
}


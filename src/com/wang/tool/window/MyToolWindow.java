package com.wang.tool.window;

import com.intellij.openapi.wm.ToolWindow;
import com.wang.dialog.wrapper.SampleDialogWrapper;

import javax.swing.*;
import java.util.Calendar;

public class MyToolWindow {

    private JButton refreshToolWindowButton;
    private JButton hideToolWindowButton;
    private JLabel currentDate;
    private JLabel currentTime;
    private JLabel timeZone;
    private JPanel myToolWindowContent;
    private JButton dialog;

    public MyToolWindow(ToolWindow toolWindow) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        refreshToolWindowButton.addActionListener(e -> currentTime());
        dialog.addActionListener(actionEvent -> {
            if (new SampleDialogWrapper().showAndGet()) {
            }
        });
    }


    public void currentTime() {
        Calendar instance = Calendar.getInstance();
        currentDate.setText(instance.get(Calendar.DAY_OF_MONTH) + "/" + (instance.get(Calendar.MONTH) + 1) + "/" + instance.get(Calendar.YEAR));
        currentDate.setIcon(new ImageIcon(getClass().getResource("/toolWindow/Calendar-icon.png")));
        int min = instance.get(Calendar.MINUTE);
        String strMin = min < 10 ? "0" + min : String.valueOf(min);
        currentTime.setText(instance.get(Calendar.HOUR_OF_DAY) + ":" + strMin);
        currentTime.setIcon(new ImageIcon(getClass().getResource("/toolWindow/Time-icon.png")));

        long gmt_Offset = instance.get(Calendar.ZONE_OFFSET);
        String str_gmt_Offset = String.valueOf(gmt_Offset / 3600000);
        str_gmt_Offset = (gmt_Offset > 0) ? "GMT + " + str_gmt_Offset : "GMT - " + str_gmt_Offset;
        timeZone.setText(str_gmt_Offset);
        timeZone.setIcon(new ImageIcon(getClass().getResource("/toolWindow/Time-zone-icon.png")));
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}

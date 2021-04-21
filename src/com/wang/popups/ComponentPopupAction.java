package com.wang.popups;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ComponentPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        JButton button = new JButton("提交");

        panel.add(button, BorderLayout.CENTER);
        ComponentPopupBuilder componentPopupBuilder = JBPopupFactory.getInstance().createComponentPopupBuilder(panel, textField);
        JBPopup popup = componentPopupBuilder.createPopup();
        button.addActionListener(action -> {
            System.out.println("单击提交按钮 text: " + textField.getText());
            popup.cancel();
        });
        popup.setRequestFocus(true);
        popup.showInBestPositionFor(e.getDataContext());
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean valueIsAdjusting = e.getValueIsAdjusting();
        System.out.println("firstIndex:" + firstIndex);
        System.out.println("lastIndex:" + lastIndex);
        System.out.println("valueIsAdjusting:" + valueIsAdjusting);
    }


    @Override
    public void onClosed(@NotNull LightweightWindowEvent event) {
        JBPopup jbPopup = event.asPopup();
        System.out.println("关闭popup");
        jbPopup.cancel();
    }
}

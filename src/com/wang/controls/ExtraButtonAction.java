package com.wang.controls;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.components.JBList;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ExtraButtonAction extends AnActionButton {

    private JBList jbList;

    private DefaultListModel<Integer> model;

    public ExtraButtonAction(DefaultListModel<Integer> model, JBList list) {
        super("edit action");
        this.jbList = list;
        this.model = model;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        int index = jbList.getSelectedIndex();
        String newValue = Messages.showInputDialog(model.get(index) + "", "Edit", Messages.getInformationIcon());
        if (StringUtils.isNotBlank(newValue)) {
            model.removeElementAt(index);
            model.add(index, Integer.valueOf(newValue));
        }
    }
}

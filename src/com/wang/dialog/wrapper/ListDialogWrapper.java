package com.wang.dialog.wrapper;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.ListSpeedSearch;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import com.wang.action.ExtraButtonAction;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class ListDialogWrapper extends DialogWrapper {

    private JBList<Integer> jbList;

    private DefaultListModel<Integer> defaultListModel;

    public ListDialogWrapper() {
        super(true);
        init();
        setTitle("JBList");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        defaultListModel = new DefaultListModel<>();
        for (int i = 0; i < 10; i++) {
            defaultListModel.addElement(i);
        }
        jbList = new JBList<>(defaultListModel);
        ColoredListCellRenderer<Integer> coloredListCellRenderer = new ColoredListCellRenderer<>() {
            @Override
            protected void customizeCellRenderer(@NotNull JList<? extends Integer> list, Integer value, int index, boolean selected, boolean hasFocus) {
                append(value + "-suffix");
            }
        };
        jbList.setCellRenderer(coloredListCellRenderer);

        new ListSpeedSearch<>(jbList);

        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(jbList);
        decorator.setAddAction(anActionButton -> addAction());
        decorator.addExtraAction(new ExtraButtonAction(defaultListModel, jbList));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(decorator.createPanel(), BorderLayout.CENTER);
        return panel;
    }

    private void addAction() {
        String newItem = Messages.showInputDialog("Input A Item", "Add", Messages.getInformationIcon());
        if (StringUtils.isNotBlank(newItem)) {
            defaultListModel.addElement(Integer.valueOf(newItem));
        }
    }

    @Override
    protected ValidationInfo doValidate() {
        Integer value = jbList.getSelectedValue();
        if (value != null) {
            Messages.showInputDialog(String.valueOf(value), String.valueOf(value), Messages.getInformationIcon());
        }
        return null;
    }
}

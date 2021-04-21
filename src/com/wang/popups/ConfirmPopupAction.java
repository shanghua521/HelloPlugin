package com.wang.popups;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConfirmPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 确认类型 popup ，展示两个选项，对应执行两种操作 TODO 这里不知道为什么选中其中一个之后必定会先弹出no信息框
        ListPopup confirmation = JBPopupFactory.getInstance().createConfirmation("confirm", "yes", "no",
                () -> Messages.showMessageDialog("yes", "yes", Messages.getInformationIcon()),
                () -> Messages.showMessageDialog("no", "no", Messages.getInformationIcon()), 0);
        confirmation.addListener(this);
        confirmation.addListSelectionListener(this);
        confirmation.showInBestPositionFor(e.getDataContext());
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
        jbPopup.dispose();
        Messages.showMessageDialog("nonono", "nonono", Messages.getInformationIcon());
//        jbPopup.cancel();
    }

}

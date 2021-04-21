package com.wang.popups;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionGroupPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // action 被选中，触发 actionPerformed 方法
        DefaultActionGroup actionGroup = (DefaultActionGroup) ActionManager.getInstance().getAction("popupGroup");
        ListPopup listPopup = JBPopupFactory.getInstance().createActionGroupPopup("popup", actionGroup, e.getDataContext(), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false);
        listPopup.showInFocusCenter();
        listPopup.addListSelectionListener(this);
        listPopup.addListener(this);
    }

    /**
     * 值改变事件监听，通过上下键选择时，可以通过 getFirstIndex 获取第一个选择的元素的索引，通过getLastIndex获取最后一个选择的元素的索引
     *
     * @param e
     */
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
//        jbPopup.cancel();
    }
}

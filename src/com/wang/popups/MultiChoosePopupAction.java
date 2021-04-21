package com.wang.popups;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.IPopupChooserBuilder;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiChoosePopupAction extends AnAction implements ListSelectionListener {


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        IPopupChooserBuilder<String> popupChooserBuilder = JBPopupFactory.getInstance().createPopupChooserBuilder(Stream.of("value1", "value2").collect(Collectors.toList()));
        JBPopup popup = popupChooserBuilder.createPopup();
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
}

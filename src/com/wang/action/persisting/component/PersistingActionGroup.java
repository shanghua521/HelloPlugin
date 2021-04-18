package com.wang.action.persisting.component;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wang.action.SdkIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PersistingActionGroup extends ActionGroup {
    @NotNull
    @Override
    public AnAction[] getChildren(@Nullable AnActionEvent e) {
        return new AnAction[]{new PersistingSetAction("持久性 set 值", "持久性 set 值", SdkIcons.DEFAULT_ICON),
                new PersistingGetAction("持久性 get 值", "持久性 get 值", SdkIcons.DEFAULT_ICON)};
    }
}

package com.wang.editor.hint;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

public class HintNotificationAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        HintManager.getInstance().showErrorHint(CommonDataKeys.EDITOR.getData(e.getDataContext()), "错误消息");
        NotificationGroup notificationGroup = new NotificationGroup("notificationGroup", NotificationDisplayType.NONE,true);
        Notification notification = notificationGroup.createNotification();
        notification.setContent("notification");
        Notifications.Bus.notify(notification);

        Notification infoNotification = notificationGroup.createNotification(NotificationType.INFORMATION);
        infoNotification.setContent("info");
        Notifications.Bus.notify(infoNotification);

        Notification errorNotification = notificationGroup.createNotification("error",NotificationType.ERROR);
        Notifications.Bus.notify(errorNotification);

    }
}

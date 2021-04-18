package com.wang.message;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

public class MyNotifier {

    public static final String GROUP = "Fredis";
    public static final String NO_TEXT = "未选中任何文本";
    public static final NotificationType NO_TEXT_TYPE = NotificationType.ERROR;

    public static void notifyUser(Project project, String content) {
//        NotificationGroup notificationGroup = new NotificationGroup(GROUP, NotificationDisplayType.BALLOON,true);
        NotificationGroupManager.getInstance().getNotificationGroup(GROUP)
                .createNotification(content, NotificationType.INFORMATION)
                .notify(project);

    }

}

package com.wang.action.service;

import com.intellij.openapi.components.*;
import com.intellij.openapi.components.State;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "MyServiceOne", storages = @Storage("myserviceOne.xml"))
//@Storage(StoragePathMacros.WORKSPACE_FILE)
public class MyServiceOne implements PersistentStateComponent<MyServiceOne> {

    public String stateValue;

    @Override
    public @Nullable
    MyServiceOne getState() {
        return this;
    }

    public void loadState(@NotNull MyServiceOne state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static MyServiceOne getInstance() {
        return ServiceManager.getService(MyServiceOne.class);
    }
}

package com.wang.action.service;

import com.intellij.openapi.components.*;
import com.intellij.openapi.components.State;
import com.intellij.util.xmlb.annotations.OptionTag;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Objects;

@State(name = "MyService", storages = @Storage("myservice.xml"))
public class MyService implements PersistentStateComponent<MyService.State> {
    public static class State {
        public String value;
        @OptionTag(converter = LocalDateTimeConverter.class)
        public LocalDateTime dateTime;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;

            return Objects.equals(value, state.value);
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    private State state = new State();

    @Override
    public @Nullable
    State getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull State state) {
        this.state = state;
    }

    public static MyService getInstance() {
        return ServiceManager.getService(MyService.class);
    }
}

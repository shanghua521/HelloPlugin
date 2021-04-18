package com.wang.action.service;

import com.intellij.util.xmlb.Converter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeConverter extends Converter<LocalDateTime> {

    @Override
    public @Nullable
    LocalDateTime fromString(@NotNull String value) {
        final long epochMilli = Long.parseLong(value);
        final ZoneId zoneId = ZoneId.systemDefault();
        return Instant.ofEpochMilli(epochMilli).atZone(zoneId).toLocalDateTime();
    }

    @Override
    public @Nullable
    String toString(@NotNull LocalDateTime value) {
        final ZoneId zoneId = ZoneId.systemDefault();
        final long toEpochMilli = value.atZone(zoneId).toInstant().toEpochMilli();
        return Long.toString(toEpochMilli);
    }
}

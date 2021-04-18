package com.wang.action.service;

import com.intellij.util.xmlb.annotations.OptionTag;

import java.time.LocalDateTime;

public class State {
    @OptionTag(converter = LocalDateTimeConverter.class)
    public LocalDateTime dateTime;
}

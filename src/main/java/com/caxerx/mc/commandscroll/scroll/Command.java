package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public abstract class Command implements Executable {
    @Setter(AccessLevel.PROTECTED)
    private String command;
}

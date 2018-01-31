package com.caxerx.mc.commandscroll.scroll;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Scroll {
    @Setter(AccessLevel.PRIVATE)
    private String name;

    public Scroll(String name) {
        this.name = name;
    }
}

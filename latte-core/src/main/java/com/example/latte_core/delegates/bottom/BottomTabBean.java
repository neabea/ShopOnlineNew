package com.example.latte_core.delegates.bottom;

public final class BottomTabBean {
    private final CharSequence ICON;
    private final CharSequence TITLE;

    public CharSequence getICON() {
        return ICON;
    }

    public CharSequence getTITLE() {
        return TITLE;
    }

    public BottomTabBean(CharSequence ICON, CharSequence TITLE) {
        this.ICON = ICON;
        this.TITLE = TITLE;
    }



}

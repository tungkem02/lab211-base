package model;

import constants.Base;

public class BaseNumber {

    private Base base;
    private String presentation;

    public BaseNumber(Base base, String presentation) {
        this.base = base;
        this.presentation = presentation;
    }

    public Base getBase() {
        return base;
    }

    public String getPresentation() {
        return presentation;
    }
}
package dto;

import constants.Base;

public class BaseDTO {

    private Base sourceBase;
    private String presentation;
    private Base targetBase;

    public Base getSourceBase() {
        return sourceBase;
    }

    public void setSourceBase(Base sourceBase) {
        this.sourceBase = sourceBase;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Base getTargetBase() {
        return targetBase;
    }

    public void setTargetBase(Base targetBase) {
        this.targetBase = targetBase;
    }
}
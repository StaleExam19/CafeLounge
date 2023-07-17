package com.syntaxerror.cafelounge.util;

public class BtnLink {
    private String href = "";
    private String label = "";
    private boolean active = false;

    public BtnLink(String href, String label) {
        this.href = href;
        this.label = label;
    }

    public BtnLink(String href, String label, boolean active) {
        this.href = href;
        this.label = label;
        this.active = active;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getHref() {
        return href;
    }

    public String getLabel() {
        return label;
    }

    public boolean isActive() {
        return active;
    }    
}

package org.apache.tools.ant;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UnsupportedElementException extends BuildException {
    private String element;

    public UnsupportedElementException(String str, String str2) {
        super(str);
        this.element = str2;
    }

    public String getElement() {
        return this.element;
    }
}

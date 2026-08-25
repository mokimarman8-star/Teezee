package org.apache.tools.ant;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class UnsupportedAttributeException extends BuildException {
    private String attribute;

    public UnsupportedAttributeException(String str, String str2) {
        super(str);
        this.attribute = str2;
    }

    public String getAttribute() {
        return this.attribute;
    }
}

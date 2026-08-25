package com.transsnet.loginapi.bean;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class SearchFilter implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract char getAlpha(String str);

    public abstract String getFullSpell(String str);

    public abstract String getInputString(String str);
}

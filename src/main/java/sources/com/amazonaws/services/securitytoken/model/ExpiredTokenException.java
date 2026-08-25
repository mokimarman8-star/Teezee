package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ExpiredTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ExpiredTokenException(String str) {
        super(str);
    }
}

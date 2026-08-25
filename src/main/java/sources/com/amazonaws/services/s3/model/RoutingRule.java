package com.amazonaws.services.s3.model;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class RoutingRule {
    RoutingRuleCondition a;
    RedirectRule b;

    public void a(RoutingRuleCondition routingRuleCondition) {
        this.a = routingRuleCondition;
    }

    public void b(RedirectRule redirectRule) {
        this.b = redirectRule;
    }
}

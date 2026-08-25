package org.jsoup.parser;

import org.jsoup.parser.Token;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
enum TokeniserState {
    Data { // from class: org.jsoup.parser.TokeniserState.1
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                hVar.i(aVar.d());
            } else {
                if (q == '&') {
                    hVar.a(TokeniserState.CharacterReferenceInData);
                    return;
                }
                if (q == '<') {
                    hVar.a(TokeniserState.TagOpen);
                } else if (q != 65535) {
                    hVar.j(aVar.e());
                } else {
                    hVar.k(new Token.f());
                }
            }
        }
    },
    CharacterReferenceInData { // from class: org.jsoup.parser.TokeniserState.2
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readCharRef(hVar, TokeniserState.Data);
        }
    },
    Rcdata { // from class: org.jsoup.parser.TokeniserState.3
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                aVar.a();
                hVar.i(TokeniserState.replacementChar);
            } else {
                if (q == '&') {
                    hVar.a(TokeniserState.CharacterReferenceInRcdata);
                    return;
                }
                if (q == '<') {
                    hVar.a(TokeniserState.RcdataLessthanSign);
                } else if (q != 65535) {
                    hVar.j(aVar.m('&', '<', TokeniserState.nullChar));
                } else {
                    hVar.k(new Token.f());
                }
            }
        }
    },
    CharacterReferenceInRcdata { // from class: org.jsoup.parser.TokeniserState.4
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readCharRef(hVar, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: org.jsoup.parser.TokeniserState.5
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readData(hVar, aVar, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: org.jsoup.parser.TokeniserState.6
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readData(hVar, aVar, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: org.jsoup.parser.TokeniserState.7
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                aVar.a();
                hVar.i(TokeniserState.replacementChar);
            } else if (q != 65535) {
                hVar.j(aVar.k(TokeniserState.nullChar));
            } else {
                hVar.k(new Token.f());
            }
        }
    },
    TagOpen { // from class: org.jsoup.parser.TokeniserState.8
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == '!') {
                hVar.a(TokeniserState.MarkupDeclarationOpen);
                return;
            }
            if (q == '/') {
                hVar.a(TokeniserState.EndTagOpen);
                return;
            }
            if (q == '?') {
                hVar.a(TokeniserState.BogusComment);
                return;
            }
            if (aVar.C()) {
                hVar.g(true);
                hVar.u(TokeniserState.TagName);
            } else {
                hVar.r(this);
                hVar.i('<');
                hVar.u(TokeniserState.Data);
            }
        }
    },
    EndTagOpen { // from class: org.jsoup.parser.TokeniserState.9
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.r()) {
                hVar.p(this);
                hVar.j("</");
                hVar.u(TokeniserState.Data);
            } else if (aVar.C()) {
                hVar.g(false);
                hVar.u(TokeniserState.TagName);
            } else if (aVar.w('>')) {
                hVar.r(this);
                hVar.a(TokeniserState.Data);
            } else {
                hVar.r(this);
                hVar.a(TokeniserState.BogusComment);
            }
        }
    },
    TagName { // from class: org.jsoup.parser.TokeniserState.10
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            hVar.i.v(aVar.j());
            char d = aVar.d();
            if (d == 0) {
                hVar.i.v(TokeniserState.replacementStr);
                return;
            }
            if (d != ' ') {
                if (d == '/') {
                    hVar.u(TokeniserState.SelfClosingStartTag);
                    return;
                }
                if (d == '>') {
                    hVar.o();
                    hVar.u(TokeniserState.Data);
                    return;
                } else if (d == 65535) {
                    hVar.p(this);
                    hVar.u(TokeniserState.Data);
                    return;
                } else if (d != '\t' && d != '\n' && d != '\f' && d != '\r') {
                    hVar.i.u(d);
                    return;
                }
            }
            hVar.u(TokeniserState.BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: org.jsoup.parser.TokeniserState.11
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.w('/')) {
                hVar.h();
                hVar.a(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (aVar.C() && hVar.b() != null) {
                if (!aVar.p("</" + hVar.b())) {
                    hVar.i = hVar.g(false).B(hVar.b());
                    hVar.o();
                    aVar.I();
                    hVar.u(TokeniserState.Data);
                    return;
                }
            }
            hVar.j("<");
            hVar.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen { // from class: org.jsoup.parser.TokeniserState.12
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.C()) {
                hVar.j("</");
                hVar.u(TokeniserState.Rcdata);
            } else {
                hVar.g(false);
                hVar.i.u(aVar.q());
                hVar.h.append(aVar.q());
                hVar.a(TokeniserState.RCDATAEndTagName);
            }
        }
    },
    RCDATAEndTagName { // from class: org.jsoup.parser.TokeniserState.13
        private void anythingElse(h hVar, a aVar) {
            hVar.j("</" + hVar.h.toString());
            aVar.I();
            hVar.u(TokeniserState.Rcdata);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.C()) {
                String h = aVar.h();
                hVar.i.v(h);
                hVar.h.append(h);
                return;
            }
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                if (hVar.s()) {
                    hVar.u(TokeniserState.BeforeAttributeName);
                    return;
                } else {
                    anythingElse(hVar, aVar);
                    return;
                }
            }
            if (d == '/') {
                if (hVar.s()) {
                    hVar.u(TokeniserState.SelfClosingStartTag);
                    return;
                } else {
                    anythingElse(hVar, aVar);
                    return;
                }
            }
            if (d != '>') {
                anythingElse(hVar, aVar);
            } else if (!hVar.s()) {
                anythingElse(hVar, aVar);
            } else {
                hVar.o();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    RawtextLessthanSign { // from class: org.jsoup.parser.TokeniserState.14
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.w('/')) {
                hVar.h();
                hVar.a(TokeniserState.RawtextEndTagOpen);
            } else {
                hVar.i('<');
                hVar.u(TokeniserState.Rawtext);
            }
        }
    },
    RawtextEndTagOpen { // from class: org.jsoup.parser.TokeniserState.15
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readEndTag(hVar, aVar, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: org.jsoup.parser.TokeniserState.16
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.handleDataEndTag(hVar, aVar, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: org.jsoup.parser.TokeniserState.17
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '!') {
                hVar.j("<!");
                hVar.u(TokeniserState.ScriptDataEscapeStart);
            } else if (d == '/') {
                hVar.h();
                hVar.u(TokeniserState.ScriptDataEndTagOpen);
            } else {
                hVar.j("<");
                aVar.I();
                hVar.u(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: org.jsoup.parser.TokeniserState.18
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.readEndTag(hVar, aVar, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: org.jsoup.parser.TokeniserState.19
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.handleDataEndTag(hVar, aVar, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: org.jsoup.parser.TokeniserState.20
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.w('-')) {
                hVar.u(TokeniserState.ScriptData);
            } else {
                hVar.i('-');
                hVar.a(TokeniserState.ScriptDataEscapeStartDash);
            }
        }
    },
    ScriptDataEscapeStartDash { // from class: org.jsoup.parser.TokeniserState.21
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.w('-')) {
                hVar.u(TokeniserState.ScriptData);
            } else {
                hVar.i('-');
                hVar.a(TokeniserState.ScriptDataEscapedDashDash);
            }
        }
    },
    ScriptDataEscaped { // from class: org.jsoup.parser.TokeniserState.22
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.r()) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
                return;
            }
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                aVar.a();
                hVar.i(TokeniserState.replacementChar);
            } else if (q == '-') {
                hVar.i('-');
                hVar.a(TokeniserState.ScriptDataEscapedDash);
            } else if (q != '<') {
                hVar.j(aVar.m('-', '<', TokeniserState.nullChar));
            } else {
                hVar.a(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash { // from class: org.jsoup.parser.TokeniserState.23
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.r()) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
                return;
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i(TokeniserState.replacementChar);
                hVar.u(TokeniserState.ScriptDataEscaped);
            } else if (d == '-') {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataEscapedDashDash);
            } else if (d == '<') {
                hVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
            } else {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.24
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.r()) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
                return;
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i(TokeniserState.replacementChar);
                hVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                if (d == '-') {
                    hVar.i(d);
                    return;
                }
                if (d == '<') {
                    hVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
                } else if (d != '>') {
                    hVar.i(d);
                    hVar.u(TokeniserState.ScriptDataEscaped);
                } else {
                    hVar.i(d);
                    hVar.u(TokeniserState.ScriptData);
                }
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.25
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.C()) {
                if (aVar.w('/')) {
                    hVar.h();
                    hVar.a(TokeniserState.ScriptDataEscapedEndTagOpen);
                    return;
                } else {
                    hVar.i('<');
                    hVar.u(TokeniserState.ScriptDataEscaped);
                    return;
                }
            }
            hVar.h();
            hVar.h.append(aVar.q());
            hVar.j("<" + aVar.q());
            hVar.a(TokeniserState.ScriptDataDoubleEscapeStart);
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: org.jsoup.parser.TokeniserState.26
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.C()) {
                hVar.j("</");
                hVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                hVar.g(false);
                hVar.i.u(aVar.q());
                hVar.h.append(aVar.q());
                hVar.a(TokeniserState.ScriptDataEscapedEndTagName);
            }
        }
    },
    ScriptDataEscapedEndTagName { // from class: org.jsoup.parser.TokeniserState.27
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.handleDataEndTag(hVar, aVar, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: org.jsoup.parser.TokeniserState.28
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.handleDataDoubleEscapeTag(hVar, aVar, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: org.jsoup.parser.TokeniserState.29
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                aVar.a();
                hVar.i(TokeniserState.replacementChar);
            } else if (q == '-') {
                hVar.i(q);
                hVar.a(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (q == '<') {
                hVar.i(q);
                hVar.a(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (q != 65535) {
                hVar.j(aVar.m('-', '<', TokeniserState.nullChar));
            } else {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: org.jsoup.parser.TokeniserState.30
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i(TokeniserState.replacementChar);
                hVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (d == '-') {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (d == '<') {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d != 65535) {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.31
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i(TokeniserState.replacementChar);
                hVar.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            if (d == '-') {
                hVar.i(d);
                return;
            }
            if (d == '<') {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d == '>') {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptData);
            } else if (d != 65535) {
                hVar.i(d);
                hVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.32
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (!aVar.w('/')) {
                hVar.u(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            hVar.i('/');
            hVar.h();
            hVar.a(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: org.jsoup.parser.TokeniserState.33
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            TokeniserState.handleDataDoubleEscapeTag(hVar, aVar, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: org.jsoup.parser.TokeniserState.34
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.C();
                aVar.I();
                hVar.u(TokeniserState.AttributeName);
                return;
            }
            if (d != ' ') {
                if (d != '\"' && d != '\'') {
                    if (d == '/') {
                        hVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (d == 65535) {
                        hVar.p(this);
                        hVar.u(TokeniserState.Data);
                        return;
                    }
                    if (d == '\t' || d == '\n' || d == '\f' || d == '\r') {
                        return;
                    }
                    switch (d) {
                        case com.vungle.ads.internal.b.TIMEOUT /* 60 */:
                        case '=':
                            break;
                        case '>':
                            hVar.o();
                            hVar.u(TokeniserState.Data);
                            break;
                        default:
                            hVar.i.C();
                            aVar.I();
                            hVar.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                hVar.r(this);
                hVar.i.C();
                hVar.i.p(d);
                hVar.u(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName { // from class: org.jsoup.parser.TokeniserState.35
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            hVar.i.q(aVar.n(TokeniserState.attributeNameCharsSorted));
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.p(TokeniserState.replacementChar);
                return;
            }
            if (d != ' ') {
                if (d != '\"' && d != '\'') {
                    if (d == '/') {
                        hVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (d == 65535) {
                        hVar.p(this);
                        hVar.u(TokeniserState.Data);
                        return;
                    }
                    if (d != '\t' && d != '\n' && d != '\f' && d != '\r') {
                        switch (d) {
                            case com.vungle.ads.internal.b.TIMEOUT /* 60 */:
                                break;
                            case '=':
                                hVar.u(TokeniserState.BeforeAttributeValue);
                                break;
                            case '>':
                                hVar.o();
                                hVar.u(TokeniserState.Data);
                                break;
                            default:
                                hVar.i.p(d);
                                break;
                        }
                        return;
                    }
                }
                hVar.r(this);
                hVar.i.p(d);
                return;
            }
            hVar.u(TokeniserState.AfterAttributeName);
        }
    },
    AfterAttributeName { // from class: org.jsoup.parser.TokeniserState.36
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.p(TokeniserState.replacementChar);
                hVar.u(TokeniserState.AttributeName);
                return;
            }
            if (d != ' ') {
                if (d != '\"' && d != '\'') {
                    if (d == '/') {
                        hVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (d == 65535) {
                        hVar.p(this);
                        hVar.u(TokeniserState.Data);
                        return;
                    }
                    if (d == '\t' || d == '\n' || d == '\f' || d == '\r') {
                        return;
                    }
                    switch (d) {
                        case com.vungle.ads.internal.b.TIMEOUT /* 60 */:
                            break;
                        case '=':
                            hVar.u(TokeniserState.BeforeAttributeValue);
                            break;
                        case '>':
                            hVar.o();
                            hVar.u(TokeniserState.Data);
                            break;
                        default:
                            hVar.i.C();
                            aVar.I();
                            hVar.u(TokeniserState.AttributeName);
                            break;
                    }
                    return;
                }
                hVar.r(this);
                hVar.i.C();
                hVar.i.p(d);
                hVar.u(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue { // from class: org.jsoup.parser.TokeniserState.37
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.r(TokeniserState.replacementChar);
                hVar.u(TokeniserState.AttributeValue_unquoted);
                return;
            }
            if (d != ' ') {
                if (d == '\"') {
                    hVar.u(TokeniserState.AttributeValue_doubleQuoted);
                    return;
                }
                if (d != '`') {
                    if (d == 65535) {
                        hVar.p(this);
                        hVar.o();
                        hVar.u(TokeniserState.Data);
                        return;
                    }
                    if (d == '\t' || d == '\n' || d == '\f' || d == '\r') {
                        return;
                    }
                    if (d == '&') {
                        aVar.I();
                        hVar.u(TokeniserState.AttributeValue_unquoted);
                        return;
                    }
                    if (d == '\'') {
                        hVar.u(TokeniserState.AttributeValue_singleQuoted);
                        return;
                    }
                    switch (d) {
                        case com.vungle.ads.internal.b.TIMEOUT /* 60 */:
                        case '=':
                            break;
                        case '>':
                            hVar.r(this);
                            hVar.o();
                            hVar.u(TokeniserState.Data);
                            break;
                        default:
                            aVar.I();
                            hVar.u(TokeniserState.AttributeValue_unquoted);
                            break;
                    }
                    return;
                }
                hVar.r(this);
                hVar.i.r(d);
                hVar.u(TokeniserState.AttributeValue_unquoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.38
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            String m = aVar.m(TokeniserState.attributeDoubleValueCharsSorted);
            if (m.length() > 0) {
                hVar.i.s(m);
            } else {
                hVar.i.F();
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.r(TokeniserState.replacementChar);
                return;
            }
            if (d == '\"') {
                hVar.u(TokeniserState.AfterAttributeValue_quoted);
                return;
            }
            if (d != '&') {
                if (d != 65535) {
                    hVar.i.r(d);
                    return;
                } else {
                    hVar.p(this);
                    hVar.u(TokeniserState.Data);
                    return;
                }
            }
            int[] d2 = hVar.d('\"', true);
            if (d2 != null) {
                hVar.i.t(d2);
            } else {
                hVar.i.r('&');
            }
        }
    },
    AttributeValue_singleQuoted { // from class: org.jsoup.parser.TokeniserState.39
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            String m = aVar.m(TokeniserState.attributeSingleValueCharsSorted);
            if (m.length() > 0) {
                hVar.i.s(m);
            } else {
                hVar.i.F();
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.r(TokeniserState.replacementChar);
                return;
            }
            if (d == 65535) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != '&') {
                if (d != '\'') {
                    hVar.i.r(d);
                    return;
                } else {
                    hVar.u(TokeniserState.AfterAttributeValue_quoted);
                    return;
                }
            }
            int[] d2 = hVar.d('\'', true);
            if (d2 != null) {
                hVar.i.t(d2);
            } else {
                hVar.i.r('&');
            }
        }
    },
    AttributeValue_unquoted { // from class: org.jsoup.parser.TokeniserState.40
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            String n = aVar.n(TokeniserState.attributeValueUnquoted);
            if (n.length() > 0) {
                hVar.i.s(n);
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.i.r(TokeniserState.replacementChar);
                return;
            }
            if (d != ' ') {
                if (d != '\"' && d != '`') {
                    if (d == 65535) {
                        hVar.p(this);
                        hVar.u(TokeniserState.Data);
                        return;
                    }
                    if (d != '\t' && d != '\n' && d != '\f' && d != '\r') {
                        if (d == '&') {
                            int[] d2 = hVar.d('>', true);
                            if (d2 != null) {
                                hVar.i.t(d2);
                                return;
                            } else {
                                hVar.i.r('&');
                                return;
                            }
                        }
                        if (d != '\'') {
                            switch (d) {
                                case com.vungle.ads.internal.b.TIMEOUT /* 60 */:
                                case '=':
                                    break;
                                case '>':
                                    hVar.o();
                                    hVar.u(TokeniserState.Data);
                                    break;
                                default:
                                    hVar.i.r(d);
                                    break;
                            }
                            return;
                        }
                    }
                }
                hVar.r(this);
                hVar.i.r(d);
                return;
            }
            hVar.u(TokeniserState.BeforeAttributeName);
        }
    },
    AfterAttributeValue_quoted { // from class: org.jsoup.parser.TokeniserState.41
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(TokeniserState.BeforeAttributeName);
                return;
            }
            if (d == '/') {
                hVar.u(TokeniserState.SelfClosingStartTag);
                return;
            }
            if (d == '>') {
                hVar.o();
                hVar.u(TokeniserState.Data);
            } else if (d == 65535) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
            } else {
                hVar.r(this);
                aVar.I();
                hVar.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    SelfClosingStartTag { // from class: org.jsoup.parser.TokeniserState.42
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '>') {
                hVar.i.i = true;
                hVar.o();
                hVar.u(TokeniserState.Data);
            } else if (d == 65535) {
                hVar.p(this);
                hVar.u(TokeniserState.Data);
            } else {
                hVar.r(this);
                aVar.I();
                hVar.u(TokeniserState.BeforeAttributeName);
            }
        }
    },
    BogusComment { // from class: org.jsoup.parser.TokeniserState.43
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            aVar.I();
            Token.d dVar = new Token.d();
            dVar.c = true;
            dVar.b.append(aVar.k('>'));
            hVar.k(dVar);
            hVar.a(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen { // from class: org.jsoup.parser.TokeniserState.44
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.u("--")) {
                hVar.e();
                hVar.u(TokeniserState.CommentStart);
            } else if (aVar.v("DOCTYPE")) {
                hVar.u(TokeniserState.Doctype);
            } else if (aVar.u("[CDATA[")) {
                hVar.h();
                hVar.u(TokeniserState.CdataSection);
            } else {
                hVar.r(this);
                hVar.a(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart { // from class: org.jsoup.parser.TokeniserState.45
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.n.b.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.Comment);
                return;
            }
            if (d == '-') {
                hVar.u(TokeniserState.CommentStartDash);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else if (d != 65535) {
                hVar.n.b.append(d);
                hVar.u(TokeniserState.Comment);
            } else {
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    CommentStartDash { // from class: org.jsoup.parser.TokeniserState.46
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.n.b.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.Comment);
                return;
            }
            if (d == '-') {
                hVar.u(TokeniserState.CommentStartDash);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else if (d != 65535) {
                hVar.n.b.append(d);
                hVar.u(TokeniserState.Comment);
            } else {
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    Comment { // from class: org.jsoup.parser.TokeniserState.47
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char q = aVar.q();
            if (q == 0) {
                hVar.r(this);
                aVar.a();
                hVar.n.b.append(TokeniserState.replacementChar);
            } else if (q == '-') {
                hVar.a(TokeniserState.CommentEndDash);
            } else {
                if (q != 65535) {
                    hVar.n.b.append(aVar.m('-', TokeniserState.nullChar));
                    return;
                }
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: org.jsoup.parser.TokeniserState.48
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                StringBuilder sb = hVar.n.b;
                sb.append('-');
                sb.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.Comment);
                return;
            }
            if (d == '-') {
                hVar.u(TokeniserState.CommentEnd);
                return;
            }
            if (d == 65535) {
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else {
                StringBuilder sb2 = hVar.n.b;
                sb2.append('-');
                sb2.append(d);
                hVar.u(TokeniserState.Comment);
            }
        }
    },
    CommentEnd { // from class: org.jsoup.parser.TokeniserState.49
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                StringBuilder sb = hVar.n.b;
                sb.append("--");
                sb.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.Comment);
                return;
            }
            if (d == '!') {
                hVar.r(this);
                hVar.u(TokeniserState.CommentEndBang);
                return;
            }
            if (d == '-') {
                hVar.r(this);
                hVar.n.b.append('-');
                return;
            }
            if (d == '>') {
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else if (d == 65535) {
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else {
                hVar.r(this);
                StringBuilder sb2 = hVar.n.b;
                sb2.append("--");
                sb2.append(d);
                hVar.u(TokeniserState.Comment);
            }
        }
    },
    CommentEndBang { // from class: org.jsoup.parser.TokeniserState.50
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                StringBuilder sb = hVar.n.b;
                sb.append("--!");
                sb.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.Comment);
                return;
            }
            if (d == '-') {
                hVar.n.b.append("--!");
                hVar.u(TokeniserState.CommentEndDash);
                return;
            }
            if (d == '>') {
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else if (d == 65535) {
                hVar.p(this);
                hVar.m();
                hVar.u(TokeniserState.Data);
            } else {
                StringBuilder sb2 = hVar.n.b;
                sb2.append("--!");
                sb2.append(d);
                hVar.u(TokeniserState.Comment);
            }
        }
    },
    Doctype { // from class: org.jsoup.parser.TokeniserState.51
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (d != '>') {
                if (d != 65535) {
                    hVar.r(this);
                    hVar.u(TokeniserState.BeforeDoctypeName);
                    return;
                }
                hVar.p(this);
            }
            hVar.r(this);
            hVar.f();
            hVar.m.f = true;
            hVar.n();
            hVar.u(TokeniserState.Data);
        }
    },
    BeforeDoctypeName { // from class: org.jsoup.parser.TokeniserState.52
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.C()) {
                hVar.f();
                hVar.u(TokeniserState.DoctypeName);
                return;
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.f();
                hVar.m.b.append(TokeniserState.replacementChar);
                hVar.u(TokeniserState.DoctypeName);
                return;
            }
            if (d != ' ') {
                if (d == 65535) {
                    hVar.p(this);
                    hVar.f();
                    hVar.m.f = true;
                    hVar.n();
                    hVar.u(TokeniserState.Data);
                    return;
                }
                if (d == '\t' || d == '\n' || d == '\f' || d == '\r') {
                    return;
                }
                hVar.f();
                hVar.m.b.append(d);
                hVar.u(TokeniserState.DoctypeName);
            }
        }
    },
    DoctypeName { // from class: org.jsoup.parser.TokeniserState.53
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.C()) {
                hVar.m.b.append(aVar.h());
                return;
            }
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.m.b.append(TokeniserState.replacementChar);
                return;
            }
            if (d != ' ') {
                if (d == '>') {
                    hVar.n();
                    hVar.u(TokeniserState.Data);
                    return;
                }
                if (d == 65535) {
                    hVar.p(this);
                    hVar.m.f = true;
                    hVar.n();
                    hVar.u(TokeniserState.Data);
                    return;
                }
                if (d != '\t' && d != '\n' && d != '\f' && d != '\r') {
                    hVar.m.b.append(d);
                    return;
                }
            }
            hVar.u(TokeniserState.AfterDoctypeName);
        }
    },
    AfterDoctypeName { // from class: org.jsoup.parser.TokeniserState.54
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            if (aVar.r()) {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (aVar.y('\t', '\n', '\r', '\f', ' ')) {
                aVar.a();
                return;
            }
            if (aVar.w('>')) {
                hVar.n();
                hVar.a(TokeniserState.Data);
                return;
            }
            if (aVar.v("PUBLIC")) {
                hVar.m.c = "PUBLIC";
                hVar.u(TokeniserState.AfterDoctypePublicKeyword);
            } else if (aVar.v(com.transsion.usercenter.message.adapter.a.I)) {
                hVar.m.c = com.transsion.usercenter.message.adapter.a.I;
                hVar.u(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                hVar.r(this);
                hVar.m.f = true;
                hVar.a(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: org.jsoup.parser.TokeniserState.55
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(TokeniserState.BeforeDoctypePublicIdentifier);
                return;
            }
            if (d == '\"') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.56
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                return;
            }
            if (d == '\"') {
                hVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.57
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.m.d.append(TokeniserState.replacementChar);
                return;
            }
            if (d == '\"') {
                hVar.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.m.d.append(d);
                return;
            }
            hVar.p(this);
            hVar.m.f = true;
            hVar.n();
            hVar.u(TokeniserState.Data);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.58
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.m.d.append(TokeniserState.replacementChar);
                return;
            }
            if (d == '\'') {
                hVar.u(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.m.d.append(d);
                return;
            }
            hVar.p(this);
            hVar.m.f = true;
            hVar.n();
            hVar.u(TokeniserState.Data);
        }
    },
    AfterDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.59
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (d == '\"') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.n();
                hVar.u(TokeniserState.Data);
            } else if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: org.jsoup.parser.TokeniserState.60
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                return;
            }
            if (d == '\"') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.n();
                hVar.u(TokeniserState.Data);
            } else if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: org.jsoup.parser.TokeniserState.61
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(TokeniserState.BeforeDoctypeSystemIdentifier);
                return;
            }
            if (d == '\"') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.r(this);
                hVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.62
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                return;
            }
            if (d == '\"') {
                hVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (d == '\'') {
                hVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.r(this);
                hVar.m.f = true;
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.63
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.m.e.append(TokeniserState.replacementChar);
                return;
            }
            if (d == '\"') {
                hVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.m.e.append(d);
                return;
            }
            hVar.p(this);
            hVar.m.f = true;
            hVar.n();
            hVar.u(TokeniserState.Data);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.64
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == 0) {
                hVar.r(this);
                hVar.m.e.append(TokeniserState.replacementChar);
                return;
            }
            if (d == '\'') {
                hVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (d == '>') {
                hVar.r(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
                return;
            }
            if (d != 65535) {
                hVar.m.e.append(d);
                return;
            }
            hVar.p(this);
            hVar.m.f = true;
            hVar.n();
            hVar.u(TokeniserState.Data);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.65
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                return;
            }
            if (d == '>') {
                hVar.n();
                hVar.u(TokeniserState.Data);
            } else if (d != 65535) {
                hVar.r(this);
                hVar.u(TokeniserState.BogusDoctype);
            } else {
                hVar.p(this);
                hVar.m.f = true;
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    BogusDoctype { // from class: org.jsoup.parser.TokeniserState.66
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            char d = aVar.d();
            if (d == '>') {
                hVar.n();
                hVar.u(TokeniserState.Data);
            } else {
                if (d != 65535) {
                    return;
                }
                hVar.n();
                hVar.u(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: org.jsoup.parser.TokeniserState.67
        @Override // org.jsoup.parser.TokeniserState
        void read(h hVar, a aVar) {
            hVar.h.append(aVar.l("]]>"));
            if (aVar.u("]]>") || aVar.r()) {
                hVar.k(new Token.b(hVar.h.toString()));
                hVar.u(TokeniserState.Data);
            }
        }
    };

    private static final char eof = 65535;
    static final char nullChar = 0;
    static final char[] attributeSingleValueCharsSorted = {nullChar, '&', '\''};
    static final char[] attributeDoubleValueCharsSorted = {nullChar, '\"', '&'};
    static final char[] attributeNameCharsSorted = {nullChar, '\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};
    static final char[] attributeValueUnquoted = {nullChar, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf(replacementChar);

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.C()) {
            String h = aVar.h();
            hVar.h.append(h);
            hVar.j(h);
            return;
        }
        char d = aVar.d();
        if (d != '\t' && d != '\n' && d != '\f' && d != '\r' && d != ' ' && d != '/' && d != '>') {
            aVar.I();
            hVar.u(tokeniserState2);
        } else {
            if (hVar.h.toString().equals("script")) {
                hVar.u(tokeniserState);
            } else {
                hVar.u(tokeniserState2);
            }
            hVar.i(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(h hVar, a aVar, TokeniserState tokeniserState) {
        if (aVar.C()) {
            String h = aVar.h();
            hVar.i.v(h);
            hVar.h.append(h);
            return;
        }
        if (hVar.s() && !aVar.r()) {
            char d = aVar.d();
            if (d == '\t' || d == '\n' || d == '\f' || d == '\r' || d == ' ') {
                hVar.u(BeforeAttributeName);
                return;
            }
            if (d == '/') {
                hVar.u(SelfClosingStartTag);
                return;
            } else {
                if (d == '>') {
                    hVar.o();
                    hVar.u(Data);
                    return;
                }
                hVar.h.append(d);
            }
        }
        hVar.j("</" + hVar.h.toString());
        hVar.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(h hVar, TokeniserState tokeniserState) {
        int[] d = hVar.d(null, false);
        if (d == null) {
            hVar.i('&');
        } else {
            hVar.l(d);
        }
        hVar.u(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char q = aVar.q();
        if (q == 0) {
            hVar.r(tokeniserState);
            aVar.a();
            hVar.i(replacementChar);
        } else if (q == '<') {
            hVar.a(tokeniserState2);
        } else if (q != 65535) {
            hVar.j(aVar.m('<', nullChar));
        } else {
            hVar.k(new Token.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.C()) {
            hVar.g(false);
            hVar.u(tokeniserState);
        } else {
            hVar.j("</");
            hVar.u(tokeniserState2);
        }
    }

    abstract void read(h hVar, a aVar);
}

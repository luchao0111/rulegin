package com.github.rulegin.actors.msg.session;


import com.github.rulegin.common.data.id.SessionId;

public class SessionCloseMsg implements SessionCtrlMsg {

    private final SessionId sessionId;
    private final boolean revoked;
    private final boolean timeout;

    public static SessionCloseMsg onDisconnect(SessionId sessionId) {
        return new SessionCloseMsg(sessionId, false, false);
    }

    public static SessionCloseMsg onError(SessionId sessionId) {
        return new SessionCloseMsg(sessionId, false, false);
    }

    public static SessionCloseMsg onTimeout(SessionId sessionId) {
        return new SessionCloseMsg(sessionId, false, true);
    }

    public static SessionCloseMsg onCredentialsRevoked(SessionId sessionId) {
        return new SessionCloseMsg(sessionId, true, false);
    }

    private SessionCloseMsg(SessionId sessionId, boolean unauthorized, boolean timeout) {
        super();
        this.sessionId = sessionId;
        this.revoked = unauthorized;
        this.timeout = timeout;
    }

    @Override
    public SessionId getSessionId() {
        return sessionId;
    }

    public boolean isCredentialsRevoked() {
        return revoked;
    }

    public boolean isTimeout() {
        return timeout;
    }

}

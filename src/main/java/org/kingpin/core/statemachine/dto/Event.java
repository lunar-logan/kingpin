package org.kingpin.core.statemachine.dto;

import org.kingpin.core.trigger.Trigger;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    private static final long serialVersionUID = -5706590731475079657L;
    private Type type;
    private String prev;
    private String cur;
    private Date ts;
    private Trigger reason;
    private Integer seq;

    public enum Type {
        TRANSITION,
        EPHEMERAL_TRANSITION,
        TRIGGER_RECV
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Trigger getReason() {
        return reason;
    }

    public void setReason(Trigger reason) {
        this.reason = reason;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", prev='" + prev + '\'' +
                ", cur='" + cur + '\'' +
                ", ts=" + ts +
                ", reason=" + reason +
                ", seq=" + seq +
                '}';
    }
}

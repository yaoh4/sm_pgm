package gov.nih.nci.iscs.oracle.pgm.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LookUpObject implements Serializable {

    /** identifier field */
    private Object key;

    /** identifier field */
    private Object value;


    /** default constructor */
    public LookUpObject() {
    }


    /** default constructor */
    public LookUpObject(Object key, Object value) {
		this.key = key;
		this.value = value;

    }

    public Object getKey() {
        return this.key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }



    public String toString() {
        return new ToStringBuilder(this)
            .append("key ", getKey())
            .append("value ", getValue())
            .toString();
    }



}

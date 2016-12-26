package com.debtapp.javafx.objects;

/**
 * Created by Arizel on 25.12.2016.
 */
public abstract class Person {
    protected String name;
    protected long phone;
    protected String address;
    protected String vkId;
    protected String ip;

    public Person(String name, long phone, String address, String vkId, String ip) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.vkId = vkId;
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {

        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getVkId() {
        return vkId;
    }

    public String getIp() {
        return ip;
    }
}

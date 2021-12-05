package com.szhigajlo;

public class CallLog {
    private String name; // имя
    private String phoneNumber;//номер телефона
    private int callDuration; // second

    public CallLog(String name, String phoneNumber, int callDuration) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.callDuration = callDuration;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCallDuration() {
        return callDuration;
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", callDuration=" + callDuration +
                '}';
    }
}

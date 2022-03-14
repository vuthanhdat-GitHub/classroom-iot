package com.example.classroomiot.logic.enums;

public enum DeviceStatusFirebase {
    DANGHOATDONG("DANG HOAT DONG"),
    KHONGHOATDONG("KHONG HOAT DONG");

    private String value;

    DeviceStatusFirebase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


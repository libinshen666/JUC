package com.atguigu;

public enum  WeekEnmu { //作业
    MON(1,"一"),TUE(2,"二"),WEB(3,"三"),THU(4,"四"),FRI(5,"五"),SAT(6,"六");
    private int getId;
    private String getMessage;
    WeekEnmu(int getId, String getMessage) {
        this.getId = getId;
        this.getMessage = getMessage;
    }
    public int getGetId() {
        return getId;
    }
    public String getGetMessage() {
        return getMessage;
    }
    public void setGetId(int getId) {
        this.getId = getId;
    }
    public void setGetMessage(String getMessage) {
        this.getMessage = getMessage;
    }
    public static WeekEnmu for_item(int index){
        WeekEnmu[] values = WeekEnmu.values();
        for(WeekEnmu element:values){
            if(index == element.getId){
                return element;
            }
        }
        return null;
    }
}


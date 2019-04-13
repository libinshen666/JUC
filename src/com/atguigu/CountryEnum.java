package com.atguigu;

public enum  CountryEnum { //枚举类
     ONE(1,"赵"),TWO(2,"齐"),THREE(3,"韩"),FOUR(4,"魏"),FIVE(5,"楚"),SIX(6,"李");
    private Integer getcode;
    private String getMessage;

    public void setGetcode(Integer getcode) {
        this.getcode = getcode;
    }

    public void setGetMessage(String getMessage) {
        this.getMessage = getMessage;
    }

    public Integer getGetcode() {
        return getcode;
    }

    public String getGetMessage() {
        return getMessage;
    }

    CountryEnum(Integer getcode, String getMessage) {
        this.getcode = getcode;
        this.getMessage = getMessage;
    }

    public static CountryEnum foreach_CountryEnum(int index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element:values) {
            if (index == element.getcode) {
                return element;
            }
        }
        return null;//如果前边有return ，后边就return null ;
    }
}

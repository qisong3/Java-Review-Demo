package cn.errison.feature.demo.enumerate;

/**
 * 枚举类定义
 */
public enum Day {

    // enumerate definition
    MONDAY("周一",1),
    TUESDAY("周二",2),
    WEDNESDAY ("周三",3),
    THURSDAY("周四",4),
    FRIDAY("周五",5),
    SATURDAY("周六",6),
    SUNDAY("周日",7);

    private final String name;
    private final int index;

    // get item
    public String getName(){
        return this.name;
    }

    public int getIndex(){
        return this.index;
    }

    // constructor
    Day(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static Day getDayByName(String name){
        Day day = Day.FRIDAY;
        for (Day dayEnum : values()){
            if (dayEnum.name.equalsIgnoreCase(name)) {
                day = dayEnum;
            }
        }
        return null;
    }

}

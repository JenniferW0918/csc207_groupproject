package entity;

public class Category {
    private final Integer CATEGORY_ID;
    private final String name;

    public Category(Integer CATEGORY_ID, String name){
        this.CATEGORY_ID = CATEGORY_ID;
        this.name = name;
    }

    public Integer getCATEGORY_ID() {return CATEGORY_ID;}
    public String getName() {return name;}
}

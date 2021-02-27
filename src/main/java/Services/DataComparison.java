package Services;

public final class DataComparison {
    public static String compareData(String type_1, String type_2, String type_3) {
        if(type_3 == null && type_2 ==null) {
            return type_1;
        } else if(type_3 == null) {
            return type_2;
        }else {
            return type_3;
        }
    }
}

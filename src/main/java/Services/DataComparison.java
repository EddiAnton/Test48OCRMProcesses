package Services;

public final class DataComparison {
    public static String compareData(String type_1, String type_2, String type_3) {
        String result = null;

        if(type_3 == null && type_2 ==null) {
            result = type_1;
        } else if(type_3 == null) {
            result = type_2;
        }else {
            result = type_3;
        }

        if(result == null) {
            result = "";
        }

        return result;
    }
}

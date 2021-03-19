package Services;

public  final class DataConversion {
    public static String booleanConversion(String s1) {

        String result = null;

        if (s1.equals("T"))
            result = "true";
        else if (s1.equals("F"))
            result = "false";

        return result;
    }

    public static String getProductOrderNumber(String inputData) {

        String productOrderNumber = null;

        String [] splitString = inputData.split(" ");
        productOrderNumber = splitString[2];

        return productOrderNumber;
    }
}

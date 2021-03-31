package Services;

public  final class DataConversion {
    public static String testSF_booleanConversion(String s1) {

        String result = null;

        if (s1.equals("T"))
            result = "true";
        else if (s1.equals("F"))
            result = "false";
        else if (s1.equals(null))
            result = "";

        return result;
    }

    public static int stringToIntConversion(String s1) {

        int result;

        if (s1 != null)
            result = Integer.parseInt(s1);
        else
            result = -1;

        return result;
    }

    public static String getProductOrderNumber(String inputData) {

        String productOrderNumber = null;

        String [] splitString = inputData.split(" ");
        productOrderNumber = splitString[2];

        return productOrderNumber;
    }

    public static String getFB_ProductOrderID(String inputData) {

        String fb_productOrderID = null;

        String [] splitString = inputData.split("=");
        fb_productOrderID = splitString[1].substring(0, 12);

        return fb_productOrderID;
    }
}

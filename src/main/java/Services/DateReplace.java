package Services;

public final class DateReplace {
    public static String replaceInputDate(String inputDate) {
        String result = null;
        String [] parts = inputDate.split(" ");
        String [] partsResult = parts[0].split("-");
        result = partsResult[2] + "." + partsResult[1] + "." + partsResult[0];
        return result;
    }
}

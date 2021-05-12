package org.fbconsult.Services;

public class XpathAuthorization {

    // Authorization XPATH constants

    public static final String LOG_OFF_HREF = "Вернуться на страницу входа";

    public static final String INPUT_USERNAME = "//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$UserName']";

    public static final String INPUT_PASSWORD = "//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$Password']";

    public static final String SUBMIT_BUTTON = "//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$btnLogin']";

    // Open, select ant sort "Data change requests" XPATH constants

    public static final String REQUESTS_HREF = "//*[@id=\"borderCenter\"]/nav/ul/li[16]/a";

    public static final String FILTER_UC_TSP = "//*[@id=\"GroupLookupButton\"]/span[1]/div";

    public static final String INPUT_UC_TSP = "//*[@id='widget_GroupLookup-ConditionManager-SearchCondition0-TextValue']/div/input";

    public static final String SUBMIT_SELECT = "//*[@id='GroupLookup-ConditionManager-Search_label']";

    public static final String SORT_BY_MODIFIED_DATE_83 = "//*[@id='dojoUnique27']/div";

    public static final String SORT_BY_MODIFIED_DATE = "//*[@id='dojoUnique22']";

    public static final String LAST_APPLICATION = "//div[@id='dijit_layout_StackContainer_0']//td/a";

    // XPATH to data of the PRODUCTORDERNUMBER

    public static final String FIELD_PRODUCTORDERNUMBER = "//*[@id='PageTitle']";

    public static final String FIELD_PRODUCTORDER = "//*[@id=\"mainform\"]";

}

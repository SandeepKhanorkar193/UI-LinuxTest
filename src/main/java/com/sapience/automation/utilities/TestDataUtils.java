package com.sapience.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;

public class TestDataUtils {
    public static ArrayList getKPIListName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Work Time Avg.");
        arrayList.add("Private Time Avg.");
        arrayList.add("Unacc. Time Avg.");
        arrayList.add("Core Time Avg.");
        arrayList.add("Focus Time Avg.");
        arrayList.add("Meeting Time Avg.");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static ArrayList getDeviceActivityAnalyticsTabsName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Overview");
        arrayList.add("Trends");
        arrayList.add("Utilization");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static ArrayList<String> mgrGetExpectedTitles() throws Exception {
        ArrayList<String> expectedHeaders = new ArrayList<String>();
//        expectedHeaders.add("Daily Timeline");
//        expectedHeaders.add("Meeting Analytics and Activity Summary");
//        expectedHeaders.add("Daily Work Day Report");
//        expectedHeaders.add("Timesheet");
//        expectedHeaders.add("Department Utilization");
//        expectedHeaders.add("Top-20%, Mid 60%, Bottom 20% Report");
//        expectedHeaders.add("Breaks Report");
//        expectedHeaders.add("Utilization Opportunity");
//        expectedHeaders.add("Email Analytics");
//        expectedHeaders.add("EU Work Time and Rest Compliance Report");

        expectedHeaders.add("Daily Timeline");
        expectedHeaders.add("Meeting Analytics and Activity Summary");
        expectedHeaders.add("Breaks Report");
        expectedHeaders.add("Utilization Opportunity");
        expectedHeaders.add("Email Analytics");
        expectedHeaders.add("EU Work Time and Rest Compliance Report");
        expectedHeaders.add("Application Utilization By User");
        expectedHeaders.add("Core Time Report");
        expectedHeaders.add("Focus Time Report");
        expectedHeaders.add("Work Activity Trends");
        expectedHeaders.add("Unaccounted Time Report");

        Collections.sort(expectedHeaders);
        return expectedHeaders;
    }


    public static ArrayList<String> empGetExpectedTitles() throws Exception {
        ArrayList<String> emp_expectedheaders = new ArrayList<String>();
//        emp_expectedheaders.add("Daily Work Day Report");
//        emp_expectedheaders.add("Timesheet");
        emp_expectedheaders.add("Daily Timeline");
        emp_expectedheaders.add("Email Analytics");
        emp_expectedheaders.add("Work Activity Trends");
        //Daily Timeline, Email Analytics, Work Activity Trends
        Collections.sort(emp_expectedheaders);
        return emp_expectedheaders;
    }

    public static ArrayList getTeamDeviceActivityAnalyticsTabsName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList = getDeviceActivityAnalyticsTabsName();
        arrayList.add("Team Stats");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static ArrayList getActivityList() {
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Development");
        arrayList.add("Documentation");
        arrayList.add("Communication");
        arrayList.add("Browsing");
        arrayList.add("Meetings");
        arrayList.add("Miscellaneous");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String getExpectedReportName() {
        String expectedReportName = "Email Analytics";
        return expectedReportName;

    }

    public static String getExpectedReportNameDL() {
        String expectedReportNameDL = "Daily Timeline";
        return expectedReportNameDL;

    }


    public static String reportToDate() {
        String reporttoDate = "02/29/2020";
        return reporttoDate;
    }

    public static String reportFromDate() {
        String reportFromDate = "02/01/2020";
        return reportFromDate;
    }

    public static ArrayList<String> columnHeadingsListDl() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("Date");
        expectedColumnHeadingsDl.add("Manager");
        expectedColumnHeadingsDl.add("Manager’s Email");
        expectedColumnHeadingsDl.add("Employee");
        expectedColumnHeadingsDl.add("Employee’s Email");
        expectedColumnHeadingsDl.add("Start Time (HH:MM)");
        expectedColumnHeadingsDl.add("First on-PC time (HH:MM))");
        expectedColumnHeadingsDl.add("Last on-PC time (HH:MM))");
        expectedColumnHeadingsDl.add("End time (HH:MM)");
        expectedColumnHeadingsDl.add("Total Work Hours");
        expectedColumnHeadingsDl.add("Total Meeting Hours");
        expectedColumnHeadingsDl.add("Total Private Hours");
        //Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }

    public static ArrayList getDayViewGridList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Total Time / Hrs");
        arrayList.add("Work Time / Hrs");
        arrayList.add("Private Time / Hrs");
        arrayList.add("Unaccounted Time / Hrs");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static ArrayList getCalenderPageTableHeader() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Application Name");
        arrayList.add("Category");
        arrayList.add("Type");
        arrayList.add("Start Time");
        arrayList.add("End Time");
        arrayList.add("Elapsed Time");
        arrayList.add("Url");
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String getExpectedReportNameTimeSheet() {
        String expectedReportNameTimeSheet = "Timesheet";
        return expectedReportNameTimeSheet;
    }

    public static String getExpectedReportNameDailyWorkDay() {
        String expectedReportNameDailyWorkDay = "Daily Work Day Report";
        return expectedReportNameDailyWorkDay;
    }


    public static String getMeetingAnalyticsReportName() {
        String expectedReportNameDailyWorkDay = "Meeting Analytics and Activity Summary";
        return expectedReportNameDailyWorkDay;
    }

    public static ArrayList<String> utilizationOpportunityColumnList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("Employee/Team Name");
        expectedColumnHeadingsDl.add("Average Work Hours");
        expectedColumnHeadingsDl.add("Utilization Percentage");
        expectedColumnHeadingsDl.add("Opportunity Hours");
        expectedColumnHeadingsDl.add("Opportunity Percentage");
        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }

    public static ArrayList<String> dailyTimelineColumnList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("Date");
        expectedColumnHeadingsDl.add("Manager");
        expectedColumnHeadingsDl.add("Employee");
        expectedColumnHeadingsDl.add("Department");
        expectedColumnHeadingsDl.add("End time (HH:MM)");
        expectedColumnHeadingsDl.add("First on-PC time (HH:MM))");
        expectedColumnHeadingsDl.add("Job Family");
        expectedColumnHeadingsDl.add("Last on-PC time (HH:MM))");
        expectedColumnHeadingsDl.add("Location");
        expectedColumnHeadingsDl.add("Start Time (HH:MM)");
        expectedColumnHeadingsDl.add("Total Meeting Hours");
        expectedColumnHeadingsDl.add("Total Private Hours");
        expectedColumnHeadingsDl.add("Total Work Hours");

        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }


    public static ArrayList<String> dailyWorkDayColumnList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("Date");
        expectedColumnHeadingsDl.add("Manager's Name");
        expectedColumnHeadingsDl.add("Manager's email id");
        expectedColumnHeadingsDl.add("Employee's name");
        expectedColumnHeadingsDl.add("Employee's email id");
        expectedColumnHeadingsDl.add("Activity");
        expectedColumnHeadingsDl.add("Start Time");
        expectedColumnHeadingsDl.add("End Time");
        expectedColumnHeadingsDl.add("Category");
        expectedColumnHeadingsDl.add("AppName");
        expectedColumnHeadingsDl.add("ExeName");
        expectedColumnHeadingsDl.add("FileOrUrlName");

        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }

    public static ArrayList<String> timesheetColumnList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("Date");
        expectedColumnHeadingsDl.add("Manager's name");
        //needs to correct
//        expectedColumnHeadingsDl.add("Manager's email id");
        expectedColumnHeadingsDl.add("Managers' email id");
        expectedColumnHeadingsDl.add("Employee's name");
        expectedColumnHeadingsDl.add("Employee's email id");
        expectedColumnHeadingsDl.add("Total Work Hours");

        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }

    public static ArrayList<String> meetingAnalyticsColumnList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
//        expectedColumnHeadingsDl.add("Date");
//        expectedColumnHeadingsDl.add("Meeting Name");
//        expectedColumnHeadingsDl.add("Meeting Start Time (HH:MM)");
//        expectedColumnHeadingsDl.add("Meeting End Time (HH:MM)");
//        expectedColumnHeadingsDl.add("Duration (in Minutes)");
//        expectedColumnHeadingsDl.add("Total Attendees");
//        expectedColumnHeadingsDl.add("Meeting Attendee");
//        expectedColumnHeadingsDl.add("Manager Name");
//        expectedColumnHeadingsDl.add("Location");
//        expectedColumnHeadingsDl.add("Department");
//        expectedColumnHeadingsDl.add("Job Family");
//        expectedColumnHeadingsDl.add("Work Hours Captured");
//        expectedColumnHeadingsDl.add("Private Hours Captured");
        expectedColumnHeadingsDl.add("Week");
        expectedColumnHeadingsDl.add("Manager");
        expectedColumnHeadingsDl.add("Employee");
        expectedColumnHeadingsDl.add("Location");
        expectedColumnHeadingsDl.add("Department");
        expectedColumnHeadingsDl.add("Meeting Subject");
        expectedColumnHeadingsDl.add("Meeting Size");
        expectedColumnHeadingsDl.add("Meeting Duration");

        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }

    public static ArrayList<String> reportCategoryList() throws Exception {
        ArrayList<String> expectedColumnHeadingsDl = new ArrayList<String>();
        expectedColumnHeadingsDl.add("All");
        expectedColumnHeadingsDl.add("Communication Effectiveness");
        expectedColumnHeadingsDl.add("Compliance");
        expectedColumnHeadingsDl.add("Meeting Effectiveness");
        expectedColumnHeadingsDl.add("Work Hours Analysis");
        expectedColumnHeadingsDl.add("Software Utilization");

        Collections.sort(expectedColumnHeadingsDl);
        return expectedColumnHeadingsDl;
    }
}

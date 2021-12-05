package com.szhigajlo;

import com.google.gson.Gson;

import java.util.Collection;

public class TaskCallLogToGson {
    public void goGson(CallLog callLogs){
        callLogToJson(callLogs);

    }

    private void callLogToJson(CallLog callLogs) {
//        CallLog callLog = new CallLog("Ivan", "15644872", 58);
        Gson gson = new Gson();
        String json = gson.toJson(callLogs);
        System.out.println("\njson тип: " + json);
        CallLog callLogFromJson = gson.fromJson(json, CallLog.class);
        System.out.println( "\nНовая запись звонка: " + callLogFromJson);

    }


}

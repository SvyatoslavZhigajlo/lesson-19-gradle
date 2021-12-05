package com.szhigajlo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            int value = Integer.parseInt(args[0]);
            //ДЗ 23 Задание 5 - Создать Collection<CallLog> и заполнить ее случайными экземплярами до определенного размера,
            // переданного в качестве единственного аргумента командной строки. Обработать
            // отсутствие аргументов с помощью значения по умолчанию.
            new Main().run2(value);
            new Main().run();
        }else{
            new Main().run2(2);
            new Main().run();
        }
    }

    private void run() {
        Collection<CallLog> callLogs = inputData();

//        ДЗ 23 Задание 2 - Подключить библиотеку “org.apache.commons:commons-collections4” в проект. Использовать 2-3
//        класса из этой библиотеки, например, BidiMap.
        BidiMap<String, CallLog> bidiMapcallLogs = mapCallLogs(callLogs);
        showInfo(bidiMapcallLogs);

//        ДЗ 23 Задание 3 - Подключить библиотеку “com.google.code.gson:gson” в проект. Использовать его
//        для преобразования экземпляров CallLog в JSON и обратно.
        TaskCallLogToGson gson = new TaskCallLogToGson();
        gson.goGson(callLogs.iterator().next());
    }
    private void run2(int value){
        Collection <CallLog> randomCallLog = new ArrayList<>();
        for (int i = 0; i < value ; i++) {
            String name = new Data().name[(int)(Math.random() * new Data().name.length)];
            String phoneNumber = new Data().phoneNumber[(int)(Math.random() * new Data().phoneNumber.length)];
            int callDuration = (int) (Math.random() * 100);
            randomCallLog.add(new CallLog(name,phoneNumber,callDuration));
        }

        for (CallLog callLog : randomCallLog) {
            System.out.println(callLog);
        }
        //ДЗ 23 Задание 6 - Используя gson, преобразовать созданную Collection<CallLog> в JSON и обратно.
        randomCallLogJson(randomCallLog);
    }

    private Collection<CallLog> inputData() {
        CallLog callLog1 = new CallLog("Svyatoslav1", "(066)123-45-67", 54);
        CallLog callLog2 = new CallLog("Svyatoslav2", "(066)123-45-68", 32);
        CallLog callLog3 = new CallLog("Svyatoslav3", "(066)123-45-69", 59);
        CallLog callLog4 = new CallLog("Svyatoslav4", "(066)123-45-70", 113);
        CallLog callLog5 = new CallLog("Svyatoslav5", "(066)123-45-71", 40);
        CallLog callLog6 = new CallLog("Svyatoslav6", "(066)123-45-67", 15);
        Collection<CallLog> callLogs = new ArrayList<>();
        callLogs.add(callLog1);
        callLogs.add(callLog2);
        callLogs.add(callLog3);
        callLogs.add(callLog4);
        callLogs.add(callLog5);
        callLogs.add(callLog6);
        return callLogs;
    }

    private BidiMap<String, CallLog> mapCallLogs(Collection<CallLog> callLogs) {
        BidiMap<String, CallLog> bidiMap = new DualHashBidiMap<>();
        for (CallLog allCalls : callLogs) {
            bidiMap.put(allCalls.getPhoneNumber(), allCalls);
        }
        return bidiMap;
    }

    private void showInfo(BidiMap<String, CallLog> mapCallLogs) {
        for (Map.Entry<String, CallLog> showInfo : mapCallLogs.entrySet()) {
            System.out.println(showInfo);
        }
    }

    private void randomCallLogJson(Collection <CallLog> randomCallLog){
        Gson gson = new Gson();
        String randomJson = gson.toJson(randomCallLog);
        Type collectionCallLog = new TypeToken<Collection<CallLog>>(){}.getType();
        Collection<CallLog> callLogs = gson.fromJson(randomJson, collectionCallLog);
        System.out.println("\njson из случайной коллекции: " + randomJson);
        System.out.println("\nДесериализованная  коллекция: ");
        for (CallLog callLog : callLogs) {
            System.out.println(callLog);
        }
    }
}

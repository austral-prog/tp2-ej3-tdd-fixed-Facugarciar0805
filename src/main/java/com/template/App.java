package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {

        if (amount>=0){
            Map<String, Integer> newAccounts = new HashMap<String, Integer>();
            for (Map.Entry<String, Integer> entry : accounts.entrySet()){
                if (entry.getKey().equals(account) ){
                    newAccounts.put(entry.getKey(), (amount+entry.getValue()));
                }
                else{
                    newAccounts.put(entry.getKey(), entry.getValue());
                }
            }
            return newAccounts;
        }
        return accounts;
    }
    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
        if (amount>=0) {
            Map<String, Integer> newAccounts = new HashMap<String, Integer>(accounts);
            if (newAccounts.containsKey(account)) {
                if (newAccounts.get(account) >= amount) {
                    newAccounts.put(account, newAccounts.get(account) - amount);
                    return newAccounts;
                }
                return newAccounts;
            }
        }

        return accounts;
    }
    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String giver, String receiver, int amount) {
        if (amount>=0) {
            Map<String, Integer> newAccounts = new HashMap<String, Integer>(accounts);
            if ((newAccounts.containsKey(giver)) && (newAccounts.containsKey(receiver)) && !(giver.equals(receiver))){
                if (newAccounts.get(giver) >= amount){
                    newAccounts.put(giver, newAccounts.get(giver) - amount);
                    newAccounts.put(receiver, newAccounts.get(receiver) + amount);
                    return newAccounts;
                }
                return newAccounts;
            }
            return newAccounts;
        }

        return accounts;

    }
}

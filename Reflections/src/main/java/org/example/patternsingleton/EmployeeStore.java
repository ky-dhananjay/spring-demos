package org.example.patternsingleton;

import java.util.HashMap;
import java.util.Map;

public class EmployeeStore {
    private final Map<String,String> employees;
    private static EmployeeStore INSTANCE = null;

    private EmployeeStore(){
        this.employees = new HashMap<>();
        this.employees.put("101", "dj");
        this.employees.put("102", "dy");
    }

    public String getName(String id){
        if(!this.employees.containsKey(id)){
            throw new IllegalArgumentException("invalid id");
        }
        return this.employees.get(id);
    }

    public synchronized static EmployeeStore getInstance(){
        if(INSTANCE == null)
            INSTANCE = new EmployeeStore();
        return INSTANCE;
    }
}

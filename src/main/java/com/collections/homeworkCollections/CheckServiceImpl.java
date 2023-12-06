package com.collections.homeworkCollections;

import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Override
    public String check(String name, String lastName, Integer department, Float salary){
        if(name == null || lastName == null || department == null || salary == null) {
            String result = "Ошибка: ";
            if (name == null) {
                result += "\nнеобходимо ввести имя";
            }
            if (lastName == null) {
                result += "\nнеобходимо ввести фамилию.";
            }
            if (department == null) {
                result += "\nнеобходимо ввести название отдела.";
            }
            if (salary == null) {
                result += "\nнеобходимо ввести значение зарплаты.";
            }
            return result;
        }
        return null;
    }

    @Override
    public String checkName(String name, String lastName){
        if(name == null || lastName == null) {
            String result = "Ошибка: ";
            if (name == null) {
                result += "\nнеобходимо ввести имя";
            }
            if (lastName == null) {
                result += "\nнеобходимо ввести фамилию.";
            }
            return result;
        }
        return null;
    }
}

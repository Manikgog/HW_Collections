package com.collections.homeworkCollections.service;

import com.collections.homeworkCollections.exception.AddEmployeeException;
import com.collections.homeworkCollections.exception.WrongNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.lang3.StringUtils.*;

@Service
public class CheckServiceImpl implements CheckService {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя-";
    @Override
    public String[] check(String name, String lastName, Integer department, Float salary){

        if(name == null || lastName == null){
            checkName(name, lastName);
        }
        if(department == null || salary == null) {
            StringBuilder result = new StringBuilder("Ошибка. Вы забыли ввести: ");
            List<String> list = new ArrayList<>();
            if (department == null) {
                list.add("название отдела");
            }
            if (salary == null) {
                list.add("значение зарплаты");
            }
            for (int i = 0; i < list.size(); i++) {
                result.append(list.get(i));
                if(i < list.size() - 1){
                    result.append(", ");
                }else {
                    result.append(".");
                }
            }
            throw new AddEmployeeException(result.toString());
        }
        String[] nameLastName = new String[2];
        nameLastName[0] = checkCorrectName(name, alpha);
        nameLastName[1] = checkCorrectName(lastName, alpha);

        return nameLastName;
    }

    @Override
    public void checkName(String name, String lastName){

        if(name == null || lastName == null) {
            StringBuilder result = new StringBuilder("Ошибка. Вы забыли ввести: ");
            List<String> list = new ArrayList<>();
            if (name == null) {
                list.add("имя");
            }
            if (lastName == null) {
                list.add("фамилию");
            }
            for (int i = 0; i < list.size(); i++) {
                result.append(list.get(i));
                if(i < list.size() - 1){
                    result.append(", ");
                }else {
                    result.append(".");
                }
            }

            throw new AddEmployeeException(result.toString());
        }
    }

    private String checkCorrectName(String name, String validChars){
        if (!StringUtils.containsOnly(name, validChars)) {
            throw new WrongNameException(name + " содержит недопустимые символы или пробелы.");
        }
        name = lowerCase(name);
        char firstChar = name.charAt(0);
        String fc = String.valueOf(firstChar);
        return replaceFirst(name, fc, upperCase(fc));
    }


}

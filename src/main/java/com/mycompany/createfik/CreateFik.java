/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.createfik;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDefaultScriptlet;

/**
 *
 * @author jeaadmin
 */
public class CreateFik extends JRDefaultScriptlet {

    public String createFik(String invoiceNum) {
        invoiceNum = invoiceNum + 0;
        Long fikNum = Long.parseLong(invoiceNum);
        String result = "";
        int strLength = invoiceNum.length();
        // 0 = even number, 1 = uneven number
        int isEven = strLength % 2;
        int weightedNumber = 0;
        int counter = 0;
        ArrayList<Integer> weightedNumbers = new ArrayList<Integer>();
        int totalSum = 0;
        int checkDigit = 0;
        String fikAndCheck = "";
        long varLong = 0L;
        int checkRest = 0;
        
        for (int i = 0; i < strLength; i++) {
            counter = counter + 1;
            int res = 0;
            int currentNum = Character.getNumericValue(invoiceNum.charAt(i));

            if(isEven == 0){
                weightedNumber = 1;
                isEven = 1;
            } else {
                weightedNumber = 2;
                isEven = 0;
            }
            res = currentNum * weightedNumber;
            weightedNumbers.add(res);
        }
        
        for (Integer i : weightedNumbers) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            totalSum = totalSum + sum;
        }

        checkDigit = totalSum % 10;
        if(checkDigit != 0){
            checkRest = Math.abs(checkDigit - 10);
        }else{
            checkRest = 0;
        }
        fikAndCheck = Long.toString(fikNum) + checkRest;
        varLong = Long.parseLong(fikAndCheck);
        result = String.format("%015d", varLong);

        return result;
    }
    
}

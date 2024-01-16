/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.bankTransactionAnalyzer;

import entities.BankTransaction;
import java.io.File;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import parsers.ParseBankTransaction;
import processor.BankStatementProcessor;

/**
 *
 * @author mateus
 */
public class BankTransactionAnalyzer {
    public static void analyze(File fileSource, ParseBankTransaction parser) {
        List<BankTransaction> list = parser.getAllTransactions(fileSource);
        BankStatementProcessor processor = new BankStatementProcessor(list);
        
        summarizer(processor);
    }
    
    private static void summarizer(BankStatementProcessor processor) {
        System.out.println("The total for all transactions is $" + String.format("%.2f", processor.calculateTotalBalance()));
        System.out.println("The total for all transactions in january is $" + String.format("%.2f", processor.TotalTransactionByMonth(Month.JANUARY)));
        System.out.println("The total for all transactions in february is $" + String.format("%.2f", processor.TotalTransactionByMonth(Month.FEBRUARY)));
        System.out.println("The total salary received is $" + String.format("%.2f", processor.TotalTransactionsByCategory("salario")));
        System.out.println("Top 10 higher expenses: ");
        
        int i = 1;
        for (BankTransaction bt : processor.getHigherExpenses()) {
            System.out.println(i + "- " + bt.toString());
            i++;
        }

    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mateusflores.banktransactionanalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import parsers.ParseBankTransaction;
import parsers.ParseBankTransactionCsv;
import entities.BankTransaction;

/**
 *
 * @author mateus
 */
public class MainApplication {

    public static void main(String[] args) {
        String src = "C:\\repos\\Book_RWSD_Java\\BankTransactionAnalyzer\\src\\main\\java\\resources\\extrato.csv";
        File file = new File(src);
        
        ParseBankTransaction parser = new ParseBankTransactionCsv(file);
        List<BankTransaction> transactions = new ArrayList<>();
        transactions = parser.getAllTransactions();
        
        for (BankTransaction b : transactions) {
            System.out.println(b.toString());
        }
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mateusflores.bankTransactionAnalyzer;

import java.io.File;
import parsers.ParseBankTransaction;
import parsers.ParseBankTransactionCsv;


/**
 *
 * @author mateus
 */
public class MainApplication {

    public static void main(String[] args) {
        String src = "C:\\repos\\Book_RWSD_Java\\BankTransactionAnalyzer\\src\\main\\java\\resources\\extrato.csv";
        ParseBankTransaction parser = new ParseBankTransactionCsv();
        BankTransactionAnalyzer.analyze(new File(src), parser);
    }
}

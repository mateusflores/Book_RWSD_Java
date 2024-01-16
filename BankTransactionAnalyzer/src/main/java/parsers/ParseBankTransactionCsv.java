/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parsers;

import entities.BankTransaction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mateus
 */
public class ParseBankTransactionCsv implements ParseBankTransaction {
    
    private File file;

    public ParseBankTransactionCsv() {
    }

    @Override
    public BankTransaction createBankTransaction(String line) {
        String[] fields = line.split(",");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        BankTransaction bankTransaction = new BankTransaction(LocalDate.parse(fields[0], dtf), Double.parseDouble(fields[1]), fields[2]);
        
        return bankTransaction;
    }

    @Override
    public List<BankTransaction> getAllTransactions(File file) {
        List<String> lines = readFromCsv(file);
        List<BankTransaction> bankTransactionList = new ArrayList<>();
        
        for (String line : lines) {
            BankTransaction bt = createBankTransaction(line);
            bankTransactionList.add(bt);
        }
        
        return bankTransactionList;
    }

    private List<String> readFromCsv(File file) {
        String line;
        List<String> lines = new ArrayList<>();

        try {
            if(file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } else {
                System.out.println("The file doesn't exists!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}

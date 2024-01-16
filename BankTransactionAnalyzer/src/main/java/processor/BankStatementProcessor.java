/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processor;

import entities.BankTransaction;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author mateus
 */
public class BankStatementProcessor {
    private List<BankTransaction> list;

    public BankStatementProcessor(List<BankTransaction> list) {
        this.list = list;
    }
    
    public Double calculateTotalBalance() {
        Double amount = 0D;
        
        for (BankTransaction bt : list) {
            amount += bt.getAmount();
        }
        
        return amount;
    }
    
    public Double TotalTransactionByMonth(Month month) {
        Double amount = 0D;
        
        for (BankTransaction bt : list) {
            if (bt.getDate().getMonth() == month) {
                amount += bt.getAmount();
            }
        }
        
        return amount;
    }
    
    public Double TotalTransactionsByCategory(String category) {
        Double amount = 0D;
        
        for (BankTransaction bt : list) {
            if (bt.getCategory().equals(category)) {
                amount += bt.getAmount();
            }
        }
        
        return amount;
    }
    
    public List<BankTransaction> showHigherExpenses() {
        List<BankTransaction> higherExpensesList;
        Collections.sort(list);
        
        higherExpensesList = list.subList(0, 9);
        
        return higherExpensesList;
    }
}

package parsers;

import entities.BankTransaction;
import java.util.List;

/**
 *
 * @author mateus
 */
public interface ParseBankTransaction {
    public BankTransaction createBankTransaction(String line);
    public List<BankTransaction> getAllTransactions();
}

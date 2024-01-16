package parsers;

import entities.BankTransaction;
import java.io.File;
import java.util.List;

/**
 *
 * @author mateus
 */
public interface ParseBankTransaction {
    public BankTransaction createBankTransaction(String line);
    public List<BankTransaction> getAllTransactions(File file);
}

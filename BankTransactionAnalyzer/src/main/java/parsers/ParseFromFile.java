package parsers;

import entities.BankTransaction;
import java.util.List;

/**
 *
 * @author mateus
 */
public interface ParseFromFile {
    public BankTransaction createBankTransaction(String line);
    public List<BankTransaction> getAllTransactions(List<String> lines);
}

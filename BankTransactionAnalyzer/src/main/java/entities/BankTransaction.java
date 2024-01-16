package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author mateus
 */
public class BankTransaction implements Comparable<BankTransaction> {
    private LocalDate date;
    private Double amount;
    private String category;

    public BankTransaction(LocalDate date, Double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "date=" + date + ", amount=" + amount + ", category=" + category + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.date);
        hash = 43 * hash + Objects.hashCode(this.amount);
        hash = 43 * hash + Objects.hashCode(this.category);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankTransaction other = (BankTransaction) obj;
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.amount, other.amount);
    }    
    
    public int compareTo(BankTransaction anotherTransaction) {
        if (this.getAmount() < anotherTransaction.getAmount()) {
            return -1;
        } else if (this.getAmount() > anotherTransaction.getAmount()) {
            return 1;
        }
        
        return 0;
    }
}

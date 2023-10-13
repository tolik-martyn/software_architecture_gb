package hw4.core;

import hw4.models.BankAccount;
import hw4.services.CashRepository;

import java.util.List;

/**
 * Класс для обработки денежных операций.
 */
public class CashProvider {
    private CashRepository cashRepository;

    public CashProvider() {
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Выполняет транзакцию между банковскими счетами.
     *
     * @param payment   сумма платежа
     * @param cardFrom  номер карты отправителя
     * @param cardTo    номер карты получателя
     * @return true, если транзакция выполнена успешно, иначе false
     */
    public boolean makeTransaction(int payment, long cardFrom, long cardTo) {
        BankAccount fromAccount = cashRepository.findAccountByAccountNumber(cardFrom);
        BankAccount toAccount = cashRepository.findAccountByAccountNumber(cardTo);

        if (fromAccount != null && toAccount != null && fromAccount.withdraw(payment)) {
            toAccount.deposit(payment);
            return true;
        }
        return false;
    }

    public List<BankAccount> getClients() {
        return cashRepository.getClients();
    }

    public BankAccount findAccountByAccountNumber(long accountNumber) {
        return cashRepository.findAccountByAccountNumber(accountNumber);
    }

    public boolean isClientAuthorized(BankAccount clientAccount) {
        List<BankAccount> bankAccounts = cashRepository.getClients();

        for (BankAccount account : bankAccounts) {
            if (account.equals(clientAccount)) {
                return true;
            }
        }
        return false;
    }
}

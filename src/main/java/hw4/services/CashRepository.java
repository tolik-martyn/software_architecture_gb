package hw4.services;

import hw4.interfaces.ICashRepo;
import hw4.models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для работы с банковскими аккаунтами клиентов и транзакциями.
 */
public class CashRepository implements ICashRepo {
    private static CashRepository cashRepository;
    private List<BankAccount> clients; // Здесь хранятся банковские аккаунты клиентов

    /**
     * Приватный конструктор для Singleton-реализации.
     */
    private CashRepository() {
        clients = new ArrayList<>();
        initializeDummyBankAccounts(); // Заполнение фиктивными данными
    }

    /**
     * Получает экземпляр репозитория банковских аккаунтов.
     *
     * @return экземпляр репозитория банковских аккаунтов
     */
    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    /**
     * Получает список всех банковских аккаунтов клиентов.
     *
     * @return список банковских аккаунтов клиентов
     */
    public List<BankAccount> getClients() {
        return clients;
    }

    @Override
    public boolean transaction(int payment, long cardFrom, long cardTo) {
        BankAccount fromAccount = findAccountByAccountNumber(cardFrom);
        BankAccount toAccount = findAccountByAccountNumber(cardTo);

        if (fromAccount != null && toAccount != null && fromAccount.withdraw(payment)) {
            toAccount.deposit(payment);
            return true;
        }
        return false;
    }

    /**
     * Вспомогательный метод для заполнения репозитория фиктивными данными.
     */
    private void initializeDummyBankAccounts() {
        clients.add(new BankAccount(1000));
        clients.add(new BankAccount(1500));
        clients.add(new BankAccount(2000));
    }

    /**
     * Вспомогательный метод для поиска банковского аккаунта по номеру счета.
     *
     * @param accountNumber номер банковского счета
     * @return банковский аккаунт или null, если не найден
     */
    public BankAccount findAccountByAccountNumber(long accountNumber) {
        for (BankAccount account : clients) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

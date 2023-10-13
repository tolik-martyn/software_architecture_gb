package hw4.models;

/**
 * Класс, представляющий банковский счет.
 */
public class BankAccount {
    private static long nextAccountNumber = 1;
    private long accountNumber;
    private int balance;

    /**
     * Конструктор класса BankAccount.
     *
     * @param balance баланс счета
     */
    public BankAccount(int balance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = balance;
    }

    /**
     * Получает номер банковского счета.
     *
     * @return номер счета
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Получает баланс счета.
     *
     * @return баланс счета
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Пополняет баланс счета на заданную сумму.
     *
     * @param amount сумма пополнения
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * Снимает с баланса счета заданную сумму.
     *
     * @param amount сумма снятия
     * @return true, если снятие успешно, иначе false
     */
    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BankAccount that = (BankAccount) obj;

        return accountNumber == that.accountNumber;
    }

    @Override
    public int hashCode() {
        return (int) (accountNumber ^ (accountNumber >>> 32));
    }

    @Override
    public String toString() {
        return "Банковский счет {" +
                "Номер счета=" + accountNumber +
                ", Баланс=" + balance +
                '}';
    }
}

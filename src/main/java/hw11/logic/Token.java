package hw11.logic;

import java.util.Objects;

/**
 * Класс, представляющий токен доступа.
 */
public class Token {
    private final String value;

    /**
     * Конструктор класса Token.
     *
     * @param value Значение токена.
     */
    public Token(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

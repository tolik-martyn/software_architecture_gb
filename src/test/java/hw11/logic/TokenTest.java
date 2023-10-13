package hw11.logic;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @org.junit.jupiter.api.Test
    void testEquals() {
        Token token1 = new Token("tokenValue");
        Token token2 = new Token("tokenValue");
        Token token3 = new Token("differentValue");

        // Проверка на равенство двух одинаковых токенов
        assertEquals(token1, token2);

        // Проверка на неравенство токенов с разными значениями
        assertNotEquals(token1, token3);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        Token token1 = new Token("tokenValue");
        Token token2 = new Token("tokenValue");
        Token token3 = new Token("differentValue");

        // Проверка хеш-кодов для одинаковых токенов
        assertEquals(token1.hashCode(), token2.hashCode());

        // Проверка хеш-кодов для токенов с разными значениями
        assertNotEquals(token1.hashCode(), token3.hashCode());
    }
}

package hw11.data;

import hw11.logic.Token;
import hw11.logic.User;

import static org.junit.jupiter.api.Assertions.*;

class AccessRepositoryTest {

    private AccessRepository accessRepository;
    private User user1;
    private User user2;
    private Token token1;
    private Token token2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        accessRepository = new AccessRepository();
        user1 = new User("user1", "password1");
        user2 = new User("user2", "password2");
        token1 = new Token("token1");
        token2 = new Token("token2");
    }

    @org.junit.jupiter.api.Test
    void saveToken() {
        accessRepository.saveToken(user1, token1);
        assertTrue(accessRepository.isTokenExists(user1, token1));
    }

    @org.junit.jupiter.api.Test
    void isTokenExists() {
        assertFalse(accessRepository.isTokenExists(user1, token1));
        accessRepository.saveToken(user1, token1);
        assertTrue(accessRepository.isTokenExists(user1, token1));
        assertFalse(accessRepository.isTokenExists(user1, token2));
    }

    @org.junit.jupiter.api.Test
    void isUserExists() {
        assertFalse(accessRepository.isUserExists(user1));
        assertFalse(accessRepository.isUserExists(user2));
        accessRepository.saveToken(user1, token1);
        assertTrue(accessRepository.isUserExists(user1));
        assertFalse(accessRepository.isUserExists(user2));
    }
}

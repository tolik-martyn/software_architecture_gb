package hw11.logic;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user1;
    private User user2;
    private User user3;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        user1 = new User("John", "john123", "password123");
        user2 = new User("Alice", "alice456", "securePass");
        user3 = new User("admin", "admin123");
    }

    @org.junit.jupiter.api.Test
    void getLogin() {
        assertEquals("john123", user1.getLogin());
        assertEquals("alice456", user2.getLogin());
        assertEquals("admin", user3.getLogin());
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
        assertEquals("password123", user1.getPassword());
        assertEquals("securePass", user2.getPassword());
        assertEquals("admin123", user3.getPassword());
    }

    @org.junit.jupiter.api.Test
    void testGetUsername() {
        assertEquals("John", user1.getUsername());
        assertEquals("Alice", user2.getUsername());
        assertNull(user3.getUsername());
    }

    @org.junit.jupiter.api.Test
    void setUsername() {
        user1.setUsername("John Doe");
        user2.setUsername("Alice Smith");
        user3.setUsername("Super Admin");

        assertEquals("John Doe", user1.getUsername());
        assertEquals("Alice Smith", user2.getUsername());
        assertEquals("Super Admin", user3.getUsername());
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        User user1Copy = new User("John", "john123", "password123");
        User user2Copy = new User("Alice", "alice456", "securePass");
        User user3Copy = new User("admin", "admin123");

        assertEquals(user1.hashCode(), user1Copy.hashCode());
        assertEquals(user2.hashCode(), user2Copy.hashCode());
        assertEquals(user3.hashCode(), user3Copy.hashCode());

        assertNotEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
        assertNotEquals(user2.hashCode(), user3.hashCode());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        User user1Copy = new User("John", "john123", "password123");
        User user2Copy = new User("Alice", "alice456", "securePass");
        User user3Copy = new User("admin", "admin123");

        assertEquals(user1, user1Copy);
        assertEquals(user2, user2Copy);
        assertEquals(user3, user3Copy);

        assertNotEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertNotEquals(user2, user3);
    }
}

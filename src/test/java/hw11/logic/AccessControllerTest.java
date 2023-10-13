package hw11.logic;

import hw11.adapter.IAccessManager;
import hw11.data.IAccessRepository;

import static org.mockito.Mockito.*;

/**
 * Тестовый класс для AccessController, который проверяет его методы.
 */
class AccessControllerTest {

    private AccessController accessController;
    private IAccessManager accessManager;
    private IAccessRepository accessRepository;
    private User userReg;
    private User userAuth;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        accessManager = mock(IAccessManager.class);
        accessRepository = mock(IAccessRepository.class);
        accessController = new AccessController(accessManager, accessRepository);
        userReg = new User("testName","testLogin", "testPassword");
        userAuth = new User("testLogin", "testPassword");
    }

    /**
     * Тест на метод registerUser, когда пользователь не существует.
     */
    @org.junit.jupiter.api.Test
    void testRegisterUserWhenUserDoesNotExist() {
        when(accessManager.registerUser()).thenReturn(userReg);
        when(accessRepository.isUserExists(userReg)).thenReturn(false);

        accessController.registerUser();

        verify(accessRepository, times(1)).saveToken(eq(userReg), any(Token.class));
        verify(accessManager, times(1)).dataOutput("Регистрация успешно завершена.");
    }

    /**
     * Тест на метод registerUser, когда пользователь существует и выбирает аутентификацию, логин и пароль совпали.
     */
    @org.junit.jupiter.api.Test
    void testRegisterUserWhenUserExistsAndChoosesToAuthenticateWhenTokenExists() {
        when(accessManager.registerUser()).thenReturn(userReg);
        when(accessRepository.isUserExists(userReg)).thenReturn(true);
        when(accessManager.getUserInput()).thenReturn("да");
        when(accessRepository.isTokenExists(eq(userReg), any(Token.class))).thenReturn(true);

        accessController.registerUser();

        verify(accessManager, times(1)).dataOutput("Авторизация успешно завершена.");
        verify(accessManager, never()).dataOutput("Авторизация не удалась. Проверьте логин и пароль.");

    }

    /**
     * Тест на метод registerUser, когда пользователь существует и выбирает аутентификацию, логин и пароль не совпали.
     */
    @org.junit.jupiter.api.Test
    void testRegisterUserWhenUserExistsAndChoosesToAuthenticateWhenTokenDoesNotExists() {
        when(accessManager.registerUser()).thenReturn(userReg);
        when(accessRepository.isUserExists(userReg)).thenReturn(true);
        when(accessManager.getUserInput()).thenReturn("да");
        when(accessRepository.isTokenExists(eq(userReg), any(Token.class))).thenReturn(false);

        accessController.registerUser();

        verify(accessManager, never()).dataOutput("Авторизация успешно завершена.");
        verify(accessManager, times(1)).dataOutput("Авторизация не удалась. Проверьте логин и пароль.");
    }

    /**
     * Тест на метод registerUser, когда пользователь существует и выбирает не аутентифицироваться.
     */
    @org.junit.jupiter.api.Test
    void testRegisterUserWhenUserExistsAndChoosesNotToAuthenticate() {
        when(accessManager.registerUser()).thenReturn(userReg);
        when(accessRepository.isUserExists(userReg)).thenReturn(true);
        when(accessManager.getUserInput()).thenReturn("нет");

        accessController.registerUser();

        verify(accessManager, times(1)).dataOutput("Отказано в регистрации.");
    }

    /**
     * Тест на метод authenticateUser, когда токен существует.
     */
    @org.junit.jupiter.api.Test
    void testAuthenticateUserWhenTokenExists() {
        when(accessManager.authenticateUser()).thenReturn(userAuth);
        when(accessRepository.isTokenExists(eq(userAuth), any(Token.class))).thenReturn(true);

        accessController.authenticateUser();

        verify(accessManager, times(1)).dataOutput("Авторизация успешно завершена.");
    }

    /**
     * Тест на метод authenticateUser, когда пользователь существует, но токен не существует.
     */
    @org.junit.jupiter.api.Test
    void testAuthenticateUserWhenUserExistsButTokenDoesNotExist() {
        when(accessManager.authenticateUser()).thenReturn(userAuth);
        when(accessRepository.isTokenExists(eq(userAuth), any(Token.class))).thenReturn(false);
        when(accessRepository.isUserExists(eq(userAuth))).thenReturn(true);

        accessController.authenticateUser();

        verify(accessManager, times(1)).dataOutput("Авторизация не удалась. Проверьте логин и пароль.");
    }

    /**
     * Тест на метод authenticateUser, когда пользователь не существует и выбирает регистрацию.
     */
    @org.junit.jupiter.api.Test
    void testAuthenticateUserWhenUserDoesNotExistAndChoosesToRegister() {
        when(accessManager.authenticateUser()).thenReturn(userAuth);
        when(accessRepository.isTokenExists(eq(userAuth), any(Token.class))).thenReturn(false);
        when(accessRepository.isUserExists(eq(userAuth))).thenReturn(false);
        when(accessManager.getUserInput()).thenReturn("да");
        when(accessManager.registerUser()).thenReturn(userReg);
        when(accessRepository.isUserExists(userReg)).thenReturn(false);

        accessController.authenticateUser();

        verify(accessRepository, times(1)).saveToken(eq(userReg), any(Token.class));
        verify(accessManager, times(1)).dataOutput("Регистрация успешно завершена.");

    }

    /**
     * Тест на метод authenticateUser, когда пользователь не существует и выбирает не регистрироваться.
     */
    @org.junit.jupiter.api.Test
    void testAuthenticateUserWhenUserDoesNotExistAndChoosesNotToRegister() {
        when(accessManager.authenticateUser()).thenReturn(userAuth);
        when(accessRepository.isTokenExists(eq(userAuth), any(Token.class))).thenReturn(false);
        when(accessRepository.isUserExists(eq(userAuth))).thenReturn(false);
        when(accessManager.getUserInput()).thenReturn("нет");

        accessController.authenticateUser();

        verify(accessManager, times(1)).dataOutput("Отказано в регистрации.");
    }
}

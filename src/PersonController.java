public class PersonController {


    public static boolean control(String login, String password, String confirmPassword) {
        try {
            checkAlphabet(login);
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            checkAlphabet(password);
            if (password.length() >= 20) {
                throw new WrongPasswordException();
            }
            return password.equals(confirmPassword);
        } catch (WrongLoginException e) {
            System.err.println("Логин не соответствует");
        } catch (WrongPasswordException e) {
            System.err.println("Пароль не соответствует");
        }
        return false;
    }


    private static void checkAlphabet(String login) {
        for (int i = 0; i < login.length(); i++) {
            char c = Character.toLowerCase(login.charAt(i));
            if ((c >= 'a' && c <= 'z') || c == '_' || c >= '0' && c <= '9') {
                continue;
            }
            throw new WrongLoginException();
        }

    }
}


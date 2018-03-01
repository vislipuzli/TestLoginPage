import java.util.Random;

public class User {

    private String login;
    private String password;

    public void setLogin() {

        this.login = generateName();
    }

    public void setPassword() {
        this.password = generatePassword();
    }

    public String getLogin() {

        return this.login;
    }

    public String getPassword() {
        return this.password;
    }



    private String generatePassword() {
        String password = "";
        int lengthOfPassword = generateLength();
        Random rand = new Random();
        for (int i = 0; i < lengthOfPassword; i++){
            String[] sourceOfChars = {randomNum(), randomLowerLetters(), randomUppererLetters()};
            password = password + sourceOfChars[rand.nextInt(3)];
        }
        return password;
    }

    private String randomUppererLetters() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String result = String.valueOf(upperLetters.charAt(rand.nextInt(26)));
        return result;
    }

    private String randomLowerLetters() {
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        String result = String.valueOf(lowerLetters.charAt(rand.nextInt(26)));
        return result;
    }

    private String generateName() {
        int lengthOfName = generateLength();
        String alfaBetical = "abcdefghijklmnopqrstuvwxyz";
        String userName = "";
        Random rand = new Random();
        for (int i = 0; i < lengthOfName; i++){
            userName = userName + alfaBetical.charAt(rand.nextInt(26));
        }
        return userName;
    }

    private int generateLength() {
        Random rand = new Random();
        int length = rand.nextInt(10) + 8;
        return length;
    }

    private String randomNum(){
        String numbers = "0123456789";
        Random rand = new Random();
        String result = String.valueOf(numbers.charAt(rand.nextInt(10)));
        return result;
    }
}

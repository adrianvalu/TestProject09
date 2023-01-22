package Tests.ObjectModels;

public class RegistrationModel {

    private AccountRegistrationModel accountRegister;
    private String firstNameError;
    private String lastNameError;
    private String userError;
    private String passwordError;
    private String confirmPasswordError;

    public RegistrationModel() {
    }

    public RegistrationModel(String firstName, String lastName, String username, String password, String confirmPassword, String firstNameError, String lastNameError, String userError, String passwordError, String confirmPasswordError) {
        AccountRegistrationModel arc = new AccountRegistrationModel();
        arc.setFirstName(firstName);
        arc.setLastName(lastName);
        arc.setUsername(username);
        arc.setPassword(password);
        arc.setConfirmPassword(confirmPassword);

        this.accountRegister = arc;
        this.firstNameError = firstNameError;
        this.lastNameError = lastNameError;
        this.userError = userError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
    }

    public AccountRegistrationModel getAccountRegister() {
        return accountRegister;
    }

    public void setAccountRegister(AccountRegistrationModel accountRegister) {
        this.accountRegister = accountRegister;
    }

    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    @Override
    public String toString() {
        return "RegisterData{" + "accountRegister={firstName:" + accountRegister.getFirstName() +
                ",lastName:" + accountRegister.getLastName() + ",username:" + accountRegister.getUsername() +
                ",password:" + accountRegister.getPassword() + ",confirmPassword:" + accountRegister.getConfirmPassword() +  "}, " +
                "firstNameError='" + firstNameError + '\'' + ", lastNameError='" + lastNameError + '\'' + ", userError='" +
                userError + '\'' + ", passwordError='" + passwordError + '\'' + ", confirmPasswordError='" + confirmPasswordError + '\'' + '}';
    }
}

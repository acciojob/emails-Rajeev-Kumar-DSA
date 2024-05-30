package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(newPassword)){
            if (checkingValidPasswordOrNot(newPassword)){
                this.password = newPassword;  // update the password with newPassword
//                System.out.println("Password has been updated");
            }else {
//                System.out.println("provided new password is not matched the rule.....");
            }
        }else{
//            System.out.println("given password not matched with oldPassword");
        }
    }

    public boolean checkingValidPasswordOrNot(String password){
        if(password.length() < 8){
            return false;
        }
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (int i=0; i<password.length(); i++){
            char ch = password.charAt(i);

            // checking the current char is Uppercase or not [ASCII range - 65 to 90]
            if((ch>='A') && (ch<='Z')){
               uppercase = true;
            }else if(ch>='a' && ch<='z'){
                // checking the current char is lowercase or not [ASCII range - 97 to 122]
                lowercase = true;
            }else if(ch>='0' && ch<='9'){
                // checking the current char is digit or not [ASCII range - 48 to 57]
                digit = true;
            }else{
                // checking the current char is special char or not {remaining other char will count as a special char}
                specialChar = true;
            }
        }

        // when all will be true that time my password will be consideriable, otherwise not
        return uppercase && lowercase && digit && specialChar;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Admin
 */
public class Utilities {
    
    public static boolean validateCharacters(String input, String validChars) {
        for (int i = 0; i < input.length(); i++) {
            if (!validChars.contains(String.valueOf(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    
}

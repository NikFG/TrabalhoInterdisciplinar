/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Leonardo
 */
public class EmailValidator {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    /**
     *
     */
    public EmailValidator() {
            pattern = Pattern.compile(EMAIL_PATTERN);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Validate hex with regular expression
     *
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

            matcher = pattern.matcher(hex);
            return matcher.matches();

    }
    //</editor-fold>
    
}
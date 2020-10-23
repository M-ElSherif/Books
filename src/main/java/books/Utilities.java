/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 *
 * @author thesh
 */
public class Utilities {

    public enum HandleDefault {
        Include, Exclude
    }

    public static Set<String> getSupportedLocales(HandleDefault defHandler) {
        Application app = FacesContext.getCurrentInstance().getApplication();
        Set<String> languageCodes = new HashSet<>();
        for (Iterator<Locale> itr = app.getSupportedLocales();
                itr.hasNext();) {
            Locale locale = itr.next();
            languageCodes.add(locale.getLanguage());
        }

        String defaultLang = app.getDefaultLocale().getLanguage();
        if (defHandler == HandleDefault.Exclude) {
            languageCodes.remove(defaultLang);
        } else {
            languageCodes.add(defaultLang);
        }
        return languageCodes;
    }

    public static String getMessage(String key) {
        ResourceBundle messageBundle = ResourceBundle.getBundle("i18n.books.messages");
        try {
            return messageBundle.getString(key);
        } catch (MissingResourceException e) {
            return "<unkown resource: " + key + ">";
        }
    }
}

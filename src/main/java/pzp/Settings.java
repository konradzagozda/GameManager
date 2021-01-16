package pzp;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Settings for all controllers
 * @author kochr
 */
public class Settings {
    private Locale locale;
    private ResourceBundle bundle;
    private String themePath = "/themes/lightTheme.css";
    private String fontPath = "/themes/font10.css";
    
    private String languageName = "English";
    private String themeName = "theme.light";
    private String fontName = "10pt";

    public Settings() {
    }
    
    public void setLang(Locale newlocale) {
        locale = newlocale;
        Locale.setDefault(locale);
        bundle = ResourceBundle.getBundle("lang", locale);
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
    
    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
    
    public String getThemePath() {
        return themePath;
    }

    public void setThemePath(String themePath) {
        this.themePath = themePath;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
        if (themeName.equals("theme.light")) {
            setThemePath("/themes/lightTheme.css");
        } else if (themeName.equals("theme.dark")) {
            setThemePath("/themes/darkTheme.css");
        } else if (themeName.equals("theme.pink")) {
            setThemePath("/themes/pinkTheme.css");
        }
    }
    
    public String getFontPath() {
        return fontPath;
    }

    public void setFontPath(String fontPath) {
        this.fontPath = fontPath;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
         if (fontName.equals("10pt")) {
            setFontPath("/themes/font10.css");
        } else if (fontName.equals("12pt")) {
            setFontPath("/themes/font12.css");
        } else if (fontName.equals("14pt")) {
            setFontPath("/themes/font14.css");
        }
    }
}

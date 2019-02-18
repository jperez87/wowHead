package org.autom.fr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PagePersonnage {

    public WebDriver driver;
    
	@SuppressWarnings("null")
	public String trouverNombreOjet(WebElement element) {
	    String intButin = element.getText();
	    System.err.println("texte butin = "+intButin);

	    intButin = element.getText().substring(intButin.length()-2, intButin.length()-1);
	    System.err.println("texte extrait butin = "+intButin);
	    return intButin;
    }
	
	public PageItem accederItem(WebElement item) {
		item.click();
        return PageFactory.initElements(driver, PageItem.class);
	}
}

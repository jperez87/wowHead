package org.autom.fr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultatRecherche {

    public WebDriver driver;
    
    

    
    public void accesOnglet(WebElement onglet) {
        onglet.click();
    }
    
    public PagePersonnage accesPersonnage(WebElement personnage) {
    	personnage.click();
        return PageFactory.initElements(driver, PagePersonnage.class);
    }
}

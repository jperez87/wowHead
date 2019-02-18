package org.autom.fr.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	public WebDriver driver;



	public ResultatRecherche rechercheGlobale(WebElement element, WebElement elementClickable, String rechercheTexte) {
		element.clear();
		element.sendKeys(rechercheTexte);
		elementClickable.click();

		return PageFactory.initElements(driver, ResultatRecherche.class);
	}



}

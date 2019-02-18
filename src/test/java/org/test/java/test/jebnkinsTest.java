package org.test.java.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import junit.framework.Assert;

import org.junit.Before;


import org.autom.fr.pages.HomePage;
import org.autom.fr.pages.PageItem;
import org.autom.fr.pages.PagePersonnage;
import org.autom.fr.pages.ResultatRecherche;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;


public class jebnkinsTest extends HomePage {

	public String TUT = System.getProperty("navigateur");
	public WebDriver driver;

	
	@Before
	public void monbefore() throws InterruptedException {	


		if (TUT.equals("chrome")) {
			System.setProperty("driver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(TUT.equals("firefox")) {
			System.setProperty("driver.gecko.driver", "C:\\Users\\formation\\Desktop\\SUT\\geckodriver.exe");
			driver = new FirefoxDriver();

		};
		// TODO Auto-generated method stub
		//System.setProperty("driver.ie.driver", "C:\\Users\\formation\\Desktop\\SUT\\IEDriverServer.exe");

		System.err.println(driver);

		driver.manage().window().maximize();
		driver.get("https://fr.wowhead.com/");

		Thread.sleep(5000);
		if (By.xpath("//div[contains(.,'Ads help us run this site')]") != null){
			WebElement buttonCookie = driver.findElement(By.xpath("//button[contains(.,'Continue Using Site')]"));
			buttonCookie.click();
		}
		
		Thread.sleep(5000);
		WebElement buttonPiger = driver.findElement(By.xpath("//button[contains(.,\"J'ai pigé\")]"));
		buttonPiger.click();

	}

	@Test 
	public void monTestSelenium() throws InterruptedException {	
		System.out.println("**********************DEBUT DES TESTS**********************");
		
		HomePage homePage = new HomePage();

		WebElement barreRecherche = driver.findElement(By.xpath("//input[@type='text' and @name='q']"));
		WebElement searchButton = driver.findElement(By.xpath("//a[@class='header-search-button fa fa-search']"));

		String recherchePersonnage = "Lardeur";
		ResultatRecherche pageResultat = new ResultatRecherche();

		pageResultat = homePage.rechercheGlobale(barreRecherche, searchButton, recherchePersonnage);

		WebElement pNj = driver.findElement(By.xpath("//a[@href='#npcs']/div[contains(.,'PNJ')]"));
		pageResultat.accesOnglet(pNj);


		//WebElement tableResultat = driver.findElement(By.xpath("//div[@id='tab-npcs']/descendant::table[@class='listview-mode-default']"));
		WebElement personageLardeur = driver.findElement(By.xpath("//td[@class='icon-boss-padded']/a"));




		PagePersonnage pageLardeur = new PagePersonnage();
		pageLardeur = pageResultat.accesPersonnage(personageLardeur);
		WebElement butin = driver.findElement(By.xpath("//a[contains(div,'Butin')]/div"));
		WebElement item1 = driver.findElement(By.xpath("//table[@class='listview-mode-default']/tbody/tr[1]/td[2]"));


		String resultatObjet;
		resultatObjet = pageLardeur.trouverNombreOjet(butin);
		Assert.assertEquals("5", resultatObjet);

		PageItem pageDeuxiemeObjet = new PageItem();
		pageDeuxiemeObjet = pageLardeur.accederItem(item1);


	}


	@After
	public void quitterNavigateur() {
		driver.close();
		driver.quit();
	}
}

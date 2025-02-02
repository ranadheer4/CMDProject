package com.cmd.Settings;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cps.ObjectRepository.Cmd_Add_User;
import com.cps.ObjectRepository.Payer_Settings;
import com.cps.genericUtility.BaseClass;
import com.cps.genericUtility.ExcelUtility;
import com.cps.genericUtility.FileUtility;
import com.cps.genericUtility.IConstants;
import com.cps.genericUtility.JavaUtility;
import com.cps.genericUtility.WebDriverUtility;
@Listeners(com.cps.genericUtility.ItestListenerImtn.class)
public class Payer_Setting extends BaseClass {
	static {
		System.setProperty(IConstants.chromeKey, IConstants.chromeValue);
	}
	
	@Test(groups="smokeTest" ,retryAnalyzer = com.cps.genericUtility.RetryAnalyserImptn.class)
	public void payerSetting() throws InterruptedException, IOException, AWTException {
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.waitTillPageGetsLoadImplicitlyWait(driver, 30);
		Cmd_Add_User cd = new Cmd_Add_User(driver);
	    cd.mouseMover(driver);
	    cd.clickSettings();
	    Payer_Settings ps=new Payer_Settings(driver);
	    ps.getPayerSettings().click();
	    Thread.sleep(5000);
	    ps.getPageClick().click();
	    Thread.sleep(5000);
	    ps.getTinDropDown().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 0));
	    cd.clickEnter(driver);
	    Thread.sleep(3000);
		ps.getLocationDropDown().click();
		Robot s=new Robot();
		s.keyPress(KeyEvent.VK_DOWN);
		s.keyRelease(KeyEvent.VK_DOWN);
	    Thread.sleep(5000);
		s.keyPress(KeyEvent.VK_DOWN);
		s.keyRelease(KeyEvent.VK_DOWN);
	    Thread.sleep(5000);
		cd.clickEnter(driver);
		Thread.sleep(5000);
		s.keyPress(KeyEvent.VK_ESCAPE);
		s.keyRelease(KeyEvent.VK_ESCAPE);
		ps.getProviderDropDown().click();
		Thread.sleep(5000);
		s.keyPress(KeyEvent.VK_DOWN);
		s.keyRelease(KeyEvent.VK_DOWN);
		cd.clickEnter(driver);
		ps.getPayerOne().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 1));
		cd.clickEnter(driver);
		ps.getPayerType().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 2));
		cd.clickEnter(driver);
		ps.getContractType().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 3));
		cd.clickEnter(driver);
		ps.getParticipationStatus().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 4));
		cd.clickEnter(driver);
		Thread.sleep(5000);
//		ps.getClickCalendar().click();
//		ps.getSelectMonthType().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 5));
//		ps.getSelectYearType().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 6));
//		Thread.sleep(5000);
//		ps.getDay().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 7));
		ps.getProviderNo().sendKeys(eLib.readDataFromExcel("Payer_Settings", 1, 8));
		ps.clickSave();
		Thread.sleep(7000);
}
}
//comment out
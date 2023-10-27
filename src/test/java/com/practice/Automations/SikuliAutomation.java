package com.practice.Automations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliAutomation {

	public static void main(String[] args) throws Throwable {
	Robot robo = new Robot();
	Screen sc = new Screen();
	Pattern Ec_Min = new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\min.png");
	sc.click(Ec_Min);
	Pattern ChromeIcon =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\TaskBarChromeIcon.png");
	sc.click(ChromeIcon);
	Thread.sleep(1000);
	Pattern NewTabIcon =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\NewTabicon.png");
	sc.click(NewTabIcon);
	Pattern Searchbar =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\GoogleSearch.png");
	sc.type(Searchbar,"word to pdf converter");
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyRelease(KeyEvent.VK_ENTER);
	Pattern clickOnres =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\ResultClick.png");
	sc.click(clickOnres);
	Pattern ChooseFiles =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\ChooseFilesIcon.png");
	sc.click(ChooseFiles);
	Pattern file =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\file.png");
	sc.click(file);
	Pattern openbtn =new Pattern("G:\\Selenium Practice\\com.hms.royalFreeHospital\\Images\\InputImages\\open.png");
	sc.click(openbtn);
	
	}

}

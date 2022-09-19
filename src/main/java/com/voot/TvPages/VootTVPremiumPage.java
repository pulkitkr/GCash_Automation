package com.voot.TvPages;

import org.openqa.selenium.By;

public class VootTVPremiumPage {
	
	//Biggest InterNational Tray validation
	public static By objTrayName=By.xpath("//*[@text='Biggest International Shows']");
	public static By objPremiumTab=By.xpath("//*[@text='Premium']");
	public static By objPremiumRail=By.xpath("(//*[@id='header_rail_content_image'])[1]");
	public static By objHaloThumbnail=By.xpath("(//*[@contentDescription='Biggest International Shows']/*/*/*[@id='flexi_image_view'])[1]");
	public static By objHaloText=By.xpath("//*[@text='Halo']");
	

}

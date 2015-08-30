package com.lrd.inventory.values;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenElementDimention {

	
	
	public final static int XS_WIDTH=50;
	public final static int SM_WIDTH=100;
	public final static int MD_WIDTH=150;
	public final static int LG_WIDTH=200;
	public final static int XL_WIDTH=300;
	
	
	public final static int XS_HEIGHT=20;
	public final static int SM_HEIGHT=25;
	public final static int MD_HEIGHT=30;
	public final static int LG_HEIGHT=35;
	public final static int XL_HEIGHT=40;
	
	public final static int XS_GAP=10;
	public final static int SM_GAP=20;
	public final static int MD_GAP=30;
	public final static int LG_GAP=40;
	public final static int XL_GAP=50;

	
	
	
	public final int SCREEN_WIDTH;
	public final int SCREEN_HEIGHT;
	
	public ScreenElementDimention() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		SCREEN_WIDTH=screenSize.width;
		SCREEN_HEIGHT=screenSize.height;
	}

}

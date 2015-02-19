package pix.view;

import javax.swing.JFrame;

import pix.controller.FauxToeShopController;

public class FauxToeShopFrame extends JFrame
{

	private FauxToeShopPanel basePanel;
	private FauxToeShopMenu baseMenu;
	private FauxToeShopController baseController;
	
	public FauxToeShopFrame(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		basePanel = new FauxToeShopPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(600,400);
		this.setContentPane(basePanel);
		this.setVisible(true);
	}
}

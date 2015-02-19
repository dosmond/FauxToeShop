package pix.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;

public class FauxToeShopPanel extends JPanel
{

	private FauxToeShopController baseController;
	
	private JComboBox<String> filterBox;
	private JComboBox<String> imageBox;
	private JScrollPane imagePane;
	private String[] imageArray;
	private SpringLayout baseLayout;
	
	private Picture basePicture;
	
	public FauxToeShopPanel(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		
		filterBox = new JComboBox();
		filterBox.setMaximumRowCount(25);
		imagePane = new JScrollPane();
		basePicture = new Picture("beach.jpg");
		baseLayout = new SpringLayout();
		
		setupPicture();
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	

	
	private void setupComboBox()
	{
		
		String [] filterArray = 
			{
				"testStripedFilter",
			    "testZeroBlue",
			    "testKeepOnlyBlue",
			    "testKeepOnlyRed",
			    "testKeepOnlyGreen",
			    "testNegate",
			    "testGrayscale",
			    "testFixUnderwater",
			    "testMirrorVertical",
			    "testMirrorTemple",
			    "testMirrorArms",
			    "testMirrorGull",
			    "testMirrorDiagonal",
			    "testCollage",
			    "testCopy",
			    "testEdgeDetection",
			    "testEdgeDetection2",
			    "testChromakey",
			    "testEncodeAndDecode",
			    "testGetCountRedOverValue",
			    "testSetRedToHalfValueInTopHalf",
			    "testClearBlueOverValue",
			    "testGetAverageForColumn"
			 };
		
	
		
		imageBox = new JComboBox<String>(imageArray);
		filterBox = new JComboBox<String>(filterArray);
	}
	

	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setSize(600, 400);
		this.add(filterBox);
		this.add(imagePane);
	}
	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
		
	}
	
	private void loadPicture()
	{
	
		basePicture = new Picture(imageArray[imageBox.getSelectedIndex()]);
		setupPicture();
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, filterBox, 28, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, filterBox, 278, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		filterBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
				if(filterBox.getSelectedIndex() == 0)
				{
					loadPicture();
					basePicture.stripedFilter();
					setupPicture();
				}
			    else if(filterBox.getSelectedIndex() == 1)
				{
					loadPicture();
					basePicture.zeroBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 2)
				{
					loadPicture();
					basePicture.keepOnlyBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 3)
				{
					loadPicture();
					basePicture.keepOnlyRed();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 4)
				{
					loadPicture();
					basePicture.keepOnlyGreen();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 5)
				{
					loadPicture();
					basePicture.negate();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 6)
				{
					loadPicture();
					basePicture.grayscale();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 7)
				{
					loadPicture();
					basePicture.keepOnlyBlue();
					setupPicture();
				}
				
			}
		});
	}
}


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

import javax.swing.Timer;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  //j///////u/////s//////// methods ///////////////////////////////////////tin
  
         /** 
        zeroBlue() method sets the blue values at all pixels to zero 
     */
      public void zeroBlue()
      {
        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] rowArray : pixels)
         {
           for (Pixel p: rowArray)
           {
                  p.setBlue(0);
           }
        }
      }


      public void keepOnlyBlue()
      {
        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] rowArray : pixels)
         {
           for (Pixel p: rowArray)
           {
                  p.setRed(0);
                  p.setGreen(0);
           }
        }
      }
     
      public void negate()
      {
        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] rowArray : pixels)
         {
           for (Pixel p: rowArray)
           {
                  p.setRed(255-p.getRed());
                  p.setGreen(255-p.getGreen());
                  p.setBlue(255-p.getBlue());
           }
        }
      }


      public void grayScale()
      {
        Pixel[][] pixels = this.getPixels2D();
        int count = 0;

        for (int i = 0;i<pixels.length;i++) {
        	for(int j = 0;j<pixels[0].length;j++) {
        		count += pixels[i][j].getRed();
        		count += pixels[i][j].getGreen();
        		count += pixels[i][j].getBlue();
        		count/=3;
        		pixels[i][j].setRed(count);
        		pixels[i][j].setGreen(count);
        		pixels[i][j].setBlue(count);
        		count = 0;
        	}
        }  

      }
      
      public void fixUnderwater()
      {
          Pixel[][] pixels = this.getPixels2D();

          for (Pixel[] rowArray : pixels)
           {
             for (Pixel p: rowArray)
             {
                p.setRed(p.getRed()*10);
                //p.setBlue(p.getBlue()/3);
                 
             }
          }
    	  
      }
        
      /* mirrorVertical() */
      public void mirrorVertical()
      {
           Pixel[][] pixels = this.getPixels2D();
           Pixel leftPixel = null;
           Pixel rightPixel = null;
           int width = pixels[0].length;
           for (int row = 0; row < pixels.length; row++)
           {
                for (int col = 0; col < width / 2; col++)
                {
                     leftPixel = pixels[row][col];
                     rightPixel = pixels[row][width - 1 - col];
                     rightPixel.setColor(leftPixel.getColor());
                }
           }
      }
      
      
      /* mirrorVertical() */
      public void mirrorVerticalRightToLeft()
      {
           Pixel[][] pixels = this.getPixels2D();
           Pixel leftPixel = null;
           Pixel rightPixel = null;
           int width = pixels[0].length;
           for (int row = 0; row < pixels.length; row++)
           {
                for (int col = 0; col < width / 2; col++)
                {
                     leftPixel = pixels[row][col];
                     rightPixel = pixels[row][width - 1 - col];
                     leftPixel.setColor(rightPixel.getColor()); // changed
                }
           }
      }
      
      public void mirrorHorizantal()
      {
           Pixel[][] pixels = this.getPixels2D();
           Pixel topPixel = null;
           Pixel bottomPixel = null;
           int height = pixels.length;
           for (int row = 0; row < height; row++)
           {
                for (int col = 0; col < pixels[0].length; col++)
                {
                    topPixel = pixels[row][col];
                    bottomPixel = pixels[col][height - 1 - row];
                    topPixel.setColor(bottomPixel.getColor());
                }
           }
      }

  
      
      
      
      public void mirrorGull(){
    		Pixel leftPixel = null;
      		Pixel rightPixel = null;
      		
      		Pixel[][] pixels = this.getPixels2D();

      		
      		for (int row = 230; row < 340; row++)
      		{
      			 //pixels[row][10].setColor(Color.red);// dimensions of the size from top to bottom
      			for (int col = 240; col < 360; col++)
      			{

      				leftPixel = pixels[row][col];
      				rightPixel = pixels[row][360- col + 360];
      				rightPixel.setColor(leftPixel.getColor());
      			
      				
      				// pixels[270][col].setColor(Color.red); //left to right, reflects over
      				
      			}
      		}
      }
      

      
      
      
      public void mirrorArms(){
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length;i++){
          for(int j = 0;j<pixels[0].length;j++){
            if(j>70 && j<175 || j>235 && j<330){
      
              if(pixels[i][j].getAverage()>25 && pixels[i][j].getAverage()<110
              && i<210) {
                pixels[i+60][j].setColor(pixels[i][j].getColor());
              }
        
            }
          }
        }
      }
      public void mirrorHorizantalBotToTop() {
           Pixel[][] pixels = this.getPixels2D();
           Pixel topPixel = null;
           Pixel bottomPixel = null;
           int height = pixels.length;
           for (int row = 0; row < height; row++)
           {
                for (int col = 0; col < pixels[0].length; col++)
                {
                    topPixel = pixels[row][col];
                    bottomPixel = pixels[height - 1 - row][col];
                    topPixel.setColor(bottomPixel.getColor());
                }
           }
      }


  	public void mirrorTemple()
  	{

  		Pixel leftPixel = null;
  		Pixel rightPixel = null;
  		int count = 0;
  		Pixel[][] pixels = this.getPixels2D();

  		
  		for (int row = 30; row < 100; row++)
  		{
  			// pixels[row][10].setColor(Color.red); dimensions of the size from top to bottom
  			for (int col = 10; col < 270; col++)
  			{

  				leftPixel = pixels[row][col];
  				rightPixel = pixels[row][280- col + 280];
  				rightPixel.setColor(leftPixel.getColor());
  				count++;
  				
  				//pixels[270][col].setColor(Color.red); left to right, reflects over
  				
  			}
  		}

  		
  		System.out.println(count);
  	}


  	

      
      
      
       /** copy from the passed fromPic to the
         * specified startRow and startCol in the
         * current picture
         * @param fromPic the picture to copy from
         * @param startRow the start row to copy to
         * @param startCol the start col to copy to
         */
       public void copy(Picture fromPic, 
                      int startRow, int startCol)
       {
         Pixel fromPixel = null;
         Pixel toPixel = null;
         Pixel[][] toPixels = this.getPixels2D();
         Pixel[][] fromPixels = fromPic.getPixels2D();
         for (int fromRow = 0, toRow = startRow; 
              fromRow < fromPixels.length &&
              toRow < toPixels.length; 
              fromRow++, toRow++)
         {
           for (int fromCol = 0, toCol = startCol; 
                fromCol < fromPixels[0].length &&
                toCol < toPixels[0].length;  
                fromCol++, toCol++)
           {
             fromPixel = fromPixels[fromRow][fromCol];
             toPixel = toPixels[toRow][toCol];
             toPixel.setColor(fromPixel.getColor());
           }
         }   
       }

  public void edgeDetection(int edgeDist)
      {
           Pixel leftPixel = null;
           Pixel rightPixel = null;
           Pixel[][] pixels = this.getPixels2D();
           Color rightColor = null;
           for (int row = 0; row < pixels.length; row++)
           {
                for (int col = 0; col < pixels[0].length-1; col++)
                {
                     leftPixel = pixels[row][col];
                     rightPixel = pixels[row][col+1];
                     rightColor = rightPixel.getColor();
                     if (leftPixel.colorDistance(rightColor) >
                     edgeDist)
                        leftPixel.setColor(Color.BLACK);
                     else
                        leftPixel.setColor(Color.WHITE);
                }
           }
      }
      
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */


  public void miniQuiz(){
    Pixel[][] pixels = this.getPixels2D();
    int width = pixels[0].length;


    int random = 0;
	    
		
	 
    for (int row = 0; row < pixels.length; row++) {
	    for (int col = 0; col < width; col++) {
	      random = (int)(Math.random()*55);          
	      if(pixels[row][col].getAverage()<=30){
	        pixels[row][col].setRed(200+random);
	        pixels[row][col].setBlue(50+random);
	        pixels[row][col].setGreen(50+random);
	      } else if(pixels[row][col].getAverage()>220) {
	    	random = (int)(Math.random()*235);
	    	pixels[row][col].setBlue(pixels[row][col].getBlue()-random);  
	    	pixels[row][col].setRed(pixels[row][col].getRed()-random); 
	      }
	    
	      pixels[row][col].setRed(pixels[row][col].getRed()*2-20);
	      pixels[row][col].setBlue(pixels[row][col].getBlue()*2-30);
	      pixels[row][col].setGreen(pixels[row][col].getGreen()/2-40);

	    } 
    }
	
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	
	for (int row = 80; row < 200; row++)
	{
				
		// loop from 13 to just before the mirror point
		for (int col = 13; col < 100; col++)
		{
			//pixels[row][col].setColor(Color.red);
			leftPixel = pixels[row][col];
			rightPixel = pixels[row][75 - col + 75];
			rightPixel.setColor(leftPixel.getColor());
			
		}
	}
	
	
	
	
     mirrorVertical();
    
    
    
	
  }


     


   
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 

  
} // this } is the end of class Picture, put all new methods before this
 
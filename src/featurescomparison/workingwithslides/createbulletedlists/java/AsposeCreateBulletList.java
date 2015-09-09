package featurescomparison.workingwithslides.createbulletedlists.java;

import java.awt.Color;

import com.aspose.slides.BulletType;
import com.aspose.slides.ColorType;
import com.aspose.slides.IAutoShape;
import com.aspose.slides.ISlide;
import com.aspose.slides.ITextFrame;
import com.aspose.slides.NullableBool;
import com.aspose.slides.NumberedBulletStyle;
import com.aspose.slides.Paragraph;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.ShapeType;

public class AsposeCreateBulletList
{
	public static void main(String[] args)
	{
		String dataPath = "src/featurescomparison/workingwithslides/createbulletedlists/data/";
		
		//Instantiate a Presentation class that represents a PPTX file
	    Presentation pres = new Presentation();

	    //Accessing first slide
	    ISlide slide = pres.getSlides().get_Item(0);

	    //Adding and accessing Autoshape
	    IAutoShape aShp = slide.getShapes().addAutoShape(ShapeType.Rectangle, 200, 200, 400, 200);

	    //Accessing the text frame of created autoshape
	    ITextFrame txtFrm = aShp.getTextFrame();

	    //Removing the default exisiting paragraph
	    txtFrm.getParagraphs().removeAt(0);

	    //Creating a paragraph
	    Paragraph para = new Paragraph();

	    //Setting paragraph bullet style and symbol
	    para.getParagraphFormat().getBullet().setType(BulletType.Symbol);
	    para.getParagraphFormat().getBullet().setChar((char) 8226);

	    //Setting paragraph text
	    para.setText("Welcome to Aspose.Slides");

	    //Setting bullet indent
	    para.getParagraphFormat().setIndent(25);

	    //Setting bullet color
	    para.getParagraphFormat().getBullet().getColor().setColorType(ColorType.RGB);
	    para.getParagraphFormat().getBullet().getColor().setColor(Color.BLACK);

	    // set IsBulletHardColor to true to use own bullet color
	    para.getParagraphFormat().getBullet().isBulletHardColor(NullableBool.True);

	    //Setting Bullet Height
	    para.getParagraphFormat().getBullet().setHeight(100);

	    //Adding Paragraph to text frame
	    txtFrm.getParagraphs().add(para);

	    //Creating second paragraph
	    Paragraph para2 = new Paragraph();

	    //Setting paragraph bullet type and style
	    para2.getParagraphFormat().getBullet().setType(BulletType.Numbered);
	    para2.getParagraphFormat().getBullet().setNumberedBulletStyle(NumberedBulletStyle.BulletCircleNumWDBlackPlain);

	    //Adding paragraph text
	    para2.setText("This is numbered bullet");

	    //Setting bullet indent
	    para2.getParagraphFormat().setIndent(25);

	    para2.getParagraphFormat().getBullet().getColor().setColorType(ColorType.RGB);
	    para2.getParagraphFormat().getBullet().getColor().setColor(Color.BLACK);

	    // set IsBulletHardColor to true to use own bullet color
	    para2.getParagraphFormat().getBullet().isBulletHardColor(NullableBool.True);


	    //Setting Bullet Height
	    para2.getParagraphFormat().getBullet().setHeight(100);

	    //Adding Paragraph to text frame
	    txtFrm.getParagraphs().add(para2);

	    //saving the presentation as a PPTX file
	    pres.save(dataPath + "AsposeBullets.ppt", SaveFormat.Ppt);
	    
	    System.out.println("Done...");
	}
}
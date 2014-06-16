package unitTest;

import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import model.FileDataBase;

import org.junit.Assert;
import org.junit.Test;

public class FetchFromFileTest {
	@Test
	public void testFecthFromFile(){
		String datas;
		try {
			datas = FileDataBase.readFromFile(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas"+"/" + "basicInfos.txt");
			Assert.assertNotNull(datas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
		
	}
}

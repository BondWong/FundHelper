package unitTest;

import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import model.FileDataBase;

import org.junit.Assert;
import org.junit.Test;

public class FetchFromFileTest {
	@Test
	public void testFecthFromFile() throws IOException{
		String datas = FileDataBase.readFromFile(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas"+"/" + "basicInfos.txt");
		
		Assert.assertNotNull(datas);
	}
}

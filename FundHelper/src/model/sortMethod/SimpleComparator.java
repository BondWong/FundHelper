package model.sortMethod;

import java.util.Comparator;

import javax.swing.filechooser.FileSystemView;

import com.google.gson.Gson;

public abstract class SimpleComparator implements Comparator<String>{
	protected static String root = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas";
	protected static Gson gson = new Gson();
	
}

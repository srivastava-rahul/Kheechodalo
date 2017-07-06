package com.click.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



public class Test {
//	public static void main(String[] args) throws Exception, IOException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject", "root", "root");
//
//		String INSERT_PICTURE = "insert into MyPictures(id, name, photo) values (?, ?, ?)";
//
//		PreparedStatement ps = null;
//		FileInputStream fis = null;
//
//		long timeNow = System.currentTimeMillis();
//		System.out.println(new Date(timeNow));
//
//		try {
//			conn.setAutoCommit(false);
//
//			File folder = new File("/home/parveen/Pictures/pr/in/");
//			File[] listOfFiles = folder.listFiles();
//
//			for (int i = 0; i < listOfFiles.length; i++) {
//				System.out.println("=======");
//				File file = new File("/home/parveen/Pictures/pr/in/" + listOfFiles[i].getName());
//				System.out.println("====file name ==="+ file.getAbsolutePath());
//				
//				fis = new FileInputStream(file);
//				ps = conn.prepareStatement(INSERT_PICTURE);
//				ps.setInt(1, i);
//				ps.setString(2, "image" + i);
//				ps.setBinaryStream(3, fis, (int) file.length());
//				ps.executeUpdate();
//				conn.commit();
//
//			}
//		} finally {
//			ps.close();
//			fis.close();
//			long timeNow1 = System.currentTimeMillis();
//			System.out.println(new Date(timeNow1));
//		}
//	}
	public static void main(String args[]){
        try{
        	 Class.forName("com.mysql.jdbc.Driver");
        	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject", "root", "root");
             
            byte b[];
            Blob blob;
    		long timeNow = System.currentTimeMillis();
    		System.out.println(new Date(timeNow));
    		System.out.println(timeNow);
            PreparedStatement ps=conn.prepareStatement("select * from MyPictures"); 
            ResultSet rs=ps.executeQuery();
            int i = 0;
            
            FileOutputStream fos = null;
            while(rs.next()){
            	System.out.println(rs.getString(2));
                blob=rs.getBlob("photo");
                File folder = new File("/home/parveen/Pictures/pr/out/image"+ i++ +".png");
                b=blob.getBytes(1,(int)blob.length());
                fos=new FileOutputStream(folder);
                fos.write(b);
                //System.out.println(i);
            }
            
            System.out.println(new Date(timeNow));
            System.out.println(timeNow);
            ps.close();
            fos.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

package com.kafka.detectlog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by zhang on 2015/7/16.
 */
public class FileGenerator {
    private final String directoryPath;
    private final Integer threadSleepTime;

    public FileGenerator(String directoryPath, Integer threadSleepTime) {
        this.directoryPath = directoryPath;
        this.threadSleepTime = threadSleepTime;
    }


    /**
     * Creat mail content.
     * @throws IOException
     * @throws InterruptedException
     */
    private void creatContent() throws IOException, InterruptedException {
        while(true){
            String fileName = directoryPath + "File-" + new Date();

            FileOutputStream fout = new FileOutputStream( fileName );
            FileChannel fc = fout.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate( 1024 );
            buffer.put( getStaticFileContent(fileName));
            buffer.flip();

            fc.write( buffer );

            buffer.clear();
            fc.close();
            fout.close();

            System.out.println("created file - "  + fileName);

            Thread.sleep(threadSleepTime * 1000);
        }
    }

    /**
     * Gets the static file content.
     *
     * @param fileName the file name
     * @return the static file content
     */
    private static byte[] getStaticFileContent(String fileName){
        StringBuilder content = new StringBuilder();

        content.append("File Name - " + fileName);
        content.append("The first  line");
        content.append("The second line");
        content.append("The third  line");
        content.append("The fourth line");

        return content.toString().getBytes();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        FileGenerator createFile;

        try {
            //指定一个路径
            String path = "/home/songyang/kafkadata/test/";
            //指定间隔时间
            String sleepTime  = "5";

            createFile = new FileGenerator(path, Integer.parseInt(sleepTime));
            createFile.creatContent();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

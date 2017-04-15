/**
 * 
 */
package demo;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/**
 * @author Arockia
 *
 */
public class ReadFileListener implements ReadListener {

	ServletInputStream servletInputStream;
	AsyncContext asyncContext;
	volatile StringBuffer stringBuffer;

	public ReadFileListener(ServletInputStream servletInputStream,AsyncContext asyncContext) {
		this.servletInputStream = servletInputStream;
		this.asyncContext = asyncContext;
		stringBuffer=new StringBuffer();
	}

	@Override
	public void onAllDataRead() throws IOException {
		System.out.println("\nRead process is complated\n");
		System.out.println(stringBuffer);
	}

	@Override
	public void onDataAvailable() throws IOException {
		System.out.println("\nRead process is started\n");
		byte[] bytes=new byte[1024];
		int len=-1;
		while(servletInputStream.isReady() && (len=servletInputStream.read(bytes))!=-1){
			String tmp=new String(bytes, 0, len);
			stringBuffer.append(tmp);
		}
	}

	@Override
	public void onError(Throwable arg0) {
		System.out.println("\nsorry error occured");
		arg0.printStackTrace();
	}

}

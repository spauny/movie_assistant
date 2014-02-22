package verii.movie_assistant;

import java.io.IOException;
import java.util.Timer;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.webbitserver.WebServer;
import org.webbitserver.WebServers;
import org.webbitserver.WebSocketConnection;

@Test(singleThreaded=true)
public class TestTikiIslandNativeOSX {
	
	private static final int    SEC_10 							 = 10;
	
	private static final String RES_ELEM_FOUND 					 = "<return value='%s' dataType='object'/>";
	private static final String RES_ELEM_NOT_FOUND 				 = "<return dataType=\"null\" />";
	private static final String RES_ELEM_LIST_NOT_FOUND 		 = "<return value='' dataType='array'/>";

	private static final String REQ_GET_OBJ 					 = "<get-object object='%s'/>";
	private static final String REQ_GET_OBJ_WITH_PARENT 		 = "<get-object object='%s' parent='%s'/>";

	private static final String REQ_GET_OBJ_LIST 				 = "<get-object-list object='%s'/>";
	private static final String REQ_GET_OBJ_LIST_WITH_PARENT 	 = "<get-object-list object='%s' parent='%s'/>";

	private static final String REQ_GET_OBJ_PROPERTY 			 = "<get-object object='%s' property='%s' />";
	private static final String REQ_GET_OBJ_PROPERTY_WITH_PARENT = "<get-object object='%s' parent='%s' property='%s' />";

	private static final String REQ_CLICK_BUTTON 				 = "<dispatch object='%s' event='MOUSE_UP'/>";
	private static final String REQ_CLICK_BUTTON_WITH_PARENT 	 = "<dispatch object='%s' event='MOUSE_UP' parent='%s'/>";
	
	private static final String REQ_GET_EVENT 					 = "<get-xml event='%s'>";
	private static final String REQ_FORCE_RESULT 				 = "<set-result result='%s' />";
	
	private WebbitWebsocketServer currentServer;
	private Process currentProcess;

	
	private void startServerAndGame () {
		Runtime runtime = Runtime.getRuntime();
		try {
			currentProcess = runtime.exec("/Users/iulian.dafinoiu/Documents/rockaway-host-osx.app/Contents/MacOS/rockaway-host-osx "
					+ "/Users/iulian.dafinoiu/WORK/mamp/lua-tiki-island");
		} catch (IOException e) {
			System.out.println("Error while starting Rockaway OSX server");
		}
		
		currentServer = new WebbitWebsocketServer();
		WebServer webServer = WebServers.createWebServer(8887)
				.add("/", currentServer);
		webServer.start();
		
		System.out.println("+++++++++ Server running at " + webServer.getUri());
		pauseCurrentThread(10000);
	}
	
	
	private void closeApplication() {
		currentProcess.destroy();
	}
	
	public void verifyIfSpinButtonExists() {
		startServerAndGame();
                Assert.assertEquals(true, isObjectPresent("spinButton"));
		closeApplication();
	}
	
	private boolean isObjectPresent(String objectName, String parentName) {
        final Timer waitTimer = new Timer();
        
        this.currentServer.setCurrentReqString("GET_OBJ");
        this.currentServer.getCurrentSocketConnection().data("GET_OBJ","GET_OBJ");
        
        if (StringUtils.isNotBlank(parentName)) {
        	this.currentServer.getCurrentSocketConnection().send(String.format(REQ_GET_OBJ_WITH_PARENT, objectName, parentName));
        	System.out.println(String.format(REQ_GET_OBJ_WITH_PARENT, objectName, parentName));
        } else {
        	this.currentServer.getCurrentSocketConnection().send(String.format(REQ_GET_OBJ, objectName));
        	System.out.println(String.format(REQ_GET_OBJ, objectName));
        }
        
        String response = StringUtils.EMPTY;
        boolean waitForResponse = true;
        while (waitForResponse) {
        	response = (String) this.currentServer.getCurrentSocketConnection().data("GET_OBJ");
        	if (!"GET_OBJ".equals(response)) {
        		waitForResponse = false;
        	}
        }
        System.out.println("response: " + response);
        
        return !RES_ELEM_NOT_FOUND.equals(response);
	}
	
	private boolean isObjectPresent(String objectName) {
		return isObjectPresent(objectName, null);
	}
	
	/**
	 * @param milliseconds
	 */
	private void pauseCurrentThread(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println("Error while trying to sleep the current thread");
		}
	}
}

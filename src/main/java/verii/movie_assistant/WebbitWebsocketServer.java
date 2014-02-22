package verii.movie_assistant;

import org.webbitserver.BaseWebSocketHandler;
import org.webbitserver.WebSocketConnection;

public class WebbitWebsocketServer extends BaseWebSocketHandler {

    private WebSocketConnection currentSocketConnection;

    private String currentReqString;

    @Override
    public void onOpen(WebSocketConnection connection) throws Exception {
        super.onOpen(connection);
        currentSocketConnection = connection;
        System.out.println("++++++++++ Connection Opened.");
    }

    @Override
    public void onClose(WebSocketConnection connection) throws Exception {
        super.onClose(connection);
        System.out.println("++++++++++ Connection Closed.");
    }

    @Override
    public void onMessage(WebSocketConnection connection, String msg) throws Throwable {
        super.onMessage(connection, msg);
        System.out.println("-----------" + msg);
        if (connection.data(currentReqString) != null) {
            connection.data(currentReqString, msg);
            System.out.println("FILL CONNECTION");
        }
    }

    /**
     * @return the currentSocketConnection
     */
    public WebSocketConnection getCurrentSocketConnection() {
        return currentSocketConnection;
    }

    /**
     * @param currentSocketConnection the currentSocketConnection to set
     */
    public void setCurrentSocketConnection(
            WebSocketConnection currentSocketConnection) {
        this.currentSocketConnection = currentSocketConnection;
    }

    /**
     * @return the currentReqString
     */
    public String getCurrentReqString() {
        return currentReqString;
    }

    /**
     * @param currentReqString the currentReqString to set
     */
    public void setCurrentReqString(String currentReqString) {
        this.currentReqString = currentReqString;
    }

}

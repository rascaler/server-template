package com.sky.stock.socket;

import com.sky.commons.utils.GzipUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;

/** This example demonstrates how to create a websocket connection to a server. Only the most important callbacks are overloaded. */
public class ExampleClient extends WebSocketClient {

	Logger log = LoggerFactory.getLogger(ExampleClient.class);

	public ExampleClient(URI serverUri , Draft draft ) {
		super( serverUri, draft );
	}

	public ExampleClient(URI serverURI ) {
		super( serverURI );
	}

	public ExampleClient(URI serverUri, Map<String, String> httpHeaders ) {
		super(serverUri, httpHeaders);
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
//		send("Hello, it is me. Mario :)");
		System.out.println( "opened connection" );
		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
		String sub = "{\"sub\": \"market.btcusdt.kline.1min\",\"id\": \"id10\"}";
		send(sub);
	}

	@Override
	public void onMessage( String message ) {
		System.out.println( "received: " + message );
	}

	@Override
	public void onMessage(ByteBuffer bytes) {
		try {
			byte[] data = new byte[bytes.remaining()];
			bytes.get(data,0, data.length);
			String result =GzipUtil.uncompress(data);
			log.info(result);
			if(result.startsWith("{\"ping")) {
				String str = "{\"pong\": "+new Date().getTime()+"}";
				log.info("发送数据：" + str);
				send(str);
			}
		}catch (Exception e) {
			log.error("错误：",e);
		}
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + " Code: " + code + " Reason: " + reason );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}

	public static void main( String[] args ) throws URISyntaxException {
		ExampleClient c = new ExampleClient(new URI( "wss://api.huobi.pro/ws" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
		c.connect();


	}


}
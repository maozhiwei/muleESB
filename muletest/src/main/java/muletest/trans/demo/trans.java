package muletest.trans.demo;

import java.net.URLDecoder;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import muletest.demo.info;

public class trans extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Map postData = (Map) message.getPayload();
		info in = new info();
		in.setName(URLDecoder.decode(postData.get("name").toString()));
		in.setId(Integer.parseInt(postData.get("id").toString()));
		return in;
	}

}

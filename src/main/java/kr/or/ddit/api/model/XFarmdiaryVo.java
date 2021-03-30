package kr.or.ddit.api.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@XmlRootElement(name = "XfarmdiaryVo")
//@XmlAccessorType(XmlAccessType.NONE)
@JacksonXmlRootElement(localName = "xmember")
public class XFarmdiaryVo {

	@JacksonXmlProperty
	private String content;

	@JacksonXmlProperty
	private int yield;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getYield() {
		return yield;
	}

	public void setYield(int yield) {
		this.yield = yield;
	}

}

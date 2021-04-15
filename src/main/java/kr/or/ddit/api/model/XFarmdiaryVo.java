package kr.or.ddit.api.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(localName = "xfarmdiaryVo")
public class XFarmdiaryVo {

//	@JacksonXmlProperty
	private String content;

//	@JacksonXmlProperty
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

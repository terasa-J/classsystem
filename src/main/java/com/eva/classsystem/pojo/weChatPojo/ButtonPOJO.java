package com.eva.classsystem.pojo.weChatPojo;
/**
 * 
<p>Title: Button</p>
<p>Describtion: 菜单中的Button 基本按钮需要的字段</p>
 * @author Jiang Jiahong
 *@date 2017年11月16日 下午5:12:56
 */
public class ButtonPOJO {
	private String type;
	private String name;
	private ButtonPOJO[] sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ButtonPOJO[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(ButtonPOJO[] sub_button) {
		this.sub_button = sub_button;
	}
	
}

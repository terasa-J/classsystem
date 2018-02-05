package com.eva.classsystem.pojo.weChat;

import java.util.List;

/**
 * 
<p>Title: NewsMessagePOJO</p>
<p>Describtion: 图文消息的xml</p>
 * @author Gargi
 *@date 2017年11月16日 下午12:37:55
 *
 *<xml>
<ToUserName><![CDATA[toUser]]></ToUserName>
<FromUserName><![CDATA[fromUser]]></FromUserName>
<CreateTime>12345678</CreateTime>
<MsgType><![CDATA[news]]></MsgType>
<ArticleCount>2</ArticleCount>
<Articles>

<item>
<Title><![CDATA[title1]]></Title> 
<Description><![CDATA[description1]]></Description>
<PicUrl><![CDATA[picurl]]></PicUrl>
<Url><![CDATA[url]]></Url>
</item>

</Articles>
</xml>
 */
public class NewsMessagePOJO extends BaseMessage{
	private int ArticleCount;
	private List<NewsPOJO> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<NewsPOJO> getArticles() {
		return Articles;
	}
	public void setArticles(List<NewsPOJO> articles) {
		Articles = articles;
	}
	@Override
	public String toString() {
		return "NewsMessagePOJO [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}
}

package tradepost.model.vo;

import java.sql.Date;

import post.model.vo.Post;

public final class TradePost extends Post implements java.io.Serializable {
	private static final long serialVersionUID = 3591915937329788194L;

	
	public TradePost() {
		super();
	}
	public TradePost(int postSeq, int memberSeq, String memberId, String postContent, String postImg, int likeNo, int replyNO,
			Date postDate, Date lastModifieddate, String tradeResult) {
		super(postSeq, memberSeq, memberId, postContent, postImg, likeNo, replyNO, postDate, lastModifieddate, tradeResult);
	}
	@Override
	public String toString() {
		return "TradePost []";
	}

}

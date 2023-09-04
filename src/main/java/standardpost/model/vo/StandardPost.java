package standardpost.model.vo;

import java.sql.Date;

import post.model.vo.Post;

public final class StandardPost extends Post implements java.io.Serializable {
	private static final long serialVersionUID = -2455094323948180247L;

	public StandardPost() {
		super();
	}
	public StandardPost(int postSeq, int memberSeq, String memberId, String postContent, String postImg, int likeNo, int replyNO,
			Date postDate, Date lastModifieddate, String tradeResult) {
		super(postSeq, memberSeq, memberId, postContent, postImg, likeNo, replyNO, postDate, lastModifieddate, tradeResult);
	}
	@Override
	public String toString() {
		return "StandardPost []";
	}
}

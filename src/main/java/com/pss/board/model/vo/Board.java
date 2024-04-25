package com.pss.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;
	private int categoryNo;
	private String categoryName;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int count;
	private Date createDate;
	private String status;
	
	public Board() {
		super();
	}

	public Board(int boardNo, int categoryNo, String categoryName, String boardTitle, String boardContent, String boardWriter, int count,
			Date createDate, String status) {
		super();
		this.boardNo = boardNo;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardWriter=" + boardWriter
				+ ", count=" + count + ", createDate=" + createDate + ", status=" + status + ", getCategoryName()="
				+ getCategoryName() + ", getBoardNo()=" + getBoardNo() + ", getCategoryNo()=" + getCategoryNo()
				+ ", getBoardTitle()=" + getBoardTitle() + ", getBoardContent()=" + getBoardContent()
				+ ", getBoardWriter()=" + getBoardWriter() + ", getCount()=" + getCount() + ", getCreateDate()="
				+ getCreateDate() + ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}

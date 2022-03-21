package com.chernyllexs.comment.model.dto;

import java.util.List;

public class PagingCommentDto {
    private int commentsPerPage;
    private int currentPage;
    private Long numberOfComments;
    private List<CommentDto> comments;

    private PagingCommentDto() {
    }

    public static Builder newBuilder() {
        return new PagingCommentDto().new Builder();
    }

    public int getCommentsPerPage() {
        return commentsPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public Long getNumberOfComments() {
        return numberOfComments;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagingCommentDto that = (PagingCommentDto) o;

        if (getCommentsPerPage() != that.getCommentsPerPage()) return false;
        if (getCurrentPage() != that.getCurrentPage()) return false;
        if (getNumberOfComments() != null ? !getNumberOfComments().equals(that.getNumberOfComments()) : that.getNumberOfComments() != null)
            return false;
        return getComments() != null ? getComments().equals(that.getComments()) : that.getComments() == null;
    }

    @Override
    public int hashCode() {
        int result = getCommentsPerPage();
        result = 31 * result + getCurrentPage();
        result = 31 * result + (getNumberOfComments() != null ? getNumberOfComments().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PagingCommentDto{" +
                "commentsPerPage=" + commentsPerPage +
                ", currentPage=" + currentPage +
                ", numberOfComments=" + numberOfComments +
                ", comments=" + comments +
                '}';
    }

    public class Builder {

        private Builder() {
        }

        public Builder setCommentsPerPage(int numberOfPages) {
            PagingCommentDto.this.commentsPerPage = numberOfPages;
            return this;
        }

        public Builder setCurrentPage(int currentPage) {
            PagingCommentDto.this.currentPage = currentPage;
            return this;
        }

        public Builder setNumberOfComments(Long NumberOfComments) {
            PagingCommentDto.this.numberOfComments = NumberOfComments;
            return this;
        }

        public Builder setComments(List<CommentDto> comments) {
            PagingCommentDto.this.comments = comments;
            return this;
        }

        public PagingCommentDto build(){
            return PagingCommentDto.this;
        }
    }
}

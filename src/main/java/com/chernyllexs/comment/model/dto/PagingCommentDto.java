package com.chernyllexs.comment.model.dto;

import java.util.List;

public class PagingCommentDto {
    private int numberOfPages;
    private int currentPage;
    private List<CommentDto> comments;

    private PagingCommentDto() {
    }

    public static Builder newBuilder() {
        return new PagingCommentDto().new Builder();
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public List<CommentDto> getPosts() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagingCommentDto that = (PagingCommentDto) o;

        if (getNumberOfPages() != that.getNumberOfPages()) return false;
        if (getCurrentPage() != that.getCurrentPage()) return false;
        return getPosts() != null ? getPosts().equals(that.getPosts()) : that.getPosts() == null;
    }

    @Override
    public int hashCode() {
        int result = getNumberOfPages();
        result = 31 * result + getCurrentPage();
        result = 31 * result + (getPosts() != null ? getPosts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PagingCommentDto{" +
                "numberOfPages=" + numberOfPages +
                ", currentPage=" + currentPage +
                ", comments=" + comments +
                '}';
    }

    public class Builder {

        private Builder() {
        }

        public Builder setNumberOfPages(int numberOfPages) {
            PagingCommentDto.this.numberOfPages = numberOfPages;
            return this;
        }

        public Builder setCurrentPage(int currentPage) {
            PagingCommentDto.this.currentPage = currentPage;
            return this;
        }

        public Builder setPosts(List<CommentDto> comments) {
            PagingCommentDto.this.comments = comments;
            return this;
        }

        public PagingCommentDto build(){
            return PagingCommentDto.this;
        }
    }
}

# COMMENTS SERVICE

#### Function:
* add a comment to the post;
    * check for a post to add a comment;
* get all the comments for the post;
* get the last five comments;
* delete a comment;
* delete all user comments;
* delete all comments for the post;


#### Endpoints:
* POST /comment/create-comment (add a comment for this post);
* GET /comment/get-all-comment-for-post/{postId};
* GET /comment/get-five-last-comment-for-post/{postId};
* DELETE /comment/delete-all-user-comments/{userId};
* DELETE /comment/delete-all-comments-for-post/{postId};
* DELETE /comment/delete-comment/{commentId};


#### DTOs:
* CommentDto
    * Long postId;
    * Long userId;
    * LocalDateTime commentDate;
    * String commentText;


package com.anuj.potdar.redditclient.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ implements Serializable {

    @SerializedName("approved_at_utc")
    @Expose
    private Object approvedAtUtc;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("selftext")
    @Expose
    private String selftext;
    @SerializedName("user_reports")
    @Expose
    private List<Object> userReports = null;
    @SerializedName("saved")
    @Expose
    private Boolean saved;
    @SerializedName("mod_reason_title")
    @Expose
    private Object modReasonTitle;
    @SerializedName("gilded")
    @Expose
    private Integer gilded;
    @SerializedName("clicked")
    @Expose
    private Boolean clicked;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link_flair_richtext")
    @Expose
    private List<LinkFlairRichtext> linkFlairRichtext = null;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("pwls")
    @Expose
    private Integer pwls;
    @SerializedName("link_flair_css_class")
    @Expose
    private Object linkFlairCssClass;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("thumbnail_height")
    @Expose
    private Integer thumbnailHeight;
    @SerializedName("parent_whitelist_status")
    @Expose
    private String parentWhitelistStatus;
    @SerializedName("hide_score")
    @Expose
    private Boolean hideScore;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("link_flair_text_color")
    @Expose
    private String linkFlairTextColor;
    @SerializedName("author_flair_background_color")
    @Expose
    private Object authorFlairBackgroundColor;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;
    @SerializedName("thumbnail_width")
    @Expose
    private Integer thumbnailWidth;
    @SerializedName("author_flair_template_id")
    @Expose
    private Object authorFlairTemplateId;
    @SerializedName("is_original_content")
    @Expose
    private Boolean isOriginalContent;
    @SerializedName("secure_media")
    @Expose
    private SecureMedia secureMedia;
    @SerializedName("is_reddit_media_domain")
    @Expose
    private Boolean isRedditMediaDomain;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;
    @SerializedName("link_flair_text")
    @Expose
    private Object linkFlairText;
    @SerializedName("can_mod_post")
    @Expose
    private Boolean canModPost;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("edited")
    private Boolean editedBool;

    @SerializedName("edited")
    private Integer editedInt;

    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("author_flair_richtext")
    @Expose
    private List<Object> authorFlairRichtext = null;
    @SerializedName("post_hint")
    @Expose
    private String postHint;
    @SerializedName("content_categories")
    @Expose
    private Object contentCategories;
    @SerializedName("is_self")
    @Expose
    private Boolean isSelf;
    @SerializedName("mod_note")
    @Expose
    private Object modNote;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("link_flair_type")
    @Expose
    private String linkFlairType;
    @SerializedName("wls")
    @Expose
    private Integer wls;
    @SerializedName("post_categories")
    @Expose
    private Object postCategories;
    @SerializedName("banned_by")
    @Expose
    private Object bannedBy;
    @SerializedName("author_flair_type")
    @Expose
    private String authorFlairType;
    @SerializedName("contest_mode")
    @Expose
    private Boolean contestMode;
    @SerializedName("selftext_html")
    @Expose
    private Object selftextHtml;
    @SerializedName("likes")
    @Expose
    private Object likes;
    @SerializedName("suggested_sort")
    @Expose
    private Object suggestedSort;
    @SerializedName("banned_at_utc")
    @Expose
    private Object bannedAtUtc;
    @SerializedName("view_count")
    @Expose
    private Object viewCount;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("no_follow")
    @Expose
    private Boolean noFollow;
    @SerializedName("is_crosspostable")
    @Expose
    private Boolean isCrosspostable;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("over_18")
    @Expose
    private Boolean over18;
    @SerializedName("preview")
    @Expose
    private Preview preview;
    @SerializedName("media_only")
    @Expose
    private Boolean mediaOnly;
    @SerializedName("can_gild")
    @Expose
    private Boolean canGild;
    @SerializedName("spoiler")
    @Expose
    private Boolean spoiler;
    @SerializedName("locked")
    @Expose
    private Boolean locked;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("rte_mode")
    @Expose
    private String rteMode;
    @SerializedName("visited")
    @Expose
    private Boolean visited;
    @SerializedName("num_reports")
    @Expose
    private Object numReports;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("mod_reason_by")
    @Expose
    private Object modReasonBy;
    @SerializedName("removal_reason")
    @Expose
    private Object removalReason;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("report_reasons")
    @Expose
    private Object reportReasons;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("num_crossposts")
    @Expose
    private Integer numCrossposts;
    @SerializedName("num_comments")
    @Expose
    private Integer numComments;
    @SerializedName("send_replies")
    @Expose
    private Boolean sendReplies;
    @SerializedName("mod_reports")
    @Expose
    private List<Object> modReports = null;
    @SerializedName("author_flair_text_color")
    @Expose
    private Object authorFlairTextColor;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("whitelist_status")
    @Expose
    private String whitelistStatus;
    @SerializedName("stickied")
    @Expose
    private Boolean stickied;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("subreddit_subscribers")
    @Expose
    private Integer subredditSubscribers;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("is_video")
    @Expose
    private Boolean isVideo;
    @SerializedName("link_flair_template_id")
    @Expose
    private String linkFlairTemplateId;
    @SerializedName("link_flair_background_color")
    @Expose
    private String linkFlairBackgroundColor;

    @SerializedName("body")
    private String body;

    @SerializedName("replies")
    private Child replies;

    @SerializedName("children")
    private List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Child getReplies() {
        return replies;
    }

    public void setReplies(Child replies) {
        this.replies = replies;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getApprovedAtUtc() {
        return approvedAtUtc;
    }

    public void setApprovedAtUtc(Object approvedAtUtc) {
        this.approvedAtUtc = approvedAtUtc;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public List<Object> getUserReports() {
        return userReports;
    }

    public void setUserReports(List<Object> userReports) {
        this.userReports = userReports;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LinkFlairRichtext> getLinkFlairRichtext() {
        return linkFlairRichtext;
    }

    public void setLinkFlairRichtext(List<LinkFlairRichtext> linkFlairRichtext) {
        this.linkFlairRichtext = linkFlairRichtext;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getPwls() {
        return pwls;
    }

    public void setPwls(Integer pwls) {
        this.pwls = pwls;
    }

    public Object getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(Object linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getParentWhitelistStatus() {
        return parentWhitelistStatus;
    }

    public void setParentWhitelistStatus(String parentWhitelistStatus) {
        this.parentWhitelistStatus = parentWhitelistStatus;
    }

    public Boolean getHideScore() {
        return hideScore;
    }

    public void setHideScore(Boolean hideScore) {
        this.hideScore = hideScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public String getLinkFlairTextColor() {
        return linkFlairTextColor;
    }

    public void setLinkFlairTextColor(String linkFlairTextColor) {
        this.linkFlairTextColor = linkFlairTextColor;
    }

    public Object getAuthorFlairBackgroundColor() {
        return authorFlairBackgroundColor;
    }

    public void setAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
        this.authorFlairBackgroundColor = authorFlairBackgroundColor;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public Object getAuthorFlairTemplateId() {
        return authorFlairTemplateId;
    }

    public void setAuthorFlairTemplateId(Object authorFlairTemplateId) {
        this.authorFlairTemplateId = authorFlairTemplateId;
    }

    public Boolean getIsOriginalContent() {
        return isOriginalContent;
    }

    public void setIsOriginalContent(Boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
    }

    public SecureMedia getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(SecureMedia secureMedia) {
        this.secureMedia = secureMedia;
    }

    public Boolean getIsRedditMediaDomain() {
        return isRedditMediaDomain;
    }

    public void setIsRedditMediaDomain(Boolean isRedditMediaDomain) {
        this.isRedditMediaDomain = isRedditMediaDomain;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public Object getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(Object linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public Boolean getCanModPost() {
        return canModPost;
    }

    public void setCanModPost(Boolean canModPost) {
        this.canModPost = canModPost;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getEditedBool() {
        return editedBool;
    }

    public void setEdited(Boolean edited) {
        this.editedBool = edited;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public List<Object> getAuthorFlairRichtext() {
        return authorFlairRichtext;
    }

    public void setAuthorFlairRichtext(List<Object> authorFlairRichtext) {
        this.authorFlairRichtext = authorFlairRichtext;
    }

    public String getPostHint() {
        return postHint;
    }

    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    public Object getContentCategories() {
        return contentCategories;
    }

    public void setContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
    }

    public Boolean getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(Boolean isSelf) {
        this.isSelf = isSelf;
    }

    public Object getModNote() {
        return modNote;
    }

    public void setModNote(Object modNote) {
        this.modNote = modNote;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getLinkFlairType() {
        return linkFlairType;
    }

    public void setLinkFlairType(String linkFlairType) {
        this.linkFlairType = linkFlairType;
    }

    public Integer getWls() {
        return wls;
    }

    public void setWls(Integer wls) {
        this.wls = wls;
    }

    public Object getPostCategories() {
        return postCategories;
    }

    public void setPostCategories(Object postCategories) {
        this.postCategories = postCategories;
    }

    public Object getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(Object bannedBy) {
        this.bannedBy = bannedBy;
    }

    public String getAuthorFlairType() {
        return authorFlairType;
    }

    public void setAuthorFlairType(String authorFlairType) {
        this.authorFlairType = authorFlairType;
    }

    public Boolean getContestMode() {
        return contestMode;
    }

    public void setContestMode(Boolean contestMode) {
        this.contestMode = contestMode;
    }

    public Object getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(Object selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public Object getLikes() {
        return likes;
    }

    public void setLikes(Object likes) {
        this.likes = likes;
    }

    public Object getSuggestedSort() {
        return suggestedSort;
    }

    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    public Object getBannedAtUtc() {
        return bannedAtUtc;
    }

    public void setBannedAtUtc(Object bannedAtUtc) {
        this.bannedAtUtc = bannedAtUtc;
    }

    public Object getViewCount() {
        return viewCount;
    }

    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getNoFollow() {
        return noFollow;
    }

    public void setNoFollow(Boolean noFollow) {
        this.noFollow = noFollow;
    }

    public Boolean getIsCrosspostable() {
        return isCrosspostable;
    }

    public void setIsCrosspostable(Boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Boolean getMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(Boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public Boolean getCanGild() {
        return canGild;
    }

    public void setCanGild(Boolean canGild) {
        this.canGild = canGild;
    }

    public Boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public String getRteMode() {
        return rteMode;
    }

    public void setRteMode(String rteMode) {
        this.rteMode = rteMode;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Object getNumReports() {
        return numReports;
    }

    public void setNumReports(Object numReports) {
        this.numReports = numReports;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Object getModReasonBy() {
        return modReasonBy;
    }

    public void setModReasonBy(Object modReasonBy) {
        this.modReasonBy = modReasonBy;
    }

    public Object getRemovalReason() {
        return removalReason;
    }

    public void setRemovalReason(Object removalReason) {
        this.removalReason = removalReason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getReportReasons() {
        return reportReasons;
    }

    public void setReportReasons(Object reportReasons) {
        this.reportReasons = reportReasons;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumCrossposts() {
        return numCrossposts;
    }

    public void setNumCrossposts(Integer numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public Boolean getSendReplies() {
        return sendReplies;
    }

    public void setSendReplies(Boolean sendReplies) {
        this.sendReplies = sendReplies;
    }

    public List<Object> getModReports() {
        return modReports;
    }

    public void setModReports(List<Object> modReports) {
        this.modReports = modReports;
    }

    public Object getAuthorFlairTextColor() {
        return authorFlairTextColor;
    }

    public void setAuthorFlairTextColor(Object authorFlairTextColor) {
        this.authorFlairTextColor = authorFlairTextColor;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getWhitelistStatus() {
        return whitelistStatus;
    }

    public void setWhitelistStatus(String whitelistStatus) {
        this.whitelistStatus = whitelistStatus;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSubredditSubscribers() {
        return subredditSubscribers;
    }

    public void setSubredditSubscribers(Integer subredditSubscribers) {
        this.subredditSubscribers = subredditSubscribers;
    }

    public Integer getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(Integer createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getLinkFlairTemplateId() {
        return linkFlairTemplateId;
    }

    public Integer getEditedInt() {
        return editedInt;
    }

    public void setEdited(Integer edited) {
        this.editedInt = edited;
    }

    public void setLinkFlairTemplateId(String linkFlairTemplateId) {
        this.linkFlairTemplateId = linkFlairTemplateId;
    }

    public String getLinkFlairBackgroundColor() {
        return linkFlairBackgroundColor;
    }

    public void setLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
        this.linkFlairBackgroundColor = linkFlairBackgroundColor;
    }

}

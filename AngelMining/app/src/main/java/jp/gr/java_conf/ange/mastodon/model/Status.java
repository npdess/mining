
package jp.gr.java_conf.ange.mastodon.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) // DEBUG
@JsonPropertyOrder({
    "account",
    "application",
    "content",
    "created_at",
    "favourited",
    "favourites_count",
    "id",
    "in_reply_to_account_id",
    "in_reply_to_id",
    "language",
    "media_attachments",
    "mentions",
    "pinned",
    "pixiv_cards",
    "reblog",
    "reblogged",
    "reblogs_count",
    "sensitive",
    "spoiler_text",
    "tags",
    "uri",
    "url",
    "visibility"
})
public class Status {

    @JsonProperty("account")
    private Account account;
    @JsonProperty("application")
    private Application application;
    /**
     * Body of the status; this will contain HTML (remote HTML already sanitized)
     * 
     */
    @JsonProperty("content")
    @JsonPropertyDescription("Body of the status; this will contain HTML (remote HTML already sanitized)")
    private String content;
    /**
     * The time the status was created
     * 
     */
    @JsonProperty("created_at")
    @JsonPropertyDescription("The time the status was created")
    private String createdAt;
    /**
     * Whether the authenticated user has favourited the status
     * 
     */
    @JsonProperty("favourited")
    @JsonPropertyDescription("Whether the authenticated user has favourited the status")
    private String favourited;
    /**
     * The number of favourites for the status
     * 
     */
    @JsonProperty("favourites_count")
    @JsonPropertyDescription("The number of favourites for the status")
    private Integer favouritesCount;
    /**
     * The ID of the status
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The ID of the status")
    private Integer id;
    /**
     * null or the ID of the account it replies to
     * 
     */
    @JsonProperty("in_reply_to_account_id")
    @JsonPropertyDescription("null or the ID of the account it replies to")
    private String inReplyToAccountId;
    /**
     * null or the ID of the status it replies to
     * 
     */
    @JsonProperty("in_reply_to_id")
    @JsonPropertyDescription("null or the ID of the status it replies to")
    private String inReplyToId;
    /**
     * The detected language for the status (default en)
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("The detected language for the status (default en)")
    private String language;
    /**
     * An array of Attachments
     * 
     */
    @JsonProperty("media_attachments")
    @JsonPropertyDescription("An array of Attachments")
    private List<Attachment> mediaAttachments = new ArrayList<Attachment>();
    /**
     * An array of Mentions
     * 
     */
    @JsonProperty("mentions")
    @JsonPropertyDescription("An array of Mentions")
    private List<Mention> mentions = new ArrayList<Mention>();
    /**
     * pinterest pinned?
     * 
     */
    @JsonProperty("pinned")
    @JsonPropertyDescription("pinterest pinned?")
    private Boolean pinned;
    /**
     * masutodon original?
     * 
     */
    @JsonProperty("pixiv_cards")
    @JsonPropertyDescription("masutodon original?")
    private List<Object> pixivCards = new ArrayList<Object>();
    /**
     * null or the reblogged Status
     * 
     */
    @JsonProperty("reblog")
    @JsonPropertyDescription("null or the reblogged Status")
    private String reblog;
    /**
     * Whether the authenticated user has reblogged the status
     * 
     */
    @JsonProperty("reblogged")
    @JsonPropertyDescription("Whether the authenticated user has reblogged the status")
    private String reblogged;
    /**
     * The number of reblogs for the status
     * 
     */
    @JsonProperty("reblogs_count")
    @JsonPropertyDescription("The number of reblogs for the status")
    private Integer reblogsCount;
    /**
     * Whether media attachments should be hidden by default
     * 
     */
    @JsonProperty("sensitive")
    @JsonPropertyDescription("Whether media attachments should be hidden by default")
    private Boolean sensitive;
    /**
     * If not empty, warning text that should be displayed before the actual content
     * 
     */
    @JsonProperty("spoiler_text")
    @JsonPropertyDescription("If not empty, warning text that should be displayed before the actual content")
    private String spoilerText;
    /**
     * An array of Tags
     * 
     */
    @JsonProperty("tags")
    @JsonPropertyDescription("An array of Tags")
    private List<Tag> tags = new ArrayList<Tag>();
    /**
     * A Fediverse-unique resource ID
     * 
     */
    @JsonProperty("uri")
    @JsonPropertyDescription("A Fediverse-unique resource ID")
    private String uri;
    /**
     * URL to the status page (can be remote)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL to the status page (can be remote)")
    private String url;
    /**
     * One of public, unlisted, private, direct
     * 
     */
    @JsonProperty("visibility")
    @JsonPropertyDescription("One of public, unlisted, private, direct")
    private String visibility;

    @JsonProperty("account")
    public Account getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(Account account) {
        this.account = account;
    }

    @JsonProperty("application")
    public Application getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * Body of the status; this will contain HTML (remote HTML already sanitized)
     * 
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * Body of the status; this will contain HTML (remote HTML already sanitized)
     * 
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * The time the status was created
     * 
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * The time the status was created
     * 
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Whether the authenticated user has favourited the status
     * 
     */
    @JsonProperty("favourited")
    public String getFavourited() {
        return favourited;
    }

    /**
     * Whether the authenticated user has favourited the status
     * 
     */
    @JsonProperty("favourited")
    public void setFavourited(String favourited) {
        this.favourited = favourited;
    }

    /**
     * The number of favourites for the status
     * 
     */
    @JsonProperty("favourites_count")
    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    /**
     * The number of favourites for the status
     * 
     */
    @JsonProperty("favourites_count")
    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    /**
     * The ID of the status
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The ID of the status
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * null or the ID of the account it replies to
     * 
     */
    @JsonProperty("in_reply_to_account_id")
    public String getInReplyToAccountId() {
        return inReplyToAccountId;
    }

    /**
     * null or the ID of the account it replies to
     * 
     */
    @JsonProperty("in_reply_to_account_id")
    public void setInReplyToAccountId(String inReplyToAccountId) {
        this.inReplyToAccountId = inReplyToAccountId;
    }

    /**
     * null or the ID of the status it replies to
     * 
     */
    @JsonProperty("in_reply_to_id")
    public String getInReplyToId() {
        return inReplyToId;
    }

    /**
     * null or the ID of the status it replies to
     * 
     */
    @JsonProperty("in_reply_to_id")
    public void setInReplyToId(String inReplyToId) {
        this.inReplyToId = inReplyToId;
    }

    /**
     * The detected language for the status (default en)
     * 
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * The detected language for the status (default en)
     * 
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * An array of Attachments
     * 
     */
    @JsonProperty("media_attachments")
    public List<Attachment> getMediaAttachments() {
        return mediaAttachments;
    }

    /**
     * An array of Attachments
     * 
     */
    @JsonProperty("media_attachments")
    public void setMediaAttachments(List<Attachment> mediaAttachments) {
        this.mediaAttachments = mediaAttachments;
    }

    /**
     * An array of Mentions
     * 
     */
    @JsonProperty("mentions")
    public List<Mention> getMentions() {
        return mentions;
    }

    /**
     * An array of Mentions
     * 
     */
    @JsonProperty("mentions")
    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    /**
     * pinterest pinned?
     * 
     */
    @JsonProperty("pinned")
    public Boolean getPinned() {
        return pinned;
    }

    /**
     * pinterest pinned?
     * 
     */
    @JsonProperty("pinned")
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    /**
     * masutodon original?
     * 
     */
    @JsonProperty("pixiv_cards")
    public List<Object> getPixivCards() {
        return pixivCards;
    }

    /**
     * masutodon original?
     * 
     */
    @JsonProperty("pixiv_cards")
    public void setPixivCards(List<Object> pixivCards) {
        this.pixivCards = pixivCards;
    }

    /**
     * null or the reblogged Status
     * 
     */
    @JsonProperty("reblog")
    public String getReblog() {
        return reblog;
    }

    /**
     * null or the reblogged Status
     * 
     */
    @JsonProperty("reblog")
    public void setReblog(String reblog) {
        this.reblog = reblog;
    }

    /**
     * Whether the authenticated user has reblogged the status
     * 
     */
    @JsonProperty("reblogged")
    public String getReblogged() {
        return reblogged;
    }

    /**
     * Whether the authenticated user has reblogged the status
     * 
     */
    @JsonProperty("reblogged")
    public void setReblogged(String reblogged) {
        this.reblogged = reblogged;
    }

    /**
     * The number of reblogs for the status
     * 
     */
    @JsonProperty("reblogs_count")
    public Integer getReblogsCount() {
        return reblogsCount;
    }

    /**
     * The number of reblogs for the status
     * 
     */
    @JsonProperty("reblogs_count")
    public void setReblogsCount(Integer reblogsCount) {
        this.reblogsCount = reblogsCount;
    }

    /**
     * Whether media attachments should be hidden by default
     * 
     */
    @JsonProperty("sensitive")
    public Boolean getSensitive() {
        return sensitive;
    }

    /**
     * Whether media attachments should be hidden by default
     * 
     */
    @JsonProperty("sensitive")
    public void setSensitive(Boolean sensitive) {
        this.sensitive = sensitive;
    }

    /**
     * If not empty, warning text that should be displayed before the actual content
     * 
     */
    @JsonProperty("spoiler_text")
    public String getSpoilerText() {
        return spoilerText;
    }

    /**
     * If not empty, warning text that should be displayed before the actual content
     * 
     */
    @JsonProperty("spoiler_text")
    public void setSpoilerText(String spoilerText) {
        this.spoilerText = spoilerText;
    }

    /**
     * An array of Tags
     * 
     */
    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * An array of Tags
     * 
     */
    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * A Fediverse-unique resource ID
     * 
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * A Fediverse-unique resource ID
     * 
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * URL to the status page (can be remote)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL to the status page (can be remote)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * One of public, unlisted, private, direct
     * 
     */
    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    /**
     * One of public, unlisted, private, direct
     * 
     */
    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(account).append(application).append(content).append(createdAt).append(favourited).append(favouritesCount).append(id).append(inReplyToAccountId).append(inReplyToId).append(language).append(mediaAttachments).append(mentions).append(pinned).append(pixivCards).append(reblog).append(reblogged).append(reblogsCount).append(sensitive).append(spoilerText).append(tags).append(uri).append(url).append(visibility).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(account, rhs.account).append(application, rhs.application).append(content, rhs.content).append(createdAt, rhs.createdAt).append(favourited, rhs.favourited).append(favouritesCount, rhs.favouritesCount).append(id, rhs.id).append(inReplyToAccountId, rhs.inReplyToAccountId).append(inReplyToId, rhs.inReplyToId).append(language, rhs.language).append(mediaAttachments, rhs.mediaAttachments).append(mentions, rhs.mentions).append(pinned, rhs.pinned).append(pixivCards, rhs.pixivCards).append(reblog, rhs.reblog).append(reblogged, rhs.reblogged).append(reblogsCount, rhs.reblogsCount).append(sensitive, rhs.sensitive).append(spoilerText, rhs.spoilerText).append(tags, rhs.tags).append(uri, rhs.uri).append(url, rhs.url).append(visibility, rhs.visibility).isEquals();
    }

}

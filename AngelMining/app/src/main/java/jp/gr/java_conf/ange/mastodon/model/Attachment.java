
package jp.gr.java_conf.ange.mastodon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "meta",
    "type",
    "url",
    "remote_url",
    "preview_url",
    "text_url"
})
public class Attachment {

    /**
     * ID of the attachment
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID of the attachment")
    private String id;
    /**
     * meta?
     * 
     */
    @JsonProperty("meta")
    @JsonPropertyDescription("meta?")
    private Object meta;
    /**
     * One of "image", "video", "gifv"
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("One of \"image\", \"video\", \"gifv\"")
    private String type;
    /**
     * URL of the locally hosted version of the image
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL of the locally hosted version of the image")
    private Object url;
    /**
     * For remote images, the remote URL of the original image
     * 
     */
    @JsonProperty("remote_url")
    @JsonPropertyDescription("For remote images, the remote URL of the original image")
    private String remoteUrl;
    /**
     * URL of the preview image
     * 
     */
    @JsonProperty("preview_url")
    @JsonPropertyDescription("URL of the preview image")
    private Object previewUrl;
    /**
     * Shorter URL for the image, for insertion into text (only present on local images)
     * 
     */
    @JsonProperty("text_url")
    @JsonPropertyDescription("Shorter URL for the image, for insertion into text (only present on local images)")
    private String textUrl;

    /**
     * ID of the attachment
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID of the attachment
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * meta?
     * 
     */
    @JsonProperty("meta")
    public Object getMeta() {
        return meta;
    }

    /**
     * meta?
     * 
     */
    @JsonProperty("meta")
    public void setMeta(Object meta) {
        this.meta = meta;
    }

    /**
     * One of "image", "video", "gifv"
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * One of "image", "video", "gifv"
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * URL of the locally hosted version of the image
     * 
     */
    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    /**
     * URL of the locally hosted version of the image
     * 
     */
    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    /**
     * For remote images, the remote URL of the original image
     * 
     */
    @JsonProperty("remote_url")
    public String getRemoteUrl() {
        return remoteUrl;
    }

    /**
     * For remote images, the remote URL of the original image
     * 
     */
    @JsonProperty("remote_url")
    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    /**
     * URL of the preview image
     * 
     */
    @JsonProperty("preview_url")
    public Object getPreviewUrl() {
        return previewUrl;
    }

    /**
     * URL of the preview image
     * 
     */
    @JsonProperty("preview_url")
    public void setPreviewUrl(Object previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     * Shorter URL for the image, for insertion into text (only present on local images)
     * 
     */
    @JsonProperty("text_url")
    public String getTextUrl() {
        return textUrl;
    }

    /**
     * Shorter URL for the image, for insertion into text (only present on local images)
     * 
     */
    @JsonProperty("text_url")
    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(meta).append(type).append(url).append(remoteUrl).append(previewUrl).append(textUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attachment) == false) {
            return false;
        }
        Attachment rhs = ((Attachment) other);
        return new EqualsBuilder().append(id, rhs.id).append(meta, rhs.meta).append(type, rhs.type).append(url, rhs.url).append(remoteUrl, rhs.remoteUrl).append(previewUrl, rhs.previewUrl).append(textUrl, rhs.textUrl).isEquals();
    }

}

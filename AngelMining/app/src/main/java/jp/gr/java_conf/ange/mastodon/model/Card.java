
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
    "author_name",
    "author_url",
    "description",
    "height",
    "html",
    "image",
    "provider_name",
    "provider_url",
    "title",
    "type",
    "url",
    "width"
})
public class Card {

    /**
     * null
     * 
     */
    @JsonProperty("author_name")
    @JsonPropertyDescription("null")
    private String authorName;
    /**
     * null
     * 
     */
    @JsonProperty("author_url")
    @JsonPropertyDescription("null")
    private String authorUrl;
    /**
     * The card description
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("The card description")
    private String description;
    /**
     * null
     * 
     */
    @JsonProperty("height")
    @JsonPropertyDescription("null")
    private Integer height;
    /**
     * null
     * 
     */
    @JsonProperty("html")
    @JsonPropertyDescription("null")
    private String html;
    /**
     * The image associated with the card, if any
     * 
     */
    @JsonProperty("image")
    @JsonPropertyDescription("The image associated with the card, if any")
    private String image;
    /**
     * null
     * 
     */
    @JsonProperty("provider_name")
    @JsonPropertyDescription("null")
    private String providerName;
    /**
     * null
     * 
     */
    @JsonProperty("provider_url")
    @JsonPropertyDescription("null")
    private String providerUrl;
    /**
     * The title of the card
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("The title of the card")
    private String title;
    /**
     * "link", "photo", "video", or "rich"
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("\"link\", \"photo\", \"video\", or \"rich\"")
    private String type;
    /**
     * The url associated with the card
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The url associated with the card")
    private String url;
    /**
     * null
     * 
     */
    @JsonProperty("width")
    @JsonPropertyDescription("null")
    private Integer width;

    /**
     * null
     * 
     */
    @JsonProperty("author_name")
    public String getAuthorName() {
        return authorName;
    }

    /**
     * null
     * 
     */
    @JsonProperty("author_name")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * null
     * 
     */
    @JsonProperty("author_url")
    public String getAuthorUrl() {
        return authorUrl;
    }

    /**
     * null
     * 
     */
    @JsonProperty("author_url")
    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    /**
     * The card description
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * The card description
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * null
     * 
     */
    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    /**
     * null
     * 
     */
    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * null
     * 
     */
    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    /**
     * null
     * 
     */
    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * The image associated with the card, if any
     * 
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * The image associated with the card, if any
     * 
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * null
     * 
     */
    @JsonProperty("provider_name")
    public String getProviderName() {
        return providerName;
    }

    /**
     * null
     * 
     */
    @JsonProperty("provider_name")
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * null
     * 
     */
    @JsonProperty("provider_url")
    public String getProviderUrl() {
        return providerUrl;
    }

    /**
     * null
     * 
     */
    @JsonProperty("provider_url")
    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    /**
     * The title of the card
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The title of the card
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * "link", "photo", "video", or "rich"
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * "link", "photo", "video", or "rich"
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The url associated with the card
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The url associated with the card
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * null
     * 
     */
    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    /**
     * null
     * 
     */
    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(authorName).append(authorUrl).append(description).append(height).append(html).append(image).append(providerName).append(providerUrl).append(title).append(type).append(url).append(width).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Card) == false) {
            return false;
        }
        Card rhs = ((Card) other);
        return new EqualsBuilder().append(authorName, rhs.authorName).append(authorUrl, rhs.authorUrl).append(description, rhs.description).append(height, rhs.height).append(html, rhs.html).append(image, rhs.image).append(providerName, rhs.providerName).append(providerUrl, rhs.providerUrl).append(title, rhs.title).append(type, rhs.type).append(url, rhs.url).append(width, rhs.width).isEquals();
    }

}

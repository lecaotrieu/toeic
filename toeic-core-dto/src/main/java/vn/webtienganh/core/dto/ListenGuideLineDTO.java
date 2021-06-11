package vn.webtienganh.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ListenGuideLineDTO implements Serializable {
    private Integer listenguidelineid;
    private String title;
    private String image;
    private String content;
    private Timestamp createdDate;
    private Timestamp modifieddate;

    public Integer getListenguidelineid() {
        return listenguidelineid;
    }

    public void setListenguidelineid(Integer listenguidelineid) {
        this.listenguidelineid = listenguidelineid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }
}

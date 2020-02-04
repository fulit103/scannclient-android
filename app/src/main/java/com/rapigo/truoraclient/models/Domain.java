package com.rapigo.truoraclient.models;

import com.google.gson.annotations.SerializedName;

public class Domain {
    private String domain;
    @SerializedName("is_down")
    private boolean isDown;
    private String logo;
    @SerializedName("previous_ssl_grade")
    private String previousSslGrade;
    @SerializedName("servers_changed")
    private String serversChanged;
    @SerializedName("ssl_grade")
    private String sslGrade;
    private String title;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isisDown() {
        return isDown;
    }

    public void setIsDown(boolean isDown) {
        this.isDown = isDown;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPreviousSslGrade() {
        return previousSslGrade;
    }

    public void setPreviousSslGrade(String previousSslGrade) {
        this.previousSslGrade = previousSslGrade;
    }

    public String getServersChanged() {
        return serversChanged;
    }

    public void setServersChanged(String serversChanged) {
        this.serversChanged = serversChanged;
    }

    public String getSslGrade() {
        return sslGrade;
    }

    public void setSslGrade(String ssl_grade) {
        this.sslGrade = ssl_grade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.example.azamat.gallery;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pojo {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public class Photos {

        @SerializedName("page")
        @Expose
        private Long page;
        @SerializedName("pages")
        @Expose
        private String pages;
        @SerializedName("perpage")
        @Expose
        private Long perpage;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("photo")
        @Expose
        private List<Photo> photo = null;

        public Long getPage() {
            return page;
        }

        public void setPage(Long page) {
            this.page = page;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public Long getPerpage() {
            return perpage;
        }

        public void setPerpage(Long perpage) {
            this.perpage = perpage;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<Photo> getPhoto() {
            return photo;
        }

        public void setPhoto(List<Photo> photo) {
            this.photo = photo;
        }

    }

    public class Photo {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("owner")
        @Expose
        private String owner;
        @SerializedName("secret")
        @Expose
        private String secret;
        @SerializedName("server")
        @Expose
        private String server;
        @SerializedName("farm")
        @Expose
        private Long farm;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("ispublic")
        @Expose
        private Long ispublic;
        @SerializedName("isfriend")
        @Expose
        private Long isfriend;
        @SerializedName("isfamily")
        @Expose
        private Long isfamily;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public Long getFarm() {
            return farm;
        }

        public void setFarm(Long farm) {
            this.farm = farm;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getIspublic() {
            return ispublic;
        }

        public void setIspublic(Long ispublic) {
            this.ispublic = ispublic;
        }

        public Long getIsfriend() {
            return isfriend;
        }

        public void setIsfriend(Long isfriend) {
            this.isfriend = isfriend;
        }

        public Long getIsfamily() {
            return isfamily;
        }

        public void setIsfamily(Long isfamily) {
            this.isfamily = isfamily;
        }

    }

}
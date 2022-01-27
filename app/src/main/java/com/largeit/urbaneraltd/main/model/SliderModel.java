package com.largeit.urbaneraltd.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SliderModel {


        @SerializedName("SliderID")
        @Expose
        private Integer sliderID;

        @SerializedName("ImageName")
        @Expose
        private String imageName;

        public Integer getSliderID() {
            return sliderID;
        }

        public void setSliderID(Integer sliderID) {
            this.sliderID = sliderID;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }


}

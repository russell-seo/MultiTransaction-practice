package com.example.multitransaction.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

public class IpBan {


    private List<BanDto> data;

    @Data
    public static class BanDto{
        @JsonProperty("ip_address")
        private String ipAddress;
        @JsonProperty("start_date")
        private Date startDate;
        @JsonProperty("end_date")
        private Date endDate;
        @JsonProperty("register_id")
        private String registerId;
        @JsonProperty("ban_reason")
        private String banReason;

        @JsonProperty("is_ban")
        private Boolean isBan;


        public BanDto() {
        }

        public BanDto(String ipAddress, Date startDate, Date endDate, String registerId, String banReason) {
            this.ipAddress = ipAddress;
            this.startDate = startDate;
            this.endDate = endDate;
            this.registerId = registerId;
            this.banReason = banReason;
        }

        public BanDto(String ipAddress) {
            this.ipAddress = ipAddress;
        }


        public BanDto(String ipAddress, Boolean isBan) {
            this.ipAddress = ipAddress;
            this.isBan = isBan;
        }
    }
}

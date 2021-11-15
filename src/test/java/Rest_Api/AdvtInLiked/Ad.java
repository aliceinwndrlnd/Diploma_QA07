package Rest_Api.AdvtInLiked;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;


@Data
public class Ad {
        private long account_id;
        private AccountParameter[] account_parameters;
        private long ad_id;
        private String ad_link;
        private AdParameter[] ad_parameters;
        private Object body;
        private String category;
        private boolean company_ad;
        private String currency;
        private Image[] images;
        private long list_id;
        private Date list_time;
        private String message_id;
        private PaidServices paid_services;
        private boolean phone_hidden;
        private String price_byn;
        private String price_usd;
        private String remuneration_type;
        private String subject;
        private String type;
}

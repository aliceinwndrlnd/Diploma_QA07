package Rest_Api.AdvtInLiked;

import lombok.Data;

import java.time.OffsetDateTime;


@Data
public class Ad {
        private long accountID;
        private AccountParameter[] accountParameters;
        private long adID;
        private String adLink;
        private AdParameter[] adParameters;
        private Object body;
        private String category;
        private boolean companyAd;
        private String currency;
        private Image[] images;
        private long listID;
        private OffsetDateTime listTime;
        private String messageID;
        private PaidServices paidServices;
        private boolean phoneHidden;
        private String priceByn;
        private String priceUsd;
        private String remunerationType;
        private String subject;
        private String type;
}
